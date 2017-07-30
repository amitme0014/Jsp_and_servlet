<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::View Donations::</title>
</head>
<body bgcolor="#FFF8DC">
<center>
<h3>*** DONAR DETAILS ***</h3>
</center>
<!-- Display Error Message if not Retrieved -->
<c:if test="${sessionScope.error ne null}">
	<h3>${sessionScope.error}</h3>
</c:if>

<!-- Display the List of Data stored in session if data available -->

<c:if test="${sessionScope.donorList ne null}">
<table width="700" align="center" border="1" bgcolor="#CCCCCC">
	<tr>
		<th>Donor ID</th>
		<th>Donor Name</th>
		<th>Phone Number</th>
		<th>Address</th>
		<th>Donated Amount</th>
		<th>Donated Date</th>
	</tr>
	<c:forEach var="donor" items="${sessionScope.donorList}">
		<tr>
			<td>${donor.donorId}</td>
			<td>${donor.donorName}</td>
			<td>${donor.phoneNumber}</td>
			<td>${donor.address}</td>
			<td>Rs.${donor.amount}</td>
			<td>${donor.donationDate}</td>
		</tr>
	</c:forEach>
</table>
</c:if>
<center><br/>
<a href="Home.obj">Go Back To HomePage</a>
</center>
</body>
</html>