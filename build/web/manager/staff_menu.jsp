<%-- 
    Document   : admin_menu
    Created on : 2020-5-29, 21:44:33
    Author     : Jason
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Staff Management</title>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    
</head>
<body>
<div class="topbar-wrap white" width = "">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <ul class="navbar-list clearfix">
                <li><a class="on" href="admin_index.jsp">Home</a></li>
                <li><a href="#">Staff:${currentUser.USER_FIRST_NAME}</a></li>
                <li><a href="/ISD_ASS2/Logout">Exit</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li><a href="#">Staff:${currentUser.USER_FIRST_NAME}</a></li>
                <li><a href="/ISD_ASS2/Logout">Exit</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>Menu</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#">Management</a>
                    <ul class="sub-menu">
                        <li><a href="DeviceSearch">IoT Devices</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
