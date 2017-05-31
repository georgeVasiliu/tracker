package main;

import createAccount.CreateAccountController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.LoginController;
import summary.SummaryController;


import java.io.IOException;

/**
 * Created by g0dzax on 5/26/2017.
 */
public class MainApp extends Application {


    private static Stage primaryStage;
    private static MainApp mainAppInstance;


    public static void main(String[] args) {
        mainAppInstance = new MainApp();
        mainAppInstance.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initLoginInterface();

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static MainApp getMainAppInstance() {
        return mainAppInstance;
    }

    public void initLoginInterface() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(LoginController.class.getResource("Login.fxml"));
        changePrimaryStageScene(fxmlLoader);
    }

    public void initSummaryInterface() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(SummaryController.class.getResource("Summary.fxml"));
        changePrimaryStageScene(fxmlLoader);
    }

    public void initCreateAccountInterface() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(CreateAccountController.class.getResource("CreateAccount/fxml"));
        changePrimaryStageScene(fxmlLoader);

    }

    private static void changePrimaryStageScene(FXMLLoader loader) {
        try {
            Scene newScene = new Scene(loader.load());
            primaryStage.setScene(newScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
