package hotelmanagerBO;

/**
 *
 * @author Thomas
 */
public class Hotel {
    
    private int hotel_id;
    private String hotel_adresse;
    private String hotel_nb_lit;
    

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }
    
    public String getHotel_adresse()
    {
        return hotel_adresse;
    }
    
    public void setHotel_adresse(String hotel_adresse)
    {
        this.hotel_adresse = hotel_adresse;
    }
    
    public String getHotel_nb_lit()
    {
        return hotel_nb_lit;
    }
    
    public void setHotel_nb_lit (String hotel_nb_lit)
    {
        this.hotel_nb_lit = hotel_nb_lit;
    }
    
}
