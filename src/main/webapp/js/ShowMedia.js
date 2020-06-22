import {createLabelFor} from "./AddMedia.js";
import {createNumberInput} from "./AddMedia.js";
import {createTextInput} from "./AddMedia.js";
import {createCheckBox} from "./AddMedia.js";
import {createCheckBoxHidden} from "./AddMedia.js";
import {populateMediaContainer} from "./ShowAllMedia.js";

let sinModal = document.querySelector("#single-media-modal");
let cancel = sinModal.querySelector(".cancel");
cancel.addEventListener("click", function(){
	closeModal(sinModal);
});

function createLinkEle(link){
	let anchor = document.createElement("a");
	anchor.innerHTML = "<i class='fas fa-external-link-alt\'></i>";
	anchor.href = link
	anchor.classList.add("media-link");
	anchor.setAttribute("target", "_blank");
	return anchor;
}
function deleteMedia(mediaId){
	if(confirm("Really delete this media?")){
		fetch("rest/user/media/"+mediaId, {method: 'DELETE',
			headers: {
				'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
			}}).then(populateMediaContainer);
		closeModal(sinModal);
	} else{
		// Do nothing
	}
}
export function showSingleMedia(media){
	openModal(sinModal);
	let allMenuItems = document.querySelector("#main-nav").children;
	let currentCat;
	for(let i=0; i<allMenuItems.length;i++){
		if(allMenuItems[i].classList.contains("active")){
			currentCat = allMenuItems[i].querySelector(".nav-label").innerHTML;
		}
	}
	// remove all previously added details
	let detailsContainer = sinModal.querySelector("#single-media-details-container");
	while (detailsContainer.firstChild) {
		detailsContainer.removeChild(detailsContainer.lastChild);
	}
	// remove all previously added controls
	let ctrlBar = sinModal.querySelector("#control-bar");
	while (ctrlBar.firstChild) {
		ctrlBar.removeChild(ctrlBar.lastChild);
	}

	let editBtn = document.createElement("li");
	editBtn.id = "edit-mode";
	let editIco = document.createElement("i");
	editIco.classList.add("fas");
	editIco.classList.add("fa-pencil-alt");
	editBtn.append(editIco);
	ctrlBar.append(editBtn);

	let delBtn = document.createElement("li");
	delBtn.id = "remove-btn";
	let remIco = document.createElement("i");
	remIco.classList.add("fas");
	remIco.classList.add("fa-trash-alt");
	delBtn.append(remIco);
	ctrlBar.append(delBtn);

	delBtn.addEventListener("click", function(){
		deleteMedia(media.id);
	});

	let titleEle = sinModal.querySelector("#single-title");
	let descEle = sinModal.querySelector("#single-description");
	let thumbnailEle = sinModal.querySelector("#single-image-holder");
	let notesEle = sinModal.querySelector(".notes-area");
	let genreEle = sinModal.querySelector("#single-genre-holder");

	let title = media.title;
	let desc = media.description;
	let thumbnail = media.thumbnail;
	let notes = media.notes;
	let genres = media.genres;

	titleEle.innerText = title;
	descEle.innerText = desc;
	notesEle.innerText = notes;

	thumbnailEle.style.backgroundImage = "url("+thumbnail+")";
	console.log(thumbnail);

	// remove all previously added genres
	while (genreEle.firstChild) {
		genreEle.removeChild(genreEle.lastChild);
	}
	// populate genre holder
	for(let i=0;i<genres.length;i++){
		let name = genres[i].name;
		let label = document.createElement("span");
		label.innerText = name;
		label.classList.add("genre-label");
		genreEle.append(label);
	}

	switch(currentCat) {
		case "anime":
			let label = createLabelFor("link");
			label.append(createLinkEle(media.link));
			detailsContainer.append(
				createLabelFor("season"),
				createNumberInput("season", media.season),
				createLabelFor("episode"),
				createNumberInput("episode", media.episode),
				label,
				createTextInput("link", media.link)
			);
			break;
		case "books":
			detailsContainer.append(
				createLabelFor("author"),
				createTextInput("author"),
				createLabelFor("page"),
				createNumberInput("page")
			);
			break;
		case "manga":
			detailsContainer.append(
				createLabelFor("chapter"),
				createNumberInput("chapter"),
				createLabelFor("link"),
				createTextInput("link")
			);
			break;
		case "movies":
			detailsContainer.append(
				createLabelFor("director"),
				createTextInput("director"),
				createLabelFor("watched"),
				createCheckBox("watched"),
				createCheckBoxHidden("watched")
			);
			break;
		case "shows":
			detailsContainer.append(
				createLabelFor("season"),
				createNumberInput("season"),
				createLabelFor("episode"),
				createNumberInput("episode")
			);
			break;
	}
}
export function closeModal(modal){
	modal.style.opacity = "0";
	setTimeout(visible => modal.style.visibility = "hidden", 200);
}
function openModal(modal){
	modal.style.visibility = "visible";
	modal.style.opacity = "1";
}