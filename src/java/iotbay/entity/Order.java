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
public class Order {
    private int id;
    private String userId;
    private String status;
    private String date;
    private String total;

    public Order(int id, String userId, String status, String total) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.date = date;
        this.total = total;
    }

    public Order(int id, String userId, String status, String date, String total) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.date = date;
        this.total = total;
    }

    public Order(String userId, String status, String total) {
        this.userId = userId;
        this.status = status;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String toString(){
        return "Id: "+ id + "  UserId: " + userId + "  Status: " + status + "  Date: " + date+ "  Total: " + total;
    }
    
    
}
