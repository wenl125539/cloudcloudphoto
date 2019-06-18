package com.cphoto.web.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cphoto.pojo.User;
import com.cphoto.service.UserService;
import com.cphoto.service.impl.UserServiceImpl;
import com.cphoto.utils.UploadFileImg;


@WebServlet("/uploadHead")
@MultipartConfig
public class UploadHead extends HttpServlet {
	private UserService service = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		 try {
			 
			//String header = part.getHeader("content-disposition");
				Part part = request.getPart("head");
				
				String username = request.getParameter("username");
				
			
				InputStream sbs = part.getInputStream();
				
				ByteArrayOutputStream swapStream = new ByteArrayOutputStream(); 
				byte[] buff = new byte[100]; //buff用于存放循环读取的临时数据 
				int rc = 0; 
				while ((rc = sbs.read(buff, 0, 100)) > 0) { 
				swapStream.write(buff, 0, rc); 
				} 
				byte[] in_b = swapStream.toByteArray();
				String savePath = this.getServletContext().getRealPath("/WEB-INF/upload/head");
				String headName = UploadFileImg.store(in_b, savePath);
				
				User user = new User();
				user.setUserid(username);
				user.setHead(headName);
				try {
					service.updateUserHead(user);
				} catch (Exception e) {
					request.setAttribute("msg","修改失败");
				}
				//跳转页面
				
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ServletException e) {
				
				e.printStackTrace();
			}
		}
}
