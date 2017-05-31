package projectSummary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import project.Project;
import viewProjectObjectives.ProjectObjectivesController;

import java.io.IOException;

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
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(ProjectObjectivesController.class.getResource("ProjectObjectives.fxml"));

        try {
            SplitPane splitPane = fxmlLoader.load();
            ProjectObjectivesController projectObjectivesController = fxmlLoader.getController();
            projectObjectivesController.setProject(project);
            Stage dialogStage = new Stage();
            Scene scene = new Scene(splitPane);
            projectObjectivesController.setDialogStage(dialogStage);
            dialogStage.setScene(scene);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
