/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.servlet.device;

import iotbay.dao.OrderDAO;

import iotbay.entity.OrderLine;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/OrderInfo")
public class OrderInfo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("Id");
        ArrayList<OrderLine> list = OrderDAO.SearchOrderLine(Integer.parseInt(id));
        request.setAttribute("orderLines", list);
        request.getRequestDispatcher("/Update.jsp").forward(request, response);
       
    }
}
