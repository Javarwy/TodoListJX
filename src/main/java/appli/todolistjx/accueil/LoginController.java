package appli.todolistjx.accueil;

import appli.todolistjx.StartApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        StartApplication.changeScene ("resources/register-view.fxml");
    }




}