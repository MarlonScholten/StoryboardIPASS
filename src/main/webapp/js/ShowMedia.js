import { addMedia } from "./AddMedia.js";

let mediaContainer = document.querySelector("#media-container");

function getCurrentCat(){
	let allMenuItems = document.querySelector("#main-nav").children;
	let currentCat;

	// set the current category
	for(let i=0; i<allMenuItems.length;i++){
		if(allMenuItems[i].classList.contains("active")){
			currentCat = allMenuItems[i].querySelector(".nav-label").innerHTML;
		}
	}
	return currentCat;
}

function genAddMediaCard(){
	let addMediaEle = document.createElement("div");
	addMediaEle.classList.add("card");
	addMediaEle.id = "add-media";
	let heading = document.createElement("h4");
	heading.setAttribute("unselectable", "on");
	heading.classList.add("unselectable");
	heading.innerText = "Add media";
	addMediaEle.appendChild(heading);
	addMediaEle.addEventListener("click", addMedia);
	return addMediaEle;
}

function purgeMediaContainer(){
	while(mediaContainer.children.length > 1){
		mediaContainer.removeChild(mediaContainer.firstChild);
	}
}
export function populateMediaContainer(){
	purgeMediaContainer();

	fetch("rest/user/"+getCurrentCat(), {method: 'GET',
		headers: {
			'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
		}})
		.then(function (response){
			if(response.ok) return response.json();
			else if(response.status===401) console.log("unauthorized");
		}).then(r => {
			let obj;
			for(obj of r){
				let card = document.createElement("div");
				card.classList.add("card");

				console.log(obj.thumbnail);
				card.style.backgroundImage = "url('"+ obj.thumbnail.replace(/\s/g,'')+"')";

				mediaContainer.prepend(card);
			}
	}).then(r =>{
		mediaContainer.prepend(genAddMediaCard());
	});
}