/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.Dao;

import com.redes.proyectoredes.model.Conexion;
import com.redes.proyectoredes.model.Cliente;
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
public class ClienteDao {

    private final String INSERT="INSERT INTO cliente (nombre_cliente,nit_cliente) VALUES(?,?);";
    private final String UPDATE="UPDATE cliente SET nombre_cliente = ?, nit_cliente = ?  WHERE id_cliente = ?;";
    private final String GETONE="SELECT id_cliente, nombre_cliente,nit_cliente FROM cliente WHERE id_cliente = ?;";
    private final String GETALL="SELECT id_cliente, nombre_cliente,nit_cliente FROM cliente";

    
    public void INSERT(Cliente cl){
        try {
            int count=1;
            PreparedStatement ps = Conexion.getConexion().prepareStatement(INSERT);
            ps.setString(count++, cl.getNombreCliente());
            ps.setString(count++, cl.getNitCliente());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UPDATE(Cliente cl){
        try {
            int count=1;
            PreparedStatement ps = Conexion.getConexion().prepareStatement(UPDATE);
            ps.setString(count++, cl.getNombreCliente());
            ps.setString(count++, cl.getNitCliente());
            ps.setInt(count++, cl.getIdCliente());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Cliente GETONE(int id){
        try {
            Cliente cl = new Cliente();
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(GETONE);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                cl.setIdCliente(rs.getInt("id_cliente"));
                cl.setNombreCliente(rs.getString("nombre_cliente"));
                cl.setNitCliente(rs.getString("nit_cliente"));
            }
            return cl;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Cliente> GETALL(){

        try {
            List<Cliente> lista = new ArrayList();
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(GETALL);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            Cliente cl;
            while (rs.next()) {
                cl = new Cliente();
                cl.setIdCliente(rs.getInt("id_cliente"));
                cl.setNombreCliente(rs.getString("nombre_cliente"));
                cl.setNitCliente(rs.getString("nit_cliente"));
                lista.add(cl);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
