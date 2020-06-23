import { populateMediaContainer } from "../ShowAllMedia.js";
import { closeModal } from "../ShowMedia.js";

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
function getCategories(){
	const resources = ["anime", "manga", "books", "movies", "shows"];
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
function genMenuItem(name){
	name = name.toLowerCase();
	const navTemp = document.querySelector("#nav-template");

	let tempContent = navTemp.content.cloneNode(true);
	let label = tempContent.querySelector(".nav-label");
	let href = tempContent.querySelector(".menu-href");

	label.innerText = (name);
	href.classList.add(name + "-menu-item");
	href.classList.add("unselectable");
	href.addEventListener("click", switchCat, false);
	href.targetCat = name;
	return tempContent;
}
function getCatDiff(){
	return getCategories().then(myCats=>{
		let resources = ["anime", "manga", "books", "movies", "shows"];
		let difference = resources.filter(x => !myCats.includes(x));
		return difference;
	});
}
function toggleCatSelect(){
	let holder = document.querySelector("#cat-select-holder");
	holder.classList.toggle("select-open");
}
function genCatSelect(){
	let target =  document.querySelector("#main-nav");

	let catContainer = document.createElement("div");
	catContainer.id = "cat-container";
	let btn = document.createElement("button");
	btn.id = "add-cat-btn";
	let icon = document.createElement("i");
	icon.classList.add("far");
	icon.classList.add("fa-plus-square");
	let span = document.createElement("span");
	span.innerText = "Add category";
	btn.append(icon, span);
	btn.addEventListener("click", function(){
		toggleCatSelect()
	});
	catContainer.append(btn);
	let selectholder = document.createElement("div");
	selectholder.id = "cat-select-holder";

	getCatDiff().then(diff => {
		for(let i=0;i<diff.length;i++){
			let catbtn = document.createElement("button");
			catbtn.classList.add("cat-select-btn");
			catbtn.innerText = diff[i];
			catbtn.addEventListener("click", function(){
				selectholder.removeChild(catbtn);
				target.lastChild.before(genMenuItem(catbtn.innerText));
			});
			selectholder.append(catbtn);
		}
	});
	catContainer.append(selectholder);
	return catContainer;
}
function switchCat(cat){
	let sinModal = document.querySelector("#single-media-modal");
	let targetCat = cat.currentTarget.targetCat;
	let menuItem = document.querySelector("." + targetCat+"-menu-item");
	clearActiveStates();
	menuItem.classList.add("active");
	populateMediaContainer();
	closeModal(sinModal);
	localStorage.setItem("lastCategory", targetCat);
}
function defaultActive(catString){
	let allMenuItems = document.querySelector("#main-nav").children;
	clearActiveStates();
	for(let i=0;i<allMenuItems.length;i++){
		if((allMenuItems[i].firstChild.innerText.toLowerCase()) === catString){
			allMenuItems[i].classList.add("active");
			localStorage.setItem("lastCategory", catString);
		}
	}
}
getCategories().then(myCats => {
	let target =  document.querySelector("#main-nav");

	for(let i=0; i<myCats.length;i++){
		target.append(genMenuItem(myCats[i]));
	}
	if(!(myCats.length === 5)){
		target.append(genCatSelect())
	}
	if(myCats.length >= 1){
		if(localStorage.getItem("lastCategory") === null){
			defaultActive(myCats[0])
		} else{
			defaultActive(localStorage.getItem("lastCategory"))
		}
	}
	populateMediaContainer();
});