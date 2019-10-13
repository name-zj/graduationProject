package com.zj.servlet.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.entity.Customer;
import com.zj.service.CustomerService;


public class UpdateUserInfo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doGEt");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String i = request.getParameter("id");		
		int id = 0;
		try {
			id = Integer.parseInt(i);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		
		String name = (String)request.getParameter("cname");
		String password = (String)request.getParameter("cpassword");
		String imgurl = (String)request.getParameter("cimgurl");
		String phone = (String)request.getParameter("cphone");

		Customer c = new Customer();
		c.setId(id);
		c.setCname(name);
		c.setCimgurl(imgurl);
		c.setCphone(phone);
		c.setCpassword(password);
		System.out.println(c);
		CustomerService service = new CustomerService();
		service.updateUserinfo(c);

	}

}
