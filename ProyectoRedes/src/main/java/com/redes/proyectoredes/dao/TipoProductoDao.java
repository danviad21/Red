/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.dao;

import com.redes.proyectoredes.model.Conexion;
import com.redes.proyectoredes.model.TipoProducto;
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
public class TipoProductoDao {

    private final String INSERT="INSERT INTO tipo_producto (descrip_tipo_prod) VALUES(?);";
    private final String UPDATE="UPDATE tipo_producto SET descrip_tipo_prod = ? WHERE id_Tipo_Producto = ?;";
    private final String GETONE="SELECT id_Tipo_Producto,descrip_tipo_prod FROM  tipo_producto WHERE id_Tipo_Producto = ?;";
    private final String GETALL="SELECT id_Tipo_Producto,descrip_tipo_prod FROM tipo_producto"; 

    
    public void INSERT(TipoProducto tpd){
        try {
            int count=1;
            PreparedStatement ps = Conexion.getConexion().prepareStatement(INSERT);
            ps.setString(count++, tpd.getDescripTipoProd());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UPDATE(TipoProducto tpd){
        try {
            int count=1;
            PreparedStatement ps = Conexion.getConexion().prepareStatement(UPDATE);
            ps.setString(count++, tpd.getDescripTipoProd());
            ps.setInt(count++, tpd.getIdTipoProducto());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public TipoProducto GETONE(int id){
        try {
            TipoProducto tpd = new TipoProducto();
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(GETONE);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                tpd.setIdTipoProducto(rs.getInt("id_Tipo_Producto"));
                tpd.setDescripTipoProd(rs.getString("descrip_tipo_prod"));

            }
            return tpd;
        } catch (SQLException ex) {
            Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<TipoProducto> GETALL(){

        try {
            List<TipoProducto> lista = new ArrayList();
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(GETALL);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            TipoProducto tpd;
            while (rs.next()) {
                tpd = new TipoProducto();
                tpd.setIdTipoProducto(rs.getInt("id_Tipo_Producto"));
                tpd.setDescripTipoProd(rs.getString("descrip_tipo_prod"));
                lista.add(tpd);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(TipoProductoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void main(String[] args) {
        TipoProductoDao tpd = new TipoProductoDao();
        List<TipoProducto> ltp =  tpd.GETALL();
        for(int i=0; i<ltp.size(); i++){
            System.out.println(ltp.get(i));
        }
    }
}
