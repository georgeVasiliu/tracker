package login;


import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.scene.BoundsAccessor;
import command.local.LocalLoginCommand;
import command.network.LoginCommand;
import createAccount.CreateAccountController;
import hash.HashGen;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.effect.Effect;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import request.Delegator;
import request.RequestHandler;
import response.Receiver;
import response.Response;
import response.ResponseManager;
import secureCommunication.UserAccountOutParameters;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by george on 5/24/17.
 */
public class LoginController implements Receiver {


    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField userPasswordField;
    @FXML
    private Button loginButton;
    @FXML
    private Canvas canvas;


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
