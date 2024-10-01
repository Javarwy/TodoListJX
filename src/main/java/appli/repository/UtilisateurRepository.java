package appli.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import appli.database.*;

public class UtilisateurRepository {

    public boolean valide;
    private Connection Req;
    public String SQLReq;


    public void Hydration (boolean valide) {

        this.valide = valide;

    }

    public void Inscription (boolean valide) throws SQLException {

        Database db = new Database();

        try {
            db.getConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        SQLReq = "SELECT * FROM utilisateur";

        if ()

    }






}
