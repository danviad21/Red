/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.dao;

import com.redes.proyectoredes.model.Conexion;
import com.redes.proyectoredes.model.Usuario;
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
public class UsuarioDao {

    private final String EXISTUSER = "SELECT id_usuario,user_name,user_pass,Red_id_red FROM usuario WHERE user_name = ? and user_pass = ?;";
    private final String INSERT="INSERT INTO usuario (user_name,user_pass,Red_id_red) VALUES(?,?,?);";
    private final String UPDATE="UPDATE usuario SET user_pass = ?, Red_id_red = ? WHERE id_usuario = ?;";
    private final String GETONE="SELECT id_usuario, user_name,user_pass,Red_id_red FROM usuario WHERE id_usuario = ?;";
    private final String GETALL="SELECT id_usuario, user_name,user_pass,Red_id_red FROM usuario;";

    
    public void INSERT(Usuario user){
        try {
            int count=1;
            PreparedStatement ps = Conexion.getConexion().prepareStatement(INSERT);
            ps.setString(count++, user.getUserName());
            ps.setString(count++, user.getUserPass());
            ps.setInt(count++, user.getIdRed());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UPDATE(Usuario user){
        try {
            int count=1;
            PreparedStatement ps = Conexion.getConexion().prepareStatement(UPDATE);
            ps.setString(count++, user.getUserPass());
            ps.setInt(count++, user.getIdRed());
            ps.setInt(count++, user.getIdUser());
            System.out.println(ps);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Usuario GETONE(int id){
        try {
            Usuario user = new Usuario();
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(GETONE);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                user.setIdUser(rs.getInt("id_usuario"));
                user.setUserName(rs.getString("user_name"));
                user.setIdRed(rs.getInt("Red_id_red"));
                user.setIdRed(id);
                user.setValido(true);
            }
            return user;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public List<Usuario> GETALL(){

        try {
            List<Usuario> lista = new ArrayList();
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(GETALL);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            Usuario user;
            while (rs.next()) {
                user = new Usuario();
                user.setIdUser(rs.getInt("id_usuario"));
                user.setUserName(rs.getString("user_name"));
                user.setIdRed(rs.getInt("Red_id_red"));
                user.setValido(true);
                lista.add(user);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
}
    }
}
