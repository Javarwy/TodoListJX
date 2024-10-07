package appli.todolistjx.accueil;

import appli.repository.UtilisateurRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Window;
import model.Utilisateur;
import model.Utilisateur.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField emailIdField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button ButtIns;

    @FXML
    protected void onRegisterButtonClick(ActionEvent event) throws IOException, SQLException {

        Window owner = ButtIns.getScene().getWindow();

        System.out.println(nomField.getText());
        System.out.println(prenomField.getText());
        System.out.println(emailIdField.getText());
        System.out.println(passwordField.getText());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


        if (nomField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Erreur!", "Pas de nom");
            return;
        }

        if (prenomField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Erreur!", "Pas de prenom");
            return;
        }

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
        Utilisateur pirate = new Utilisateur(prenom, nom, email, encoder.encode(password));
        UtilisateurRepository utilisateurRepository = new UtilisateurRepository();
        utilisateurRepository.inscription(pirate);

        showAlert(Alert.AlertType.INFORMATION, owner, "Succès!", "Inscription réussie.");
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
