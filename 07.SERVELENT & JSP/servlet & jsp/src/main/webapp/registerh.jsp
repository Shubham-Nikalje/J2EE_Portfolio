<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<fieldset>
		<legend>EMPLOYEE FORM</legend>
		<form action="registerj.jsp">
			<label for="id">ID:</label>
        <input type="text" id="id" name="id" required><br>

        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required><br>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>

        <label for="mobile">Mobile Number:</label>
        <input type="text" id="mobile" name="mobile" required><br>

        <input type="submit" value="Submit">
		</form>
	</fieldset>
</body>
</html>