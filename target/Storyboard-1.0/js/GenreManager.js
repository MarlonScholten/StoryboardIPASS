import {openModal} from "./ShowMedia.js";
import {closeModal} from "./ShowMedia.js";
import {createLabelFor} from "./AddMedia.js";
import {createCheckBox} from "./AddMedia.js";
import {createCheckBoxHidden} from "./AddMedia.js";

let genreModal = document.querySelector("#genre-mngr-modal");
let genreToggler = document.querySelector("#genre-btn");

genreToggler.addEventListener("click", function(){
	openModal(genreModal);
	populateGenreList()
});
let cancel = genreModal.querySelector(".cancel");
cancel.addEventListener("click", function(){
	closeModal(genreModal);
});

let genreList = document.querySelector("#genre-list-holder");
function populateGenreList(){
	while (genreList.firstChild) {
		genreList.removeChild(genreList.lastChild);
	}
	const fetchoptions = {
		method: 'GET',
		headers: {
			'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
		}
	};

	fetch("rest/user/genres", fetchoptions)
		.then(function (response){
			if(response.ok) return response.json();
			else if(response.status===401) console.log("unauthorized");
		}).then(genres => {
		for(let i=0;i<genres.length;i++){
			let name = genres[i].name;
			let li = document.createElement("li");
			let label = createLabelFor(name);
			label.append(
				createCheckBox(name),
				createCheckBoxHidden(name)
			);
			li.append(label);
			genreList.append(li);
		}
	});
}
let nameInput = genreModal.querySelector(".genre-txt-input");
let addBtn = genreModal.querySelector("#add-genre");
addBtn.addEventListener("click", function(){
	addNewGenre()
});
function addNewGenre(){
	let newName = nameInput.value;
	// TODO: voeg nieuwe genre toe aan lijst.
	// TODO: maybe bij het toevoegen al een POST request sturen, en bij het verwijderen een DELETE in plaats van 1 formulier beide laten doen.
	console.log(newName);
}