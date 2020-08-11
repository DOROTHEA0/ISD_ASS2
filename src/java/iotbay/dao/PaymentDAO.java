/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.dao;

import iotbay.entity.Payment;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Adam Eyileten
 */
public class PaymentDAO {
    
    public static int AddPayment(Payment payment){
        String sql = "insert into iotbay.iotbay_payment values(?, ?, ?, ?, ?, ?)";
        Object[] params = {
            payment.getPaymentId(),
            payment.getUserId(),
            payment.getFullName(),
            payment.getCardNumber(),
            payment.getCvv(),
            payment.getDate()
        };
        
        return BaseDAO.exectuCUD(sql, params);
    }
    
    public static int UpdatePayment(Payment payment){
        String sql = "update iotbay.iotbay_payment set FULL_NAME=?, CARD_NUMBER=?, CVV=?, DATE=? where PAYMENT_ID=?";
        Object[] params = {
            payment.getFullName(),
            payment.getCardNumber(),
            payment.getCvv(),
            payment.getDate(),
            payment.getPaymentId()
        };
        return BaseDAO.exectuCUD(sql, params);
    }
    
    public static ArrayList<Payment> ListPaymentbyUser(String userId){
        ArrayList<Payment> PaymentList = new ArrayList<Payment>();
            String sql = "";

            ResultSet rs = null;
            Connection conn = BaseDAO.getConn();

            PreparedStatement ps = null;
        try {
            sql = "select * from iotbay.iotbay_payment where USER_ID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);


            rs = ps.executeQuery();
            while(rs.next()){
                Payment payment = new Payment(
                    rs.getString("PAYMENT_ID"),
                    rs.getString("USER_ID"),
                    rs.getString("FULL_NAME"),
                    rs.getString("CARD_NUMBER"),
                    rs.getInt("CVV"),
                    rs.getString("DATE")
                );
                PaymentList.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            BaseDAO.closeAll(rs, ps, conn);
        }
        return PaymentList;
    }
    
    public static Payment SearchbyId(String paymentId){
        Payment payment = null;


        ResultSet rs = null;
        Connection conn = BaseDAO.getConn();

        PreparedStatement ps = null;
        try {
                String sql = "select * from iotbay_payment where PAYMENT_ID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, paymentId);
                rs = ps.executeQuery();

            while(rs.next()){
                payment = new Payment(
                    rs.getString("PAYMENT_ID"),
                    rs.getString("USER_ID"),
                    rs.getString("FULL_NAME"),
                    rs.getString("CARD_NUMBER"),
                    rs.getInt("CVV"),
                    rs.getString("DATE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            BaseDAO.closeAll(rs, ps, conn);
        }
        return payment;
    }

    public static int DeletePayment(String paymentId) {
        String sql = "delete from iotbay.iotbay_payment where PAYMENT_ID=?";
        Object[] params = {paymentId};
        return BaseDAO.exectuCUD(sql, params);
    }
}
