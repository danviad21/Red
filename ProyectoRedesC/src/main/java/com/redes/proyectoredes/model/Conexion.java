/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author danvi
 */
public class Conexion {
    
    private static Connection conexion=null;
    private static final String USER="root";
    private static final String PASS="odavid";
            
    private Conexion(){};

    public static Connection getConexion(){
        
        if(conexion == null){
            try {
                String url = "jdbc:mysql://localhost:3306/network";
                conexion = DriverManager.getConnection(url,USER,PASS);
                System.out.println(conexion.getCatalog());
            } catch (SQLException ex) {
                System.out.println("error"+ex.getMessage()+ex.getLocalizedMessage());
            }
        }
        return conexion;
    }
    
    public static void cerrarConexion() throws SQLException{
        if(conexion!=null){
            conexion.close();
        }
    }
    
    public static String test(String n, String n2){
        return n+" "+n2;
    }
}