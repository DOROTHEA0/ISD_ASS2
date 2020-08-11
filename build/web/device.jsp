<%-- 
    Document   : device
    Created on : Jun 5, 2020, 11:35:55 PM
    Author     : Jason
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="iotbay.entity.Device"%>
<%@ include file = "usermenu.jsp" %>
<div class="you fl">
            <div class="tx clearfix">
                <div class="fl clearfix">
                    <form action="UserDeviceSearch" method="get">
                        <p class="fl"><span style="font-size: 20px;">search type:&emsp;<input type="text" name="keywords" value="${searchParam}" list="typelist" autocomplete="off">&emsp;<input class="subbtn" type="submit" value="Search"></span></p>
                            <datalist id="typelist">
                                <option>smart home</option>
                                <option>laptop</option>
                                <option>cable</option>
                                <option>mobile</option>
                            </datalist>
                    </form>
                </div>
            </div>
            <div class="bott">
                <ul>
                    <%
                        ArrayList<Device> DeviceList = (ArrayList<Device>)request.getAttribute("devicelist");
                    %>
                    <%
                        for(Device device: DeviceList){
                    %>
                    <li><%=device.toString()%><span>&emsp;<a href="AddToCart?deviceId=<%=device.getId()%>">Add to Cart</a></span></li>
                    <%
                        }
                    %>
                </ul>
            </div>
            <div class="listpage">
                Total logs count:${totalcount}, page${currentpage}/${totalpage}
                <a href="UserDeviceSearch?cp=1&keywords=${searchParam}">first page</a>
                <a href="UserDeviceSearch?cp=${currentpage-1<1?1:currentpage-1}&keywords=${searchParam}">pre page</a>
                <a href="UserDeviceSearch?cp=${currentpage+1>totalpage?totalpage:currentpage+1}&keywords=${searchParam}">next page</a>
                <a href="UserDeviceSearch?cp=${totalpage}&keywords=${searchParam}">end page</a>
            </div>
        </div>
    
</body>
</html>