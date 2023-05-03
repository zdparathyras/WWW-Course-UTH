<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="myPackage.Store" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Create your menu</title>
	<link rel="stylesheet" href="style/mystyle.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	
	<%
		Store session_store = (Store)session.getAttribute("ses_store");
				String sname = session_store.getSname();
				//System.out.println("jsp: " + sname);
		%>
	
	<header id="mainHeader">
		<div class="container">
			<h1>Deli & Dine</h1>
		</div>
	</header>

	<div class="register">
		<h3>Προσθέστε προϊόντα.</h3>
		<form class="my-form" action="StoreFood">
			<input type="hidden" name="store_name" value="<%= sname  %>" />
			<div class="row">
				<label>Όνομα Προϊόντος:</label>
				<input type="text" name="fname" placeholder="Συμπληρώστε Όνομα">
			</div>
			<br>
			<div class="row">
				<label>Τιμή:</label>
				<input type="text" name="fcost" placeholder="Συμπληρώστε Τιμή">
			</div>
			<br>
			<div class="row">
				<label>Κατηγορία:</label>
				<input type="text" name="fcatg" placeholder="Συμπληρώστε Κατηγορία">
			</div>
			<br>
			<div class="submit">
				<input type="submit" value="Αποθήκευση">
			</div>
		</form>
	</div>
</body>
</html>