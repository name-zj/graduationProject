package com.zj.servlet.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.entity.Customer;
import com.zj.service.CustomerService;

public class FindCustomerByid extends HttpServlet {

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
		Customer customer = service.findCustomerByid(id);
//		System.out.println(customer);
		request.setAttribute("customer",customer);
		request.setAttribute("chosedItem","myinfo");
		request.setAttribute("content","myinfo.jsp");
		request.getRequestDispatcher("customer/mainPag.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doPost");

	}

}
