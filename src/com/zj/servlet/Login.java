package com.zj.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.entity.Customer;
import com.zj.entity.Manager;
import com.zj.service.CustomerService;
import com.zj.service.ManagerService;

public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doGEt");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String juese = (String)request.getParameter("juese");
		String name = (String)request.getParameter("name");
		String password = (String)request.getParameter("password");
		System.out.println("juese="+juese+"  name="+name+"   pass="+password);
		if(juese.equals("manager")){
			Manager manager = new Manager();
			manager.setMname(name);
			manager.setMpassword(password);

			ManagerService service = new ManagerService();
			Manager m = service.login(manager);
			if(m!=null){
				request.setAttribute("user",m);
				request.getRequestDispatcher("mFindAllGoods?curPage=1").forward(request, response);
			}else{
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
		}else{
			Customer customer = new Customer();
			customer.setCname(name);
			customer.setCpassword(password);
			CustomerService service = new CustomerService();
			Customer c = service.login(customer);
			if(c!=null){
				request.setAttribute("user",c);
				request.getRequestDispatcher("notice").forward(request, response);
			}else{
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
		}

	}

}
