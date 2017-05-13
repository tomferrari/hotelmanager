/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagerDAO;
import  hotelmanagerBO.Hotel;
import hotelmanagerBLL.HotelManager;
import java.*;
import java.math.*;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Thomas
 */
public class HotelDAO {
    
    private static HotelDAO unHotelDAO;

    public static HotelDAO GetunHotelDAO()
    {
        if (unHotelDAO == null)
        {
            unHotelDAO = new HotelDAO();
        }
        return unHotelDAO;
    }

    public static List<Hotel> GetHotel()
    {
        int idHotel;
        String nomHotel;
        String adresseHotel;
        int nbChambreHotel;

        Hotel unHotel;

        SqlConnection maConnexion = AccesBD.GetConnexionBD().GetSqlConnexion();

        List<Hotel> lesHotels = new List<Hotel>();

        SqlCommand cmd = new SqlCommand();
        cmd.Connection = maConnexion;
        cmd.CommandText = "SELECT * FROM HOTEL";

        SqlDataReader monReader = cmd.ExecuteReader();

        while (monReader.Read())
        {
            idHotel = Convert.ToInt32(monReader["ID_HOTEL"].ToString());
            nomHotel = monReader["NOM_HOTEL"].ToString();
            adresseHotel = Convert.ToInt32(monReader["ADRESSE_HOTEL"].ToString());
            nbChambreHotel = Convert.ToInt32(monReader["NB_CHAMBRE_HOTEL"].ToString());


            //proprietaire = new PROPRIETAIRE(Convert.ToInt32(proprietaire.ID), proprietaire.NOM);
            //entraineur = new ENTRAINEUR(Convert.ToInt32(entraineur.ID), entraineur.NOM);
            unHotel = new Hotel(Convert.ToInt32(idHotel), nomHotel, adresseHotel, Convert.ToInt32(nbChambreHotel));
            lesHotels.add(unHotel);
        }
        maConnexion.Close();

        return lesHotels;
    }

    public static int EnregistrerHotel(Hotel unHotel)
    {
        int nbEnr;

        SqlConnection maConnexion = AccesBD.GetConnexionBD().GetSqlConnexion();

        SqlCommand cmd = new SqlCommand();
        cmd.Connection = maConnexion;
        cmd.CommandText = "INSERT INTO HOTEL VALUES ('" + unHotel.getNomHotel()+ "','" + unHotel.getAdresseHotel()+ "','" + unHotel.getNbChambreHotel() + "')";

        nbEnr = cmd.ExecuteNonQuery();
        maConnexion.Close();
        return nbEnr;
    }

    public int SupprimerHotel(Hotel unHotel)
    {
        int nbEnregSup;
        // on récupère l'objet responsable de la connexion à la base
        SqlConnection maConnexion = AccesBD.GetConnexionBD().GetSqlConnexion();

        // on crée l'objet qui va contenir la requête SQL qui sera exécutée
        SqlCommand cmd = new SqlCommand();
        cmd.Connection = maConnexion;
        cmd.CommandText = "DELETE FROM HOTEL WHERE ID_HOTEL =" + unHotel.getIdHotel();

        // on exécute la requête
        nbEnregSup = cmd.ExecuteNonQuery();
        // on retourne le nombre d'enregistrements ajoutés
        return nbEnregSup;
    }

    public int ModifierHotel(Hotel unHotel)
    {
        int nbEnregAjout;
        // on récupère l'objet responsable de la connexion à la base
        SqlConnection maConnexion = AccesBD.GetConnexionBD().GetSqlConnexion();

        // on crée l'objet qui va contenir la requête SQL qui sera exécutée
        SqlCommand cmd = new SqlCommand();
        cmd.Connection = maConnexion;

        cmd.CommandText = "UPDATE HOTEL SET NOM_HOTEL = '" + unHotel.getNomHotel() + "', ADRESSE_HOTEL='" +
                unHotel.getAdresseHotel() + "',NB_CHAMBRE_HOTEL ='" + unHotel.getNbChambreHotel() + 
                "' WHERE ID_HOTEL ='" + unHotel.getIdHotel() + "'";

        // on exécute la requête
        nbEnregAjout = cmd.ExecuteNonQuery();
        // on retourne le nombre d'enregistrements ajoutés
        return nbEnregAjout;
    }
    
}
