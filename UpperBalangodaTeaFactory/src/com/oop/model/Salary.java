 
package com.oop.model;


public class Salary {

	private String employeeID;
	private String FistName;
	private String LastName;
	private int WorkDate;
	private int BasicSalary;
	private int OtHours;
	private int OtRate;
	private int TotalEpf;
	private float TotalSalry;
	private int ETF;
	private int EPF;
	public Salary(String employeeID, String fistName, String lastName, int workDate, int basicSalary, int otHours,
			int otRate, int totalEpf, float totalSalry, int eTF, int ePF) {
		super();
		this.employeeID = employeeID;
		FistName = fistName;
		LastName = lastName;
		WorkDate = workDate;
		BasicSalary = basicSalary;
		OtHours = otHours;
		OtRate = otRate;
		TotalEpf = totalEpf;
		TotalSalry = totalSalry;
		ETF = eTF;
		EPF = ePF;
	}
	
	public Salary(){}
	
	
	public String getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}
	public String getFistName() {
		return FistName;
	}
	public void setFistName(String fistName) {
		FistName = fistName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getWorkDate() {
		return WorkDate;
	}
	public void setWorkDate(int workDate) {
		WorkDate = workDate;
	}
	public int getBasicSalary() {
		return BasicSalary;
	}
	public void setBasicSalary(int basicSalary) {
		BasicSalary = basicSalary;
	}
	public int getOtHours() {
		return OtHours;
	}
	public void setOtHours(int otHours) {
		OtHours = otHours;
	}
	public int getOtRate() {
		return OtRate;
	}
	public void setOtRate(int otRate) {
		OtRate = otRate;
	}
	public int getTotalEpf() {
		return TotalEpf;
	}
	public void setTotalEpf(int totalEpf) {
		TotalEpf = totalEpf;
	}
	public float getTotalSalry() {
		return TotalSalry;
	}
	public void setTotalSalry(float totalSalry) {
		TotalSalry = totalSalry;
	}
	public int getETF() {
		return ETF;
	}
	public void setETF(int eTF) {
		ETF = eTF;
	}
	public int getEPF() {
		return EPF;
	}
	public void setEPF(int ePF) {
		EPF = ePF;
	}
	
	
	
	
}