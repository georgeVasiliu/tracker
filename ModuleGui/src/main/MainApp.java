package main;

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


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initLoginInterface();

    }

    public void initLoginInterface() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(MainApp.class.getResource("login/Login.fxml"));
        LoginController loginController = fxmlLoader.getController();
        loginController.setMainApp(this);
        changePrimaryStageScene(fxmlLoader);
    }

    public void initSummaryInterface() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(MainApp.class.getResource("summary/Summary.fxml"));
        SummaryController summaryController = fxmlLoader.getController();
        summaryController.setMainApp(this);
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
