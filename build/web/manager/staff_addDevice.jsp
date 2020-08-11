<%-- 
    Document   : admin_adduser
    Created on : 2020-6-2, 22:11:27
    Author     : Jason
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "staff_menu.jsp" %>
<!DOCTYPE html>
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><a href="#">Home</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_device.jsp">Device</a><span class="crumb-step">&gt;</span><span>New Device</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/ISD_ASS2/manager/DoDeviceAdd" method="post">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                            <th><i class="require-red">*</i>Device ID</th>
                            <td>
                                    <input class="common-text required" id="title" name="Id" size="50" value="" type="text">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>Device Name</th>
                            <td>
                                <input class="common-text required" id="title" name="Name" size="50" value="" type="text">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>Type</th>
                            <td>
                                <input class="common-text required" id="title" name="Type" size="50" value="" type="text">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>Price</th>
                            <td>
                                <input class="common-text required" id="title" name="Price" size="50" value="" type="text">
                            </td>
                            </tr>
                            <tr>
                            <th><i class="require-red">*</i>Quantity</th>
                            <td>
                                <input class="common-text required" id="title" name="Quantity" size="50" value="" type="text">
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
