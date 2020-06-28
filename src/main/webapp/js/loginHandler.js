function login(event){
	let formData = new FormData(document.querySelector("#login-form"));
	let encData = new URLSearchParams(formData.entries());

	event.preventDefault();

	fetch("rest/authenticate", {method:'POST', body: encData})
		.then(function(response){
			if(response.ok) return response.json();
			else alert("Wrong email/password combination");
		})
		.then(myJson => {
			window.sessionStorage.clear();
			window.sessionStorage.setItem("myJWT", myJson.JWT);
			window.location.assign("/dashboard.html");
		})
		.catch(error => console.log(error));
}
document.querySelector("#login-submit").addEventListener("click", login);