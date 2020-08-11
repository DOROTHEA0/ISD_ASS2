/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.entity;

/**
 *
 * @author Jason
 */
public class Device {
    private String id;
    private String name;
    private String type;
    private String price;
    private String quantity;

    public Device(String id, String name, String type, String price, String quantity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public String toString(){
        return "Name: "+ name + "  Type: " + type + "  Price: " + price + "  Quantity: " + quantity;
    }
     public String toSString(){
        return "Name: "+ name + "  Type: " + type + "  Price: " + price + "  Quantity: " + 1;
    }
}
    
    
