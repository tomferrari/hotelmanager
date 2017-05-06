/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanager;

/**
 *
 * @author Thomas
 */
public class Client {
    
    private int id;
    private String nomClient;
    private String prenomClient;
    private String emailClient;
    private int telClient;
    
    
    public Client (int id, String nomClient, String prenomClient, String emailClient, int telClient)
    {
        this.id = id;
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.emailClient = emailClient;
        this.telClient = telClient;
    }
    
    public int getId()
    {
        return id;
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
    
    
}
