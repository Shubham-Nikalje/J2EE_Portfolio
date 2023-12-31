<%@page import="java.util.List"%>
<%@page import="com.jspider.springmvc1.pojo.StudentPOJO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:include page="NavBar.jsp"></jsp:include>
    <%String msg = (String)request.getAttribute("msg"); 
    List<StudentPOJO> students = (List<StudentPOJO>)request.getAttribute("StudList");
    %>
<!DOCTYPE html>
<html>
<style>
body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<form action="./remove" method="post">
			<fieldset>
				<legend>Search Student Details</legend>
				<table>
					<tr>
						<td>Enter ID</td>
						<td><input type="text" name="id"></td>
					</tr>
				</table>
			</fieldset>
			<input type="submit" value="REMOVE">
		</form>
		<%
		if (msg != null) {
		%>
		<h4><%=msg%></h4>
		<%
		}
		%>
		<%
		if(students != null){
		%>
		<table id="data">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Contact</th>
					<th>Address</th>
				</tr>
			</thead>
			<%
			for(StudentPOJO pojo : students){
			%>
			<tr>
				<td><%=pojo.getId()%></td>
				<td><%=pojo.getName()%></td>
				<td><%=pojo.getEmail()%></td>
				<td><%=pojo.getMobile()%></td>
				<td><%=pojo.getAddress()%></td>
			</tr>
			<%
			}
			%>
			</table>
			<%
		}
			%>
	</div>
</body>
</html>