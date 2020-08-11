<%-- 
    Document   : addpayment
    Created on : 2020-6-6, 14:28:04
    Author     : Adam Eyileten
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Payment add</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
</head>
<body>
<div class="reg">
    <form action="/ISD_ASS2/AddPayment" method="post">
        <p style="padding:0px;magin:0px;font-size:30px;background:#1F1E33;text-align:center;line-height:60px;color:#FFFFFF;">Add Payment</p>
        <p><input type="text" name="userfullname" value="${currentUser.USER_FIRST_NAME} ${currentUser.USER_SECOND_NAME}" placeholder=""></p>
        <p><input type="text" name="cardnum" value="" placeholder="Card Number"></p>
        <p style="font-size: 18px;">Valid Date:<input type="date" name="date" value="" placeholder=""></p>
        <p><input type="text" name="cvv" value="" placeholder="cvv"></p>
        <p style="font-size: 18px;"><input type="submit" name="" value="Add Payment"><input type="button" name="" onclick="history.go(-1)" value="return"></p>
    </form>
</div>
</body>
</html>
