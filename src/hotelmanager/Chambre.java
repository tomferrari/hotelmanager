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
public class Chambre {
    
    private int idChambre;
    private int etageChambre;
    private int numeroChambre;
    private int nbLitChambre;
    private int prixChambre;
    
    //Constructeur
    public Chambre (int idChambre, int etageChambre, int numeroChambre,int nbLitChambre,int prixChambre)
    {
        this.idChambre = idChambre;
        this.etageChambre = etageChambre;
        this.numeroChambre = numeroChambre;
        this.nbLitChambre = nbLitChambre;
        this.prixChambre = prixChambre;
    }
    
    //Getters
    public int getIdChambre()
    {
        return idChambre;
    }
    
    public int getEtageChambre()
    {
        return etageChambre;
    }
    
    public int getNumeroChambre()
    {
        return numeroChambre;
    }
    
    public int getNbLitChambre()
    {
        return nbLitChambre;
    }
    
    public int getPrixChambre()
    {
        return prixChambre;
    }
    
    //Setters
    public void setIdChambre(int idChambre)
    {
      this.idChambre = idChambre;
    }
    
    public void setEtageChambre(int etageChambre)
    {
      this.etageChambre = etageChambre;
    }
    
    public void setNumeroChambre(int numeroChambre)
    {
      this.numeroChambre = numeroChambre;
    }
    
    public void setNbLitChambre(int nbLitChambre)
    {
      this.nbLitChambre = nbLitChambre;
    }
    
    public void setPrixChambre(int prixChambre)
    {
      this.prixChambre = prixChambre;
    }
    
}
