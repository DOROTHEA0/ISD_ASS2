<%-- 
    Document   : userinfo
    Created on : 2020-6-1, 16:51:23
    Author     : komei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "usermenu.jsp" %>

        <div class="you fl">
            <div class="tx clearfix">
                <div class="fl clearfix">
                    <p class="fl"><span style="font-size: 28px;">${currentUser.USER_ID}</span><a href="useredit.jsp" style="font-size: 20px;">Update information></a></p></div>
                    <div class="fr"><a href="Logout" style="font-size: 20px;">Log out</a></div>
                </div>
            <div class="bott">
                <ul>
                    <li>Firt name:&emsp;<span>${currentUser.USER_FIRST_NAME}</span></li>
                    <li>Second name:&emsp;<span>${currentUser.USER_SECOND_NAME}</span></li>
                    <li>Password:&emsp;<span>${currentUser.USER_PASSWORD}</span></li>
                    <li>Date of birth:&emsp;<span>${currentUser.USER_DOB}</span></li>
                    <li>Email:&emsp;<span>${currentUser.USER_EMAIL}</span></li>
                    <li>Phone number:&emsp;<span>${currentUser.USER_PHONE}</span></li>
                    <li>Address:&emsp;<span>${currentUser.USER_ADDRESS}</span></li>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
