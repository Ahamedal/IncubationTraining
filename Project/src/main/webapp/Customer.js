/**
 * 
 */
 var array=new Array();
 class Customer{
	constructor(name,address,mobileNumber){
		this.name=name;
		this.address=address;
		this.mobileNumber=mobileNumber;
	}
}
function display(){
	
	var nam=document.getElementById("name").value;
	var addres=document.getElementById("address").value;
	var mobileNumbe=document.getElementById("mn").value;
	
	
	var customer=new Customer(nam,addres,mobileNumbe);
	array.push(customer);
	
	document.getElementById("title").innerHTML="<tr>"+"<th> name </th>"+"<th> address </th>"+"<th> mobile number </th><th> Delete </th></tr></table>";
	
	for(var i=0;i<array.length;i++){
		var btn = document.createElement('input');
		btn.type = "button";
		btn.className = "btn";
		
		
		document.getElementById("title").innerHTML+="<tr><td>"+array[i].name+"</td>"+"<td>"+array[i].address+"</td>"+"<td>"+array[i].mobileNumber+"</td><td>"+document.body.appendChild(btn);
		document.getElementById("bb"+i).innerHTML="Submit";+"</td></tr>";
	}
	

}


