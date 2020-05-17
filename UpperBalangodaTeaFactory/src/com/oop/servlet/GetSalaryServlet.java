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


public class GetSalaryServlet extends HttpServlet {


	
	
	private static final long serialVersionUID = 1L;

	
	public GetSalaryServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

 		String employeeID = request.getParameter("EmployeeID");			
		ISalaryService iSalaryService = new SalaryServiceImpl();
		Salary salary = iSalaryService.getEmployeeByID(employeeID);

		request.setAttribute("salary", salary);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/GetSalary.jsp");
		dispatcher.forward(request, response);
	}

}
