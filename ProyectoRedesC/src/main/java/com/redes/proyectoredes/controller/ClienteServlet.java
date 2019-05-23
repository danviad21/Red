/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.controller;

import com.redes.proyectoredes.Dao.ClienteDao;
import java.io.IOException;
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

@WebServlet("/Cliente")
public class ClienteServlet extends HttpServlet{

    private ClienteDao clienteDao;
    
    @Override
    public void init(){
        this.clienteDao = new ClienteDao();
    }
    
    
    protected void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("./mod/Clientes/CatalogoClientes.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            String action = request.getServletPath();
        System.out.println(action);
        switch(action){
            case "/new":
                showNewForm(request,response);
            break;
        }
    }
}
