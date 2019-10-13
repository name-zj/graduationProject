package com.zj.servlet.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.entity.Goods;
import com.zj.service.CustomerService;

//根据用户id查找已发布的资源
public class FindGoodsByUserid extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String curPage = request.getParameter("curPage");
		String id = request.getParameter("id");
		
		int page = 0;
		int userid = 0;
		try {
			page = Integer.parseInt(curPage);
			userid = Integer.parseInt(id);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
//		System.out.println(page);
		
		CustomerService service = new CustomerService();

		List<Goods> goods = service.findAllGoods(userid,page);
//		System.out.println(goods);
		if(goods.size()>0){
			request.setAttribute("goods",goods);
			request.setAttribute("chosedItem","postedGoods");
			request.setAttribute("content","iPostedGoods.jsp");
			
			request.getRequestDispatcher("customer/mainPag.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doPost");

	}

}
