function validateForm()
{
	
}
function ajax_function()
{
	form_data = document.forms["signupForm"];
	if(form_data["fname"].value == ""){
		alert("First must not be empty !!");
		return false;
	}
		 else if(form_data["email"].value=="" || !form_data["email"].value.includes("@")){
		alert("Must be a valid email format");
		return false;
	}
	 else if(form_data["confirm"].value=="" || form_data["confirm"].value != form_data["email"].value){
		alert("Must be a valid email format and match email field");
		return false;
	}
	 else if(form_data["gender"].value == ""){
		alert("Gender Must not be empty!!");
		return false;
	}	
	 else if(form_data["phone"].value=="" || !Number.isInteger(form_data["phone"].value)){
		 if (form_data["phone"].value.length != 10){
			alert("Must contain a 10 digit number only");
		return false;
		}
	}
$.ajax({
		url:"https://reqres.in/api/users/10",
		async:false,
		dataType:'json',
		type:"GET",
		success:function(data){
		$('#avatar').attr('src',data['data']['avatar'])
		 $('#first_name').val(data['data']['first_name']);
		 $('#last_name').val(data['data']['last_name']);
		 console.log(data['data']['avatar']);
		},
		error:function(er){
			console.log(er);
		}
	});
}

