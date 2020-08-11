<%-- 
    Document   : OrderList
    Created on : Jun 6, 2020, 4:12:30 PM
    Author     : 18071
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="iotbay.entity.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "usermenu.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Order</title>
    </head>

    <body>
<form action="SearchOrder" method="get">
        <div class="you fl">
        <div class="bott">
        <h3>Search by ID: <input class="input" type="text" placeholder=" order id" name="orderid"></h3>
        <h3>   
          Search by date from  <input class="input" type="date" name="dateFrom"> 
             to <input class="input" type="date" name="dateTo">
            <button type="submit">Search</button>
        </h3>
        </form> 
        
            <ul>
                <%                    
                    ArrayList<Order> OrderList = (ArrayList<Order>) session.getAttribute("orderlist");
                    session.setAttribute("userid", "1");
                %>


                <%
                    for (Order order : OrderList) {
                %>
                <li><%=order.toString()%><% if (order.getStatus().equals("pending")) {%>
                    <span>&emsp;<a href="DeleteOrder?Id=<%=order.getId()%>">Remove</a></span>
                    <span>&emsp;<a href="OrderInfo?Id=<%=order.getId()%>">Update</a></span>
                    <% }%></li>
                    <%
                        }
                    %>


            </ul>      
             </div>
</div>
    </body>
</html>
