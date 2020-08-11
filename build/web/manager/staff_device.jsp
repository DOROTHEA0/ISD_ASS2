<%-- 
    Document   : admin_user
    Created on : 2020-5-29, 21:28:32
    Author     : Jason
--%>


<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@  page import= "iotbay.entity.Device"%>
<%@ include file = "staff_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><a href="staff_menu.jsp">Home</a>><span class="crumb-name">Device</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/ISD_ASS2/manager/DeviceSearch" method="get">
                    <table class="search-tab">
                        <tr>
                            <th width="70">Search:</th>
                            <td><input class="common-text" placeholder="" name="keywords" value="${searchParam}" id="" type="text" list="type-list" autocomplete="off"></td>
                            <datalist id="type-list">
                                <option>smart home</option>
                                <option>laptop</option>
                                <option>cable</option>
                                <option>mobile</option>

                            </datalist>
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
                        <a href="staff_addDevice.jsp">New Device</a>
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%" border="5">
                        <tr>
                            <th>Device ID</th>
                            <th>Device Name</th>
                            <th>Device Type</th>
                            <th>Device Price</th>
                            <th>Device Quantity</th>
                            <th>Process</th>
                        </tr>
                        <%
                            ArrayList<Device> DeviceList = (ArrayList<Device>)request.getAttribute("devicelist");
                        %>
                        <%
                            for(Device device: DeviceList){
                        %>
                            <tr>
                                <td><%=device.getId()%></td>
                                <td><%=device.getName()%></td>
                                <td><%=device.getType()%></td>
                                <td><%=device.getPrice()%></td>
                                <td><%=device.getQuantity()%></td>
                                <td>
                                    <a class="update" href="ToDeviceUpdate?Id=<%=device.getId()%>&cp=${currentpage}">Update</a>
                                    <a class="delete" href="javascript:DeleteConfirm('confirm to delete device <%=device.getId()%>?', 'DoDeviceDelete?deviceid=<%=device.getId()%>&cp=${currentpage}')">Delete</a>
                                </td>
                            </tr>
                        <%
                            }
                        %>

`                       <script>
                            function DeleteConfirm(mess, url){
                                if(confirm(mess)) location.href = url;
                            }
                        </script>

                    </table>
                    <div class="list-page">
                    	Total device:${totalcount}, page${currentpage}/${totalpage}
                    	<a href="DeviceSearch?cp=1&keywords=${searchParam}">first page</a>
                    	<a href="DeviceSearch?cp=${currentpage-1<1?1:currentpage-1}&keywords=${searchParam}">pre page</a>
                    	<a href="DeviceSearch?cp=${currentpage+1>totalpage?totalpage:currentpage+1}&keywords=${searchParam}">next page</a>
                    	<a href="DeviceSearch?cp=${totalpage}&keywords=${searchParam}">end page</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
