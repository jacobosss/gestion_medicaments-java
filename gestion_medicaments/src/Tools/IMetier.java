/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import Entity.TypeIndividu;
import Entity.Medicament;
import Entity.TypeIndividu;
import java.util.ArrayList;

/**
 *
 * @author Jacob
 */
public interface IMetier {
    //Récupération des individus
    public ArrayList<TypeIndividu> getAllIndividus();
    
    //Gestion des familles
    public ArrayList<String> getFamLib();
    public int getFamCodeByFamLib(String famLib);
    
    //Gestion des prescriptions
    public Boolean addPrescription(String med_nomCommercial, String tin_libelle, String dos_quantite, String dos_unite, String pre_posologie);
    
    
    // Gestion des médicaments
    public Boolean addMedoc(String med_nomcommercial, String fam_libelle, String med_composition, String med_effets, String med_contreindic, float med_prixechantillon);
    public ArrayList<Medicament> getMedoc();
    
}
