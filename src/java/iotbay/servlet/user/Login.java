/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.servlet.user;

import iotbay.dao.LogDAO;
import iotbay.dao.UserDAO;
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
@WebServlet("/Login")
public class Login extends HttpServlet {

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
        String password = request.getParameter("password");
        String message = null;
        
        if(UserDAO.SearchbyId(userId) != null){
            User currentUser = UserDAO.SearchbyId(userId);
            if(password.equals(currentUser.getUSER_PASSWORD())){
                if("active".equals(currentUser.getUSER_IS_ACTIVE()))
                {
                    int userIsAdmin = currentUser.getUSER_IS_ADMIN();
                    HttpSession session = request.getSession();
                    session.setAttribute("currentUser", currentUser);
                    /*************************************************
                     * Create login log to database
                     ************************************************/
                    int currentUserLogCount = LogDAO.FindUserLogCount(userId);
                    String logId = userId + "_log" + Integer.toString(currentUserLogCount + 1);
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
                    Log loginLog = new Log(logId, userId, "login", df.format(new Date()));
                    int logupdate = LogDAO.AddLog(loginLog);
                    if(logupdate > 0)
                        System.out.println("log update successed!");

                    switch (userIsAdmin) {
                        case 2:
                            //system admin
                            response.sendRedirect("/ISD_ASS2/manager/DoUserSearch");
                            break;
                        case 1:
                            //staff
                            response.sendRedirect("/ISD_ASS2/manager/DeviceSearch");
                            break;
                        default:
                            //normal user
                            response.sendRedirect("/ISD_ASS2/userinfo.jsp");
                            break;
                    }
                    return;
                }
            message = "user account is deactive!";
            request.setAttribute("message", message);
            request.getRequestDispatcher("login.jsp").forward(request, response);    
                
            return;
            }
            message = "worng password";
            request.setAttribute("message", message);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        message = "user id not exist";
        request.setAttribute("message", message);
        request.getRequestDispatcher("login.jsp").forward(request, response);
        return;
    }
}
