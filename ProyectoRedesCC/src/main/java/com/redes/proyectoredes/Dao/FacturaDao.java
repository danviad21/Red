/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.Dao;

import com.redes.proyectoredes.model.Conexion;
import com.redes.proyectoredes.model.DetalleFactura;
import com.redes.proyectoredes.model.Factura;
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
public class FacturaDao {

        private final String INSERT="INSERT INTO factura (status_fact,Cliente_id_cliente) VALUES(?,?);";
    private final String UPDATE="UPDATE factura SET status_fact = ? WHERE Registro_Fact = ?;";
    private final String GETONE="SELECT Registro_Fact,fecha_venta,status_fact,Cliente_id_cliente FROM factura WHERE Registro_Fact = ?;";
    private final String GETALL="SELECT Registro_Fact,fecha_venta,status_fact,Cliente_id_cliente FROM factura;";

    
    public void INSERT(Factura f){
        try {
            int count=1;
            PreparedStatement ps = Conexion.getConexion().prepareStatement(INSERT);
            ps.setString(count++, String.valueOf('A'));
            ps.setInt(count++, f.getIdCliente());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UPDATE(Factura f){
        try {
            int count=1;
            PreparedStatement ps = Conexion.getConexion().prepareStatement(UPDATE);
            ps.setString(count++, String.valueOf(f.getStatus()));
            ps.setInt(count++, f.getRegistro());
            
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Factura GETONE(int id){
        try {
            Factura f = new Factura();
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(GETONE);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                f.setRegistro(rs.getInt("Registro_Fact"));
                f.setFecha(rs.getDate("fecha_venta"));
                f.setStatus(rs.getString("status_fact"));
                f.setIdCliente(rs.getInt("Cliente_id_cliente"));
            }
            return f;
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Factura> GETALL(){

        try {
            List<Factura> lista = new ArrayList();
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(GETALL);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            Factura f;
            while (rs.next()) {
                f = new Factura();
                f.setRegistro(rs.getInt("Registro_Fact"));
                f.setFecha(rs.getDate("fecha_venta"));
                f.setStatus(rs.getString("status_fact"));
                f.setIdCliente(rs.getInt("Cliente_id_cliente"));
                lista.add(f);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(FacturaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void main(String[] args) {
        DetalleFactura dt = new DetalleFactura();
        dt.setRegistroFact(2);
        dt.setIdProducto(2);
        dt.setCantidadProducto(1);
        dt.setPrecioVenta(100);
        DetalleFactDao dd = new DetalleFactDao();
        dd.INSERT(dt);
    }
}
