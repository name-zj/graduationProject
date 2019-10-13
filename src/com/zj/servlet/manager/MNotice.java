package com.zj.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.entity.Goods;
import com.zj.service.CustomerService;
import com.zj.service.ManagerService;

public class MNotice extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String notice = request.getParameter("notice");
		ManagerService service = new ManagerService();
		service.notice(notice);
		
		request.getRequestDispatcher("manager/mainPag.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doPost");

	}

}
