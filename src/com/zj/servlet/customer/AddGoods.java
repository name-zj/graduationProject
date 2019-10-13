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
					//��������
					//��ȡ����
					String fieldName = item.getFieldName();
					//��ȡֵ
					String value = item.getString("utf-8");
					//�����ݷ�װ��map��
					map.put(fieldName,value);
				}else{
					//���ϴ���
					//��ȡ�ļ��ϴ�������
					String name = item.getName();
					good.setGimgurl(name);
					//��ȡ�ļ��ϴ�������
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
			
			//��map�е�����ת�Ƶ�book��
			BeanUtils.populate(good, map);
			
			//��good���󴫵ݵ�servic����
//			System.out.println(good);
			CustomerService service = new CustomerService();
			service.postedGoods(good);
			
			//����������
			
			response.sendRedirect(request.getContextPath()+"/findGoodsByUserid?curPage=1&id=1");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
