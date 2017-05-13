/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagerDAO;
import java.util.*;
import java.sql.*;


/**
 *
 * @author Thomas
 */
public class AccesBD {
    
    private Connection maConnexion;
    private static AccesBD uneConnexionBD;
    private String chaineConnexion;

    public String GetchaineConnexion()
    {
        return chaineConnexion;
    }

    public void SetchaineConnexion(String ch)
    {
        chaineConnexion = ch;
    }

    public static AccesBD GetConnexionBD()
    {
        if (uneConnexionBD == null)
        {
            uneConnexionBD = new AccesBD();
        }
        return uneConnexionBD;
    }

    public Connection GetSqlConnexion()
    {
        if (maConnexion == null)
        {
            maConnexion = new Connection();
            maConnexion.ConnectionString = chaineConnexion;
        }

        // si la connexion est fermée, on l’ouvre
        if (maConnexion.State == System.Data.ConnectionState.Closed)
        {
            maConnexion.Open;
        }
        return maConnexion;
    }

    public void CloseConnexion()
    {
        // si la connexion est ouverte, on la ferme
        if (this.maConnexion != null && this.maConnexion.State != System.Data.ConnectionState.Closed)
        {
            this.maConnexion.Close();
        }
    }
}

