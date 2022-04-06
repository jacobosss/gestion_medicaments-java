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
public class TypeIndividu {
    private int idIndividu;
    private String libelleIndividu;
    
    
    public TypeIndividu(int unIdIndividu,String unLibelleIndividu)
    {
        idIndividu = unIdIndividu;
        libelleIndividu = unLibelleIndividu;
    }
    

    /**
     * @return the idIndividu
     */
    public int getIdIndividu() {
        return idIndividu;
    }

    /**
     * @param idIndividu the idIndividu to set
     */
    public void setIdIndividu(int idIndividu) {
        this.idIndividu = idIndividu;
    }

    /**
     * @return the libelleIndividu
     */
    public String getLibelleIndividu() {
        return libelleIndividu;
    }

    /**
     * @param libelleIndividu the libelleIndividu to set
     */
    public void setLibelleIndividu(String libelleIndividu) {
        this.libelleIndividu = libelleIndividu;
    }
    
    
    
}
