package com.zb.servlet;

import com.zb.dao.OrderDao;
import com.zb.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/orderAdd")
public class OrderAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer door_id= 1;
        String order_no = req.getParameter("order_no");
        String order_type = req.getParameter("order_type");
        Integer pnum = Integer.parseInt(req.getParameter("pnum"));
        String cashier = req.getParameter("cashier");
   /*     Timestamp order_time = Timestamp.valueOf(req.getParameter("order_time"));
        Timestamp pay_time = Timestamp.valueOf(req.getParameter("pay_time"));*/
        String pay_type = req.getParameter("pay_type");
        Double price = Double.parseDouble(req.getParameter("price"));
        Order order = new Order();
        order.setDoor_id(door_id);
        order.setOrder_no(order_no);
        order.setOrder_type(order_type);
        order.setPnum(pnum);
        order.setCashier(cashier);
     /*   order.setOrder_time(order_time);
        order.setPay_time(pay_time);*/
        order.setPay_type(pay_type);
        order.setPrice(price);
        OrderDao orderDao = new OrderDao();
        orderDao.addOrder(order);
        resp.sendRedirect("/orderList");
    }
}
