<%-- 
    Document   : device
    Created on : Jun 5, 2020, 11:35:55 PM
    Author     : Jason
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="iotbay.entity.Device"%>
<%@ include file = "usermenu.jsp" %>
<div class="you fl">
    <div class="bott">
        <ul>
            <%  List<Device> shoppingCart = new ArrayList();              
                if (session.getAttribute("cart") != null) {
                    shoppingCart = (List<Device>) session.getAttribute("cart");
                }
            %>
            <%
                for (Device device : shoppingCart) {
            %>
            <li><%=device.toSString()%><span>&emsp;<a href="ShoppingCart?deviceId=<%=device.getId()%>">Remove</a></span></li>
                <%
                    }
                %>
        </ul>

    </div>
    <form action="CreateOrder" method="POST">
        <button class="subbtn" type="submit">Place Order</button>
    </form>
</div>
</body>
</html>