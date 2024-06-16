let validname=(n)=>
{
	var xhttp=new XMLHttpRequest();
	
	xhttp.onreadystatechange=function()
	{
		if(this.readyState==4&&this.status==200)
		{
	     var k=document.getElementById("nm");
		 k.innerHTML=this.responseText;
		
		}
	}
	xhttp.open("Get","vname?name="+n,true);
	xhttp.send();
}