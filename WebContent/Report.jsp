<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ReportController" method="post">
<table>
<tr>
<td>From date:</td>
<td><input type="date" name="start_date"></td>
</tr>
<tr>
<td>To date:</td>
<td><input type="date" name="end_date"></td>
</tr>
</table>
<input type="submit" value="DOWNLOAD">
</body>
</html>