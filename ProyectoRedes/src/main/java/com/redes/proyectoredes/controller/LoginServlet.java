/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.controller;

import com.redes.proyectoredes.dao.UsuarioDao;
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

@WebServlet("/")
public class LoginServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private UsuarioDao usuarioDao;
    
    @Override
    public void init(){
        this.usuarioDao = new UsuarioDao();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doGet(request, response);
    }
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            String action = request.getServletPath();
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+action);
            switch (action) {
                case "/ingresar":
                    validaLogin(request, response);
                    break;
            }
        } catch (ServletException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    
    protected void validaLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("static/Login.jsp");
        dispatcher.forward(request, response);
    }
}
    