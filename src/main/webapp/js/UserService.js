import { User } from 'src/main/java/nl/marlon/model/User.java';

function getUser(){
	const fetchoptions = {
		method: 'GET',
		headers: {
			'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
		}
	};

	fetch("rest/user", fetchoptions)
		.then(function (response){
			if(response.ok) return response.json();
			else if(response.status==404) console.log("customer not found")
			else if(response.status==401) console.log("unauthorized")
		}).then(myJson => console.log(myJson))
		.catch(error => console.log(error));
}