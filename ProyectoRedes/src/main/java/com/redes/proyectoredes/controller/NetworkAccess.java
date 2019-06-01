/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.controller;

import com.redes.proyectoredes.dao.RedDao;
import com.redes.proyectoredes.model.Red;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name="NetworAccess", urlPatterns={"/networkAccess"})
public class NetworkAccess extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RedDao redDao = new RedDao();
        List<Red> listaRedes = redDao.GETALL();
        if(listaRedes.size()>0){
            request.setAttribute("listaRedes", listaRedes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("dynamic/AdministradorRed.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        
    }
}
