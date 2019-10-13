package com.zj.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.service.ManagerService;

public class ForbiddenCustomer extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
		int i = 0;
		try {
			i = Integer.parseInt(id);
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		ManagerService service = new ManagerService();
		service.forbiddenCustomer(i);
		response.sendRedirect(request.getContextPath()+"/findAllBlack?curPage=1");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doPost");

	}

}
