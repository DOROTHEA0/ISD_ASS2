/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.servlet.user;

import iotbay.dao.LogDAO;
import iotbay.entity.Log;
import iotbay.entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet("/Logout")
public class Logout extends HttpServlet {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User logoutUser = (User)session.getAttribute("currentUser");
        String userId = logoutUser.getUSER_ID();
        /*************************************************
        * Create logout log to database
        ************************************************/
        int currentUserLogCount = LogDAO.FindUserLogCount(userId);
        String logId = userId + "_log" + Integer.toString(currentUserLogCount + 1);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
        Log loginLog = new Log(logId, userId, "logout", df.format(new Date()));
        int logupdate = LogDAO.AddLog(loginLog);
        if(logupdate > 0)
            System.out.println("log update successed!");
        
        session.removeAttribute("currentUser");
        response.sendRedirect("/ISD_ASS2/index.jsp");
    }

}
