/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author athid
 */
public class Users {
    
    private int idUser;
    private String nomUser;
    private String prenomUser;
    
    public Users(int unId, String unNom,String unPrenom)
    {
        idUser =unId;
        nomUser = unNom;
        prenomUser = unPrenom;
    }

    /**
     * @return the idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the nomUser
     */
    public String getNomUser() {
        return nomUser;
    }

    /**
     * @param nomUser the nomUser to set
     */
    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    /**
     * @return the prenomUser
     */
    public String getPrenomUser() {
        return prenomUser;
    }

    /**
     * @param prenomUser the prenomUser to set
     */
    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }
    
   

}
