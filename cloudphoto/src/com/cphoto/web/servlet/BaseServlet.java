package com.cphoto.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public abstract class BaseServlet extends HttpServlet {
		
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String methodName = request.getParameter("method");
			if(methodName==null || methodName.trim().isEmpty()) {
				throw new RuntimeException("你没有传递method参数，无法确定你要调用的方法");
			}
			/*
			 * 通过反射获取方法
			 */
			Class c = this.getClass();
			Method method = null;
			try {
				method = c.getMethod(methodName,
						HttpServletRequest.class,HttpServletResponse.class);
			} catch (Exception e) {
				throw new RuntimeException("你要调用的方法："+methodName+", 不存在");
			} 
			/*
			 * 调用method方法
			 */
			try {
				String result= (String) method.invoke(this, request,response);
				/*
				 * 获取返回的字符串
				 * 查看字符串是否含冒号，没有就表示转发，有就用冒号分割字符；前缀是f就是转发，r就重定向
				 */
				if(result ==null || result.trim().isEmpty()) {
					return;
				}
				if(result.contains(":")) {
					int index = result.indexOf(":");
					String s = result.substring(0, index);//截取前缀
					String path = result.substring(index+1);//截取后缀
					if(s.equalsIgnoreCase("f")) {//转发
						request.getRequestDispatcher(path).forward(request, response);
					}else if(s.equalsIgnoreCase("r")) {//重定向
						response.sendRedirect(request.getContextPath()+path);
					}else {
						throw new RuntimeException("你指定的操作："+s+"，当前版本还不支持");
					}
				}else {
					request.getRequestDispatcher(result).forward(request, response);
				}
			} catch (Exception e) {
				System.out.println("你要调用的："+methodName+",方法内部抛出异常");
				throw new RuntimeException(e);
			}
		}
}

