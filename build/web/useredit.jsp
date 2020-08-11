<%-- 
    Document   : useredit
    Created on : 2020-6-2, 10:28:48
    Author     : komei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "usermenu.jsp" %>

        <div class="you fl">
            <div class="tx clearfix">
                <div class="fl clearfix">
                    <p class="fl"><span style="font-size: 28px;">${currentUser.USER_ID}</span><span style="font-size: 20px;">Please update your information></span></p></div>
                    <div class="fr"><a href="Logout" style="font-size: 20px;">Log out</a></div>
                </div>
            <div class="bott">
                <form action="UserEdit" method="post">
                    <input type="hidden" name="userId" value="${currentUser.USER_ID}">
                <ul>
                    <li>Firt name:&emsp;<span><input name="FirstName" value="${currentUser.USER_FIRST_NAME}" type="text"></span></li>
                    <li>Second name:&emsp;<span><input name="SecondName" value="${currentUser.USER_SECOND_NAME}" type="text"></span></li>
                    <li>Password:&emsp;<span><input name="Password" value="${currentUser.USER_PASSWORD}" type="text"></span></li>
                    <li>Date of birth:&emsp;<span><input name="DOB" value="${currentUser.USER_DOB}" type="date"></span></li>
                    <li>Email:&emsp;<span><input name="Email" value="${currentUser.USER_EMAIL}" type="text"></span></li>
                    <li>Phone number:&emsp;<span><input name="Phone" value="${currentUser.USER_PHONE}" type="text"></span></li>
                    <li>Address:&emsp;<span><input name="Address" value="${currentUser.USER_ADDRESS}" type="text"></span></li>
                    <li><input class="subbtn" type="submit" value="Submit">&emsp;&emsp;<input class="rebtn" type="button" onClick="history.go(-1)" value="return"></li>
                </ul>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
