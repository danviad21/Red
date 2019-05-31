/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.controller;

import com.redes.proyectoredes.dao.UsuarioDao;
import com.redes.proyectoredes.model.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author danvi
 */
@WebServlet(name="ValidaLogin", urlPatterns={"/verifyUserServlet"})
public class ValidaUsuarioServlet extends HttpServlet {
    
    private UsuarioDao usuarioDao;
    
    @Override
    public void init(){
        this.usuarioDao = new UsuarioDao();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doPost(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        try {
            Usuario user = new Usuario();
            user.setUserName(request.getParameter("name").trim());
            user.setUserPass(request.getParameter("pass").trim());
            
            user = usuarioDao.VALIDAUSUARIO(user);
            if(user.esValido()){
                HttpSession session = request.getSession();
                session.setAttribute("userName", user.getUserName());
                session.setAttribute("ipAddress", request.getRemoteAddr());
                session.setAttribute("host", request.getRemoteHost());
                session.setAttribute("netMask", request.getRemoteUser());
                response.sendRedirect("dynamic/LoginSuccess.jsp");
            }else{
                HttpSession session = request.getSession();
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException ex) {
            System.out.println("el error es aqui"+ex.getLocalizedMessage());
            Logger.getLogger(ValidaUsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
