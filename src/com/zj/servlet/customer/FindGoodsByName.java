package com.zj.servlet.customer;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.entity.Goods;
import com.zj.service.CustomerService;

public class FindGoodsByName extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String curPage = request.getParameter("curPage");
		
		int page = 0;
		try {
			page = Integer.parseInt(curPage);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		String gname = URLDecoder.decode(request.getParameter("gname"),"utf-8");
//		System.out.println("gname="+gname);
		CustomerService service = new CustomerService();
		List<Goods> goods = service.findGoodsByName(gname,page);
//		System.out.println("goods="+goods);
		request.setAttribute("goods",goods);
		request.setAttribute("content","allGoods.jsp");
		request.getRequestDispatcher("customer/mainPag.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doPost");

	}

}
