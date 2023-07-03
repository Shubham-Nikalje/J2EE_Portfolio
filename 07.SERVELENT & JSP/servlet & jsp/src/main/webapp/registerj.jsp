<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.mysql.cj.xdevapi.PreparableStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.mysql.cj.jdbc.Driver"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>

	<%!
        int id;
        String firstName, lastName, email, mobile;
    %>

    
    <%
        id = Integer.parseInt(request.getParameter("id"));
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        email = request.getParameter("email");
        mobile = request.getParameter("mobile");
    %>

    
    <%!
        String url = "jdbc:mysql://localhost:3306/wejm5?user=root&password=root";
        String query = "INSERT INTO REGISTER1 (id, firstname, lastname, email, mobile) VALUES (?, ?, ?, ?, ?)";
        int count = 0;
    %>
    
    <% 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, mobile);

            count = preparedStatement.executeUpdate();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    %>

    <%-- Expression Tag: Display registration status --%>
    <h1>
        <% if (count == 1) { %>
            Form Successfully Registered
        <% } else { %>
            Failed to Register
        <% } %>
    </h1>
</body>
</html>