package com.cphoto.test;

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

import com.cphoto.utils.UploadFile;
import com.cphoto.utils.UploadFileImg;


/*@WebServlet("/upload")
@MultipartConfig*/
public class UploadTest extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		 try {
				Part part = request.getPart("file");
				
				String header = part.getHeader("content-disposition");
				
				InputStream sbs = part.getInputStream();
				
				ByteArrayOutputStream swapStream = new ByteArrayOutputStream(); 
				byte[] buff = new byte[100]; //buff用于存放循环读取的临时数据 
				int rc = 0; 
				while ((rc = sbs.read(buff, 0, 100)) > 0) { 
				swapStream.write(buff, 0, rc); 
				} 
				byte[] in_b = swapStream.toByteArray();
				String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
				System.out.println(UploadFile.store(in_b, savePath));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
