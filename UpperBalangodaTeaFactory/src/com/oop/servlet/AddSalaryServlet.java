package com.oop.servlet;

import java.io.IOException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import com.oop.model.Salary;
import com.oop.service.SalaryServiceImpl;
import com.oop.service.ISalaryService;


public class AddSalaryServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	
	

	
	public AddSalaryServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException   {

		response.setContentType("text/html");

		
		
		
		
		String fistName = request.getParameter("FistName");
		String lastName = request.getParameter("LastName");
		System.out.println(lastName);
		
		
		
	
			
			
		int workDate = Integer.parseInt(request.getParameter("WorkDate"));
		int basicSalary = Integer.parseInt(request.getParameter("BasicSalary"));
		int  otHours = Integer.parseInt(request.getParameter("OtHours"));
		int  otRate =Integer.parseInt( request.getParameter("OtRate"));
		
		
		


		
		
		int totalEpf;
		int eTF;
		int ePF;
		
		
			
			eTF = basicSalary * 3/100; 	
			ePF = basicSalary * 8/100;
			totalEpf = ePF + basicSalary * 12/100;
		float totalSalry  = ( basicSalary - (eTF+ePF))+ (otHours*otRate * workDate);
		
		
		
		
	
		Salary salary = new Salary();
		
		
		salary.setFistName(fistName);
		salary.setLastName(lastName);
		salary.setWorkDate( workDate);
		salary.setBasicSalary(basicSalary);
		salary.setOtHours(otHours);
		salary.setOtRate(otRate);
		salary.setETF(eTF);
		salary.setEPF(ePF);
		salary.setTotalEpf(totalEpf);
		salary.setTotalSalry(totalSalry);
		
		
		
	
		

		ISalaryService iSalaryService = new SalaryServiceImpl();
		
		
		iSalaryService.addSalary(salary);
		
		
		
			
			
			
			request.setAttribute("salary", salary);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListSalarys.jsp");
			dispatcher.forward(request, response);
		
		

		
	
	}

}
