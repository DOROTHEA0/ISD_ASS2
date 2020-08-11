/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import iotbay.dao.*;
import iotbay.entity.User;


/**
 *
 * @author komei
 */
@WebServlet("/manager/DoUserAdd")
public class DoUserAdd extends HttpServlet {

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

        String userId = request.getParameter("userId");
        String fName = request.getParameter("FirstName");
        String sName = request.getParameter("SecondName");
        String pwd = request.getParameter("Password");
        String dob = request.getParameter("DOB");
        String phone = request.getParameter("Phone");
        String email = request.getParameter("Email");
        String address = request.getParameter("Address");
        String isActive = request.getParameter("isActive");
        
        if(isActive == null)
            isActive = "active";
        
        if(address == null)
            address = "defult address";
              
        User newUser = new User(userId, fName, sName, pwd, dob, phone, email, address, 0, isActive);

        int count = UserDAO.InsertUser(newUser);
        System.out.print(count);

        if(count > 0){//add user succeed
            response.sendRedirect("DoUserSearch");
        }else{
            System.out.print("user add fault");
        }
    }



}
