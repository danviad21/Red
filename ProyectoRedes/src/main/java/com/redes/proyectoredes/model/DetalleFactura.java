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
public class DetalleFactura {
    private int RegistroFact;
    private int idProducto;
    private float cantidadProducto;
    private float precioVenta;
    /**
     * @return the RegistroFact
     */
    public int getRegistroFact() {
        return RegistroFact;
    }

    /**
     * @param RegistroFact the RegistroFact to set
     */
    public void setRegistroFact(int RegistroFact) {
        this.RegistroFact = RegistroFact;
    }

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
     * @return the cantidadVenta
     */
    public float getCantidadProducto() {
        return cantidadProducto;
    }

    /**
     * @param cantidadVenta the cantidadVenta to set
     */
    public void setCantidadProducto(float cantidadVenta) {
        this.cantidadProducto = cantidadVenta;
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

 
}
