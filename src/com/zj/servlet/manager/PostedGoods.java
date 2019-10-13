package com.zj.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.entity.Goods;
import com.zj.service.CustomerService;
import com.zj.service.ManagerService;

public class PostedGoods extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String i = request.getParameter("id");
		
		int id = 0;
		try {
			id = Integer.parseInt(i);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		
//		System.out.println(id);
		ManagerService service = new ManagerService();
		service.postedGoods(id);
		response.sendRedirect(request.getContextPath()+"/findToBeAuditedGoods?curPage=1");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doPost");

	}

}
