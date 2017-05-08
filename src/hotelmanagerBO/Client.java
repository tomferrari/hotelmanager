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
public class Client {
    
    private int idClient;
    private String nomClient;
    private String prenomClient;
    private String emailClient;
    private int telClient;
    
    //Constructeur
    public Client (int idClient, String nomClient, String prenomClient, String emailClient, int telClient)
    {
        this.idClient = idClient;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.emailClient = emailClient;
        this.telClient = telClient;
    }
    
    public Client (String nomClient, String prenomClient, String emailClient, int telClient)
    {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.emailClient = emailClient;
        this.telClient = telClient;
    }
    
    public Client (int idClient)
    {
        this.idClient = idClient;
    }
    
    //Getters
    public int getIdClient()
    {
        return idClient;
    }
    
    public String getNomClient()
    {
        return nomClient;
    }
    
    public String getPrenomClient()
    {
        return prenomClient;
    }
    
    public String getEmailClient()
    {
        return emailClient;
    }
    
    public int getTelClient()
    {
        return telClient;
    }
    
    
    //Setters
    public void setIdClient(int idClient)
    {
      this.idClient = idClient;
    }
    
    public void setNomClient(String nomClient)
    {
      this.nomClient = nomClient;
    }
    
    public void setPrenomClient(String prenomClient)
    {
      this.prenomClient = prenomClient;
    }
    
    public void setEmailClient(String emailClient)
    {
      this.emailClient = emailClient;
    }
    
    public void setTelClient(int telClient)
    {
      this.telClient = telClient;
    }
    
    
    
}
