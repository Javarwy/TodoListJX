package appli.todolistjx.accueil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.Liste;

import java.net.URL;
import java.util.ResourceBundle;

public class AccueilController implements Initializable {

    public void switch_back(javafx.event.ActionEvent event) {

    }

    @FXML
    private TableView<Liste> tableauListe;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[][] colonnes = {
                {"Id liste", "IdListe"},
                {"Nom", "nom"},
        };
        for (int i = 0; i < colonnes.length; i++) {
            TableColumn<Liste, String> maColonne = new TableColumn<>(colonnes[i][0]);
            maColonne.setCellValueFactory(new PropertyValueFactory<>(colonnes[i][1]));
            tableauListe.getColumns().add(maColonne);
        }
    }

    @FXML
    void OnListeSelection(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
            TablePosition cell = tableauListe.getSelectionModel().getSelectedCells().get(0);
            int indexLigne = cell.getRow();
            TableColumn colonne = cell.getTableColumn();
            Liste listeSel = tableauListe.getItems().get(indexLigne);
            System.out.println("Double-Clique ligne " + indexLigne + " + colonne " + colonne.getText() + "; " + listeSel);
        } else if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
            TablePosition cell = tableauListe.getSelectionModel().getSelectedCells().get(0);
            int indexLigne = cell.getRow();
            TableColumn colonne = cell.getTableColumn();
            Liste listeSel = tableauListe.getItems().get(indexLigne);
            System.out.println("Clic simple ligne " + indexLigne + " + colonne " + colonne.getText() + "; " + listeSel);
        }
    }
}
