/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagerDAO;
import  hotelmanagerBO.Chambre;
import hotelmanagerDAO.ChambreDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Thomas
 */
public class ChambreDAO {
    
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;
    
    public ChambreDAO()
    {
        conn = AccesBD.connectTODB();
    }
    
    public void insertCustomer(Chambre chambre)  {
        try {
            String insertQuery = "insert into Chambre"
                    + "('" + "etageChambre" + "'," + "'" + "numeroChambre" + "','" + "nbLitChambre" + "','" + "prixChambre" + "')"
                    + " values('"
                    + chambre.getEtageChambre()
                    + "','" + chambre.getNumeroChambre() + "'"
                    + ",'" + chambre.getNbLitChambre() + "'"
                    + ",'" + chambre.getPrixChambre() + "'"
                    + ")";

            //System.out.println(">>>>>>>>>> "+ insertQuery);
            statement = conn.prepareStatement(insertQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Nouvelle chambre ajouté");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
        finally
        {
            flushStatementOnly();
        }  
    }
    
    public void updateCustomer(Chambre chambre) {
        try {
            String updateQuery = "update Chambre set etageChambre = '"
                    + chambre.getEtageChambre() + "',"
                    + "numeroChambre = '" + chambre.getNumeroChambre() + "',"
                    + "nbLitChambre = '" + chambre.getNbLitChambre() + "',"
                    + "prixChambre = '" + chambre.getPrixChambre() + "' where idChambre= "
                    + chambre.getIdChambre();

            //System.out.println(">>>>>>>>>> "+ insertQuery);
            //System.out.println(updateQuery);
            statement = conn.prepareStatement(updateQuery);

            //System.out.println(updateQuery);
            statement.execute();

            JOptionPane.showMessageDialog(null, "Chambre mise à jour");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
        
        finally
        {
            flushStatementOnly();
        }

    }
    
    public void deleteCustomer(int idChambre) throws SQLException {
        try {
            String deleteQuery = "delete from Chambre where idChambre=" + idChambre;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Chambre supprimée");
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
            String query = "select * from Chambre";
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
