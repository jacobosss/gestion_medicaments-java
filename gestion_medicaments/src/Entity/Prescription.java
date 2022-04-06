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
public class Prescription {
    private int med_depotLegal;
    private int tin_code;
    private int dos_code;
    private String pre_posologie;
    
    
    public Prescription(int unMed_depotLegal, int unTin_code,int unDos_code, String unePre_posologie)
    {
        med_depotLegal = unMed_depotLegal;
        tin_code = unTin_code;
        dos_code = unDos_code;
        pre_posologie = unePre_posologie;
    }

    /**
     * @return the med_depotLegal
     */
    public int getMed_depotLegal() {
        return med_depotLegal;
    }

    /**
     * @param med_depotLegal the med_depotLegal to set
     */
    public void setMed_depotLegal(int med_depotLegal) {
        this.med_depotLegal = med_depotLegal;
    }

    /**
     * @return the tin_code
     */
    public int getTin_code() {
        return tin_code;
    }

    /**
     * @param tin_code the tin_code to set
     */
    public void setTin_code(int tin_code) {
        this.tin_code = tin_code;
    }

    /**
     * @return the dos_code
     */
    public int getDos_code() {
        return dos_code;
    }

    /**
     * @param dos_code the dos_code to set
     */
    public void setDos_code(int dos_code) {
        this.dos_code = dos_code;
    }

    /**
     * @return the pre_posologie
     */
    public String getPre_posologie() {
        return pre_posologie;
    }

    /**
     * @param pre_posologie the pre_posologie to set
     */
    public void setPre_posologie(String pre_posologie) {
        this.pre_posologie = pre_posologie;
    }
    
    
}
