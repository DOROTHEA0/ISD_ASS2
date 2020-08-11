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
import iotbay.entity.Order;
import iotbay.entity.OrderLine;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author komei
 */
@WebServlet("/CreateOrder")
public class CreateOrder extends HttpServlet {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Device> cart = (List<Device>) session.getAttribute("cart");
        if (cart== null) {
            
        cart=new ArrayList();}
        double total= 0;
        for(int i=0;i<cart.size();i++){
            total=total+ Double.parseDouble(cart.get(i).getPrice().replace("$",""));
        }
        Order order = new Order("1", "pending", String.valueOf(total));
        try {
            int orderid=OrderDAO.InsertOrder(order);
            
              for(Device device : cart) {
                int a=Integer.parseInt(device.getQuantity());
                
                OrderLine ol = new OrderLine(orderid, device.getId(), 1,a-1);
                OrderDAO.InsertOrderLine(ol);
                OrderDAO.ChangeDeviceQuantity(ol);
            }
          
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("cart", new ArrayList());
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
        }
    }


