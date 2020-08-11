<%-- 
    Document   : usermenu
    Created on : 2020-6-1, 20:28:54
    Author     : komei
--%>

<%@page import="java.util.List"%>
<%@page import="iotbay.entity.Device"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>User information</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/userinfo.css"/>
</head>
<body>
<div class="address mt" id="add">
    <div class="wrapper clearfix"><a href="index.html" class="fl">Home</a><span>/</span><a href="userinfo.jsp" class="on">User</a>
    </div>
</div>
<div class="Bott">
    <div class="wrapper clearfix">
        <div class="zuo fl">
            <h3><a href="#"></a>
                <p class="clearfix"><span class="fl">Hello:${currentUser.USER_FIRST_NAME}</span></p></h3>
            <div >
                <h4>User</h4>
                <%
                    List<Device> cart = (List<Device>)session.getAttribute("cart");
                %>
                <ul>
                    <li><a href="userinfo.jsp">Information</a></li>
                    <li><a href="UserLogSearch">View Logs</a></li>
                    <li><a href="UserDeviceSearch">IoTDevice</a></li>
                     <li><a href="cart.jsp">Cart</a><sup style="color: red"><%= cart == null? 0: cart.size() %></sup></li>
                    <li><a href="SearchOrder">Order</a></li>
                    <li><a href="UserPaymentSearch">Payment</a></li>
                    
                </ul>
            </div>
        </div>
