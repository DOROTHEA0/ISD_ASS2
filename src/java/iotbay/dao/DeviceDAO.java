/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.dao;

import java.sql.*;
import java.util.*;

import iotbay.entity.Device;
/**
 *
 * @author komei
 */
public class DeviceDAO {
    
    public static int InsertDevice(Device device){
        String sql = "insert into DEVICES values(?, ?, ?, ?, ?)";
        Object[] params = {
            device.getId(),
            device.getName(),
            device.getType(),
            device.getPrice(),
            device.getQuantity()
        };
        
        return DeviceDB.exectuCUD(sql, params);
    }
    
    public static int UpdateDevice(Device device){
        String sql = "update DEVICES set NAME=?,TYPE=?,PRICE=?,QUANTITY=? where ID=?";
        Object[] params = {
            device.getName(),
            device.getType(),
            device.getPrice(),
            device.getQuantity(),
            device.getId()
        };
        return DeviceDB.exectuCUD(sql, params);
    }
    
    public static int DeleteDevice(String deviceId){
        String sql = "delete from DEVICES where ID=?";
        Object[] params = {deviceId};
        return DeviceDB.exectuCUD(sql, params);
    }
    
    public static ArrayList<Device> SearchAll(int currentPage, int count, String keyword){
            ArrayList<Device> DeviceList = new ArrayList<Device>();
            String sql = "";

            ResultSet rs = null;
            Connection conn = DeviceDB.getConn();

            PreparedStatement ps = null;
        try {
            if(keyword == null){
                sql = "select * from DEVICES order by ID offset ? rows fetch next ? rows only"; // limit ?, ?
                ps = conn.prepareStatement(sql);
                ps.setInt(1, (currentPage - 1) * count);
                ps.setInt(2, count);
            }else{
                sql = "select * from DEVICES where TYPE like ? order by ID offset ? rows fetch next ? rows only";
                ps = conn.prepareStatement(sql);
                ps.setString(1, "%"+keyword+"%");
                ps.setInt(2, (currentPage - 1) * count);
                ps.setInt(3, count);
            }
            rs = ps.executeQuery();
            while(rs.next()){
                Device DeviceResult = new Device(
                    rs.getString("ID"), 
                    rs.getString("NAME"),
                    rs.getString("TYPE"),
                    rs.getString("PRICE"),
                    rs.getString("QUANTITY")
                );
                DeviceList.add(DeviceResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            BaseDAO.closeAll(rs, ps, conn);
        }
        return DeviceList;
    }
    
    public static Device SearchbyId(String deviceId){
        Device device = null;


        ResultSet rs = null;
        Connection conn = DeviceDB.getConn();

        PreparedStatement ps = null;
        try {
                String sql = "select * from DEVICES where ID=?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, deviceId);
                rs = ps.executeQuery();

            while(rs.next()){
                device = new Device(
                    rs.getString("ID"), 
                    rs.getString("NAME"),
                    rs.getString("TYPE"),
                    rs.getString("PRICE"),
                    rs.getString("QUANTITY")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            DeviceDB.closeAll(rs, ps, conn);
        }
        return device;
    }
    
    public static int[] getTotalCount(int count, String keyword){
        int[] array = {0, 0};//array[0] total count; array[1] total page
        Connection conn = DeviceDB.getConn();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "";
        try {
            if(keyword == null){
                sql = "select count(*) from DEVICES";
                ps = conn.prepareStatement(sql);
            }else{
                sql = "select count(*) from DEVICES where ID like ?";
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
            DeviceDB.closeAll(rs, ps, conn);
        }
        return array;
    }
}


