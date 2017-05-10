/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagerDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Thomas
 */
public class AccesBD {
    
        private SqlConnection maConnexion;
        private static AccesBD uneConnexionBD;
        private string chaineConnexion;

        public String GetchaineConnexion()
        {
            return chaineConnexion;
        }

        public void SetchaineConnexion(String ch)
        {
            chaineConnexion = ch;
        }

        public static AccesBD GetConnexionBD()
        {
            if (uneConnexionBD == null)
            {
                uneConnexionBD = new AccesBD();
            }
            return uneConnexionBD;
        }

        public SqlConnection GetSqlConnexion()
        {
            if (maConnexion == null)
            {
                maConnexion = new SqlConnection();
                maConnexion.ConnectionString = chaineConnexion;
            }

            // si la connexion est fermée, on l’ouvre
            if (maConnexion.State == System.Data.ConnectionState.Closed)
            {
                maConnexion.Open();
            }
            return maConnexion;
        }

        public void CloseConnexion()
        {
            // si la connexion est ouverte, on la ferme
            if (this.maConnexion != null && this.maConnexion.State != System.Data.ConnectionState.Closed)
            {
                this.maConnexion.Close();
            }
        }
    }
}
