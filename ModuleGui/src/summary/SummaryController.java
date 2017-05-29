package summary;

import account.UserAccount;
import createProject.CreateProjectController;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import local.LocalManager;
import logger.Log;
import main.MainApp;

 import java.io.IOException;

/**
 * Created by g0dzax on 5/26/2017.
 */
public class SummaryController {

    @FXML
    private ChoiceBox<String> stringChoiceBox;
    @FXML
    private Label currentUserAccountName;
    @FXML
    private ImageView currentUserImageView;
    @FXML
    private ListView<String> listView;

    private ObservableList<String> choiceBoxItems;
    private UserAccount currentUser;
    private ObservableList<String> listViewItems;
    private MainApp mainApp;
    private Stage dialogStage;

    public SummaryController() {
        System.out.println("First, created the controller");
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    @FXML
    private void initialize() {
        listViewItems = FXCollections.observableArrayList("Create a new project");
        choiceBoxItems = FXCollections.observableArrayList("Logout");
        mainApp = MainApp.getMainAppInstance();
        currentUser = LocalManager.getLocalManager().getCurrentUser();
        stringChoiceBox.setItems(choiceBoxItems);
        stringChoiceBox.getSelectionModel()
                .selectedItemProperty()
                .addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> Log.printLog(Log.LOG_TYPE_INFO, "Performing logout."));
        currentUserAccountName.setText(currentUser.getUserFirstName());
        listView.setItems(listViewItems);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        //set currentUser icon if it has one selected
        //initialize the list view with the projects that belong to the user logged in
        //after initializing the list view, we want to add one more item to it, that will be named "Create new project"


    }


    @FXML
    private void listItemClicked() {
        if (listView.getSelectionModel().getSelectedItem().contains("new")) {
            // bring up the create a new project list
            System.out.println("Clicked on new project item ! " + listView.getSelectionModel().getSelectedItem());
            loadCreateProjectDialogStage();
        } else {
            // populate the statistics with the information held in the project
            System.out.println("Clicked on item ! " + listView.getSelectionModel().getSelectedItem());

        }
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


}
