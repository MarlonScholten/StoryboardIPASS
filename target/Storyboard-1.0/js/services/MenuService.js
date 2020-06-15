import { populateMediaContainer } from "../ShowMedia.js";
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
function clearActiveStates(){
	let allMenuItems = document.querySelector("#main-nav").children;
	for(let i=0; i<allMenuItems.length;i++){
		allMenuItems[i].classList.remove("active");
	}
}
function switchCat(cat){
	let targetCat = cat.currentTarget.targetCat;
	let menuItem = document.querySelector("." + targetCat+"-menu-item");
	clearActiveStates();
	menuItem.classList.add("active");
	populateMediaContainer();
}
function defaultActive(){
	let allMenuItems = document.querySelector("#main-nav").children;
	clearActiveStates();
	allMenuItems[0].classList.add("active");
}
populateMenu().then(myCats => {
	const navTemp = document.querySelector("#nav-template");
	let target =  document.querySelector("#main-nav");

	for(let i=0; i<myCats.length;i++){
		let tempContent = navTemp.content.cloneNode(true);
		let label = tempContent.querySelector(".nav-label");
		let href = tempContent.querySelector(".menu-href");

		label.innerText = (myCats[i]);
		href.classList.add(myCats[i] + "-menu-item");
		href.classList.add("unselectable");
		href.addEventListener("click", switchCat, false);
		href.targetCat = myCats[i];
		target.appendChild(tempContent);
	}
	defaultActive();
	populateMediaContainer();
});