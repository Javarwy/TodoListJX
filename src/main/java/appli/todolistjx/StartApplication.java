package appli.todolistjx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class StartApplication extends Application {
    static Stage mainStage;

    @Override

    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        mainStage.setTitle("Connexion");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void changeScene(String Fxml) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("register-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        mainStage.setTitle("Inscription");
        mainStage.setScene(scene);
        mainStage.show();







    }

    public static void main(String[] args) {
        launch();
    }
}

