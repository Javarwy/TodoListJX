package appli.todolistjx.accueil;

import appli.repository.UtilisateurRepository;
import appli.todolistjx.StartApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Window;
import model.Utilisateur;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField emailIdField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button ButtCon;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) throws IOException, SQLException {

        Window owner = ButtCon.getScene().getWindow();

        System.out.println(emailIdField.getText());
        System.out.println(passwordField.getText());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


        if (emailIdField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Erreur!", "Pas d'email");
            return;
        }

        if (passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Erreur!", "Pas de mot de passe");
            return;
        }


        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String email = emailIdField.getText();
        String password = passwordField.getText();
        Utilisateur pirateCon = new Utilisateur(prenom, nom, email, encoder.encode(password));
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        utilisateurRepository.Connexion(pirateCon);

        showAlert(Alert.AlertType.INFORMATION, owner, "Succès!", "Connexion réussie.");
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }




}