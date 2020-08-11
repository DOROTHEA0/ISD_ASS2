/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.servlet.device;

import iotbay.dao.OrderDAO;
import iotbay.entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 18071
 */
@WebServlet("/SearchOrder")
public class SearchOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String userid = (String) session.getAttribute("userid");//get user search keyword
        String orderid = (String) request.getParameter("orderid");
        String dateFrom = (String) request.getParameter("dateFrom");
        String dateTo = (String) request.getParameter("dateTo");
       
        
        if (userid == null) {
            userid = "1";
        }
        ArrayList<Order> OrderList = OrderDAO.SearchOrder(userid, orderid, dateFrom, dateTo);
        session.setAttribute("orderlist", OrderList);
        request.getRequestDispatcher("OrderList.jsp").forward(request, response);
    }
}
