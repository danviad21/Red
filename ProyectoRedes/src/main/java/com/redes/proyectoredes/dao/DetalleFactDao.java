/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.dao;

import com.redes.proyectoredes.model.Conexion;
import com.redes.proyectoredes.model.DetalleFactura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danvi
 */
public class DetalleFactDao {

    private final String INSERT="INSERT INTO detalle (Factura_Registro_Fact,Producto_id_producto,cantidad_prod,precio_venta) VALUES(?,?,?,?);" ;
    private final String GETONE="SELECT Factura_Registro_Fact,Producto_id_producto,cantidad_prod,precio_venta FROM  detalle WHERE Factura_Registro_Fact = ?;";
    
    
    public void INSERT(DetalleFactura df){
        try {
            int count=1;
            PreparedStatement ps = Conexion.getConexion().prepareStatement(INSERT);
            ps.setInt(count++, df.getRegistroFact());
            ps.setInt(count++, df.getIdProducto());
            ps.setFloat(count++, df.getCantidadProducto());
            ps.setFloat(count++, df.getPrecioVenta());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFactDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public List<DetalleFactura> GETONE(int id){

        try {
            List<DetalleFactura> lista = new ArrayList();
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(GETONE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            DetalleFactura pr;
            while (rs.next()) {
                pr = new DetalleFactura();
                pr.setRegistroFact(rs.getInt("Factura_Registro_Fact"));
                pr.setIdProducto(rs.getInt("Producto_id_producto"));
                pr.setCantidadProducto(rs.getFloat("cantidad_prod"));
                pr.setPrecioVenta(rs.getFloat("precio_venta"));
                lista.add(pr);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DetalleFactDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
