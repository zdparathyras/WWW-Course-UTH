<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="myPackage.food,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Menu</title>
	<link rel="stylesheet" href="style/mystyle3.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

	<%
		String store_name = (String)request.getAttribute("storename");
		String food_names="";
		String food_categories="";
		String food_costs="";
		List<food> foods = (List<food>)request.getAttribute("foods");
		for (int i=0; i<foods.size(); i++){
			food_names += foods.get(i).getName();
			food_categories += foods.get(i).getCategory();
			food_costs += foods.get(i).getCost();
			if (i<foods.size()-1){
				food_names=food_names+"-";
				food_categories=food_categories+"-";
				food_costs=food_costs+"-";
			}
		}
		
	%>
	
	<header id="mainHeader">
		<div class="container">
			<h1>Deli & Dine</h1>
		</div>
	</header>

	<div id="desc" class="store_desc">
		<!--
		<h2>Σουβλάκια Θώδωρας</h2>
		<h4>Ασκληπιού 32, Περιστέρι Αθήνα</h4>
		<h4>Σουβλάκια, Grill - Ελάχιστη 5 ευρώ - 30'</h4>
		-->
	</div>
	
	<div class="row">
		<div class="column1">
			<div id="cc" class="categories_checkbox">
				<h4>Κατηγορίες:</h4>
			</div>
		</div>
		<div id="cl2" class="column2">
		
		</div>
		<div id="cl3" class="column3">
			<h3>Το καλάθι μου:</h3>
			<br>
			<div id="cart"></div>
			<h4 id="cl3h4">Βάλε προϊόντα στο καλάθι σου από το μενού στα αριστερά.</h4>
			<br>
			<div class="continue">
				<input type="submit" value="Συνέχεια">
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var store_name="<%=store_name%>";
		var names="<%=food_names%>";
		var categories="<%=food_categories%>";
		var costs="<%=food_costs%>";
	</script>
	<script src="JsFiles/orderUtility.js"></script>
	<script type="text/javascript">masterUtility();</script>
</body>
</html>