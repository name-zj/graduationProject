package com.zj.servlet.customer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zj.entity.Goods;
import com.zj.service.CustomerService;

public class AddGoods extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doGEt");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String> map = new HashMap<String,String>();
		Goods good = new Goods();
		
		try{
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("utf-8");
			List<FileItem> parse = upload.parseRequest(request);
			for(FileItem item:parse){
				if(item.isFormField()){
					//表单输入域
					//获取名称
					String fieldName = item.getFieldName();
					//获取值
					String value = item.getString("utf-8");
					//将数据封装在map中
					map.put(fieldName,value);
				}else{
					//表单上传项
					//获取文件上传的名称
					String name = item.getName();
					good.setGimgurl(name);
					//获取文件上传的内容
					InputStream in = item.getInputStream();
					String path = this.getServletContext().getRealPath("/imgs"+name);
					OutputStream out = new FileOutputStream(path);
					int len = 0;
					byte[] buffer = new byte[1024];
					while((len=in.read(buffer))>0){
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
				}
			}
			
			good.setGowner("1");
			good.setGifaduiting("1");
			
			//将map中的数据转移到book中
			BeanUtils.populate(good, map);
			
			//将good对象传递到servic层中
//			System.out.println(good);
			CustomerService service = new CustomerService();
			service.postedGoods(good);
			
			//返回主界面
			
			response.sendRedirect(request.getContextPath()+"/findGoodsByUserid?curPage=1&id=1");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
