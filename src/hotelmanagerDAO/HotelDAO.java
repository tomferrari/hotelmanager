/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagerDAO;

import hotelmanagerBO.Hotel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Thomas
 */
public class HotelDAO {
    
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;
    
    public HotelDAO()
    {
        conn = DataBaseConnection.connectTODB();
    }

     public void insertHotel(Hotel hotel) {
        try {
            String insertQuery = "insert into hotels"
                    + "('" + "hotel_adresse" + "'," + "'" + "hotel_nb_lit" + "')"
                    + " values('"
                    + hotel.getHotel_adresse()
                    + ",'" + hotel.getHotel_nb_lit() + "'"
                    + ")";

            statement = conn.prepareStatement(insertQuery);

            statement.execute();

            JOptionPane.showMessageDialog(null, "Hotel ajouté avec succées ");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
        finally
        {
            flushStatmentOnly();
        }
    }

    public ResultSet getHotels() {
        try {
            String query = "select * from hotel";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n Erreur");
        }
        
        return result;
    }
    

    public void deleteHotel(int hotelId) {

        try {
            String deleteQuery = "delete from hotel where hotel_id=" + hotelId;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();
            JOptionPane.showMessageDialog(null, "Hotel supprimé");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Erreur");
        }
        finally
        {
            flushStatmentOnly();
        }
    }
    
    public void updateHotel(Hotel hotel) 
    {
        try {
            String updateQuery = "update hotel set hotel_adresse = '"
                    + hotel.getHotel_adresse() + "',"
                    + "hotel_nb_lit = '" + hotel.getHotel_nb_lit() + "' where hotel_id= "
                    + hotel.getHotel_id();

            //System.out.println(">>>>>>>>>> "+ insertQuery);
            //System.out.println(updateQuery);
            statement = conn.prepareStatement(updateQuery);

            //System.out.println(updateQuery);
            statement.execute();

            JOptionPane.showMessageDialog(null, "Hotel modifié");
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
