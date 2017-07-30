<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::Donated::</title>
</head>
<body bgcolor="#D0D0D0">
<center>
<h3>Congrats!Donation Made Successfully.</h3><br/>
</center>
<!-- Dispaly the Data stored in session -->
<table width="500" align="center">
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
<center>
<br/><a href="Home.obj">Go Back To HomePage</a> 
</center>
</body>
</html>