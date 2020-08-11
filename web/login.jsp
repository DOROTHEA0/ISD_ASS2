 <%-- 
    Document   : login
    Created on : 2020-5-31, 15:41:41
    Author     : komei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
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
<div class="login">
    <form action="Login" method="post">
        <p style="padding:0px;magin:0px;font-size:30px;background:#1F1E33;text-align:center;line-height:60px;color:#FFFFFF;">Login</p>
        <p><input type="text" name="userId" value="" placeholder="User id"></p>
        <p><input type="password" name="password" value="" placeholder="Password"></p>
        <p><input type="submit" value="Sign In"></p>
        <p class="txt">Don't have account?<a class="" href="register.jsp">Sign Up</a></p>
    </form>
</div>
</body>
</html>
