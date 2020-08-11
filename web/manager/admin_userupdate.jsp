<%-- 
    Document   : admin_userupdate
    Created on : 2020-5-31, 13:28:22
    Author     : komei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "admin_menu.jsp" %>
<!DOCTYPE html>
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><a href="#">Home</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">User</a><span class="crumb-step">&gt;</span><span>New User</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/ISD_ASS2/manager/DoUserUpdate" method="post">
                    <input type="hidden" name="userisadmin" value="${user.USER_IS_ADMIN}">
                    <input type="hidden" name="userId" value="${user.USER_ID}">
                    <input type="hidden" name="cp" value="${cp}">
                    <input type="hidden" name="ori_dob" value="${user.USER_DOB}">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                            	<th><i class=""></i>User ID: ${user.USER_ID}</th>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>First Name</th>
                            <td>
                                <input class="common-text required" id="title" name="FirstName" size="50" value="${user.USER_FIRST_NAME}" type="text">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>Second Name</th>
                            <td>
                                <input class="common-text required" id="title" name="SecondName" size="50" value="${user.USER_SECOND_NAME}" type="text">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>Password</th>
                            <td>
                                <input class="common-text required" id="title" name="Password" size="50" value="${user.USER_PASSWORD}" type="text">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>Date of Birth</th>
                            <td>
                                <input class="common-text required" id="title" name="DOB" size="50" value="${user.USER_DOB}" type="date">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>Phone Number</th>
                            <td>
                                <input class="common-text required" id="title" name="Phone" size="50" value="${user.USER_PHONE}" type="text">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>Email</th>
                            <td>
                                <input class="common-text required" id="title" name="Email" size="50" value="${user.USER_EMAIL}" type="text">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>Address</th>
                            <td>
                                <input class="common-text required" id="title" name="Address" size="50" value="${user.USER_ADDRESS}" type="text">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>User isActive</th>
                            <td>
                                <input class="common-text required" id="title" name="isActive" size="50" value="${user.USER_IS_ACTIVE}" type="text" list="active-list" autocomplete="off">
                                <datalist id="active-list">
                                    <option>active</option>
                                    <option>deactive</option>
                                </datalist>
                            </td>
                            </tr>
                            <tr>
                            <th></th>
                            <td>
                                <input class="btn btn-primary btn6 mr10" value="Submit" type="submit">
                                <input class="btn btn6" onClick="history.go(-1)" value="return" type="button">
                            </td>
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>
    </div>

</div>
</body>
</html>
