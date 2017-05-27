/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagerDAO;

import hotelmanagerBO.Client;
import hotelmanagerBLL.ClientManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Thomas
 */
public class ClientDAO {
    
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;
    
    public ClientDAO()
    {
        conn = AccesBD.connectTODB();
    }
    
    public void insertCustomer(Client client)  {
        try {
            String insertQuery = "insert into Client"
                    + "('" + "nomClient" + "'," + "'" + "prenomClient" + "','" + "emailClient" + "','" + "telClient" + "')"
                    + " values('"
                    + client.getNomClient()
                    + "','" + client.getPrenomClient() + "'"
                    + ",'" + client.getEmailClient() + "'"
                    + ",'" + client.getTelClient() + "'"
                    + ")";

            //System.out.println(">>>>>>>>>> "+ insertQuery);
            statement = conn.prepareStatement(insertQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Nouveau client ajouté");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
        finally
        {
            flushStatementOnly();
        }  
    }
    
    public void updateCustomer(Client client) {
        try {
            String updateQuery = "update Client set nomClient = '"
                    + client.getNomClient() + "',"
                    + "prenomClient = '" + client.getPrenomClient() + "',"
                    + "emailClient = '" + client.getEmailClient() + "',"
                    + "telClient = '" + client.getTelClient() + "' where idClient= "
                    + client.getIdClient();

            //System.out.println(">>>>>>>>>> "+ insertQuery);
            //System.out.println(updateQuery);
            statement = conn.prepareStatement(updateQuery);

            //System.out.println(updateQuery);
            statement.execute();

            JOptionPane.showMessageDialog(null, "Client mit à jour");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
        
        finally
        {
            flushStatementOnly();
        }

    }
    
    public void deleteCustomer(int idClient) throws SQLException {
        try {
            String deleteQuery = "delete from Client where idClient=" + idClient;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Client supprimé");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
        finally
        {
            flushStatementOnly();
        }

    }
    
    public ResultSet getAllCustomer() {
        try {
            String query = "select * from Client";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n Erreur");
        }
        

        return result;
    }
    
    private void flushStatementOnly()
    {
        {
            try
            {
                statement.close();
                //conn.close();
            }
            catch(SQLException ex)
            {System.err.print(ex.toString()+" >> CLOSING DB");}
        }
    }
    
    public void flushAll()
    {
        {
            try
            {
                statement.close();
                result.close();
            }
            catch(SQLException ex)
            {System.err.print(ex.toString()+" >> CLOSING DB");}
        }
    }
}
