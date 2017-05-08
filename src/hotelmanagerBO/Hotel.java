/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagerBO;

/**
 *
 * @author Thomas
 */
public class Hotel {
    
    private int idHotel;
    private String nomHotel;
    private String adresseHotel;
    private int nbChambreHotel;
    
    //Constructeur
    public Hotel (int idHotel, String nomHotel, String adresseHotel, int nbChambreHotel)
    {
        this.idHotel = idHotel;
        this.nomHotel = nomHotel;
        this.adresseHotel = adresseHotel;
        this.nbChambreHotel = nbChambreHotel;
    }
    
    //Getters
    public int getIdHotel()
    {
        return idHotel;
    }
    
    public String getNomHotel()
    {
        return nomHotel;
    }
    
    public String getAdresseHotel()
    {
        return adresseHotel;
    }
    
    public int getNbChambreHotel()
    {
        return nbChambreHotel;
    }
    
    //Setters
    public void setIdHotel(int idHotel)
    {
      this.idHotel = idHotel;
    }
    
    public void setNomHotel(String nomHotel)
    {
      this.nomHotel = nomHotel;
    }
    
    public void setAdresseHotel(String adresseHotel)
    {
      this.adresseHotel = adresseHotel;
    }
    
    public void setNbChambreHotel(int nbChambreHotel)
    {
      this.nbChambreHotel = nbChambreHotel;
    }
}
