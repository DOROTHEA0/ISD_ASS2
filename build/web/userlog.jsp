<%-- 
    Document   : userlog
    Created on : 2020-6-1, 21:49:14
    Author     : komei
--%>

<%@page import="iotbay.entity.Log"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "usermenu.jsp" %>

        <div class="you fl">
            <div class="tx clearfix">
                <div class="fl clearfix">
                    <form action="UserLogSearch" method="get">
                        <p class="fl"><span style="font-size: 20px;">search date:&emsp;<input type="date" name="keywords" value="${searchParam}">&emsp;<input class="subbtn" type="submit" value="Search"></span></p>
                    </form>
                </div>
            </div>
            <div class="bott">
                <ul>
                    <%
                        ArrayList<Log> LogList = (ArrayList<Log>)request.getAttribute("loglist");
                    %>
                    <%
                        for(Log log: LogList){
                    %>
                        <li>Log: <%=log.getLOG_ID()%>: User: <%=log.getUSER_ID()%> <%=log.getUSER_STATUS()%> at <%=log.getSTATUS_TIME()%></li>
                    <%
                        }
                    %>
                </ul>
            </div>
            <div class="listpage">
                Total logs count:${totalcount}, page${currentpage}/${totalpage}
                <a href="UserLogSearch?cp=1&keywords=${searchParam}">first page</a>
                <a href="UserLogSearch?cp=${currentpage-1<1?1:currentpage-1}&keywords=${searchParam}">pre page</a>
                <a href="UserLogSearch?cp=${currentpage+1>totalpage?totalpage:currentpage+1}&keywords=${searchParam}">next page</a>
                <a href="UserLogSearch?cp=${totalpage}&keywords=${searchParam}">end page</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
