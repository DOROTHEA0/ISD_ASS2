
<%@page import="iotbay.entity.OrderLine"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order info</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <div class="center-container">

            <%
                List<OrderLine> s = (List<OrderLine>) request.getAttribute("orderLines");
            %>
            <h3><%=(session.getAttribute("updated") != null ? "Edit the quantity: " + session.getAttribute("updated") : "")%></h3>
            <form action="UpdateOrder" method="POST">
                
                <table>
                    <%
                        for (OrderLine or : s) {
                    %>  
                    <tr>
                        <td>OrderLine Id</td>
                        <td><input type="text" name="id" value="<%= or.getId()%>" readonly></td>
                    </tr>
                    <tr>
                        <td>Devices Id</td>
                        <td><input type="text" name="deviceId" value="<%= or.getDeviceId()%>" readonly></td>
                    </tr>

                    <tr>
                        <td>Quantity</td>
                        <td><input type="text" name="quantity" value="<%= or.getQuantity()%>" ></td>
                    </tr>  

                    <tr>
                        <td><input class="button" type="submit" value="Update"></td>
                    </tr>
                    <% }%>
                </table>
            </form>

        </div>
    </body>
</html>