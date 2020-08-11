/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.servlet.user;

import iotbay.dao.UserDAO;
import iotbay.entity.User;
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
 * @author komei
 */
@WebServlet("/UserEdit")
public class UserEdit extends HttpServlet {
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

        String userId = request.getParameter("userId");
        String fName = request.getParameter("FirstName");
        String sName = request.getParameter("SecondName");
        String pwd = request.getParameter("Password");
        String dob = request.getParameter("DOB");
        String phone = request.getParameter("Phone");
        String email = request.getParameter("Email");
        String address = request.getParameter("Address");

        User newUser = new User(userId, fName, sName, pwd, dob, phone, email, address, 0, "active");
        int count = UserDAO.UpdateUser(newUser);
        if(count > 0){
            session.setAttribute("currentUser", newUser);
            response.sendRedirect("userinfo.jsp");
        }else{
            System.out.print("update default");
            response.sendRedirect("userinfo.jsp");
        }
    }
}
