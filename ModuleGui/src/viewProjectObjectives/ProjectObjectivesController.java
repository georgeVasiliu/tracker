package viewProjectObjectives;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import objective.Objective;
import project.Project;

import java.util.List;

/**
 * Created by g0dzax on 5/30/2017.
 */
public class ProjectObjectivesController {
    @FXML
    private ListView<Objective> listView;
    @FXML
    private Label objectiveTitle;
    @FXML
    private Label objectiveSummary;
    @FXML
    private Label objectiveStatus;
    @FXML
    private Label objectiveDueDate;
    @FXML
    private Label objectiveMembers;
    @FXML
    private Label objectiveSupervisor;


    private Project project;
    private ObservableList<Objective> projectListOfObjectives;
    private Stage dialogStage;
    private static final Objective createObjective = new Objective();

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setProject(Project project) {

        this.project = project;
        createObjective.setTitle("Create objective.");
        project.getProjectListOfObjectives().add(createObjective);
        projectListOfObjectives = FXCollections.observableArrayList(project.getProjectListOfObjectives());

    }


    private void updateObjectiveDescription(Objective objective) {
        objectiveTitle.setText(objective.getTitle());
        objectiveSummary.setText(objective.getDescription());
        objectiveStatus.setText(objective.getStatus().toString());
        objectiveDueDate.setText(objective.getDeadline().toString());
        objectiveMembers.setText("No members for now.");
        objectiveSupervisor.setText("No supervisor for now.");

    }

    @FXML
    private void initialize() {
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.setItems(projectListOfObjectives);
        listView.setCellFactory(new Callback<ListView<Objective>, ListCell<Objective>>() {
            @Override
            public ListCell<Objective> call(ListView<Objective> param) {
                ListCell<Objective> cell = new ListCell<Objective>() {
                    @Override
                    protected void updateItem(Objective objective, boolean empty) {
                        super.updateItem(objective, empty);
                        if (objective != null) {
                            setText(objective.getTitle());
                        }
                    }
                };
                cell.setOnMousePressed((MouseEvent mouseEvent) -> {
                    if (cell.isEmpty()) {
                        mouseEvent.consume();
                        listView.getSelectionModel().clearSelection();
                    } else {
                        updateObjectiveDescription(cell.getItem());
                    }
                });
                return cell;
            }
        });

    }
}
