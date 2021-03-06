package local;

import account.UserAccount;
import account.UserAccountWrapper;
import hash.HashGen;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import logger.Log;
import objective.Objective;
import project.Project;
import response.Dispatcher;
import response.Receiver;
import response.Response;
import response.ResponseManager;
import task.Task;

import javax.xml.bind.*;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by george on 5/17/17.
 */
public class LocalManager implements Dispatcher {
    private static final List<String> receiversForThisDispatcher = new ArrayList<>();
    private static LocalManager localManager;
    private List<UserAccount> storedUserAccounts;
    private List<Receiver> receiverList = new ArrayList<>();
    private final String jarDir;
    private static UserAccount currentUser;
    private static boolean localLogin;

    private LocalManager() {
        receiversForThisDispatcher.add("Login");
        receiversForThisDispatcher.add("ListProject");
        CodeSource codeSource = LocalManager.class.getProtectionDomain().getCodeSource();
        File jarFile = null;
        try {
            jarFile = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        jarDir = jarFile.getPath().substring(0, jarFile.getPath().length() - 19);
        ResponseManager.addDispatcher(this);
        readAnyStoredData();
        Log.printLog(Log.LOG_TYPE_INFO, "Set the jarDir to : " + jarDir);
    }

    public static LocalManager getLocalManager() {
        if (localManager == null) {
            localManager = new LocalManager();
        }
        return localManager;
    }


    public void readAnyStoredData() {
        File file = new File(jarDir + "LocalAccounts.xml");
        if (file.exists()) {
            UserAccountWrapper userAccountWrapper = JAXB.unmarshal(file, UserAccountWrapper.class);
            storedUserAccounts = new ArrayList<>();
            storedUserAccounts.addAll(userAccountWrapper.getUserAccounts());
        } else {
            storedUserAccounts = new ArrayList<>();
        }
    }

    public void validateLogin(String userName, String userPassword) {
        String hashedPassword = HashGen.getHash(userPassword);
        for (UserAccount userAccount : storedUserAccounts) {
            if (userAccount.getUserName().equals(userName) && userAccount.getUserPassword().equals(hashedPassword)) {
                Log.printLog(Log.LOG_TYPE_INFO, "Successfully logged into the application with user : " + userName);
                currentUser = userAccount;
                localLogin = true;
                sendResponse(new Response("Successful login, bro!"), "Login");

                return;
            }
        }
        localLogin = false;
        sendResponse(new Response("Failed login, bro!"), "Login");
    }

    public void createLocalAccount(UserAccount userAccount) {
        try {
            createLocalFolderForAccount(userAccount);
            JAXBContext context = JAXBContext.newInstance(UserAccountWrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            UserAccountWrapper userAccountWrapper = new UserAccountWrapper();
            storedUserAccounts.add(userAccount);
            userAccountWrapper.setUserAccounts(storedUserAccounts);
            marshaller.marshal(userAccountWrapper, new File(jarDir + "LocalAccounts.xml"));

        } catch (JAXBException e) {
            Log.printLog(Log.LOG_TYPE_ERROR, "A JAXBException has been caught.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save the user account!");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.showAndWait();
        }
    }

    private void createLocalFolderForAccount(UserAccount userAccount) {
        Path path = Paths.get(jarDir + userAccount.getUserUID());
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
                userAccount.setLocalFolder(path.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Path path2 = Paths.get(path + "/Projects");
        if (!Files.exists(path2)) {
            try {
                Files.createDirectory(path2);
                userAccount.setProjectsFolder(path2.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void grabProjects() {
        List<Project> projects = new ArrayList<>();
        Log.printLog(Log.LOG_TYPE_INFO, "Grabbing all local projects for user: " + currentUser.getUserName());
        File folder = new File(currentUser.getProjectsFolder());
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles.length < 1) {
            sendResponse(new Response(projects), "ListProject");
            return;
        }
        for (File file : listOfFiles) {
            if (file.isFile()) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    Project project = (Project) objectInputStream.readObject();
                    projects.add(project);
                    Log.printLog(Log.LOG_TYPE_INFO, "Successfully read one project from the folder!");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
        Log.printLog(Log.LOG_TYPE_INFO, "SENT A LIST WITH SIZE : " + projects.size());
        sendResponse(new Response(projects), "ListProject");
    }

    public void grabObjectives() {

    }

    public void grabTasks() {

    }

    public void storeProject(Project project) {
        try {
            File file = new File(currentUser.getProjectsFolder() + "/" + project.getProjectName() + ".ser");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(project);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            Log.printLog(Log.LOG_TYPE_INFO, "Serialized project :" + project.getProjectName());
            grabProjects();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void storeObjective(Objective objective) {

    }

    public void storeTask(Task task) {

    }

    public void updateProject(Project project) {

    }

    public void updateObjective(Objective objective) {

    }

    public void updateTask(Task task) {

    }

    public UserAccount getCurrentUser() {
        return currentUser;
    }

    @Override
    public void addReceiver(Receiver receiver) {
        receiverList.add(receiver);
    }

    @Override
    public void removeReceiver(Receiver receiver) {
        receiverList.remove(receiver);
    }

    @Override
    public void sendResponse(Response response, String toWhichReceiver) {
        for (Receiver receiver : receiverList)
            if (receiver.getReceiverType().contains(toWhichReceiver)) {
                Platform.runLater(() -> {
                    receiver.update(response);
                });
            }
    }

    @Override
    public List<String> getTypeOfReceiver() {
        return receiversForThisDispatcher;

    }
}
