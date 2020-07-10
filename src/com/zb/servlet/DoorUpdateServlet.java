package com.zb.servlet;

import com.zb.dao.DoorDao;
import com.zb.pojo.Door;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/doorUpdate")
public class DoorUpdateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        // 接收jsp页面传值
        String name=req.getParameter("name");
        String tel = req.getParameter("tel");
        String addr = req.getParameter("addr");
        // 封装传入实体化door对象中
        Door door = new Door();
        door.setAddr(addr);
        door.setTel(tel);
        door.setName(name);
        door.setId(id);
        try {
            new DoorDao().updateDoor(door);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/doorList");
    }
}
