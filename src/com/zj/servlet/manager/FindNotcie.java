package com.zj.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zj.entity.Notice;
import com.zj.service.ManagerService;

public class FindNotcie extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ManagerService service = new ManagerService();
		Notice notice = service.findNotice();
		request.setAttribute("notice",notice);
		request.setAttribute("chosedItem","fourth");
		request.setAttribute("content","notice.jsp");
		
		request.getRequestDispatcher("manager/mainPag.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().write("doPost");

	}

}
