/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redes.proyectoredes.controller;

import com.redes.proyectoredes.dao.ClienteDao;
import com.redes.proyectoredes.model.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name="customersManager",urlPatterns={"/customersM"})
public class CustomerManager extends HttpServlet{
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("dynamic/Clientes.jsp");
            ClienteDao clienteDao = new ClienteDao();
            List<Cliente> listaClientes = new ArrayList();
            clienteDao.GETALL(listaClientes);
            if(listaClientes.size()>0){
                request.setAttribute("listaClientes", listaClientes);
            }
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            System.out.println("servlet con eeror cliente"+ex.getLocalizedMessage());
            Logger.getLogger(CustomerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
