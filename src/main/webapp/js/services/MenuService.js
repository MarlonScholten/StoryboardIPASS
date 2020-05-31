function getResource(resource) {
	const fetchoptions = {
		method: 'GET',
		headers: {
			'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
		}
	};
	return fetch("rest/user/"+resource, fetchoptions)
		.then(function (response){
			if(response.ok) return response.json();
			else if(response.status===404) console.log("list not found")
			else if(response.status===401) console.log("unauthorized")
		}).then(myJson => {
			if(myJson.length > 0){
				return resource;
			}
		})
}
function populateMenu(){
	const resources = ["anime", "books", "manga", "movies", "shows"];
	return Promise.all(resources.map(getResource)).then(items=>{
		return items.filter(item=>{
			return item!== undefined
		})
	})
}
populateMenu().then(myCats => {
	const navTemp = document.querySelector("#nav-template");
	let target =  document.querySelector("#main-nav");

	for(let i=0; i<myCats.length;i++){
		let tempContent = navTemp.content.cloneNode(true);
		let label = tempContent.querySelector(".nav-label");
		label.innerText = (myCats[i]);
		target.appendChild(tempContent);
	}
});