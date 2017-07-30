<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::View Donar::</title>
</head>
<body bgcolor="#FFF8DC">
<center>
<h3>Enter a Donor ID to Search:</h3>
<form action="Search.obj" method="post">
	<input type="text" name="donorId" />
	<br/>
	<input type="submit" name="input" value="Search"></input>
</form>


<!-- Display Error Message if not Retrieved -->
<c:if test="${sessionScope.error ne null}">
	<h3>${sessionScope.error}</h3>
</c:if>
</center>
<!-- Display the Data stored in session if data available -->
<c:if test="${sessionScope.donor ne null}">
<h3 align="center"><u>Donor Detail with Last Donated History</u></h3><br/>
<table width="500" align="center" bgcolor="#D0D0D0" border="1">
	<tr>
		<td>Donor ID:</td>
		<td>${sessionScope.donor.donorId}</td>
	</tr>
	<tr>
		<td>Donor Name:</td>
		<td>${sessionScope.donor.donorName}</td>
	</tr>
	<tr>
		<td>Phone Number:</td>
		<td>${sessionScope.donor.phoneNumber}</td>
	</tr>
	<tr>
		<td>Address:</td>
		<td>${sessionScope.donor.address}</td>
	</tr>
	<tr>
		<td>Donated Amount:</td>
		<td>Rs.${sessionScope.donor.amount}</td>
	</tr>
	<tr>
		<td>Donated Date:</td>
		<td>${sessionScope.donor.donationDate}</td>
	</tr>
</table>
</c:if>
<center>
	<br/><br/><a href="Home.obj">Go Back To HomePage</a>
</center>
</body>
</html>