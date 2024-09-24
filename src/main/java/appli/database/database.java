package appli.database;

import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {

    private String server;
    private String nomDeLaBase;
    private String utilisateur;
    private String motDePasse;

    private void getURL() throws IOException {
        String URL = "jdbc:mysql://***serveur***/***nomDeLaBase***?serverTimezone=UTC ";
        return;
    }

    private Connection getConnection() {
        try {
            Connection cnx = DriverManager.getConnection(this.getURL(), this.user, this.password);
            System.out.print ("Etat de connexion :");
            System.out.print (cnx.isClosed()?)"fermé":"ouvert \r\n");
            return cnx;
        } catch (SQLException e) {
            System.out.print ("erreur lors de la tentative de connection à la base de données")
                    e.printStackTrace();
                    return null;



        }

    }

  }
