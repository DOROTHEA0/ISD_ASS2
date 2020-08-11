<%-- 
    Document   : payment
    Created on : 2020-6-6, 14:18:50
    Author     : Adam Eyileten
--%>

<%@page import="iotbay.entity.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file = "usermenu.jsp" %>

        <div class="you fl">
            <div class="tx clearfix">
                <div class="fl clearfix">
                    <p class="fl"><span style="font-size: 20px;"><a href="addpayment.jsp">Add Payment Method></a></span></p>
                </div>
            </div>
            <div class="bott">
                <ul>
                    <%
                        ArrayList<Payment> PaymentList = (ArrayList<Payment>)request.getAttribute("paymentlist");
                    %>
                    <%
                        if(PaymentList != null){
                            for(Payment payment: PaymentList){
                    %>
                    <li>Card number:<%=payment.getCardNumber()%> Vaild date:<%=payment.getDate()%>  Cvv:<%=payment.getCvv()%><span>&emsp;<a href="PaymentDetail?paymentId=<%=payment.getPaymentId()%>">View</a>&emsp;<a href="DeletePayment?paymentId=<%=payment.getPaymentId()%>">Delete</a></span></li>
                    <%
                            }
                        }      
                    %>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
