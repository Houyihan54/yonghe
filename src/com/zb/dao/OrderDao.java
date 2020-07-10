package com.zb.dao;

import com.zb.pojo.Door;
import com.zb.pojo.Order;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public List<Order> findAll() {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from tb_order";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Order order = null;
            while (rs.next()){
                order=new Order();
                order.setId(rs.getInt("id"));
                order.setDoor_id(rs.getInt("door_id"));
                order.setOrder_no(rs.getString("order_no"));
                order.setOrder_type(rs.getString("order_type"));
                order.setPnum(rs.getInt("pnum"));
                order.setCashier(rs.getString("cashier"));
                order.setOrder_time(rs.getTimestamp("order_time"));
                order.setPay_time(rs.getTimestamp("pay_time"));
                order.setPay_type(rs.getString("pay_type"));
                order.setPrice(rs.getDouble("price"));
                list.add(order);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return list;
    }
    public void addOrder(Order order){
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "insert into tb_order values (null,?,?,?,?,?,default,default,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,order.getDoor_id());
            ps.setString(2,order.getOrder_no());
            ps.setString(3,order.getOrder_type());
            ps.setInt(4,order.getPnum());
            ps.setString(5,order.getCashier());
         /*   ps.setTimestamp(5,order.getOrder_time());
            ps.setTimestamp(6,order.getPay_time());*/
            ps.setString(6,order.getPay_type());
            ps.setDouble(7,order.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
    public void delOrder(Integer id){
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "delete from tb_order where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
    public Order findById(Integer id){
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from tb_order where id=?";
        Order order = new Order();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                order.setId(rs.getInt("id"));
                order.setDoor_id(rs.getInt("door_id"));
                order.setOrder_no(rs.getString("order_no"));
                order.setOrder_type(rs.getString("order_type"));
                order.setPnum(rs.getInt("pnum"));
                order.setCashier(rs.getString("cashier"));
                order.setOrder_time(rs.getTimestamp("order_time"));
                order.setPay_time(rs.getTimestamp("pay_time"));
                order.setPay_type(rs.getString("pay_type"));
                order.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return order;
    }
    public void updateOrder(Order order){
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "update tb_order set door_id=?,order_no=?,order_type=?,pnum=?,cashier=?," +
                "order_time=?,pay_time=?,pay_type=?,price=? where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,order.getDoor_id());
            ps.setString(2,order.getOrder_no());
            ps.setString(3,order.getOrder_type());
            ps.setInt(4,order.getPnum());
            ps.setString(5,order.getCashier());
            ps.setTimestamp(6,order.getOrder_time());
            ps.setTimestamp(7,order.getPay_time());
            ps.setString(8,order.getPay_type());
            ps.setDouble(9,order.getPrice());
            ps.setInt(10,order.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }

}
