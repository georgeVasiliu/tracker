package summary;

import account.UserAccount;
import command.local.GetLocalProjectsCommand;
import createProject.CreateProjectController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import local.LocalManager;
import logger.Log;
import main.MainApp;
import project.Project;
import projectSummary.ProjectSummaryController;
import request.Delegator;
import request.RequestHandler;
import response.Receiver;
import response.Response;
import response.ResponseManager;

import java.io.IOException;
import java.util.List;

/**
 * Created by g0dzax on 5/26/2017.
 */
public class SummaryController implements Receiver {


    @FXML
    private SplitPane splitPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label currentUserAccountName;
    @FXML
    private ImageView currentUserImageView;
    @FXML
    private ListView<Project> listView;

    private UserAccount currentUser;
    private ObservableList<Project> currentUserProjects;
    private MainApp mainApp;
    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    private void loadCreateProjectDialogStage() {
        Stage createProjectStage = new Stage();
        createProjectStage.initModality(Modality.APPLICATION_MODAL);
        createProjectStage.initOwner(dialogStage);
        FXMLLoader createProjectLoader = new FXMLLoader();
        createProjectLoader.setLocation(CreateProjectController.class.getResource("CreateProject.fxml"));
        try {
            AnchorPane createProjectPane = createProjectLoader.load();
            Scene newScene = new Scene(createProjectPane);
            CreateProjectController createProjectController = createProjectLoader.getController();
            createProjectController.setDialogStage(createProjectStage);
            createProjectStage.setScene(newScene);
            createProjectStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setProjectSummary(Project project) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(ProjectSummaryController.class.getResource("ProjectSummary.fxml"));
        try {
            AnchorPane projectSummary = fxmlLoader.load();
            ProjectSummaryController projectSummaryController = fxmlLoader.getController();
            projectSummaryController.setProject(project);
            anchorPane.getChildren().clear();
            anchorPane.getChildren().addAll(projectSummary);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    private void initialize() {
        mainApp = MainApp.getMainAppInstance();
        currentUser = LocalManager.getLocalManager().getCurrentUser();
        currentUserAccountName.setText(currentUser.getUserFirstName());
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.setCellFactory(new Callback<ListView<Project>, ListCell<Project>>() {
            @Override
            public ListCell<Project> call(ListView<Project> param) {
                ListCell<Project> cell = new ListCell<Project>() {
                    @Override
                    protected void updateItem(Project project, boolean empty) {
                        super.updateItem(project, empty);
                        if (project != null) {
                            setText(project.getProjectName());
                        }
                    }
                };
                cell.setOnMousePressed((MouseEvent event) -> {
                    if (cell.isEmpty()) {
                        event.consume();
                        listView.getSelectionModel().clearSelection();
                    } else {
                        if (cell.getItem().getProjectName().equals("Create a new project")) {
                            loadCreateProjectDialogStage();
                        } else {
                            setProjectSummary(cell.getItem());
                        }

                    }
                });
                return cell;
            }
        });
        ResponseManager.addReceiver(this);
        Delegator.getDelegator().sendRequest(RequestHandler.RequestType.PROJECT, new GetLocalProjectsCommand());
    }


    @FXML
    private void handleLogout() {
        Log.printLog(Log.LOG_TYPE_INFO, "Logging out of the current user...");
    }


    @Override
    public void update(Response response) {
        List<Project> projectList = response.getProjects();
        currentUserProjects = FXCollections.observableArrayList(projectList);
        currentUserProjects.add(new Project("Create a new project", "", null));
        listView.setItems(currentUserProjects);
    }

    @Override
    public String getReceiverType() {
        return "ListProject";
    }
}
