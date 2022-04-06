/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class ConnexionBdd {
    private static Connection cnx;
    
    
    public static Connection getCnx() {
         try
        {
            String pilote = "com.mysql.jdbc.Driver";
            // chargement du pilote
            Class.forName(pilote);
            // L'objet connexion à la BDD avec le nom de la base, le user et le password
            //cnx = DriverManager.getConnection("jdbc:mysql://localhost/gestion_medicaments?serverTimezone="
                    //+ TimeZone.getDefault().getID(), "root", "root");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/gestion_medicaments","root", "root");
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cnx;
    }
    
}
