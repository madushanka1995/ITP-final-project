<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" type = "text/css href = "Employee.css" /> 
 
  <style type="text/css"> 
    *{
   margin :0;
   padding :0;
   }
   
  .head{
  
  width : 800px;
  background-color:rgb(0,0,0,0.6);
  margin:auto;
  color:#FFFFFF;
  padding:10px 0px 10px 0px;
  text-align:center;
  border-radiuse:15px 15px 0px 0px;
  
 } 
 
 .main{
     background-color:rgb(0,0,0,0.5);
     width : 800px;
 	 margin:auto;
 
 
 }
 
 .styl{
 	position:relative;
 	left:200px;
 	top:-37px;
 	line-height:40px;
 	width:532px;
 	border-radius:6px;
 	padding:0 22px;
 	font-size:16px;
 	color:#555;
 
 }
 
 
 
 
 
.input-div > div{
    position: relative;
	height: 45px;
}

.input-div > div > h5{
	position: absolute;
	left: 10px;
	top: 50%;
	transform: translateY(-50%);
	color: #999;
	font-size: 18px;
	transition: .3s;
}

.input-div:before, .input-div:after{
	content: '';
	position: absolute;
	bottom: -2px;
	width: 0%;
	height: 2px;
	background-color: #38d39f;
	transition: .4s;
}

.input-div:before{
	right: 50%;
}

.input-div:after{
	left: 50%;
}

.input-div.focus:before, .input-div.focus:after{
	width: 50%;
}

.input-div.focus > div > h5{
	top: -5px;
	font-size: 15px;
}

.input-div.focus > .i > i{
	color: #38d39f;
}

.input-div > div > input{
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	border: none;
	outline: none;
	background: none;
	padding: 0.5rem 0.7rem;
	font-size: 1.2rem;
	color: #555;
	font-family: 'poppins', sans-serif;
}

.input-div.pass{
	margin-bottom: 4px;
}

a{
	display: block;
	text-align: right;
	text-decoration: none;
	color: #999;
	font-size: 0.9rem;
	transition: .3s;
}

a:hover{
	color: #38d39f;
}









.btn{
	display: block;
	width: 38%;
	height: 45px;
	left:50px;
	border-radius: 25px;
	outline: none;
	border: none;
	background-image: linear-gradient(to right, #32be8f, #38d39f, #32be8f);
	background-size: 100%;
	font-size: 1rem;
	color: #fff;
	font-family: 'Poppins', sans-serif;
	text-transform: uppercase;
	margin: 1rem 0;
	cursor: pointer;
	transition: .5s;
}
.btn:hover{
	background-position: right;
}  
   </style> 

<meta charset="UTF-8">
<title></title>
</head>
<body class="body" >

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include> 

    
  

	<div class="head"><h2 class="h2">Salary Calculation of Employees</h2></div>

	  
	<br>
	<br>
<div class="main">
	<form method="POST" action="AddSalaryServlet">

		<table>
			<tr style="color:#FFFFFF;" >
				<td>Fist Name</td>
				<td><input type="text" name="FistName" required /></td>
			</tr>
			
			<tr style="color:#FFFFFF;">
				<td>Last Name
				<td><input type="text" name="LastName" required /></td>
			</tr>
			<tr style="color:#FFFFFF;">
				<td>Work Date of Month</td>
				<td><input type="text" name="WorkDate" required /></td>
			</tr >
			<tr style="color:#FFFFFF;">
				<td>Basic Salary</td>
				<td><input type="text" name="BasicSalary" required/></td>
			</tr>
			<tr style="color:#FFFFFF;">
				<td>OT Hourse for Date</td>
				<td><input type="text" name="OtHours" required /></td>
			</tr>
			<tr style="color:#FFFFFF;">
				<td>OT Rate for Hour</td>
				<td><input type="text" name="OtRate" required /></td>
			</tr>
			
			</table>
			
			<input type="submit" value="Calculate Salary " class="btn" /> 
			<input type="reset" value="Reset" class="btn" />
			
		
	</form>

	<form method="POST" action="ListSalaryServlet">
	
				<input type="submit" value="List All Salary " class="btn" />
		
		
		
	</form>
</div>
	 <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include> 
	
</body>
</html>