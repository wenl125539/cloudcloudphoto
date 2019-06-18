package com.cphoto.filter;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cphoto.pojo.User;
import com.cphoto.service.UserService;
import com.cphoto.service.impl.UserServiceImpl;



public class AutoLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    /**
     * 处理过滤信息方法
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        Object object = req.getSession().getAttribute("user");
        // 如果从session中获取user为空，我们才需要获取cookie进行登陆以及存放到session中,否则直接放行
        if (object == null) {
            // 获取请求携带的cookies
            Cookie[] cookies = req.getCookies();
            Cookie cookie = null;
            // 先要判断获取的cookies是否存在，不然遍历的时候会报空指针异常
            if (cookies != null && cookies.length > 0) {
                // 遍历cookies
                for (Cookie c : cookies) {
                    String name = c.getName();
                    if ("autoLogin".equals(name)) {
                        // 说明cookie中存在自动登录信息
                        cookie = c;
                        break;
                    }
                }
            }

            try {
                // 说明存在自动登陆的cookie
                if (cookie != null) {
                    // 我们需要把cookie的值读取出来存放到session中
                    String[] split = cookie.getValue().split("&");
                    User user = new User();
                    user.setUserid(split[0]);
                    user.setPassword(split[1]);
                    // 调用service层登陆
                    UserService service = new UserServiceImpl();
                    User userBack = service.findUser(user);
                    if (userBack != null) {// 说明登陆成功
                        req.getSession().setAttribute("user", userBack);
                    }
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // 如果不存在直接 放行
        chain.doFilter(req, resp);

        // 过滤响应
    }
    @Override
    public void destroy() {
    }

}
