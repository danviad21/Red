/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author danvi
 */
public class Conexion {
    
    private static Connection conexion;
    private static final String USER="root";
    private static final String PASS="odavid";
            
    private Conexion(){};

    public static Connection getConexion() throws SQLException{
        
        if(conexion == null || conexion.isClosed()){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost/network";
                conexion = DriverManager.getConnection(url,USER,PASS);
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getLocalizedMessage()+" >>"+ex.getMessage()+"    >>>>>>"+conexion.isClosed());
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion;
    }
    
    public static void cerrarConexion() throws SQLException{
        if(!conexion.isClosed()){
            conexion.close();
        }
    }
}