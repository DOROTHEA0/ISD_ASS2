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
public class Log {
    private String LOG_ID;
    private String USER_ID;
    private String USER_STATUS;
    private String STATUS_TIME;

    public Log(String lOG_ID, String uSER_ID, String uSER_STATUS, String sTATUS_TIME){
        LOG_ID = lOG_ID;
        USER_ID = uSER_ID;
        USER_STATUS = uSER_STATUS;
        STATUS_TIME = sTATUS_TIME;
    }
    
    
    /**
     * @return the LOG_ID
     */
    public String getLOG_ID() {
        return LOG_ID;
    }

    /**
     * @param LOG_ID the LOG_ID to set
     */
    public void setLOG_ID(String LOG_ID) {
        this.LOG_ID = LOG_ID;
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
     * @return the USER_STATUS
     */
    public String getUSER_STATUS() {
        return USER_STATUS;
    }

    /**
     * @param USER_STATUS the USER_STATUS to set
     */
    public void setUSER_STATUS(String USER_STATUS) {
        this.USER_STATUS = USER_STATUS;
    }

    /**
     * @return the STATUS_TIME
     */
    public String getSTATUS_TIME() {
        return STATUS_TIME;
    }

    /**
     * @param STATUS_TIME the STATUS_TIME to set
     */
    public void setSTATUS_TIME(String STATUS_TIME) {
        this.STATUS_TIME = STATUS_TIME;
    }
    
    
}
