package appli.todolistjx.accueil;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class AccueilController implements Initializable {

    public void switch_back (ActionEvent event) {

    }

    @FXML
    private TableView<?> TableauListe;

    @Override

    public void initialize(URL url, ResourceBundle rb) {

        for (int i = 0 ; i < collones.length ; i++) {

            TableColumn<Liste, String> maCollone = new TableColumn<>(collones[i][0]);
            maCollone.setCellValueFactory(new PropertyValueFactory<>(collones[i][1]));
            tableauListe.getCollumns.add(maCollone);

        }
        };

    void OnListeSelection (ActionEvent event) {

        if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {

            TablePosition cell = tableauListe.getSelectionModel().getSelectedCells().get(0);
            int indexLigne = cell.getRow();
            TableColumn colonne = cell.getTableColumn();
            Liste ListeSel = tableauListe.getItems().get(indexLigne);
            System.out.println("Double-Clique ligne" + indexLigne + " + colonnes" + colonne.getText() + ";" + ListeSel);

        } else if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1 ){

            TablePosition cell = tableauListe.getSelectionModel().getSelectedCells().get(0);
            int indexLigne = cell.getRow();
            TableColumn colonne = cell.getTableColumn();
            Liste ListeSel = tableauListe.getItems().get(indexLigne);
            System.out.println("Double-Clique ligne" + indexLigne + " + colonnes" + colonne.getText() + ";" + ListeSel);
















    }














}












}