package iotbay.dao;

import java.sql.*;
import java.util.*;
import iotbay.entity.Order;
import iotbay.entity.OrderLine;

/**
 *
 * @author komei
 */
public class OrderDAO {

    public static int InsertOrder(Order order) throws SQLException {
        String sql = "insert into ORDERS(USERID, TOTAL, STATUS) values(?, ?, ?)";
        Object[] params = {
            order.getUserId(),
            order.getTotal(),
            order.getStatus()
        };
        DeviceDB.exectuCUD(sql, params);

        ResultSet rs = null;
        Connection conn = DeviceDB.getConn();
        PreparedStatement ps = null;
        sql = "select ID from ORDERS order by ID desc";
        ps = conn.prepareStatement(sql);

        rs = ps.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public static int InsertOrderLine(OrderLine orderLine) throws SQLException {
        String sql = "insert into ORDERLINES(ORDERID, DEVICEID, QUANTITY, DQUANTITY) values(?, ?, ?, ?)";
        Object[] params = {
            orderLine.getOrderId(),
            orderLine.getDeviceId(),
            orderLine.getQuantity(),
            orderLine.getDquantity()
        };
        return DeviceDB.exectuCUD(sql, params);

    }

    public static int ChangeDeviceQuantity(OrderLine orderLine) throws SQLException {
        String sql = "update DEVICES set QUANTITY='"+orderLine.getDquantity()+"' where ID='"+orderLine.getDeviceId()+"'";
        Object[] params = {};
        return DeviceDB.exectuCUD(sql, params);
    }

    public static ArrayList<OrderLine> SearchOrderLine(int orderid) {
        ArrayList<OrderLine> list = new ArrayList<OrderLine>();
        ResultSet rs = null;
        Connection conn = DeviceDB.getConn();
        PreparedStatement ps = null;

        try {
            String sql = "select * from Orderlines where ORDERID=?";
            ps = conn.prepareStatement(sql);
            String id = orderid + "";
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderLine or = new OrderLine(rs.getInt("ID"), rs.getInt("ORDERID"), rs.getString("DEVICEID"), rs.getInt("QUANTITY"), rs.getInt("Dquantity"));
                list.add(or);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeAll(rs, ps, conn);
        }
        return list;
    }

    public static int UpdateOrderLine(OrderLine orderline) {
        String sql = "update ORDERLINES set QUANTITY=?, DQUANTITY=? where ID=?";
        Object[] params = {
            orderline.getQuantity(), orderline.getDquantity(), orderline.getId()
        };
        return DeviceDB.exectuCUD(sql, params);
    }

    public static OrderLine findOrderLine(int id) {
        String sql = "";
        OrderLine or = null;
        ResultSet rs = null;
        Connection conn = DeviceDB.getConn();

        PreparedStatement ps = null;
        try {

            sql = "select * from ORDERLINES where ID=?";
            ps = conn.prepareStatement(sql);
            String a = id + "";
            ps.setString(1, a);
            rs = ps.executeQuery();
            while (rs.next()) {
                or = new OrderLine(
                        rs.getInt("ID"),
                        rs.getInt("ORDERID"),
                        rs.getString("DEVICEID"),
                        rs.getInt("QUANTITY"),
                        rs.getInt("DQUANTITY")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeAll(rs, ps, conn);
        }
        return or;
    }

    public static Order DeleteOrder(int id) {
        String status = "Cancel";
        String sql = "update ORDERS set STATUS=? where ID=?";
        Object[] params = {status, id};
        DeviceDB.exectuCUD(sql, params);
        Order or = null;
        ResultSet rs = null;
        Connection conn = DeviceDB.getConn();

        PreparedStatement ps = null;
        try {

            sql = "update ORDERS set STATUS=? where ID=?";
            ps = conn.prepareStatement(sql);
            String a = id + "";
            ps.setString(1, a);
            rs = ps.executeQuery();
            while (rs.next()) {
                or = new Order(
                        rs.getInt("ID"),
                        rs.getString("USERID"),
                        rs.getString("STATUS"),
                        rs.getString("TOTAL")
                        
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeAll(rs, ps, conn);
        }
        return or;

    }

    public static ArrayList<Order> SearchAll(String userId) {
        ArrayList<Order> OrderList = new ArrayList<Order>();
        String sql = "";

        ResultSet rs = null;
        Connection conn = DeviceDB.getConn();

        PreparedStatement ps = null;
        try {

            sql = "select * from ORDERS where USERID=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order OrderResult = new Order(
                        rs.getInt("ID"),
                        rs.getString("USERID"),
                        rs.getString("STATUS"),
                        rs.getString("DATE"),
                        rs.getString("TOTAL")
                );
                OrderList.add(OrderResult);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDAO.closeAll(rs, ps, conn);
        }
        return OrderList;
    }

    public static ArrayList<Order> SearchOrder(String userId, String id, String dateFrom, String dateTo) {
        Order order = null;
        ResultSet rs = null;
        Connection conn = DeviceDB.getConn();
        String sql = "select * from Orders where USERID='" + userId + "'";
        if (id != null && !id.isEmpty()) {
            sql = sql + " and ID=" + id;
        }

        if (dateFrom != null && !dateFrom.isEmpty()) {
            sql = sql + " and DATE>=TIMESTAMP('" + dateFrom + " 00:00:00')";
        }

        if (dateTo != null && !dateTo.isEmpty()) {
            sql = sql + " and DATE<=TIMESTAMP('" + dateTo + " 00:00:00')";
        }
        System.out.println(sql);
        PreparedStatement ps = null;
        ArrayList<Order> olist = new ArrayList();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                olist.add(new Order(
                        rs.getInt("ID"),
                        rs.getString("USERID"),
                        rs.getString("STATUS"),
                        rs.getString("DATE"),
                        rs.getString("TOTAL")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DeviceDB.closeAll(rs, ps, conn);
        }
        return olist;
    }

}

