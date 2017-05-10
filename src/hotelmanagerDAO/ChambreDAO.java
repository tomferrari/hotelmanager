/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagerDAO;
import  hotelmanagerBO.Chambre;
import hotelmanagerDAO.ChambreDAO;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Thomas
 */
public class ChambreDAO {
    
    private static ChambreDAO uneChambreDAO;
    
    public static ChambreDAO GetuneChambreDAO()
    {
        if (uneChambreDAO == null)
        {
            uneChambreDAO = new ChambreDAO();
        }
        return uneChambreDAO;
    }
    
    public static List<Chambre> GetChambre()
    {
        int idChambre;
        int etageChambre;
        int numeroChambre;
        int nbLitChambre;
        int prixChambre;

        Chambre uneChambre;

        SqlConnection maConnexion = AccesBD.GetConnexionBD().GetSqlConnexion();

        List<Chambre> lesChambres = new List<Chambre>();

        SqlCommand cmd = new SqlCommand();
        cmd.Connection = maConnexion;
        cmd.CommandText = "SELECT * FROM CHAMBRE";

        SqlDataReader monReader = cmd.ExecuteReader();

        while (monReader.Read())
        {
            idChambre = Convert.ToInt32(monReader["ID_CHAMBRE"].ToString());
            etageChambre = Convert.monReader["ETAGE_CHAMBRE"].ToString();
            numeroChambre = Convert.ToInt32(monReader["NUMERO_CHAMBRE"].ToString());
            nbLitChambre = Convert.monReader["NB_LIT_CHAMBRE"].ToString();
            prixChambre = Convert.ToInt32(monReader["PRIX_CHAMBRE"].ToString());

            uneChambre = new Chambre(Convert.ToInt32(idClient), Convert.ToInt32(etageChambre), Convert.ToInt32(numeroChambre), Convert.ToInt32(nbLitChambre), Convert.ToInt32(prixChambre));
            lesChambres.Add(uneChambre);
        }
        maConnexion.Close();

        return lesChambres;
    }
    
    public static int EnregistrerChambre(Chambre uneChambre)
    {
        int nbEnr;

        SqlConnection maConnexion = AccesBD.GetConnexionBD().GetSqlConnexion();

        SqlCommand cmd = new SqlCommand();
        cmd.Connection = maConnexion;
        cmd.CommandText = "INSERT INTO CHAMBRE VALUES ('" + uneChambre.getEtageChambre() + "','" + uneChambre.getNumeroChambre() + "','" + uneChambre.getNbLitChambre() + "','" + uneChambre.getPrixChambre() + "')";

        nbEnr = cmd.ExecuteNonQuery();
        maConnexion.Close();
        return nbEnr;
    }
    
    public int SupprimerChambre(Chambre uneChambre)
    {
        int nbEnregSup;
        // on récupère l'objet responsable de la connexion à la base
        SqlConnection maConnexion = AccesBD.GetConnexionBD().GetSqlConnexion();

        // on crée l'objet qui va contenir la requête SQL qui sera exécutée
        SqlCommand cmd = new SqlCommand();
        cmd.Connection = maConnexion;
        cmd.CommandText = "DELETE FROM CHAMBRE WHERE ID_CHAMBRE =" + uneChambre.getIdChambre();

        // on exécute la requête
        nbEnregSup = cmd.ExecuteNonQuery();
        // on retourne le nombre d'enregistrements ajoutés
        return nbEnregSup;
    }
    
    public int ModifierChambre(Chambre uneChambre)
    {
        int nbEnregAjout;
        // on récupère l'objet responsable de la connexion à la base
        SqlConnection maConnexion = AccesBD.GetConnexionBD().GetSqlConnexion();

        // on crée l'objet qui va contenir la requête SQL qui sera exécutée
        SqlCommand cmd = new SqlCommand();
        cmd.Connection = maConnexion;

        cmd.CommandText = "UPDATE CHAMBRE SET ETAGE_CHAMBRE = '" + uneChambre.getEtageChambre() + "', NUMERO_CHAMBRE='" +
                uneChambre.getNumeroChambre() + "',NB_LIT_CHAMBRE ='" + uneChambre.getNbLitChambre() + "',PRIX_CHAMBRE='" + uneChambre.getPrixChambre() +
                "' WHERE ID_CHAMBRE ='" + uneChambre.getIdChambre() + "'";

        // on exécute la requête
        nbEnregAjout = cmd.ExecuteNonQuery();
        // on retourne le nombre d'enregistrements ajoutés
        return nbEnregAjout;
    }
}
