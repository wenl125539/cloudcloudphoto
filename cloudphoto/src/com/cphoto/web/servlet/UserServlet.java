package com.cphoto.web.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cphoto.pojo.User;
import com.cphoto.service.UserService;
import com.cphoto.service.impl.UserServiceImpl;
import com.cphoto.utils.MD5Utils;


@WebServlet(value="/UserServlet")
public class UserServlet extends BaseServlet {

		//转发 c			return"f:/a.jsp";
		
		//重定向：			return"r:/a.jsp";
	
	private UserService userService = new UserServiceImpl();
	
	public String login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		
		
		
		if("".equals(username)||"".equals(password)) {
			request.setAttribute("username",username);
			request.setAttribute("msg","用户名或密码不能为空");
			return"f:/index.jsp";
		}else if(username.length()>8||username.length()<0) {
			request.setAttribute("username",username);
			request.setAttribute("msg","用户名范围在1-8之间");
			return"f:/index.jsp";
		}else if(password.length()>8||password.length()<0) {
			request.setAttribute("msg","密码范围在1-8之间");
			return"f:/index.jsp";
		}
		
		
		
		User user = new User();
		user.setUserid(username);
		user.setPassword(MD5Utils.md5(password));
		
		if(request.getParameter("cb").equals("ok")) {
			Cookie cookie = new Cookie("autoLogin", user.getUserid() + "&" + user.getPassword());
			 cookie.setMaxAge(360000);
             cookie.setPath(request.getContextPath());
             // 在响应中添加cookie,并返回给浏览器
             response.addCookie(cookie);
		}
		
		try {
			User user2 =  userService.findUser(user);
			if(user2 == null) {
				request.setAttribute("username",username);
				request.setAttribute("msg","用户名或密码错误");
				return"f:/index.jsp";
			}else {
				//保存user到session
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(30);
				session.setAttribute("userid", user2.getUserid());
				//跳转到相册页面
				return"f:/WEB-INF/login.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return"f:/index.jsp";
	}
	
	
	public String regist(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();
		
		if("".equals(username)||"".equals(password)) {
			request.setAttribute("username",username);
			request.setAttribute("msg","用户名或密码不能为空");
			request.setAttribute("ztm","1");
			return"f:/index.jsp";
		}else if(username.length()>8||username.length()<0) {
			request.setAttribute("username",username);
			request.setAttribute("ztm","1");
			request.setAttribute("msg","用户名范围在1-8之间");
			return"f:/index.jsp";
		}else if(password.length()>8||password.length()<0) {
			request.setAttribute("ztm","1");
			request.setAttribute("username",username);
			request.setAttribute("msg","密码范围在1-8之间");
			return"f:/index.jsp";
		}
		
		
		
		User user = new User();
		user.setUserid(username);
		user.setPassword(MD5Utils.md5(password));
		try {
			Boolean falg =  userService.addUser(user);
			if(!falg) {
				request.setAttribute("username",username);
				request.setAttribute("ztm","1");
				request.setAttribute("msg","注册失败");
				return"f:/index.jsp";
			}else {
				//保存user到session
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(30);
				session.setAttribute("userid", username);
				//跳转到相册页面
				return"f:/index.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("ztm","1");
			request.setAttribute("username",username);
			request.setAttribute("msg",e.getMessage());
			return"f:/index.jsp";
		}
	}
	
	
	public String editUser(HttpServletRequest request, HttpServletResponse response) {
		
		String username = request.getParameter("username").trim();
		String password = request.getParameter("password").trim();

		
		if("".equals(username)||"".equals(password)) {
			request.setAttribute("username",username);
			request.setAttribute("ztm","2");
			request.setAttribute("msg","用户名或密码不能为空");
			return"f:/index.jsp";
		}else if(username.length()>8||username.length()<0) {
			request.setAttribute("username",username);
			request.setAttribute("ztm","2");
			request.setAttribute("username",username);
			request.setAttribute("msg","用户名范围在1-8之间");
			return"f:/index.jsp";
		}else if(password.length()>8||password.length()<0) {
			request.setAttribute("ztm","2");
			request.setAttribute("username",username);
			request.setAttribute("msg","密码范围在1-8之间");
			return"f:/index.jsp";
		}
		
		
		
		User user = new User();
		user.setUserid(username);
		user.setPassword(MD5Utils.md5(password));
		try {
			Boolean falg =  userService.editUser(user);
			if(!falg) {
				request.setAttribute("username",username);
				request.setAttribute("msg","修改失败,用户不存在");
				request.setAttribute("ztm","2");
				return"f:/index.jsp";
			}else {
				//保存user到session
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(30);
				session.setAttribute("userid", username);
				//跳转到登陆
				return"f:/index.jsp";
			}
		} catch (Exception e) {
			e.getMessage();
			request.setAttribute("ztm","2");
			request.setAttribute("username",username);
			request.setAttribute("msg",e.getMessage());
			return"f:/index.jsp";
		}
	}
}
