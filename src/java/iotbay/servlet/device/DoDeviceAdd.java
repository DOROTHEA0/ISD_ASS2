/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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


/**
 *
 * @author Jason
 */
@WebServlet("/manager/DoDeviceAdd")
public class DoDeviceAdd extends HttpServlet {

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

        String Id = request.getParameter("Id");
        String Name = request.getParameter("Name");
        String Type = request.getParameter("Type");
        String Price = request.getParameter("Price");
        String Quantity = request.getParameter("Quantity");
              
        Device newDevice = new Device(Id, Name, Type, Price, Quantity);

        int count = DeviceDAO.InsertDevice(newDevice);
        System.out.print(count);

        if(count > 0){//add device succeed
            response.sendRedirect("DeviceSearch");
        }else{
            System.out.print("device add fault");
        }
    }



}
