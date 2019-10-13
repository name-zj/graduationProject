package com.zj.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.entity.Customer;
import com.zj.entity.Goods;
import com.zj.service.ManagerService;

public class FindAllCustomer extends HttpServlet {

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

		List<Customer> customers = service.findAllCustomer(page);
//		System.out.println(goods);
		if(customers.size()>0){
			request.setAttribute("customers",customers);
			request.setAttribute("chosedItem","third");
			request.setAttribute("content","allCustomer.jsp");
			
			request.getRequestDispatcher("manager/mainPag.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doPost");

	}

}
