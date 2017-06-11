package hotelmanagerDAO;

import hotelmanagerBO.Chambre;
import hotelmanagerBO.ChambreType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ChambreDAO {
    
    Connection conn = DataBaseConnection.connectTODB();
    PreparedStatement statement = null;
    ResultSet result = null;

     public void insertRoom(Chambre room) {
        try {
            String insertQuery = "insert into room('room_no','bed_number','room_class')"
                    + " values('"
                    + room.getRoom_no()
                    + "'," + room.getBed_number() + ""
                    + ",'" + room.getRoom_class().getRoom_type() + "'"
                    + ")";

            System.out.println(">>>>>>>>>> "+ room.getRoom_class().getRoom_type());
            statement = conn.prepareStatement(insertQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Chambre ajouté ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
        finally
        {
            flushStatmentOnly();
        }
    }

    public ResultSet getRooms() {
        try {
            String query = "select * from room";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n Erreur");
        }
        
        return result;
    }
    
    public int getNoOfRooms()
    {
        int rooms = -1;
        try {
            String query = "select count(room_no)  as noRoom from room";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
            while(result.next())
            {
                rooms = result.getInt("noRoom");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n erreur");
        }
        
        return rooms;
    }
    
    public ResultSet getAllRoomNames()
    {
         try {
            String query = "select room_no from room";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n Erreur");
        }
        
        return result;
    }

    public void deleteRoom(int roomId) {

        try {
            String deleteQuery = "delete from room where room_id=" + roomId;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Chambre supprimé");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
        finally
        {
            flushStatmentOnly();
        }
    }
    
    public void updateRoom(Chambre room)
    {
         try {
            String updateQuery ="update room set room_no = '"
                    +room.getRoom_no()+"', bed_number="
                    +room.getBed_number()+"', room_class= '"
                    +room.getRoom_class().getRoom_type()+"'";
                    

            System.out.println(">>>>>>>>>> "+ updateQuery);
            //System.out.println(updateQuery);
            statement = conn.prepareStatement(updateQuery);

            //System.out.println(updateQuery);
            statement.execute();

            JOptionPane.showMessageDialog(null, "Chambre modifié");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
         finally
         {
             flushStatmentOnly();
         }

    }

    public String boolToString(boolean value) {
        return value ? "true" : "false";
    }
    
    public void insertRoomType(ChambreType roomType) {
        try {
            String insertRoomTypeQuery = "insert into roomType values('" + roomType.getRoom_type() + "'," + roomType.getPricePerDay() + ")";

            System.out.println(">>>>>>>>>> " + insertRoomTypeQuery);

            statement = conn.prepareStatement(insertRoomTypeQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Type de chambre ajouté");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
        finally
        {
            flushStatmentOnly();
        }
    }

    public ResultSet getRoomType() {
        try {
            String query = "select * from roomType";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n Erreur");
        }

        return result;
    }

    public void updateRoomType(ChambreType roomType) {
        try {
            String updateRoomTypeQuery = "update roomType set price= " + roomType.getPricePerDay() + " where type='" + roomType.getRoom_type() + "'";

            //System.out.println(">>>>>>>>>> "+ updateRoomTypeQuery);
            statement = conn.prepareStatement(updateRoomTypeQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Type de chambre modifié");

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
