import { addMedia } from "./AddMedia.js";
import { showSingleMedia } from "./ShowMedia.js";

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
	while(mediaContainer.children.length > 2){
		mediaContainer.removeChild(mediaContainer.firstChild);
	}
}
function deleteMedia(mediaId){
	if(confirm("Really delete this media?")){
		fetch("rest/user/media/"+mediaId, {method: 'DELETE',
			headers: {
				'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
			}}).then(populateMediaContainer);
	} else{
		// Do nothing
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
			for(let i=0;i<r.length;i++){
				let card = document.createElement("div");
				card.classList.add("card");
				card.classList.add("media-item");
				card.addEventListener("click", function(){
					showSingleMedia(r[i])
				});
				let title = document.createElement("h6");
				title.classList.add("media-title");
				title.innerText = r[i].title;
				card.append(title);
				let delbtn = document.createElement("i");
				delbtn.classList.add("far");
				delbtn.classList.add("fa-times-circle");
				delbtn.classList.add("del-btn");
				delbtn.addEventListener("click", function(){
					deleteMedia(r[i].id);
				});
				card.append(delbtn);

				mediaContainer.prepend(card);
			}
	}).then(r =>{
		mediaContainer.prepend(genAddMediaCard());
	});
}
