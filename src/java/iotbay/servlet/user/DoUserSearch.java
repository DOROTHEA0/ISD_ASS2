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
import java.util.ArrayList;

/**
 *
 * @author komei
 */
@WebServlet("/manager/DoUserSearch")
public class DoUserSearch extends HttpServlet {

    

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
        String keyword = request.getParameter("keywords");//get user search keyword
		
        int currentPage = 1;
        int count = 5;

        String cp = request.getParameter("cp");
        if(cp != null){
                currentPage = Integer.parseInt(cp);
        }
        //get user total count and page of list user
        int[] array = UserDAO.getTotalCount(count, keyword);

        //get all user from db
        ArrayList<User> UserList = UserDAO.SearchAll(currentPage, count, keyword);
        //store in request
        request.setAttribute("totalcount", array[0]);
        request.setAttribute("totalpage", array[1]);
        request.setAttribute("currentpage", currentPage);
        request.setAttribute("userlist", UserList);

        if(keyword != null) request.setAttribute("searchParam", keyword);

        request.getRequestDispatcher("/manager/admin_user.jsp").forward(request, response);
    }

}
