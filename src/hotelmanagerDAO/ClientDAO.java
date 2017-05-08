/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagerDAO;
import  hotelmanagerBO.Client;
import hotelmanagerBLL.ClientManager;
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
public class ClientDAO {
    
    private static ClientDAO unClientDAO;

        public static ClientDAO GetunClientDAO()
        {
            if (unClientDAO == null)
            {
                unClientDAO = new ClientDAO();
            }
            return unClientDAO;
        }
        
        public static List<Client> GetClient()
        {
            int idClient;
            String nomClient;
            String prenomClient;
            String emailClient;
            int telClient;

            Client unClient;

            SqlConnection maConnexion = AccesBD.GetConnexionBD().GetSqlConnexion();

            List<Client> lesClients = new List<Client>();

            SqlCommand cmd = new SqlCommand();
            cmd.Connection = maConnexion;
            cmd.CommandText = "SELECT * FROM CLIENT";

            SqlDataReader monReader = cmd.ExecuteReader();

            while (monReader.Read())
            {
                idClient = Convert.ToInt32(monReader["ID_CLIENT"].ToString());
                nomClient = monReader["NOM_CLIENT"].ToString();
                prenomClient = Convert.ToInt32(monReader["PRENOM_CLIENT"].ToString());
                emailClient = monReader["EMAIL_CLIENT"].ToString();
                telClient = Convert.ToInt32(monReader["TEL_CLIENT"].ToString());


                //proprietaire = new PROPRIETAIRE(Convert.ToInt32(proprietaire.ID), proprietaire.NOM);
                //entraineur = new ENTRAINEUR(Convert.ToInt32(entraineur.ID), entraineur.NOM);
                unClient = new Client(Convert.ToInt32(idClient), nomClient, prenomClient, emailClient, Convert.ToInt32(telClient));
                lesClients.Add(unClient);
            }
            maConnexion.Close();

            return lesClients;
        }
        
        public static int EnregistrerClient(Client unClient)
        {
            int nbEnr;

            SqlConnection maConnexion = AccesBD.GetConnexionBD().GetSqlConnexion();

            SqlCommand cmd = new SqlCommand();
            cmd.Connection = maConnexion;
            cmd.CommandText = "INSERT INTO CLIENT VALUES ('" + unClient.getNomClient() + "','" + unClient.getPrenomClient() + "','" + unClient.getEmailClient() + "','" + unClient.getTelClient() + "')";

            nbEnr = cmd.ExecuteNonQuery();
            maConnexion.Close();
            return nbEnr;
        }
        
        public int SupprimerClient(Client unClient)
        {
            int nbEnregSup;
            // on récupère l'objet responsable de la connexion à la base
            SqlConnection maConnexion = AccesBD.GetConnexionBD().GetSqlConnexion();

            // on crée l'objet qui va contenir la requête SQL qui sera exécutée
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = maConnexion;
            cmd.CommandText = "DELETE FROM CLIENT WHERE ID_CLIENT =" + unClient.getIdClient();

            // on exécute la requête
            nbEnregSup = cmd.ExecuteNonQuery();
            // on retourne le nombre d'enregistrements ajoutés
            return nbEnregSup;
        }
        
        public int ModifierClient(Client unClient)
        {
            int nbEnregAjout;
            // on récupère l'objet responsable de la connexion à la base
            SqlConnection maConnexion = AccesBD.GetConnexionBD().GetSqlConnexion();

            // on crée l'objet qui va contenir la requête SQL qui sera exécutée
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = maConnexion;

            cmd.CommandText = "UPDATE CLIENT SET NOM_CLIENT = '" + unClient.getNomClient() + "', PRENOM_CLIENT='" +
                    unClient.getPrenomClient() + "',EMAIL_CLIENT ='" + unClient.getEmailClient() + "',TEL_CLIENT='" + unClient.getTelClient() +
                    "' WHERE ID_CLIENT ='" + unClient.getIdClient() + "'";

            // on exécute la requête
            nbEnregAjout = cmd.ExecuteNonQuery();
            // on retourne le nombre d'enregistrements ajoutés
            return nbEnregAjout;
        }
    
}
