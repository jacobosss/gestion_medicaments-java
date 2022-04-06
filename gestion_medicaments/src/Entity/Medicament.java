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
public class Medicament {
    private int med_depotlegal;
    private String med_nomcommercial;
    private int fam_code;
    private String med_composition;
    private String med_effets;
    private String med_contreindic;
    private Float med_prixechantillon;
    
    public Medicament(int unMed_depotlegal, String unMed_nomcommercial, int uneFam_code, String unMed_composition, String unMed_effets, String unMed_contreindic, Float unMed_prixechantillon)
            {
                med_depotlegal= unMed_depotlegal;
                med_nomcommercial= unMed_nomcommercial;
                fam_code= uneFam_code;
                med_composition= unMed_composition;
                med_effets= unMed_effets;
                med_contreindic= unMed_contreindic;
                med_prixechantillon=unMed_prixechantillon;
                
            }

    public Medicament(int unMed_depotlegal, String unMed_nomcommercial) {
         med_depotlegal= unMed_depotlegal;
         med_nomcommercial= unMed_nomcommercial;
    }
    public Medicament(String unMed_nomcommercial) {
         med_nomcommercial= unMed_nomcommercial;
    }
    /**
     * @return the med_depotlegal
     */
    public int getMed_depotlegal() {
        return med_depotlegal;
    }

    /**
     * @param med_depotlegal the med_depotlegal to set
     */
    public void setMed_depotlegal(int med_depotlegal) {
        this.med_depotlegal = med_depotlegal;
    }

    /**
     * @return the        return med_depotlegal;
 med_nomcommercial
     */
    public String getMed_nomcommercial() {
        return med_nomcommercial;
    }

    /**
     * @param med_nomcommercial the med_nomcommercial to set
     */
    public void setMed_nomcommercial(String med_nomcommercial) {
        this.med_nomcommercial = med_nomcommercial;
    }

    /**
     * @return the fam_code
     */
    public int getFam_code() {
        return fam_code;
    }

    /**
     * @param fam_code the fam_code to set
     */
    public void setFam_code(int fam_code) {
        this.fam_code = fam_code;
    }

    /**
     * @return the med_composition
     */
    public String getMed_composition() {
        return med_composition;
    }

    /**
     * @param med_composition the med_composition to set
     */
    public void setMed_composition(String med_composition) {
        this.med_composition = med_composition;
    }

    /**
     * @return the med_effets
     */
    public String getMed_effets() {
        return med_effets;
    }

    /**
     * @param med_effets the med_effets to set
     */
    public void setMed_effets(String med_effets) {
        this.med_effets = med_effets;
    }

    /**
     * @return the med_contreindic
     */
    public String getMed_contreindic() {
        return med_contreindic;
    }

    /**
     * @param med_contreindic the med_contreindic to set
     */
    public void setMed_contreindic(String med_contreindic) {
        this.med_contreindic = med_contreindic;
    }

    /**
     * @return the med_prixechantillon
     */
    public Float getMed_prixechantillon() {
        return med_prixechantillon;
    }

    /**
     * @param med_prixechantillon the med_prixechantillon to set
     */
    public void setMed_prixechantillon(Float med_prixechantillon) {
        this.med_prixechantillon = med_prixechantillon;
    }
    
}
