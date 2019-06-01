/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danvi
 */
@WebServlet(name="manager",urlPatterns={"/"})
public class ServletManager extends HttpServlet{
  
    private void redirigeError(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("static/Error.jsp");
        dispatcher.forward(request, response);
    }
    
    private void redirigePrincipal(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("static/Home.jsp");
        dispatcher.forward(request, response);
    }
    
    private void redirigeLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("dynamic/Login.jsp");
        dispatcher.forward(request, response);
    }
    
    private void redirigeServletRed(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher("networkAccess").forward(request, response);
    }
    
    private void redirigeServletCliente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        request.getRequestDispatcher("customersM").forward(request, response);
    }
    
    private void redirige(HttpServletRequest request, HttpServletResponse response){
        try {
            String action = request.getServletPath();
            
            switch(action){
                case "/signin":
                    redirigeLogin(request, response);
                break;
                case "/home":
                    redirigePrincipal(request, response);
                break;
                case "/customers":
                        redirigeServletCliente(request, response);
                break;
                case "/networks":
                        redirigeServletRed(request, response);
                break;
                default:
                    redirigeError(request, response);
                break;
            }
        } catch (IOException | ServletException ex) {
            Logger.getLogger(ServletManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        redirige(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        
    }
    
    
}
