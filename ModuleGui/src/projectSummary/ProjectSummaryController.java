package projectSummary;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import project.Project;

/**
 * Created by george on 5/30/17.
 */
public class ProjectSummaryController {

    @FXML
    private Label projectNameLabel;
    @FXML
    private Label projectSummaryLabel;
    @FXML
    private Label projectDueDateLabel;
    @FXML
    private Label projectTotalObjectivesLabel;
    @FXML
    private Label projectCompletedObjectivesLabel;
    @FXML
    private Label projectInProgressObjectivesLabel;
    @FXML
    private Label projectAbandonedObjectivesLabel;

    private Project project;


    public void setProject(Project project) {
        this.project = project;
        projectNameLabel.setText(project.getProjectName());
        projectSummaryLabel.setText(project.getProjectSummary());
        projectDueDateLabel.setText(project.getProjectDueDate().toString());
        projectTotalObjectivesLabel.setText(((Integer.toString(project.getProjectListOfObjectives().size()))));
        projectCompletedObjectivesLabel.setText("-1");
        projectInProgressObjectivesLabel.setText("-1");
        projectAbandonedObjectivesLabel.setText("-1");
    }


    @FXML
    private void initialize() {

    }

    @FXML
    private void handleViewObjectives() {

    }

}
