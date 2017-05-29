package login;


import command.local.LocalLoginCommand;
import createAccount.CreateAccountController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.MainApp;
import request.Delegator;
import request.RequestHandler;
import response.Receiver;
import response.Response;
import response.ResponseManager;

import java.io.IOException;

/**
 * Created by george on 5/24/17.
 */
public class LoginController implements Receiver {

    private MainApp mainApp;

    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField userPasswordField;
    @FXML
    private Button loginButton;
    @FXML
    private Canvas canvas;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    @FXML
    private void initialize() {
        ResponseManager.addReceiver(this);
    }


    @FXML
    private void handleLogin() {
        String userName = userNameField.getText();
        String userPassword = userPasswordField.getText();
        Delegator.getDelegator().sendRequest(RequestHandler.RequestType.LOGIN, new LocalLoginCommand(userName, userPassword));

    }


    @FXML
    private void handleCreateAccount() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(CreateAccountController.class.getResource("CreateAccount.fxml"));
        try {
            AnchorPane createAccountLayout = fxmlLoader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Create a new local account");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(createAccountLayout);
            dialogStage.setScene(scene);

            CreateAccountController createAccountController = fxmlLoader.getController();
            createAccountController.setDialogStage(dialogStage);
            dialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Response response) {

        if (response.getString().contains("Successful")) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Login successful");
            alert.setContentText("Please wait while the application starts");
            alert.showAndWait();
            boolean result = alert.getResult().getButtonData().isDefaultButton();
            if (result) {


            }

        }
        if (response.getString().contains("Failed")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Login unsuccessful");
            alert.setContentText("The credentials you entered are invalid");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.showAndWait();
        }
    }

    @Override
    public String getReceiverType() {
        return "Login";
    }
}
