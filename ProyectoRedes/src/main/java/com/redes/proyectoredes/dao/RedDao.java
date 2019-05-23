/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.dao;

import com.redes.proyectoredes.model.Conexion;
import com.redes.proyectoredes.model.Red;
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
public class RedDao {

    private final String INSERT="INSERT INTO red (descrip_red,ip_red,mascara_red,es_administrador) VALUES(?,?,?,?);";
    private final String UPDATE="UPDATE red SET descrip_red = ?, ip_red = ?, mascara_red = ?, es_administrador = ? WHERE id_red = ?;";
    private final String GETONE="SELECT id_red, descrip_red,ip_red,mascara_red,es_administrador FROM red WHERE id_red = ?;";
    private final String GETALL="SELECT id_red, descrip_red,ip_red,mascara_red,es_administrador FROM red;";

    
    public void INSERT(Red red){
        try {
            int count=1;
            PreparedStatement ps = Conexion.getConexion().prepareStatement(INSERT);
            ps.setString(count++, red.getNombreRed());
            ps.setString(count++, red.getIpRed());
            ps.setString(count++, red.getMascaraRed());
            ps.setInt(count++, red.isEsRedAdmin());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RedDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UPDATE(Red red){
        try {
            int count=1;
            PreparedStatement ps = Conexion.getConexion().prepareStatement(UPDATE);
            ps.setString(count++, red.getNombreRed());
            ps.setString(count++, red.getIpRed());
            ps.setString(count++, red.getMascaraRed());
            ps.setInt(count++, red.isEsRedAdmin());
            ps.setInt(count++, red.getIdRed());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RedDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Red GETONE(int id){
        try {
            Red red = new Red();
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(GETONE);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                red.setNombreRed(rs.getString("descrip_red"));
                red.setIpRed(rs.getString("ip_red"));
                red.setMascaraRed(rs.getString("mascara_red"));
                red.setEsRedAdmin(rs.getInt("es_administrador"));
                red.setIdRed(rs.getInt("id_red"));

            }
            return red;
        } catch (SQLException ex) {
            Logger.getLogger(RedDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Red> GETALL(){

        try {
            List<Red> lista = new ArrayList();
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(GETALL);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            Red red;
            while (rs.next()) {
                red =new Red();
                red.setIdRed(rs.getInt("id_red"));
                red.setNombreRed(rs.getString("descrip_red"));
                red.setIpRed(rs.getString("ip_red"));
                red.setMascaraRed(rs.getString("mascara_red"));
                red.setEsRedAdmin(rs.getInt("es_administrador"));
                lista.add(red);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(RedDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
