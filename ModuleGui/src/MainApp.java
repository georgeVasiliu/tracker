import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by g0dzax on 5/26/2017.
 */
public class MainApp extends Application {


    private Stage primaryStage;


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
        changePrimaryStageScene(fxmlLoader);
    }

    private void changePrimaryStageScene(FXMLLoader loader) {
        try {
            Scene newScene = new Scene(loader.load());
            primaryStage.setScene(newScene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
