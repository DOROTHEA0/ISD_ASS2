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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/DeleteOrder")
public class DeleteOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String orderId = request.getParameter("Id");//get user search keyword
        int a = Integer.parseInt(orderId);
        Order order = OrderDAO.DeleteOrder(a);
        ArrayList<OrderLine> list = OrderDAO.SearchOrderLine(a);
        try {
            for (OrderLine or : list) {
                int b = or.getDquantity() + or.getQuantity();
                or.setDquantity(b);
                or.setQuantity(0);
                OrderDAO.ChangeDeviceQuantity(or);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("order", order);
        response.sendRedirect("SearchOrder");
    }

}
