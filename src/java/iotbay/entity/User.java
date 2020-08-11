/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.entity;

/**
 *
 * @author komei
 */
public class User {
    private String USER_ID;
    private String USER_FIRST_NAME;
    private String USER_SECOND_NAME;
    private String USER_PASSWORD;
    private String USER_DOB;
    private String USER_PHONE;
    private String USER_EMAIL;
    private String USER_ADDRESS;
    private int USER_IS_ADMIN;
    private String USER_IS_ACTIVE;
    
    public User(String uSER_ID, String uSER_FIRST_NAME,
                String uSER_SECOND_NAME, String uSER_PASSWORD, String uSER_DOB,
                String uSER_PHONE, String uSER_EMAIL, String uSER_ADDRESS,
                int uSER_IS_ADMIN, String uSER_IS_ACTIVE) {
        super();
        USER_ID = uSER_ID;
        USER_FIRST_NAME = uSER_FIRST_NAME;
        USER_SECOND_NAME = uSER_SECOND_NAME;
        USER_PASSWORD = uSER_PASSWORD;
        USER_DOB = uSER_DOB;
        USER_PHONE = uSER_PHONE;
        USER_EMAIL = uSER_EMAIL;
        USER_ADDRESS = uSER_ADDRESS;
        USER_IS_ADMIN = uSER_IS_ADMIN;
        USER_IS_ACTIVE = uSER_IS_ACTIVE;
    }
    /**
     * @return the USER_ID
     */
    public String getUSER_ID() {
        return USER_ID;
    }

    /**
     * @param USER_ID the USER_ID to set
     */
    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    /**
     * @return the USER_FIRST_NAME
     */
    public String getUSER_FIRST_NAME() {
        return USER_FIRST_NAME;
    }

    /**
     * @param USER_FIRST_NAME the USER_FIRST_NAME to set
     */
    public void setUSER_FIRST_NAME(String USER_FIRST_NAME) {
        this.USER_FIRST_NAME = USER_FIRST_NAME;
    }

    /**
     * @return the USER_SECOND_NAME
     */
    public String getUSER_SECOND_NAME() {
        return USER_SECOND_NAME;
    }

    /**
     * @param USER_SECOND_NAME the USER_SECOND_NAME to set
     */
    public void setUSER_SECOND_NAME(String USER_SECOND_NAME) {
        this.USER_SECOND_NAME = USER_SECOND_NAME;
    }

    /**
     * @return the USER_PASSWORD
     */
    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    /**
     * @param USER_PASSWORD the USER_PASSWORD to set
     */
    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }

    /**
     * @return the USER_DOB
     */
    public String getUSER_DOB() {
        return USER_DOB;
    }

    /**
     * @param USER_DOB the USER_DOB to set
     */
    public void setUSER_DOB(String USER_DOB) {
        this.USER_DOB = USER_DOB;
    }

    /**
     * @return the USER_PHONE
     */
    public String getUSER_PHONE() {
        return USER_PHONE;
    }

    /**
     * @param USER_PHONE the USER_PHONE to set
     */
    public void setUSER_PHONE(String USER_PHONE) {
        this.USER_PHONE = USER_PHONE;
    }

    /**
     * @return the USER_EMAIL
     */
    public String getUSER_EMAIL() {
        return USER_EMAIL;
    }

    /**
     * @param USER_EMAIL the USER_EMAIL to set
     */
    public void setUSER_EMAIL(String USER_EMAIL) {
        this.USER_EMAIL = USER_EMAIL;
    }

    /**
     * @return the USER_ADDRESS
     */
    public String getUSER_ADDRESS() {
        return USER_ADDRESS;
    }

    /**
     * @param USER_ADDRESS the USER_ADDRESS to set
     */
    public void setUSER_ADDRESS(String USER_ADDRESS) {
        this.USER_ADDRESS = USER_ADDRESS;
    }

    /**
     * @return the USER_IS_ADMIN
     */
    public int getUSER_IS_ADMIN() {
        return USER_IS_ADMIN;
    }
    
    public String getUSER_IS_ADMINstr() {
        switch(USER_IS_ADMIN){
            case 2:
                return "admin";
            case 1:
                return "staff";
            default:
                return "customer";     
        }
    }

    /**
     * @param USER_IS_ADMIN the USER_IS_ADMIN to set
     */
    public void setUSER_IS_ADMIN(int USER_IS_ADMIN) {
        this.USER_IS_ADMIN = USER_IS_ADMIN;
    }

    /**
     * @return the USER_IS_ACTIVE
     */
    public String getUSER_IS_ACTIVE() {
        return USER_IS_ACTIVE;
    }
    
    
}
