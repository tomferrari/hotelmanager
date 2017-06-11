package hotelmanagerDAO;
import hotelmanagerBO.Chambre;
import hotelmanagerBO.ChambreType;
import hotelmanagerBO.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Faysal Ahmed
 */
public class DatabaseOperation {

    Connection conn = DataBaseConnection.connectTODB();
    PreparedStatement statement = null;
    ResultSet result = null;

    public void insertCustomer(Client user) throws SQLException {
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

            JOptionPane.showMessageDialog(null, "client ajouté");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
        finally
        {
            flushStatmentOnly();
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

    public void updateCustomer(Client user) {
        // update userInfo set name = 'faysal' ,address = 'dhaka' where user_id = 3
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

            JOptionPane.showMessageDialog(null, "Client modifé");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
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
            flushStatmentOnly();
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
        finally
        {
            flushAll();
        }

        return result;
    }


    public ResultSet getAvailableRooms(long check_inTime)
    {
       try {
            String query = "SELECT room_no FROM room LEFT OUTER JOIN booking ON room.room_no = booking.booking_room WHERE booking.booking_room is null or "+check_inTime+"< booking.check_in " +"or booking.check_out <"+check_inTime+" group by room.room_no  order by room_no ";
            System.out.println(query);
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n Erreur");
        }

      
        return result;
    }
    
    public ResultSet getBookingInfo(long start_date, long end_date,String roomNo)
    {
        try {
            
            String query = "select * from booking where booking_room = '"+ roomNo+"' AND ("
                    +"( check_in <= "+start_date +" and ( check_out = 0 or check_out<= "+end_date+") ) or"
                    +"( check_in >"+start_date+" and check_out< "+end_date+" ) or"
                    +"( check_in <= "+end_date +" and ( check_out =0 or check_out> "+end_date+") ) )";
                    
                    
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n Erreur");
        }
        

        return result;
    }
    
    public int getCustomerId(Client user)
    { int id = -1;
        try {
            String query = "select user_id from userInfo where name='"+user.getName()+"' and phone ='"+user.getPhone_no()+"'";
            
            System.out.println(query +" <<<");
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
            //System.out.println(" user id "+ result.getInt("user_id"));
            
            id = result.getInt("user_id");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n Erreur");
        }
       
        return id;
    }
    
    
    
    private void flushStatmentOnly()
    {
        {
                        try
                        {
                            statement.close();
                        }
                        catch(SQLException ex)
                        {System.err.print(ex.toString()+" >> CLOSING DB");}
                    }
    }
}
