package com.zb.utils;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    public void destroy() {
        System.out.println("过滤器销毁");
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器准备就绪");
        // 过滤器设置编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //放行：执行后续的操作
        chain.doFilter(req,resp);
    }
    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化过滤器");
    }
}
