/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.entity;

/**
 *
 * @author 18071
 */
public class OrderLine {
    private int id;
    private int orderId;
    private String deviceId;
    private int quantity;
    private int Dquantity;

    public OrderLine(int id, int orderId, String deviceId, int quantity, int Dquantity) {
        this.id = id;
        this.orderId = orderId;
        this.deviceId = deviceId;
        this.quantity = quantity;
        this.Dquantity = Dquantity;
    }

    public OrderLine(int orderId, String deviceId, int quantity,int Dquantity) {
        this.orderId = orderId;
        this.deviceId = deviceId;
        this.quantity = quantity;
        this.Dquantity=Dquantity;
    }
    

    public int getDquantity() {
        return Dquantity;
    }

    public void setDquantity(int Dquantity) {
        this.Dquantity = Dquantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
     
}
