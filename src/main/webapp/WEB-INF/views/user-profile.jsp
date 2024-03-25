<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome, ${loginUser.name }</h1>
	<h3> <a href="logout">${loginUser.name }, Logout</a> </h3>
</body>
</html>