/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.servlet.payment;

import iotbay.dao.BaseDAO;
import iotbay.dao.PaymentDAO;
import iotbay.entity.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adam Eyileten
 */
@WebServlet("/AddPayment")
public class AddPayment extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset = utf-8");
        HttpSession session = request.getSession();
        User currentUser = (User)session.getAttribute("currentUser");
        
        String paymentId = BaseDAO.genUniqueKey();
        String userId = currentUser.getUSER_ID();
        String fullName = request.getParameter("userfullname");
        String cardNum = request.getParameter("cardnum");
        int cvv = Integer.parseInt( request.getParameter("cvv"));
        String date = request.getParameter("date");
        Payment newPayment = new Payment(paymentId, userId, fullName, cardNum, cvv, date);
        int count = PaymentDAO.AddPayment(newPayment);
        if(count > 0){
            response.sendRedirect("UserPaymentSearch");
        }else{
            System.out.println("payment add default");
        }
    }


}
