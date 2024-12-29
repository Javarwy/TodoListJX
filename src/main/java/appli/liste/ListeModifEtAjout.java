package appli.liste;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import appli.database.Database;
import model.Liste;

public class ListeModifEtAjout {
    public boolean ajout(Liste liste) throws SQLException, IOException {
        Database bdd = new Database();
        PreparedStatement requetePrepareInsert = bdd.getConnection().prepareStatement(
                "INSERT INTO liste (nom) VALUES (?)"
        );
        requetePrepareInsert.setString(1, liste.getNom());
        requetePrepareInsert.executeUpdate();
        PreparedStatement reqPrepareSelect = bdd.getConnection().prepareStatement("SELECT nom FROM liste WHERE nom = ?"
        );
        reqPrepareSelect.setString(1, liste.getNom());
        ResultSet resultatRequete = reqPrepareSelect.executeQuery();
        if (resultatRequete.next()) {
            return true;
        } else {
            return false;
        }
    }

    public Liste getListeByNom(String nom) throws SQLException, IOException {
        Database base = new Database();
        PreparedStatement reqPrepareSelect = base.getConnection().prepareStatement("SELECT * FROM liste WHERE nom = ?"
        );
        reqPrepareSelect.setString(1, nom);
        ResultSet resultatRequete = reqPrepareSelect.executeQuery();
        if (resultatRequete.next()) {
            Liste liste = new Liste(resultatRequete.getInt(1), resultatRequete.getString(2));
            return liste;
        } else {
            return null;
        }
    }

    public ArrayList<Liste> getListes() throws SQLException, IOException {
        Database base = new Database();
        PreparedStatement reqPrepareSelect = base.getConnection().prepareStatement("SELECT * FROM liste"
        );
        ResultSet resultatRequete = reqPrepareSelect.executeQuery();
        ArrayList<Liste> resultats = new ArrayList<Liste>();
        while (resultatRequete.next()){
            resultats.add(new Liste(resultatRequete.getInt(1), resultatRequete.getString(2)));
        }
        return resultats;
    }

    public boolean editer(Liste liste) throws SQLException, IOException {
        Database base = new Database();
        PreparedStatement requetePrepareEdit = base.getConnection().prepareStatement(
                "UPDATE liste SET nom = ? WHERE id_liste = ?"
        );
        requetePrepareEdit.setString(1, liste.getNom());
        requetePrepareEdit.setInt(2, liste.getIdListe());
        requetePrepareEdit.executeUpdate();
        PreparedStatement reqPrepareSelect = base.getConnection().prepareStatement("SELECT nom FROM liste WHERE nom = ?"
        );
        reqPrepareSelect.setString(1, liste.getNom());
        ResultSet resultatRequete = reqPrepareSelect.executeQuery();
        if (resultatRequete.next()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean supprimer(Liste liste) throws SQLException, IOException {
        Database base = new Database();
        PreparedStatement requetePrepareDelete = base.getConnection().prepareStatement(
                "DELETE FROM liste WHERE id_liste = ?"
        );
        requetePrepareDelete.setInt(1, liste.getIdListe());
        requetePrepareDelete.executeUpdate();
        PreparedStatement reqPrepareSelect = base.getConnection().prepareStatement("SELECT * FROM liste WHERE id_liste = ?");
        reqPrepareSelect.setInt(1, liste.getIdListe());
        ResultSet resultatRequete = reqPrepareSelect.executeQuery();
        if (!resultatRequete.next()) {
            return true;
        } else {
            return false;
        }
    }
}
