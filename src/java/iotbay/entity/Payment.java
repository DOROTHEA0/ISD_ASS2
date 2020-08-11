/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.entity;

/**
 *
 * @author Adam Eyileten
 */
public class Payment {
    private String PaymentId;
    private String UserId;
    private String FullName;
    private String CardNumber;
    private int Cvv;
    private String Date;
    
    public Payment(String paymentid, String userid, String fullname, String cardnumber, int cvv, String date){
        PaymentId = paymentid;
        UserId = userid;
        FullName = fullname;
        CardNumber = cardnumber;
        Cvv = cvv;
        Date = date;
    }

    /**
     * @return the PaymentId
     */
    public String getPaymentId() {
        return PaymentId;
    }

    /**
     * @param PaymentId the PaymentId to set
     */
    public void setPaymentId(String PaymentId) {
        this.PaymentId = PaymentId;
    }

    /**
     * @return the UserId
     */
    public String getUserId() {
        return UserId;
    }

    /**
     * @param UserId the UserId to set
     */
    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    /**
     * @return the FullName
     */
    public String getFullName() {
        return FullName;
    }

    /**
     * @param FullName the FullName to set
     */
    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    /**
     * @return the CardNumber
     */
    public String getCardNumber() {
        return CardNumber;
    }

    /**
     * @param CardNumber the CardNumber to set
     */
    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }

    /**
     * @return the Cvv
     */
    public int getCvv() {
        return Cvv;
    }

    /**
     * @param Cvv the Cvv to set
     */
    public void setCvv(int Cvv) {
        this.Cvv = Cvv;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }
        
}
