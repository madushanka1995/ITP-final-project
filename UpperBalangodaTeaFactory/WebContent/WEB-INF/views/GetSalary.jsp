<%@page import="com.oop.model.Salary"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Employee.css" />
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<h2 class="h2">View Salary  for Update and Delete</h2>

	
	<br>
	<br>
	<%
	Salary salary = (Salary) request.getAttribute("salary");
	%>

	<form method="POST" action="UpdateSalaryServlet">
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="employeeID" disabled="disabled"
					value="<%=salary.getEmployeeID()%>" /></td>
			</tr>
			<tr>
				<td>Fist Name</td>
				<td><input type="text" name="FistName"
					value="<%=salary.getFistName()%>" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="LastName"
					value="<%=salary.getLastName()%>" /></td>
			</tr>
			<tr>
				<td>Work Date</td>
				<td><input type="text" name="WorkDate"
					value="<%=salary.getWorkDate()%>" /></td>
			</tr>
			<tr>
				<td>Basic Salary</td>
				<td><input type="text" name="BasicSalary"
					value="<%=salary.getBasicSalary()%>" /></td>
			</tr>
			<tr>
				<td>OT Hourse</td>
				<td><input type="text" name="OtHours"
					value="<%=salary.getOtHours()%>" /></td>
			</tr>
			<tr>
				<td>OT Rate</td>
				<td><input type="text" name="OtRate"
					value="<%=salary.getOtRate()%>" /></td>
			</tr>
		
		
		<tr>
				<td>Total EPF</td>
				<td><input type="text" name="TotalEpf"
					value="<%=salary.getTotalEpf()%>" /></td>
			</tr>
			
			
			<tr>
				<td>Total Salary</td>
				<td><input type="text" name="TotalSalry"
					value="<%=salary.getTotalSalry()%>" /></td>
			</tr>
			
			
			<tr>
				<td>ETF</td>
				<td><input type="text" name="ETF"
					value="<%=salary.getETF()%>" /></td>
			</tr>
			
			
			<tr>
				<td>EPF</td>
				<td><input type="text" name="EPF"
					value="<%=salary.getEPF()%>" /></td>
			</tr>
			
			
		
		
		
		
		
		
		
			<tr>
				<td colspan="2"><input type="hidden" name="employeeID"
					value="<%=salary.getEmployeeID()%>" /> <input type="submit"
					value="Update Salary" class="update-button"/></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteSalaryServlet">
					<input type="hidden" name="employeeID"
						value="<%=salary. getEmployeeID()%>" /> <input type="submit"
						value="Delete Salary" class="delete-button"/>
				</form>
			</td>
		</tr>
	</table>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>