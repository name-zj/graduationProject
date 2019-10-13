package com.zj.servlet.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.service.CustomerService;

public class Notice extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CustomerService service = new CustomerService();
		com.zj.entity.Notice n = service.Notice();
		request.setAttribute("notice",n);
		request.setAttribute("content","notice.jsp");
		request.getRequestDispatcher("customer/mainPag.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doPost");

	}

}
