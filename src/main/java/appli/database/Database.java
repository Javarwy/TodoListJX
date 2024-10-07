package appli.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private String server = "localhost";
    private String nomDeLaBase = "javafx";
    private String utilisateur = "root";
    private String motDePasseSQL = "";

    public String getUrl() throws IOException {
        String url = "jdbc:mysql://localhost/javafx?serverTimezone=UTC ";
        return url;
    }

    public Connection getConnection() throws IOException {
        try {
            Connection cnx = DriverManager.getConnection(this.getUrl(), this.utilisateur, this.motDePasseSQL);
            System.out.print ("Etat de connexion :");
            System.out.print (cnx.isClosed()?"fermé":"ouvert \r\n");
            return cnx;
        } catch (SQLException | IOException e) {
            System.out.print ("erreur lors de la tentative de connection à la base de données");
                    e.printStackTrace();
                    return null;



        }

    }

  }
