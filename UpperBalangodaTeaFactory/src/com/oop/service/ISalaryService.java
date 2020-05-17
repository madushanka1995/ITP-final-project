
package com.oop.service;

import com.oop.model.Salary;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;


@SuppressWarnings("unused")
public interface ISalaryService {

	
	public static final Logger log = Logger.getLogger(ISalaryService.class.getName());


	
	public void addSalary(Salary salary);

	
	public Salary getEmployeeByID(String employeeID);
	
	
	public ArrayList<Salary> getSalarys();
	
	
	public Salary updateSalary(String employeeID, Salary salary);

	
	public void removeSalary(String employeeID);

}
