/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.servlet.device;

import iotbay.dao.DeviceDAO;
import iotbay.entity.Device;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jason
 */
@WebServlet("/manager/DoDeviceUpdate")
public class DoDeviceUpdate extends HttpServlet {



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
        
        Device newDevice = new Device(Id,Name,Type,Price,Quantity);

        int count = DeviceDAO.UpdateDevice(newDevice);
        System.out.print(count);

        if(count > 0){//add user succeed
            response.sendRedirect("DeviceSearch?cp=" + request.getParameter("cp"));
        }else{
            System.out.print("Device update fault");
            response.sendRedirect("ToDeviceUpdate?id=" + Id + "&cp=" + request.getParameter("cp"));
        }
    }

}
