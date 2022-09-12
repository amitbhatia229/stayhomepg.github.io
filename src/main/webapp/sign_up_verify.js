function verifypassword()
  	{
	
  	var password= document.getElementById("passworduser").value;
  	var confirmPassword= document.getElementById("cpassword").value; 
  	 	
  	if (password != confirmPassword) 
  	{
  		alert("Password and Confirm Password Should Be Same");
  		return false;
  	}
  	
  	var phonenoRegex = /^\d{10}$/;
  	var phoneNumber = document.getElementById("mobile_number").value;
  	
    if(!phoneNumber.match(phonenoRegex))
    {
    	 alert("Mobile Number Should Be Of 10 Digits");
         return false;
    }

    return true;
  	}