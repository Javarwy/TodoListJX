package model;

import java.sql.Connection;
import java.sql.ResultSet;

public class UtilisateurConnecte extends Utilisateur {

    private static UtilisateurConnecte INSTANCE;

    private Connection connection;
    private ResultSet resultSet;

    private UtilisateurConnecte(String prenom, String nom, String email, String motDePasse, Connection connection, ResultSet resultSet) {
        super(prenom, nom, email, motDePasse);
        this.connection = connection;
        this.resultSet = resultSet;
    }

    private UtilisateurConnecte(Utilisateur utilisateur) {
        super(utilisateur.getPrenom(), utilisateur.getNom(), utilisateur.getEmail(), utilisateur.getMotDePasse());
    }

    public static boolean initInstance(Utilisateur utilisateur) {
        if (INSTANCE == null) {
            INSTANCE = new UtilisateurConnecte(utilisateur);
            return true;
        }
        return false;
    }


    public static UtilisateurConnecte getInstance() {
        return INSTANCE;
    }

    public static boolean clearInstance() {
        if (INSTANCE != null) {
            INSTANCE = null;
            return true;
        }
        return false;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
