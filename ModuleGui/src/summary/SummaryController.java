package summary;

import account.UserAccount;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import local.LocalManager;
import logger.Log;
import main.MainApp;

import javax.swing.text.html.ImageView;
import java.util.List;

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

    private ObservableList<String> choiceBoxItems = FXCollections.observableArrayList("Logout");
    private UserAccount currentUser;
    private ObservableList<String> listViewItems = FXCollections.observableArrayList("Create a new project");
    private MainApp mainApp;

    public SummaryController() {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {
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
            System.out.println("Clicked on item ! " + listView.getSelectionModel().getSelectedItem());
        } else {
            // populate the statistics with the information held in the project
            System.out.println("Clicked on item ! " + listView.getSelectionModel().getSelectedItem());

        }
    }


}
