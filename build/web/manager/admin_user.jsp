<%-- 
    Document   : admin_user
    Created on : 2020-5-29, 21:28:32
    Author     : komei
--%>


<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@  page import= "iotbay.entity.User"%>
<%@ include file = "admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><a href="admin_menu.jsp">Home</a>><span class="crumb-name">User</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/ISD_ASS2/manager/DoUserSearch" method="get">
                    <table class="search-tab">
                        <tr>
                            <th width="70">Search:</th>
                            <td><input class="common-text" placeholder="Search for ID" name="keywords" value="${searchParam}" type="text"></td> 
                            <td><input class="btn btn-primary btn2" name="sub" value="Search" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="result-wrap">
            <form name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="admin_adduser.jsp">New User</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%" border="5">
                        <tr>
                            <th>User ID</th>
                            <th>First Name</th>
                            <th>Second Name</th>
                            <th>Date of Birth</th>
                            <th>Phone Number</th>
                            <th>Email</th>
                            <th>Address</th>
                            <th>User type</th>
                            <th>Status</th>
                            <th>Process</th>
                        </tr>
                        <%
                            ArrayList<User> UserList = (ArrayList<User>)request.getAttribute("userlist");
                        %>
                        <%
                            for(User user: UserList){
                        %>
                            <tr>
                                <td><%=user.getUSER_ID()%></td>
                                <td><%=user.getUSER_FIRST_NAME()%></td>
                                <td><%=user.getUSER_SECOND_NAME()%></td>
                                <td><%=user.getUSER_DOB()%></td>
                                <td><%=user.getUSER_PHONE()%></td>
                                <td><%=user.getUSER_EMAIL()%></td>
                                <td><%=user.getUSER_ADDRESS()%></td>
                                <td><%=user.getUSER_IS_ADMINstr()%></td>
                                <td><%=user.getUSER_IS_ACTIVE()%></td>
                                <td>
                                    <a class="update" href="ToUserUpdate?userid=<%=user.getUSER_ID()%>&cp=${currentpage}">Update</a>
                                    <%if(user.getUSER_IS_ADMINstr() != "admin"){
                                    %>
                                        <a class="delete" href="javascript:DeleteConfirm('confirm to delete user <%=user.getUSER_ID()%>?', 'DoUserDelete?userid=<%=user.getUSER_ID()%>&cp=${currentpage}')">Delete</a>
                                    <%
                                    }%>
                                </td>
                            </tr>
                        <%
                            }
                        %>

                        <script>
                            function DeleteConfirm(mess, url){
                                if(confirm(mess)) location.href = url;
                            }
                        </script>

                    </table>
                    <div class="list-page">
                    	Total user:${totalcount}, page${currentpage}/${totalpage}
                    	<a href="DoUserSearch?cp=1&keywords=${searchParam}">first page</a>
                    	<a href="DoUserSearch?cp=${currentpage-1<1?1:currentpage-1}&keywords=${searchParam}">pre page</a>
                    	<a href="DoUserSearch?cp=${currentpage+1>totalpage?totalpage:currentpage+1}&keywords=${searchParam}">next page</a>
                    	<a href="DoUserSearch?cp=${totalpage}&keywords=${searchParam}">end page</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
