/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagerBLL;
import  hotelmanagerBO.Chambre;
import hotelmanagerDAO.ChambreDAO;
import hotelmanagerDAO.AccesBD;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Thomas
 */
public class ChambreManager {
    
    private static ChambreManager uneChambre;
    
    public static ChambreManager GetChambres()
    {
        if (uneChambre == null)
        {
            uneChambre = new ChambreManager();
        }
        return uneChambre;
    }
    
    public static void SetchaineConnexion(ConnectionStringSettings chset)
    {
        String chaine = chset.ConnectionString;
        AccesBD.GetConnexionBD().SetchaineConnexion(chaine);
    }
    
    public static List<Chambre> GetChambre()
    {
        return ChambreDAO.GetChambre();
    }
    
    public static int EnregistrerChambre(int etageChambre, int numeroChambre, int nbLitChambre, int prixChambre)
    {
        Chambre chambre;
        chambre = new Chambre(etageChambre, numeroChambre, nbLitChambre, prixChambre);
        return ChambreDAO.EnregistrerChambre(chambre);
    }
    
    public static int SupprimerChambre(int idChambre)
    {
        Chambre chambre;
        chambre = new Chambre(idChambre);
        return ChambreDAO.GetuneChambreDAO().SupprimerChambre(chambre);
    }
    
    public static int ModifierChambre(int idChambre, int etageChambre, int numeroChambre, int nbLitChambre, int prixChambre)
    {
        Chambre chambre;
        chambre = new Chambre(idChambre, etageChambre, numeroChambre, nbLitChambre, prixChambre);
        return ChambreDAO.GetuneChambreDAO().ModifierChambre(chambre);
    }
}
