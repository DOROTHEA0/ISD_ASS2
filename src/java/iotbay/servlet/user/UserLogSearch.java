/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.servlet.user;

import iotbay.dao.LogDAO;
import iotbay.dao.UserDAO;
import iotbay.entity.*;
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
 * @author komei
 */
@WebServlet("/UserLogSearch")
public class UserLogSearch extends HttpServlet {


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
        String keyword = request.getParameter("keywords");//get log search date
		
        int currentPage = 1;
        int count = 7;
        HttpSession session = request.getSession();
        User currentUser = (User)session.getAttribute("currentUser");

        String cp = request.getParameter("cp");
        if(cp != null){
                currentPage = Integer.parseInt(cp);
        }
        //get user total count and page of list user
        int[] array = LogDAO.SearchAllUserLogsCount(count, keyword, currentUser.getUSER_ID());
        
        //get all user from db
        ArrayList<Log> LogList = LogDAO.SearchAllUserLogs(currentPage, count, keyword, currentUser.getUSER_ID());
        //store in request
        request.setAttribute("totalcount", array[0]);
        request.setAttribute("totalpage", array[1]);
        request.setAttribute("currentpage", currentPage);
        request.setAttribute("loglist", LogList);

        if(keyword != null) request.setAttribute("searchParam", keyword);

        request.getRequestDispatcher("userlog.jsp").forward(request, response);
    }

    
}
