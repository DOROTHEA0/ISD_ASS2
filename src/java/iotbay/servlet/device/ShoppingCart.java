/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.servlet.device;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import iotbay.dao.*;
import iotbay.entity.Device;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jason
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Device> cart = (List<Device>)session.getAttribute("cart");
        if(cart == null) {
            cart = new ArrayList();
        }
        String deviceId = request.getParameter("deviceId");//get user search keyword
        Device device = DeviceDAO.SearchbyId(deviceId);
        for(int i=0; i<cart.size(); i++){
            if(cart.get(i).getId().equals(deviceId)) {
                cart.remove(i);
        }
        }        
        session.setAttribute("cart", cart);
        response.sendRedirect("cart.jsp");
    }

}
