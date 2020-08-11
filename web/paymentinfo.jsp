<%-- 
    Document   : paymentinfo
    Created on : 2020-6-6, 17:19:38
    Author     : Adam Eyileten
--%>

<%@page import="iotbay.entity.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "usermenu.jsp" %>

        <div class="you fl">
            <%
                Payment payment = (Payment)request.getAttribute("payment");
            %>
            <div class="tx clearfix">
                <div class="fl clearfix">
                    <p class="fl"><span style="font-size: 28px;">Payment id:<%=payment.getPaymentId()%></span></p>
                </div>
            </div>
            <div class="bott">
                
                <form action="UpdatePayment" method="post">
                    <input type="hidden" name="paymentId" value="<%=payment.getPaymentId()%>">
                <ul>
                    <li>Full name:&emsp;<span><input name="FullName" value="<%=payment.getFullName()%>" type="text"></span></li>
                    <li>Card Number:&emsp;<span><input name="CardNumber" value="<%=payment.getCardNumber()%>" type="text"></span></li>
                    <li>Vaild date:&emsp;<span><input name="Date" value="<%=payment.getDate()%>" type="date"></span></li>
                    <li>cvv:&emsp;<span><input name="Cvv" value="<%=payment.getCvv()%>" type="text"></span></li>
                    <li><input class="subbtn" type="submit" value="Save">&emsp;&emsp;<input class="rebtn" type="button" onClick="window.location='UserPaymentSearch'" value="return"></li>
                </ul>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
