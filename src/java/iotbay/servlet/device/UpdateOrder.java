/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.servlet.device;

import iotbay.dao.OrderDAO;

import iotbay.entity.OrderLine;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateOrder")
public class UpdateOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String a = request.getParameter("id");
        int id = Integer.parseInt(a);
        String quantity = request.getParameter("quantity");
        int newQuantity = Integer.parseInt(quantity);
        OrderLine or = OrderDAO.findOrderLine(id);
        if (or != null) {
            if (newQuantity > or.getDquantity()+or.getQuantity()) {
                session.setAttribute("updated", "Update was not successful because we do not have enough quantity");
                response.sendRedirect("OrderInfo?Id=" + id);
            } else {
                try {
                    int c = or.getDquantity() +or.getQuantity()- newQuantity;
                    or.setQuantity(newQuantity);
                    or.setDquantity(c);
                    OrderDAO.UpdateOrderLine(or);
                    OrderDAO.ChangeDeviceQuantity(or);
                    response.sendRedirect("SearchOrder");
                } catch (SQLException ex) {
                    Logger.getLogger(CreateOrder.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
