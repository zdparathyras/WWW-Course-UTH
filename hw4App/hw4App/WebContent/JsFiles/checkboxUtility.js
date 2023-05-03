var master_checkbox=document.getElementById("allcats");
master_checkbox.checked=true;

function uncheck_all(){
	var checkboxes = document.getElementsByTagName("input");
	var storeDivs = document.getElementsByClassName("row2");
	var master_checkbox=document.getElementById("allcats");
	
	//uncheck all other checkboxes
	if (master_checkbox.checked==true){
		for(var i = 0; i < checkboxes.length; i++) {
			if(checkboxes[i].type == "checkbox" && checkboxes[i].id!="allcats") {
					checkboxes[i].checked = false;
			}
		}
	}
	
	//set all store div on display
	for(var i = 0; i < storeDivs.length; i++) {
		if(storeDivs[i].style.display == 'none'){
			storeDivs[i].style.display= 'block';
		}
	}
}

function uncheck_master(this_checkbox_id){
	var this_checkbox=document.getElementById(this_checkbox_id);
	var this_name = this_checkbox.getAttribute("name");;
	var storeDivs = document.getElementsByClassName("row2");
	var checkboxes = document.getElementsByTagName("input");
	
	//uncheck all other checkboxes
	for(var i = 0; i < checkboxes.length; i++) {
		if(checkboxes[i].type == "checkbox" && checkboxes[i].id!=this_checkbox_id) {	
			checkboxes[i].checked = false;
		}
	}
	
	
	for(var i = 0; i < storeDivs.length; i++) {
			var store_catergory=storeDivs[i].getAttribute("name");
			if(store_catergory!=this_name) { //if the checkbox name(stands for category) does not equal store category then set display off
				storeDivs[i].style.display = 'none';
			}
			else { // else set display on
				if (storeDivs[i].style.display == 'none'){ 
					storeDivs[i].style.display= 'block';
				}
			}
	}
}