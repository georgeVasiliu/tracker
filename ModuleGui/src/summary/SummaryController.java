package summary;

import command.local.GetLocalProjectsCommand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import local.LocalManager;
import logger.Log;
import project.Project;
import request.Delegator;
import request.RequestHandler;
import response.Receiver;
import response.Response;
import response.ResponseManager;

import java.util.List;


/**
 * Created by george on 5/31/17.
 */
public class SummaryController implements Receiver {
    @FXML
    private BorderPane borderLayout;
    @FXML
    private ImageView userIcon;
    @FXML
    private ListView<Project> projectListView;
    @FXML
    private Label userNameLabel;

    private ObservableList<Project> projectObservableList;


    @FXML
    private void initialize() {
        projectObservableList = FXCollections.observableArrayList();
        projectListView.prefHeightProperty().bind(borderLayout.heightProperty());
        userNameLabel.setText(LocalManager.getLocalManager().getCurrentUser().getUserFirstName());
        projectListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        projectListView.setCellFactory(new Callback<ListView<Project>, ListCell<Project>>() {
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
                cell.setOnMousePressed((MouseEvent mouseEvent) -> {
                    if (cell.isEmpty()) {
                        mouseEvent.consume();
                        projectListView.getSelectionModel().clearSelection();
                    } else {
                        getProjectSummary(cell.getItem());
                    }
                });
                return cell;
            }
        });
        ResponseManager.addReceiver(this);
        Delegator.getDelegator().sendRequest(RequestHandler.RequestType.PROJECT, new GetLocalProjectsCommand());
        projectListView.setItems(projectObservableList);


    }

    @FXML
    private void handleLogout() {
        Log.printLog(Log.LOG_TYPE_DEBUG,
                "Logging out from the current user account..."
                        + LocalManager.getLocalManager().getCurrentUser().getUserName());
    }


    private void getProjectSummary(Project project) {

    }

    @Override
    public void update(Response response) {
        Log.printLog(Log.LOG_TYPE_DEBUG, "Got response for updating list of projects!");
        projectObservableList.clear();
        projectObservableList.addAll(response.getProjects());
    }

    @Override
    public String getReceiverType() {
        return "ListProject";
    }
}
