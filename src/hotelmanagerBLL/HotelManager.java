/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagerBLL;
import  hotelmanagerBO.Hotel;
import hotelmanagerDAO.HotelDAO;
import hotelmanagerDAO.AccesBD;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Thomas
 */
public class HotelManager {
    
    private static HotelManager unHotel;

    public static HotelManager GetHotels()
    {
        if (unHotel == null)
        {
            unHotel = new HotelManager();
        }
        return unHotel;
    }

    public static void SetchaineConnexion(ConnectionStringSettings chset)
    {
        String chaine = chset.ConnectionString;
        AccesBD.GetConnexionBD().SetchaineConnexion(chaine);
    }

    public static List<Hotel> GetHotel()
    {
        return HotelDAO.GetHotel();
    }

    public static int EnregistrerHotel(String nomHotel, String adresseHotel, int nbChambreHotel)
    {
        Hotel hotel;
        hotel = new Hotel(nomHotel, adresseHotel, nbChambreHotel);
        return HotelDAO.EnregistrerHotel(hotel);
    }

    public static int SupprimerHotel(int idHotel)
    {
        Hotel hotel;
        hotel = new Hotel(idHotel);
        return HotelDAO.GetunHotelDAO().SupprimerHotel(hotel);
    }

    public static int ModifierHotel(int idHotel, String nomHotel, String adresseHotel, int nbChambreHotel)
    {
        Hotel hotel;
        hotel = new Hotel(idHotel, nomHotel, adresseHotel, nbChambreHotel);
        return HotelDAO.GetunHotelDAO().ModifierHotel(hotel);
    }
    
}
