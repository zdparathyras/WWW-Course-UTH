<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.List,myPackage.Store,java.util.ArrayList,myPackage.Customer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Delivery</title>
	<link rel="stylesheet" href="style/mystyle2.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyD9I2D4m8UtbuugWlGXrIh1OqXne5iXn6c&callback=initMap&libraries=&v=weekly"></script>
	
</head>
<body>

	<header id="mainHeader">
		<div class="container">
			<h1>Deli & Dine</h1>
		</div>
	</header>

	<h2 style="color: black; text-align: center;">Διαθέσιμα καταστήματα</h2>

	<div class="row">
		<div class="column1">
			<div class="categories_checkbox">
				<h4>Κατηγορίες:</h4>
				
				<input type="checkbox" id="allcats" name="allcats" onclick="uncheck_all();">
				<label for="allcats">Όλες</label><br>
				
				<input type="checkbox" id="cat1" name="Σουβλάκια" onclick="uncheck_master(this.id);">
				<label for="cat1">Σουβλάκια</label><br>

				<input type="checkbox" id="cat2" name="Pizza" onclick="uncheck_master(this.id);">
				<label for="cat2">Pizza</label><br>

				<input type="checkbox" id="cat3" name="Crepe" onclick="uncheck_master(this.id);">
				<label for="cat3">Crepe</label><br>

				<input type="checkbox" id="cat4" name="Μαγειρευτά" onclick="uncheck_master(this.id);">
				<label for="cat4">Μαγειρευτά</label><br>

				<input type="checkbox" id="cat5" name="Grill" onclick="uncheck_master(this.id);">
				<label for="cat5">Grill</label><br>

				<input type="checkbox" id="cat6" name="Θαλλασινά" onclick="uncheck_master(this.id);">
				<label for="cat6">Θαλλασινά</label><br>

				<input type="checkbox" id="cat7" name="Καφές" onclick="uncheck_master(this.id);">
				<label for="cat7">Καφές</label><br>

				<input type="checkbox" id="cat8" name="Πρωινό" onclick="uncheck_master(this.id);">
				<label for="cat8">Πρωινό</label><br>

				<input type="checkbox" id="cat9" name="Vegan" onclick="uncheck_master(this.id);">
				<label for="cat9">Vegan</label><br>

				<input type="checkbox" id="cat10" name="Ζυμαρικά" onclick="uncheck_master(this.id);">
				<label for="cat10">Ζυμαρικά</label><br>

				<input type="checkbox" id="cat11" name="Burgers" onclick="uncheck_master(this.id);">
				<label for="cat11">Burgers</label><br>

				<input type="checkbox" id="cat12" name="Αρτοποιήματα" onclick="uncheck_master(this.id);">
				<label for="cat12">Αρτοποιήματα</label><br>
				
			</div>
			
		</div>
		<div id="cl2" class="column2">
			<%
			List<Store> allStores = (List<Store>)request.getAttribute("stores");
								Customer Session_customer = (Customer)session.getAttribute("ses_customer");
									
								List<Integer> positions = new ArrayList<>();
								String adrs = new String();
								String customer_address = new String();
								String customer_adm_area = new String();
								String store_adm_area = new String();
								String names = new String();
								String categories = new String();
								String minimum = new String();
								String minutes = new String();
								int stores_near_customer=0;
									
								if (Session_customer!=null){
									customer_address = Session_customer.getAddress();
									customer_adm_area = Session_customer.getAdm_area();
									//System.out.println(customer_address);
									
									for(int i=0; i<allStores.size(); i++) {
										store_adm_area=allStores.get(i).getAdm_area();
										if(store_adm_area.equals(customer_adm_area)) {
											stores_near_customer++;
											positions.add(i);
											adrs = adrs + allStores.get(i).getAddress();
											names = names + allStores.get(i).getSname();
											categories = categories + allStores.get(i).getCategory();
											minutes = minutes + allStores.get(i).getMinutes();
											minimum = minimum + allStores.get(i).getMinimun();
											if (i<allStores.size()-1){
												adrs=adrs+"-";
												names=names+"-";
												categories=categories+"-";
												minutes=minutes+"-";
												minimum=minimum+"-";
											}
										}
									}
								}
			%>
			<input type="text" id="result_meters" name="resultMeters" placeholder="meters">
			<script type="text/javascript">
				var minutes="<%=minutes%>";
				var minimum="<%=minimum%>";
				var names="<%=names%>";
				var categories="<%=categories%>";
				var a = "<%=adrs%>";
				var b = "<%=customer_address%>";
			</script>
			<script src="JsFiles/distance.js"></script>
			<script type="text/javascript">calculate();</script>
			<script src="JsFiles/checkboxUtility.js"></script>
		</div>
	</div>
</body>
</html>