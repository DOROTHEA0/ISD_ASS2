<%-- 
    Document   : register
    Created on : 2020-5-31, 16:25:15
    Author     : komei
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>register</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
</head>
<body>
    <%
        String message = (String)request.getAttribute("message");
        if(message != null){
    %>
        <script type="text/javascript">alert("${message}");</script>
    <%
        }
    %>
<div class="reg">
    <form action="/ISD_ASS2/Register" method="post">
        <p style="padding:0px;magin:0px;font-size:30px;background:#1F1E33;text-align:center;line-height:60px;color:#FFFFFF;">User SignUp</p>
        <p><input type="text" name="userId" value="" placeholder="User ID"></p>
        <p><input type="text" name="FirstName" value="" placeholder="First name"></p>
        <p><input type="text" name="SecondName" value="" placeholder="Second name"></p>
        <p><input type="text" name="Password" value="" placeholder="Password"></p>
        <p><input type="text" name="RePassword" value="" placeholder="Confirm Password"></p>
        <p style="font-size: 18px;">Date of Birth:<input type="date" name="DOB" value="" placeholder=""></p>
        <p><input type="text" name="Phone" value="" placeholder="Phone number"></p>
        <p><input type="text" name="Email" value="" placeholder="Email"></p>
        <p><input type="text" name="Address" value="" placeholder="Address"></p>
        <p><input type="submit" name="" value="Sign Up"></p>
        <p class="txt"><a href="login.jsp"><span></span>Already have account</a></p>
    </form>
</div>
</body>
</html>
