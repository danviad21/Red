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
public class Producto {
    
    private int idProducto;
    private String descripProd;
    private float precioVenta;
    private float existenciaProd;
    private int idTipoProd;

    /**
     * @return the idProducto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the descripProd
     */
    public String getDescripProd() {
        return descripProd;
    }

    /**
     * @param descripProd the descripProd to set
     */
    public void setDescripProd(String descripProd) {
        this.descripProd = descripProd;
    }

    /**
     * @return the precioVenta
     */
    public float getPrecioVenta() {
        return precioVenta;
    }

    /**
     * @param precioVenta the precioVenta to set
     */
    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    /**
     * @return the existenciaProd
     */
    public float getExistenciaProd() {
        return existenciaProd;
    }

    /**
     * @param existenciaProd the existenciaProd to set
     */
    public void setExistenciaProd(float existenciaProd) {
        this.existenciaProd = existenciaProd;
    }

    /**
     * @return the idTipoProd
     */
    public int getIdTipoProd() {
        return idTipoProd;
    }

    /**
     * @param idTipoProd the idTipoProd to set
     */
    public void setIdTipoProd(int idTipoProd) {
        this.idTipoProd = idTipoProd;
    }

    @Override
    public String toString() {
        return idProducto+") "+ descripProd+" Q "+existenciaProd;
    }
    
    
}
