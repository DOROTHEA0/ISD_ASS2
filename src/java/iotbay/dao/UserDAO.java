/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.dao;

import java.sql.*;
import java.util.*;

import iotbay.entity.User;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author komei
 */
public class UserDAO {
    public static int InsertUser(User user){
        String sql = "insert into iotbay.iotbay_user values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {
            user.getUSER_ID(), 
            user.getUSER_FIRST_NAME(), 
            user.getUSER_SECOND_NAME(),
            user.getUSER_PASSWORD(),
            user.getUSER_DOB(),
            user.getUSER_PHONE(),
            user.getUSER_EMAIL(),
            user.getUSER_ADDRESS(),
            user.getUSER_IS_ADMIN(),
            user.getUSER_IS_ACTIVE()
        };
        
        return BaseDAO.exectuCUD(sql, params);
    }
    
    public static int UpdateUser(User user){
        String sql = "update iotbay.iotbay_user set USER_FIRST_NAME=?, USER_SECOND_NAME=?, USER_PASSWORD=?, USER_DOB=?, USER_PHONE=?, USER_EMAIL=?, USER_ADDRESS=?, USER_IS_ADMIN=?, IS_ACTIVE=? where USER_ID=?";
        Object[] params = {
            user.getUSER_FIRST_NAME(), 
            user.getUSER_SECOND_NAME(),
            user.getUSER_PASSWORD(),
            user.getUSER_DOB(),
            user.getUSER_PHONE(),
            user.getUSER_EMAIL(),
            user.getUSER_ADDRESS(),
            user.getUSER_IS_ADMIN(),
            user.getUSER_IS_ACTIVE(),
            user.getUSER_ID()
        };
        return BaseDAO.exectuCUD(sql, params);
    }
    
    public static int DeleteUser(String userId){
        String sql = "delete from iotbay.iotbay_user where USER_ID=?";
        Object[] params = {userId};
        return BaseDAO.exectuCUD(sql, params);
    }
    
    public static ArrayList<User> SearchAll(int currentPage, int count, String keyword){
            ArrayList<User> UserList = new ArrayList<User>();
            String sql = "";

            ResultSet rs = null;
            Connection conn = BaseDAO.getConn();

            PreparedStatement ps = null;
        try {
            if(keyword == null){
                sql = "select * from iotbay.iotbay_user order by USER_ID offset ? rows fetch next ? rows only"; // limit ?, ?
                ps = conn.prepareStatement(sql);
                ps.setInt(1, (currentPage - 1) * count);
                ps.setInt(2, count);
            }else{
                sql = "select * from iotbay.iotbay_user where USER_ID like ? order by USER_ID offset ? rows fetch next ? rows only";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%"+keyword+"%");
                ps.setInt(2, (currentPage - 1) * count);
                ps.setInt(3, count);
            }
            rs = ps.executeQuery();
            while(rs.next()){
                User UserResult = new User(
                    rs.getString("USER_ID"), 
                    rs.getString("USER_FIRST_NAME"),
                    rs.getString("USER_SECOND_NAME"),
                    rs.getString("USER_PASSWORD"),
                    rs.getString("USER_DOB"),
                    rs.getString("USER_PHONE"),
                    rs.getString("USER_EMAIL"),
                    rs.getString("USER_ADDRESS"),
                    rs.getInt("USER_IS_ADMIN"),
                    rs.getString("IS_ACTIVE")
                );
                UserList.add(UserResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            BaseDAO.closeAll(rs, ps, conn);
        }
        return UserList;
    }
    
    public static User SearchbyId(String userId){
        User user = null;


        ResultSet rs = null;
        Connection conn = BaseDAO.getConn();

        PreparedStatement ps = null;
        try {
                String sql = "select * from iotbay_user where USER_ID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, userId);
                rs = ps.executeQuery();

            while(rs.next()){
                user = new User(
                    rs.getString("USER_ID"), 
                    rs.getString("USER_FIRST_NAME"),
                    rs.getString("USER_SECOND_NAME"),
                    rs.getString("USER_PASSWORD"),
                    rs.getString("USER_DOB"),
                    rs.getString("USER_PHONE"),
                    rs.getString("USER_EMAIL"),
                    rs.getString("USER_ADDRESS"),
                    rs.getInt("USER_IS_ADMIN"),
                    rs.getString("IS_ACTIVE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            BaseDAO.closeAll(rs, ps, conn);
        }
        return user;
    }
    
    public static int[] getTotalCount(int count, String keyword){
        int[] array = {0, 0};//array[0] total count; array[1] total page
        Connection conn = BaseDAO.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "";
        try {
            if(keyword == null){
                sql = "select count(*) from iotbay_user";
                ps = conn.prepareStatement(sql);
            }else{
                sql = "select count(*) from iotbay_user where USER_ID like ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%"+keyword+"%");
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
