/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Jacob
 */
public class Dosages {
    private int dosage_code;
    private String dosage_quantite;
    private String dosage_unite;
    
    public Dosages(int unDosage_code, String unDosage_quantite, String unDosage_unite)
    {
        dosage_code = unDosage_code;
        dosage_quantite = unDosage_quantite;
        dosage_unite = unDosage_unite;
    
    }
    public Dosages(String unDosage_quantite, String unDosage_unite)
    {
        dosage_quantite = unDosage_quantite;
        dosage_unite = unDosage_unite;
    
    }

    /**
     * @return the dosage_code
     */
    public int getDosage_code() {
        return dosage_code;
    }

    /**
     * @param dosage_code the dosage_code to set
     */
    public void setDosage_code(int dosage_code) {
        this.dosage_code = dosage_code;
    }

    /**
     * @return the dosage_quantite
     */
    public String getDosage_quantite() {
        return dosage_quantite;
    }

    /**
     * @param dosage_quantite the dosage_quantite to set
     */
    public void setDosage_quantite(String dosage_quantite) {
        this.dosage_quantite = dosage_quantite;
    }

    /**
     * @return the dosage_unite
     */
    public String getDosage_unite() {
        return dosage_unite;
    }

    /**
     * @param dosage_unite the dosage_unite to set
     */
    public void setDosage_unite(String dosage_unite) {
        this.dosage_unite = dosage_unite;
    }
    
    
}
