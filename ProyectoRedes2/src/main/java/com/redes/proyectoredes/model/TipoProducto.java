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
public class TipoProducto {
    private int idTipoProducto;
    private String descripTipoProd;

    
    public TipoProducto(){
        
    }
    
    /**
     * @return the idTipoProducto
     */
    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    /**
     * @param idTipoProducto the idTipoProducto to set
     */
    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    /**
     * @return the descripTipoProd
     */
    public String getDescripTipoProd() {
        return descripTipoProd;
    }

    /**
     * @param descripTipoProd the descripTipoProd to set
     */
    public void setDescripTipoProd(String descripTipoProd) {
        this.descripTipoProd = descripTipoProd;
    }

    @Override
    public String toString() {
        return idTipoProducto+") "+descripTipoProd;
    }
    
    
    
}
