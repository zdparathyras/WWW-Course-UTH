// This sample requires the Places library. Include the libraries=places
// parameter when you first load the API. For example:
// <script
// src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&libraries=places">
function initMap() {
	const map = new google.maps.Map(document.getElementById("map"), {
	center: { lat: 37.983810, lng: 23.727539 },
	zoom: 6,
	});
	const input = document.getElementById("pac-input");
	const autocomplete = new google.maps.places.Autocomplete(input);
	autocomplete.bindTo("bounds", map);
	// Specify just the place data fields that you need.
	autocomplete.setFields(["place_id", "geometry", "name", "formatted_address"]);
	map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);
	const infowindow = new google.maps.InfoWindow();
	const infowindowContent = document.getElementById("infowindow-content");
	infowindow.setContent(infowindowContent);
	const geocoder = new google.maps.Geocoder();
	const marker = new google.maps.Marker({ map: map });
	marker.addListener("click", () => {
	infowindow.open(map, marker);
	});
	autocomplete.addListener("place_changed", () => {
	infowindow.close();
	const place = autocomplete.getPlace();

	if (!place.place_id) {
		return;
	}
	geocoder.geocode({ placeId: place.place_id }, (results, status) => {
		if (status !== "OK") {
			window.alert("Geocoder failed due to: " + status);
			return;
		}
		map.setZoom(17);
		map.setCenter(results[0].geometry.location);
		// Set the position of the marker using the place ID and location.
		marker.setPlace({
		placeId: place.place_id,
		location: results[0].geometry.location,
	});
	marker.setVisible(true);
	infowindowContent.children["place-name"].textContent = place.name;
	infowindowContent.children["place-id"].textContent = place.place_id;
	infowindowContent.children["place-address"].textContent = results[0].formatted_address;
	infowindow.open(map, marker);
	//input.value=results[0].formatted_address;
	//input.value=results[0].address_components[2].long_name;
	const formated = document.getElementById("formated");
	const adm_area = document.getElementById("adm_area");
	formated.value=results[0].formatted_address;
	adm_area.value=results[0].address_components[3].long_name;
	
	/*
	var component;
	var city;
	var str;
	for (c = 0; c< results[0].address_components.length; c++) {
		component = results[0].address_components[c];
		str="results[0].address_components["+c+"]"
		console.log(component.types[0]+" at "+str);
		if (component.types[0] === 'administrative_area_level_3') {
			city = component.long_name;
			console.log(city);
			break;
		}
	}
	*/
	
	});
});
}