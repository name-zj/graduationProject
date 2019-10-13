package com.zj.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.entity.Goods;
import com.zj.service.ManagerService;

public class FindToBeAuditedGoods extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String curPage = request.getParameter("curPage");
		
		int page = 0;
		try {
			page = Integer.parseInt(curPage);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
//		System.out.println(page);
		
		ManagerService service = new ManagerService();

		List<Goods> goods = service.findToBeAuditedGoods(page);
//		System.out.println(goods);
		if(goods.size()>0){
			request.setAttribute("goods",goods);
			request.setAttribute("chosedItem","second");
			request.setAttribute("content","aduiting.jsp");
			
			request.getRequestDispatcher("manager/mainPag.jsp").forward(request, response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doPost");

	}

}
