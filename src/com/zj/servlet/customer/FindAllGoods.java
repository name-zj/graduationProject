package com.zj.servlet.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.entity.Goods;
import com.zj.service.CustomerService;

public class FindAllGoods extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String curPage = request.getParameter("curPage");
	
		int page = 0;
		try {
			page = Integer.parseInt(curPage);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
//		System.out.println(page);
		
		CustomerService service = new CustomerService();

		List<Goods> goods = service.findAllGoods(page);
//		System.out.println(goods);
		if(goods.size()>0){
			request.setAttribute("goods",goods);
			request.setAttribute("chosedItem","allGoods");
			request.setAttribute("content","allGoods.jsp");
			
			request.getRequestDispatcher("customer/mainPag.jsp").forward(request, response);
		}
		
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

}
