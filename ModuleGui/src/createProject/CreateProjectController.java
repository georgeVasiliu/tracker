package createProject;

import command.local.CreateProjectCommand;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import project.Project;
import request.Delegator;
import request.RequestHandler;

import java.util.Date;

/**
 * Created by george on 5/29/17.
 */
public class CreateProjectController {
    @FXML
    private TextField projectNameTextField;
    @FXML
    private TextField projectSummaryTextField;
    @FXML
    private DatePicker projectDueDate;

    private Stage dialogStage;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void initialize() {

    }

    @FXML
    private void handleOk() {
        Project project = new Project(projectNameTextField.getText(), projectSummaryTextField.getText(), projectDueDate.getValue());
        Delegator.getDelegator().sendRequest(RequestHandler.RequestType.PROJECT, new CreateProjectCommand(project));
        dialogStage.close();
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
