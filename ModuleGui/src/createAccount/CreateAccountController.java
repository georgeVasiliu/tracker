package createAccount;

import account.UserAccount;
import command.local.CreateLocalAccountCommand;
import hash.HashGen;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.MainApp;
import request.Delegator;
import request.RequestHandler;

/**
 * Created by g0dzax on 5/25/2017.
 */
public class CreateAccountController {
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField userPassword;
    @FXML
    private TextField userFirstNameField;
    @FXML
    private TextField userLastNameField;
    @FXML
    private TextField userAdressField;
    @FXML
    private TextField userCityField;
    @FXML
    private TextField userCountryField;
    @FXML
    private TextField userPhoneNumberField;


    private Stage dialogStage;
    private MainApp mainApp;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    private void initialize() {
        mainApp = MainApp.getMainAppInstance();
    }


    @FXML
    private void handleOk() {
        //Remember, we have to validate input always, and only after that should we construct the object
        String hashPassword = HashGen.getHash(userPassword.getText());
        UserAccount tempAccount = new UserAccount(userNameField.getText(), hashPassword);
        tempAccount.setUserFirstName(userFirstNameField.getText());
        tempAccount.setUserLastName(userLastNameField.getText());
        tempAccount.setUserAddress(userAdressField.getText());
        tempAccount.setUserCity(userCityField.getText());
        tempAccount.setUserCountry(userCountryField.getText());
        tempAccount.setUserPhoneNumber(Integer.valueOf(userPhoneNumberField.getText()));
        Delegator.getDelegator().sendRequest(RequestHandler.RequestType.LOGIN, new CreateLocalAccountCommand(tempAccount));
        dialogStage.close();
    }


    @FXML
    private void handleCancel() {
        System.out.println("Going to close the dialog...");
        dialogStage.close();
    }
}


