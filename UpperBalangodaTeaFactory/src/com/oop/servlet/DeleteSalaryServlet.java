package com.oop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Salary;
import com.oop.service.SalaryServiceImpl;
import com.oop.service.ISalaryService;


public class DeleteSalaryServlet extends HttpServlet {


	
	private static final long serialVersionUID = 1871871796669342804L;

	
	public DeleteSalaryServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String employeeID = request.getParameter("employeeID");			
		
		ISalaryService iSalaryService = new SalaryServiceImpl();
		iSalaryService.removeSalary(employeeID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListSalarys.jsp");
		dispatcher.forward(request, response);
	}

}
