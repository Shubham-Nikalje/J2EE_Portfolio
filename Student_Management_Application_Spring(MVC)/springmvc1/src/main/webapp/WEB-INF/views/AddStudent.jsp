<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:include page="NavBar.jsp"></jsp:include>
 <% 
String msg = (String)request.getAttribute("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-image:
		url('https://www.xmple.com/wallpaper/linear-blue-white-highlight-gradient-1920x1080-c2-ffffff-e0ffff-l-50-a-165-f-21.svg');
	background-size: 100%;
}
</style>
</head>
<body>
<div align="center">
		<form action="./add" method="post">
			<fieldset>
				<legend>Add Student Details</legend>
				<table>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>Email</td>
				   		<td><input type="text" name="email"></td>
					</tr>
					<tr>
						<td>Mobile</td>
						<td><input type="text" name="mobile"></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address"></td>
					</tr>
				</table>
			</fieldset>
			<input type="submit" value="ADD">
		</form>

		<%
		if (msg != null) {
		%>
		<h3><%=msg%></h3>
		<%
		}
		%>
	</div>
</body>
</html>