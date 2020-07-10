package com.zb.servlet;

import com.zb.dao.DoorDao;
import com.zb.dao.OrderDao;
import com.zb.pojo.Door;
import com.zb.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("订单列表查询");
        OrderDao orderDao = new OrderDao();
        try{
            List<Order> list = orderDao.findAll();
            req.setAttribute("list",list);
            req.getRequestDispatcher("/order_list.jsp").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
