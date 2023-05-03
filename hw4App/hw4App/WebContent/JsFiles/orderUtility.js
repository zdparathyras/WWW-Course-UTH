function masterUtility() {
	var desc = document.getElementById("desc");
	var h2 = document.createElement('h2');
	var t2 = document.createTextNode(store_name); //store desc
	h2.appendChild(t2);
	desc.appendChild(h2);
	
	food_names=names.split("-");
	food_categories=categories.split("-");
	food_costs=costs.split("-");
	
	//this code creates an array of all unique strings from another array
	var categories_stringsSet = new Set(food_categories);
	var unique_categories = [...categories_stringsSet];
	console.log(unique_categories);
	
	//create a div for every category and link to it
	var unique_categories_id=[];
	var div_id = "";
	var num = 1;
	for (var i=0; i<unique_categories.length; i++){
		div_id="c"+num;
		createCategoryDiv(unique_categories[i],div_id);
		createLink(unique_categories[i],div_id);
		unique_categories_id.push(div_id);
		num++;
	}
	console.log(unique_categories_id);
	
	//create a div for every food item
	var pos=-1;
	for (var i=0; i<food_names.length; i++){
		pos=unique_categories.indexOf(food_categories[i]); //this finds the index of the foodcategory in the unique array
		createFoodDiv(unique_categories_id[pos],food_names[i],food_costs[i]);
	}
}

function createLink(link_label,dest_id){
	var categoriesDiv = document.getElementById("cc");
	var c1 = document.createElement('a');
	var link = document.createTextNode(link_label); 
	c1.appendChild(link);  
	c1.href="#"+dest_id;
	categoriesDiv.appendChild(c1);
}

function createCategoryDiv(h3_text,div_id){
	var column2 = document.getElementById("cl2");
	
	var row2 = document.createElement('div');
	row2.className = 'row2';
	var food_cat = document.createElement('div');
	food_cat.className = 'food_cat';
	food_cat.id=div_id;
	var h3 = document.createElement('h3');
	var t3 = document.createTextNode(h3_text); //foods categeory
	
	h3.appendChild(t3);
	column2.appendChild(row2);
	row2.appendChild(food_cat);
	food_cat.appendChild(h3);
	
}

function createFoodDiv(div_id,b_text,h5_text){
	var c1 = document.getElementById(div_id);
	
	var food_item = document.createElement('div');
	food_item.className="food_item";
	var str= "addToCart(" + "'"+ b_text + "'" +")";
	food_item.setAttribute("onclick",str);
	var b = document.createElement('b');
	var bt1 = document.createTextNode(b_text); //foods name
	var h5 = document.createElement('h5');
	var t5 = document.createTextNode(h5_text+"  Eυρώ"); //foods cost
	//const lineBreak = document.createElement('br');
	
	h5.appendChild(t5);
	b.appendChild(bt1); //foods name
	c1.appendChild(food_item);
	food_item.appendChild(b);
	food_item.appendChild(h5);
	//c1.appendChild(lineBreak);
}

function addToCart(foods_name){
	var cart_div = document.getElementById("cart");
	var h4 = document.getElementById("cl3h4");
    h4.style.visibility="hidden";
 	
	var food_div = document.createElement('div');
	food_div.className="food_cart";
	var h5 = document.createElement('h5');
	var t5 = document.createTextNode(foods_name);
	var minus = document.createElement("button");
	minus.className="cart_button";
	minus.innerHTML="-";
	var plus = document.createElement("button");
	plus.innerHTML="+";
	plus.className="cart_button"
	h5.appendChild(t5);
	
	food_div.appendChild(h5);
	food_div.appendChild(minus);
	food_div.appendChild(plus);
	cart_div.appendChild(food_div);
	
}
