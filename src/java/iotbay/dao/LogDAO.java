/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.dao;

import iotbay.entity.Log;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author komei
 */
public class LogDAO {
    
    public static int AddLog(Log log){
        String sql = "insert into iotbay.iotbay_userlog values(?, ?, ?, ?)";
        Object[] params = {
            log.getLOG_ID(),
            log.getUSER_ID(),
            log.getUSER_STATUS(),
            log.getSTATUS_TIME()
        };
        return BaseDAO.exectuCUD(sql, params);
    }
    
    public static int FindUserLogCount(String userId){
        int count = 0;
        Connection conn = BaseDAO.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select count(*) from iotbay.iotbay_userlog where USER_ID=?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            
            while(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LogDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            BaseDAO.closeAll(rs, ps, conn);
        }
        return count;
    }
    
    public static ArrayList<Log> SearchAllUserLogs(int currentPage, int count, String keyword, String userId){
        ArrayList<Log> LogList = new ArrayList<Log>();
        String sql = "";

        ResultSet rs = null;
        Connection conn = BaseDAO.getConn();

        PreparedStatement ps = null;
        try {
            if(keyword == null){
                sql = "select * from iotbay.iotbay_userlog where USER_ID=? order by STATUS_TIME desc offset ? rows fetch next ? rows only";
                ps = conn.prepareStatement(sql);
                ps.setString(1, userId);
                ps.setInt(2, (currentPage - 1) * count);
                ps.setInt(3, count);
            }else{
                sql = "select * from iotbay.iotbay_userlog where USER_ID=? and STATUS_TIME like ? order by STATUS_TIME desc offset ? rows fetch next ? rows only";
                ps = conn.prepareStatement(sql);
                ps.setString(1, userId);
                ps.setString(2, "%"+keyword+"%");
                ps.setInt(3, (currentPage - 1) * count);
                ps.setInt(4, count);
            }
            rs = ps.executeQuery();
            while(rs.next()){
                Log LogResult = new Log(
                    rs.getString("LOG_ID"), 
                    rs.getString("USER_ID"),
                    rs.getString("USER_STATUS"),
                    rs.getString("STATUS_TIME")
                );
                LogList.add(LogResult);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally{
            BaseDAO.closeAll(rs, ps, conn);
        }
        return LogList;
    }
    
    public static int[] SearchAllUserLogsCount(int count, String keyword, String userId){
        int[] array = {0, 0};//array[0] total count; array[1] total page
        Connection conn = BaseDAO.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "";
        try {
            if(keyword == null){
                sql = "select count(*) from iotbay.iotbay_userlog where USER_ID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, userId);
            }else{
                System.out.println("keyword!=null!!!");
                sql = "select count(*) from iotbay.iotbay_userlog where USER_ID=? and STATUS_TIME like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, userId);
                ps.setString(2, "%"+keyword+"%");
            }

            rs = ps.executeQuery();

            while(rs.next()){
                array[0] = rs.getInt(1);
                if(array[0] % count == 0)
                    array[1] = array[0] / count;
                else
                    array[1] = array[0] / count + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            BaseDAO.closeAll(rs, ps, conn);
        }
        return array;
    }
}
