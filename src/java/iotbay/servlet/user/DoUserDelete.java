/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.servlet.user;

import iotbay.dao.UserDAO;
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
@WebServlet("/manager/DoUserDelete")
public class DoUserDelete extends HttpServlet {

 
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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset = utf-8");

        String userId = request.getParameter("userid");

        int count = UserDAO.DeleteUser(userId);
        if(count > 0){//delete user succeed
            response.sendRedirect("DoUserSearch?cp=" + request.getParameter("cp"));
        }else{
            System.out.print("user delete fault");
            response.sendRedirect("DoUserSearch?cp=" + request.getParameter("cp"));
        }
    }


}
