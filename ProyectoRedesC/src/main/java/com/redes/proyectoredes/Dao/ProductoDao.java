/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.Dao;

import com.redes.proyectoredes.model.Conexion;
import com.redes.proyectoredes.model.Producto;
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
public class ProductoDao {

    private final String INSERT="INSERT INTO producto (descrip_prod,precio_venta,existencia_producto,Tipo_Producto_idTipo_Producto) VALUES(?,?,?,?);";
    private final String UPDATE="UPDATE producto SET descrip_prod = ?,precio_venta =?,existencia_producto =?,Tipo_Producto_idTipo_Producto = ?  WHERE id_producto = ?;";
    private final String GETONE="SELECT id_producto,descrip_prod,precio_venta,existencia_producto,Tipo_Producto_idTipo_Producto FROM  producto WHERE id_producto = ?;";
    private final String GETALL="SELECT id_producto,descrip_prod,precio_venta,existencia_producto,Tipo_Producto_idTipo_Producto FROM  producto"; 

    
    public void INSERT(Producto pd){
        try {
            int count=1;
            PreparedStatement ps = Conexion.getConexion().prepareStatement(INSERT);
            ps.setString(count++, pd.getDescripProd());
            ps.setFloat(count++, pd.getPrecioVenta());
            ps.setFloat(count++, pd.getExistenciaProd());
            ps.setInt(count++, pd.getIdTipoProd());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UPDATE(Producto pr){
        try {
            int count=1;
            PreparedStatement ps = Conexion.getConexion().prepareStatement(UPDATE);
            ps.setString(count++, pr.getDescripProd());
            ps.setFloat(count++, pr.getPrecioVenta());
            ps.setFloat(count++, pr.getExistenciaProd());
            ps.setFloat(count++, pr.getIdTipoProd());
            ps.setInt(count++, pr.getIdProducto());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Producto GETONE(int id){
        try {
            Producto pr = new Producto();
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(GETONE);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                pr.setIdProducto(rs.getInt("id_producto"));
                pr.setDescripProd(rs.getString("descrip_prod"));
                pr.setPrecioVenta(rs.getFloat("precio_venta"));
                pr.setExistenciaProd(rs.getFloat("existencia_producto"));
                pr.setIdTipoProd(rs.getInt("Tipo_Producto_idTipo_Producto"));
            }
            return pr;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Producto> GETALL(){

        try {
            List<Producto> lista = new ArrayList();
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(GETALL);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            Producto pr;
            while (rs.next()) {
                pr = new Producto();
                pr.setIdProducto(rs.getInt("id_producto"));
                pr.setDescripProd(rs.getString("descrip_prod"));
                pr.setPrecioVenta(rs.getFloat("precio_venta"));
                pr.setExistenciaProd(rs.getFloat("existencia_producto"));
                pr.setIdTipoProd(rs.getInt("Tipo_Producto_idTipo_Producto"));
                lista.add(pr);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
