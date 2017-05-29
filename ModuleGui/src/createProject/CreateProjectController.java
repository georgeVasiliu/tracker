package createProject;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        //here, we take the data and create the project and assign it to the current user;
    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
