/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.model;

/**
 *
 * @author danvi
 */
public class Usuario {

    private int idUser;
    private String userName;
    private String userPass;
    private int idRed;
    private boolean valido;

    /**
     */
    public Usuario(){
       
    }
    

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
       
    public int getIdUser() {
        return idUser;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userPass
     */
    public String getUserPass() {
        return userPass;
    }

    /**
     * @param userPass the userPass to set
     */
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    /**
     * @return the idRed
     */
    public int getIdRed() {
        return idRed;
    }

    /**
     * @param idRed the idRed to set
     */
    public void setIdRed(int idRed) {
        this.idRed = idRed;
    }
    
    public boolean esValido(){
        return valido;
    }
    
    public void setValido(boolean valido){
        this.valido = valido;
    }

    @Override
    public String toString() {
        return idUser+")"+userName+" "+userPass+" "+idRed;
    }
    
    
}
