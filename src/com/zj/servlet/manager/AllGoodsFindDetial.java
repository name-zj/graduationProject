package com.zj.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.entity.Goods;
import com.zj.service.CustomerService;

public class AllGoodsFindDetial extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String i = request.getParameter("id");
		
		int id = 0;
		try {
			id = Integer.parseInt(i);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		
//		System.out.println(id);
		CustomerService service = new CustomerService();
		Goods goods = service.findGoodsById(id);
		
		request.setAttribute("goods",goods);
		request.setAttribute("chosedItem","first");
		request.setAttribute("content","mGoodsDetial.jsp");
		request.getRequestDispatcher("manager/mainPag.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doPost");

	}

}