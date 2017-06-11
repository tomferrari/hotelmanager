package hotelmanagerDAO;

import hotelmanagerBO.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClientDAO {
    
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;
    
    public ClientDAO()
    {
        conn = DataBaseConnection.connectTODB();
    }
      public void insertCustomer(Client user)  {
        try {
            String insertQuery = "insert into userInfo"
                    + "('" + "name" + "'," + "'" + "surname" + "','" + "adress" + "','" + "phone" + "')"
                    + " values('"
                    + user.getName()
                    + "','" + user.getSurname() + "'"
                    + ",'" + user.getAddress() + "'"
                    + ",'" + user.getPhone_no() + "'"
                    + ")";

            //System.out.println(">>>>>>>>>> "+ insertQuery);
            statement = conn.prepareStatement(insertQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Client ajouté");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
        finally
        {
            flushStatementOnly();
        }
        
        
    }
    
    public void updateCustomer(Client user) {
        
        try {
            String updateQuery = "update userInfo set name = '"
                    + user.getName() + "',"
                    + "surname = '" + user.getSurname() + "',"
                    + "adress = '" + user.getAddress() + "',"
                    + "phone = '" + user.getPhone_no() + "' where user_id= "
                    + user.getCustomer_id();

            //System.out.println(">>>>>>>>>> "+ insertQuery);
            //System.out.println(updateQuery);
            statement = conn.prepareStatement(updateQuery);

            //System.out.println(updateQuery);
            statement.execute();

            JOptionPane.showMessageDialog(null, "Client modifié");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
        
        finally
        {
            flushStatementOnly();
        }

    }

    public void deleteCustomer(int userId) throws SQLException {
        try {
            String deleteQuery = "delete from userInfo where user_id=" + userId;
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
            String query = "select * from userInfo";
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
