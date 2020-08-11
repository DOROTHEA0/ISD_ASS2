<%-- 
    Document   : admin_updateDevice
    Created on : Jun 5, 2020, 10:19:47 PM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "staff_menu.jsp" %>
<!DOCTYPE html>
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><a href="#">Home</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_device.jsp">Device</a><span class="crumb-step">&gt;</span><span>Update Device</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/ISD_ASS2/manager/DoDeviceUpdate" method="post">
                    <input type="hidden" name="Id" value="${device.id}">
                    <input type="hidden" name="cp" value="${cp}">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                            	<th><i class=""></i>Device ID: ${device.id}</th>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>Device Name</th>
                            <td>
                                <input class="common-text required" id="title" name="Name" size="50" value="${device.name}" type="text">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>Device Type</th>
                            <td>
                                <input class="common-text required" id="title" name="Type" size="50" value="${device.type}" type="text">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>Price</th>
                            <td>
                                <input class="common-text required" id="title" name="Price" size="50" value="${device.price}" type="text">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>QUANTITY</th>
                            <td>
                                <input class="common-text required" id="title" name="Quantity" size="50" value="${device.quantity}" type="text">
                            </td>
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
