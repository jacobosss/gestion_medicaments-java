/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.Dosages;
import Entity.TypeIndividu;
import Entity.Medicament;
import Entity.TypeIndividu;
import Entity.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class FonctionMetier implements IMetier{

    // Fonction qui sert a récupérer les individus dans un tableau
    @Override
    public ArrayList<TypeIndividu> getAllIndividus() {
        
       ArrayList<TypeIndividu> arr = new ArrayList<>();
        try {
             Connection c = ConnexionBdd.getCnx();
            PreparedStatement s = c.prepareStatement("select TIN_CODE, TIN_LIBELLE from type_individu");
            ResultSet rs = s.executeQuery();
            while(rs.next())
            {
               arr.add(new TypeIndividu(rs.getInt("TIN_CODE"), rs.getString("TIN_LIBELLE"))); 
            }
                  
        } 
        catch(SQLException exception) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, exception);
        }
       
        return arr;
    }
    
    // Fonction qui permet de modifier un individu
     public void updateIndividu(int code, String libelle) {
       
        try {
             Connection c = ConnexionBdd.getCnx();
            PreparedStatement s = c.prepareStatement("update type_individu set TIN_LIBELLE='"+ libelle +"' where TIN_CODE="+code+"");
            s.execute();               
        } 
        catch(SQLException exception) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, exception);
        }
        
     
    }
     
    //fonction qui récupère le libellé d'une famille de médicaments
    public ArrayList<String> getFamLib() {
        
       ArrayList<String> arr = new ArrayList<>();
        try {
            
             Connection c = ConnexionBdd.getCnx();
            PreparedStatement s = c.prepareStatement("select FAM_LIBELLE from famille");
            ResultSet rs = s.executeQuery();
            while(rs.next())
            {
               arr.add(new String(rs.getString("FAM_LIBELLE"))); 
            }
                  
        } 
        catch(SQLException exception) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, exception);
        }
     return arr;
    }
    //Fonction qui récupuère le code par libellé d'une famille de médicaments envoyée en paramètre
    public int getFamCodeByFamLib(String famLib){
        
        int code=0;
        try {
            Connection c = ConnexionBdd.getCnx();
            PreparedStatement s = c.prepareStatement("select FAM_CODE from famille WHERE FAM_LIBELLE ='"+famLib+"'");
            ResultSet rs = s.executeQuery();
            while(rs.next())
            {
               code = rs.getInt("FAM_CODE"); 
            }
                  
        } 
        catch(SQLException exception) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, exception);
        }
       
        return code;
    }
    
    //Fonction qui ajoute un médicament
    public Boolean addMedoc(String med_nomcommercial, String fam_libelle, String med_composition, String med_effets, String med_contreindic, float med_prixechantillon) {

        try {
             Connection c = ConnexionBdd.getCnx();
             //recuperer le code de la famille a partir du libelle
            int fam_code = getFamCodeByFamLib(fam_libelle);
            PreparedStatement s = c.prepareStatement("INSERT INTO medicaments VALUES (null,'"+med_nomcommercial+"',"+fam_code+",'"+ med_composition+"','"+med_effets+"','"+ med_contreindic+"',"+med_prixechantillon+")");
           s.executeUpdate();
            return true;
                           
        } 
        catch(SQLException exception) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, exception);
            return false;
        }
    }
    
    @Override
    
    //Fonction qui permet de récupérer les médicaments et les mettre dans un tableau
    public ArrayList<Medicament> getMedoc() {
        
       ArrayList<Medicament> arr = new ArrayList<>();
        try {
            
            Connection c = ConnexionBdd.getCnx();
            PreparedStatement s = c.prepareStatement("select MED_DEPOTLEGAL, MED_NOMCOMMERCIAL from medicaments");
            ResultSet rs = s.executeQuery();
            while(rs.next())
            {
               arr.add(new Medicament(rs.getInt("MED_DEPOTLEGAL"), rs.getString("MED_NOMCOMMERCIAL"))); 
            }
                  
        } 
        catch(SQLException exception) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, exception);
        }
     return arr;
    }
    
    //Fonction qui permet de récupérer les dosages et les met dans un tableau
    public ArrayList<Dosages> getAllDosages() {
        
       ArrayList<Dosages> arr = new ArrayList<>();
        try {
             Connection c = ConnexionBdd.getCnx();
            PreparedStatement s = c.prepareStatement("select DOS_CODE, DOS_QUANTITE, DOS_UNITE from dosages");
            ResultSet rs = s.executeQuery();
            while(rs.next())
            {
               arr.add(new Dosages(rs.getInt("DOS_CODE"), rs.getString("DOS_QUANTITE"), rs.getString("DOS_UNITE"))); 
            }
                  
        } 
        catch(SQLException exception) {
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, exception);
        }
       
        return arr;
    }

    @Override
    
    //Fonction qui permet d'ajouter une prescription
    public Boolean addPrescription(String med_nomCommercial, String tin_libelle, String dos_quantite, String dos_unite, String pre_posologie) {
        try {
             Connection c = ConnexionBdd.getCnx();
             PreparedStatement ps = c.prepareStatement("select MED_DEPOTLEGAL from medicaments where MED_NOMCOMMERCIAL='"+med_nomCommercial+"'");
             ResultSet rs  = ps.executeQuery();
             rs.next();
             int numMedoc = rs.getInt(1);
             
             
             ps = c.prepareStatement("select tin_code from type_individu where tin_libelle='"+tin_libelle+"'");
             rs  = ps.executeQuery();
             rs.next();
             int numInd= rs.getInt(1);
                     
             ps = c.prepareStatement("select dos_code from dosages where dos_quantite='"+dos_quantite+"'and dos_unite='"+dos_unite+"'");
             rs  = ps.executeQuery();
             rs.next();
             int numDos= rs.getInt(1);     
            
            ps = c.prepareStatement("insert into prescription values("+numMedoc+","+numInd+","+numDos+",'"+pre_posologie+"')");
            ps.executeUpdate();
            return true;
        } 
        catch(SQLException exception) {
                           
            Logger.getLogger(ConnexionBdd.class.getName()).log(Level.SEVERE, null, exception);
            return false;
        }
    }
    
    //Statistique en camembert affichant le nombre de médicaments par famille de médicaments
    public HashMap<String,Integer> GetDatasGraphique2() 
    {
        HashMap<String, Integer> datas = new HashMap();
        try {
             Connection cnx = ConnexionBdd.getCnx();
             PreparedStatement ps = cnx.prepareStatement("select famille.FAM_LIBELLE, COUNT(medicaments.MED_DEPOTLEGAL) as compteur from famille INNER join medicaments ON famille.FAM_CODE= medicaments.FAM_CODE group by famille.FAM_LIBELLE");
           ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                datas.put(rs.getString(1), rs.getInt(2));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return datas;
    }
    
    //Diagramme en bâtons affichant le nombre de prescriptions d'un médicament par type d'individu
    public HashMap<Integer,String[]> GetDatasGraphique3()
    {
        HashMap<Integer,String[]> datas = new HashMap();
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select medicaments.MED_NOMCOMMERCIAL, COUNT(prescription.TIN_CODE) as compteur, type_individu.TIN_LIBELLE from medicaments inner join prescription  ON medicaments.MED_DEPOTLEGAL= prescription.MED_DEPOTLEGAL inner join type_individu ON  prescription.TIN_CODE= type_individu.TIN_CODE group by medicaments.MED_NOMCOMMERCIAL");
           ResultSet rs = ps.executeQuery();
            int i = 1;
            while(rs.next())
            {
                datas.put(i, new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
                i++;
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return datas;
    }
    
    public Users GetUnUser(String login, String mdp)
    {
        Users unUser = null;
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select idUser, nomUser,prenomUser from users where loginUser = '"+login+"' and pwdUser = '"+mdp+"'");
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                unUser = new Users(rs.getInt("idUser"), rs.getString("nomUser"),rs.getString("prenomUser"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unUser;
    }
    
    public ArrayList<TypeIndividu> GetAllTypeIndivAT()
    {
        ArrayList<TypeIndividu> ticAT = new ArrayList<>();
        try {
             Connection c = ConnexionBdd.getCnx();
            PreparedStatement s = c.prepareStatement("select TIN_CODE, TIN_LIBELLE from type_individu");
            System.out.println(s);
            ResultSet rs = s.executeQuery();
            while(rs.next())
            {
               ticAT.add(new TypeIndividu(rs.getInt("TIN_CODE"), rs.getString("TIN_LIBELLE"))); 
            
            }
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ticAT;
    }
    
    // Fonction qui sert a récupérer les noms des médicaments
    public ArrayList<Medicament> getAllNomMedicaments() {
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
        try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("select MED_NOMCOMMERCIAL from medicaments");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                
                Medicament m = new Medicament( rs.getString("MED_NOMCOMMERCIAL"));
                lesMedicaments.add(m);
            }
            ps.close();
        
        }   catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
    }
    
    public void InsererInteraction(int numMedoc, int numMedocperturber) {
        try
        {
        Connection cnx = ConnexionBdd.getCnx();
        PreparedStatement ps = cnx.prepareStatement("insert into interagir values ("+numMedoc+","+numMedocperturber+")");
        ps.executeUpdate();

        } catch (SQLException ex) {
        Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
    
    // Fonction qui sert lister les médicaments perturbateurs 
   public ArrayList<Medicament> getAllMedicamentsPerturber(int code) {
    ArrayList<Medicament> lesMedicamentsPerturber = new ArrayList<>();
    try {
    Connection cnx = ConnexionBdd.getCnx();

    PreparedStatement ps = cnx.prepareStatement("select m.MED_DEPOTLEGAL , m.MED_NOMCOMMERCIAL from medicaments m inner join interagir i on m.MED_DEPOTLEGAL=i.MED_PERTURBATEUR where i.MED_PERTURBE= "+code);
    ResultSet rs = ps.executeQuery();
    while (rs.next())
    {

    Medicament m = new Medicament(rs.getInt("MED_DEPOTLEGAL"), rs.getString("MED_NOMCOMMERCIAL"));
    lesMedicamentsPerturber.add(m);
    }
    ps.close();

    } catch (SQLException ex) {
    Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
    }
    return lesMedicamentsPerturber;

    }
   
   // Fonction qui liste les médicaments non perturbateurs
    public ArrayList<Medicament> getAllMedicamentsNonPerturber(int code) {
    ArrayList<Medicament> lesMedicamentsPerturber = new ArrayList<>();
    try {
    Connection cnx = ConnexionBdd.getCnx();
    PreparedStatement ps = cnx.prepareStatement("select m.MED_DEPOTLEGAL , m.MED_NOMCOMMERCIAL from medicaments m Where MED_DEPOTLEGAL not in( select m.MED_DEPOTLEGAL from medicaments m inner join interagir i on m.MED_DEPOTLEGAL=i.MED_PERTURBATEUR where i.MED_PERTURBE = "+code+")AND MED_DEPOTLEGAL !="+code+"");
    ResultSet rs = ps.executeQuery();
    while (rs.next())
    {

    Medicament m = new Medicament(rs.getInt("MED_DEPOTLEGAL"), rs.getString("MED_NOMCOMMERCIAL"));
    lesMedicamentsPerturber.add(m);
    }
    ps.close();

    } catch (SQLException ex) {
    Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
    }
    return lesMedicamentsPerturber;

    }
    
    public ArrayList<Medicament> getAllMedicaments() {
        
        ArrayList<Medicament> lesMedicaments = new ArrayList<>();
    try {
        Connection cnx = ConnexionBdd.getCnx();
        PreparedStatement ps = cnx.prepareStatement("select MED_DEPOTLEGAL, MED_NOMCOMMERCIAL, FAM_CODE, MED_COMPOSITION, MED_EFFETS, MED_CONTREINDIC, MED_PRIXECHANTILLON from medicaments");
        ResultSet rs = ps.executeQuery();
    while (rs.next())
        {

        Medicament m = new Medicament(rs.getInt("MED_DEPOTLEGAL"), rs.getString("MED_NOMCOMMERCIAL"),rs.getInt("FAM_CODE"), rs.getString("MED_COMPOSITION"), rs.getString("MED_EFFETS"),rs.getString("MED_CONTREINDIC"),rs.getFloat("MED_PRIXECHANTILLON"));
        lesMedicaments.add(m);
        }
        ps.close();

        } 
    catch (SQLException ex) {
    Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesMedicaments;
        
    }
    
    // Fonction qui sert a modifier les médicaments
    public void ModifierMedicament(int unDepo, String unNom, String uneCompo, String unEffet, String unContreIndi){
    try {
            Connection cnx = ConnexionBdd.getCnx();
            PreparedStatement ps = cnx.prepareStatement("update medicaments as m set m.MED_NOMCOMMERCIAL='"+unNom+"', m.MED_COMPOSITION='"+uneCompo+"', m.MED_EFFETS='"+unEffet+"', m.MED_CONTREINDIC='"+unContreIndi+"' where m.MED_DEPOTLEGAL="+unDepo+"");
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FonctionMetier.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
}