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


public class UpdateSalaryServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	
	public UpdateSalaryServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

	
		String employeeID = request.getParameter("employeeID");	
		
		
		String fistName = request.getParameter("FistName");
		String lastName = request.getParameter("LasttName");
		
		
		
		
		
			
			
		 int workDate = Integer.parseInt(request.getParameter("WorkDate"));
		int basicSalary = Integer.parseInt(request.getParameter("BasicSalary"));
		int  otHours = Integer.parseInt(request.getParameter("OtHours"));
		int  otRate =Integer.parseInt( request.getParameter("OtRate"));
		int  eTF = Integer.parseInt(request.getParameter("ETF"));
	    int ePF = Integer.parseInt(request.getParameter("EPF"));
	    int totalEpf = Integer.parseInt(request.getParameter("TotalEpf"));
		float totalSalry = Float.parseFloat(request.getParameter("TotalSalry"));
		
	
		Salary salary = new Salary();
		
		
		salary.setEmployeeID(employeeID);
		
		
		salary.setFistName(fistName);
		salary.setLastName(lastName);
		salary.setWorkDate( workDate);
		salary.setBasicSalary(basicSalary);
		salary.setOtHours(otHours);
		salary.setOtRate(otRate);
		salary.setETF(eTF);
		salary.setEPF(ePF);
		salary.setTotalEpf(totalEpf);
		salary.setTotalSalry( totalSalry);
		
		
		
		ISalaryService iSalaryService = new SalaryServiceImpl();
		iSalaryService.updateSalary(employeeID, salary);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListSalarys.jsp");
		dispatcher.forward(request, response);
	}

}
