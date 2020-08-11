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

/**
 *
 * @author komei
 */
@WebServlet("/Register")
public class Register extends HttpServlet {

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
        String repwd = request.getParameter("RePassword");
        String dob = request.getParameter("DOB");
        String phone = request.getParameter("Phone");
        String email = request.getParameter("Email");
        String address = request.getParameter("Address");

        String message = null;
        
        //check user id is exist in database
        if(UserDAO.SearchbyId(userId) != null){
            message = "User id is exist";
            request.setAttribute("message", message);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        //check user user password enter problem
        if(!pwd.equals(repwd)){
            message = "Comfirm password should same with password";
            request.setAttribute("message", message);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        
        if(!email.contains("@")){
            message = "User email must be include @";
            request.setAttribute("message", message);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        
        
        if(userId.equals("") || fName.equals("") || sName.equals("") || pwd.equals("")){
            message = "userid/first name/second name/password empty!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }
        
              
        User newUser = new User(userId, fName, sName, pwd, dob, phone, email, address, 0, "active");

        int count = UserDAO.InsertUser(newUser);
        System.out.print(count);

        if(count > 0){//add user succeed
            message = "user register success!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            System.out.print("user register fault");
        }
    }
}
