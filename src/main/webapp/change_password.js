function change_password(){
	
	var x=document.getElementById("oldpassword");
	var y=document.getElementById("newpassword");
	var z=document.getElementById("cpassword");
	
	if(y!=z)
	{
		alert("password is mismatch");	
		return false;
	}
	
}
