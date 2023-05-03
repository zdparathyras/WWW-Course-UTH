function createStore(h3_text,h5_text,img_source_path){
	const column2 = document.getElementById("cl2");
	//const metersDiv = document.getElementById("result_meters");
	//console.log(meters);
	
	var row2 = document.createElement('div');
	row2.className = 'row2';
	row2.setAttribute("name",h5_text);
	var astore = document.createElement('div');
	astore.className = 'astore';
	var row = document.createElement('div');
	row.className = 'row';
	var column3 = document.createElement('div');
	column3.className = 'column3';
	var column4 = document.createElement('div');
	column4.className = 'column4';
	var img = document.createElement('img'); 
	if (img_source_path=="Σουβλάκια") {
		img_source_path="souvlaki";
		img.src ='food/'+ img_source_path +'.jpg';
	}
	else {
		img_source_path=img_source_path.toLowerCase();
		img.src ='food/'+ img_source_path +'.jfif';
	}
		
	var h3 = document.createElement("h3");
	var t3 = document.createTextNode(h3_text);
	h3.appendChild(t3);
	var h5 = document.createElement("h5");
	var t5 = document.createTextNode(h5_text);
	h5.appendChild(t5);
		
	column2.appendChild(row2);
	row2.appendChild(astore);
	astore.appendChild(row);
	row.appendChild(column3);
	column3.appendChild(img);
	row.appendChild(column4);
	column4.appendChild(h3);
	column4.appendChild(h5);
	
}