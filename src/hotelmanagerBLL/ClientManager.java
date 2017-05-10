/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagerBLL;
import  hotelmanagerBO.Client;
import hotelmanagerDAO.ClientDAO;
import hotelmanagerDAO.AccesBD;
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
public class ClientManager {
    
        private static ClientManager unClient;

        public static ClientManager GetClients()
        {
            if (unClient == null)
            {
                unClient = new ClientManager();
            }
            return unClient;
        }

        public static void SetchaineConnexion(ConnectionStringSettings chset)
        {
            String chaine = chset.ConnectionString;
            AccesBD.GetConnexionBD().SetchaineConnexion(chaine);
        }

        public static List<Client> GetClient()
        {
            return ClientDAO.GetClient();
        }

        public static int EnregistrerClient(String nomClient, String prenomClient, String emailClient, int telClient)
        {
            Client client;
            client = new Client(nomClient, prenomClient, emailClient, telClient);
            return ClientDAO.EnregistrerClient(client);
        }

        public static int SupprimerClient(int idClient)
        {
            Client client;
            client = new Client(idClient);
            return ClientDAO.GetunClientDAO().SupprimerClient(client);
        }

        public static int ModifierClient(int idClient, String nomClient, String prenomClient, String emailClient, int telClient)
        {
            Client client;
            client = new Client(idClient, nomClient, prenomClient, emailClient, telClient);
            return ClientDAO.GetunClientDAO().ModifierClient(client);
        }
}
