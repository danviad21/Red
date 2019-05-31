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
public class Red {
    
    private int idRed;
    private String nombreRed;
    private String ipRed;
    private String mascaraRed;
    private int esRedAdmin;

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

    /**
     * @return the nombreRed
     */
    public String getNombreRed() {
        return nombreRed;
    }

    /**
     * @param nombreRed the nombreRed to set
     */
    public void setNombreRed(String nombreRed) {
        this.nombreRed = nombreRed;
    }

    /**
     * @return the ipRed
     */
    public String getIpRed() {
        return ipRed;
    }

    /**
     * @param ipRed the ipRed to set
     */
    public void setIpRed(String ipRed) {
        this.ipRed = ipRed;
    }

    /**
     * @return the mascaraRed
     */
    public String getMascaraRed() {
        return mascaraRed;
    }

    /**
     * @param mascaraRed the mascaraRed to set
     */
    public void setMascaraRed(String mascaraRed) {
        this.mascaraRed = mascaraRed;
    }

    /**
     * @return the esRedAdmin
     */
    public int isEsRedAdmin() {
        return esRedAdmin;
    }

    /**
     * @param esRedAdmin the esRedAdmin to set
     */
    public void setEsRedAdmin(int esRedAdmin) {
        this.esRedAdmin = esRedAdmin;
    }

    @Override
    public String toString() {
        return nombreRed + " "+ipRed;
    }
    
    
}