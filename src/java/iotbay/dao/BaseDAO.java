/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.dao;
import java.sql.*;
import java.util.Random;
/**
 *
 * @author yiyang hou
 */
public class BaseDAO {
    private static String url = "jdbc:derby://localhost:1527/";
    private static String dbname = "iotbay";
    private static String dbuser = "iotbay";
    private static String dbpass = "admin";
    private static String driver = "org.apache.derby.jdbc.ClientDriver";
    /***********************************************************************
     * load database driver
     **********************************************************************/
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /***********************************************************************
     * get connection
     **********************************************************************/
    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url + dbname, dbuser, dbpass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    /***********************************************************************
     * execute creat, update and delete from database
     * param:sql object
     **********************************************************************/
    public static int exectuCUD(String sql, Object[] params){
        int count = 0;//count of update
        Connection conn = BaseDAO.getConn();//prepare sql
        PreparedStatement ps = null;

        try {// insert into
            ps = conn.prepareStatement(sql);
            for(int i = 0; i < params.length; i++){
                ps.setObject(i + 1, params[i]);
            }
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            BaseDAO.closeAll(null, ps, conn);
        }
        return count;
    }
    /***********************************************************************
     * close all connection
     **********************************************************************/
    public static void closeAll(ResultSet rs, PreparedStatement ps, Connection conn){
        try {
            if(rs != null)
                rs.close();
            if(ps != null)
                ps.close();
            if(conn != null);
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /***********************************************************************
     * get unique primary key
     **********************************************************************/
    public static String genUniqueKey(){
        Random random = new Random();
        Integer number=random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }

}
