
<%@page import="com.oop.model.Salary"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.SalaryServiceImpl"%>
<%@page import="com.oop.service.ISalaryService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "Employee.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<style type="text/css">
.head{
 width : 800px;
  background-color:rgb(0,0,0,0.6);
  margin:auto;
  color:#FFFFFF;
  padding:10px 0px 10px 0px;
  text-align:center;
  border-radiuse:15px 15px 0px 0px;



}
.list{

 background-color:rgb(0,0,0,0.5);
     width : 800px;
 	 margin:auto;


}


th{
background-color:#a70000;
color:white;



}



</style>


</head>


<body>



	<div class="head"><h3>List All Salaly of Employees</h3></div>
	
	<br>
	<br>
	  <div class="list">
		<table border="1" cellpadding="12">
		 <caption><h2>List of All Salary</h2></caption>
		 <a href="homeView.jsp" style="color:#ff0000;">Calculate Salary</a>
		  <tr>
                <th>Employee ID</th>
                <th>Fist  Name</th>
                <th>Last Name</th>
                <th>Work Date</th>
                <th>Basic Salary</th>
                <th>Ot Hourse</th>
                <th>Ot Rate</th>
                <th>Total EPF</th>
                
                <th>Total Salary</th>
                 <th>ETF</th>
                  <th>EPF</th>
                
                <th>Select</th>
            </tr>
            <%
            ISalaryService iSalaryService = new SalaryServiceImpl();
			ArrayList<Salary> arrayList = iSalaryService.getSalarys();
			
			for(Salary salary : arrayList){
			%>
			 <tr>
			<td> <%=salary.getEmployeeID() %> </td>
				<td> <%=salary.getFistName()%> </td>
				<td> <%=salary.getLastName() %> </td>
				<td> <%=salary.getWorkDate() %> </td>
				<td> <%=salary.getBasicSalary() %> </td>
				<td> <%=salary.getOtHours() %> </td>
				<td> <%=salary.getOtRate() %> </td>
				<td> <%=salary.getTotalEpf() %> </td>
				<td> <%=salary.getTotalSalry()%> </td>	
				<td> <%=salary.getETF() %> </td>	
				<td> <%=salary.getEPF() %> </td>		
				<td> 
				
				
				<form method="POST" action="GetSalaryServlet">
				<input type="hidden" name="SalaryID" value="<%=salary.getEmployeeID()%>"/>
				 <input type="submit" value= "Select Salary" class="select-button" /> 
				 </form>
				 </td>	
				</tr>		
			<%	
			   }
            %>     
		</table>
		</div>
		
</body>
</html>