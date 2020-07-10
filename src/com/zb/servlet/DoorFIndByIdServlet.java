package com.zb.servlet;

import com.zb.dao.DoorDao;
import com.zb.pojo.Door;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doorFindById")
public class DoorFIndByIdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取门店id
        Integer id = Integer.parseInt(req.getParameter("id"));
        // 根据id 查询门店信息
        Door door = new DoorDao().findById(id);
        System.out.println(door);
        req.setAttribute("door",door);
        req.getRequestDispatcher("/door_update.jsp").forward(req,resp);
    }
}
