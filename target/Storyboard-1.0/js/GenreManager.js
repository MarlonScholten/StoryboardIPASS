import {openModal} from "./ShowMedia.js";
import {closeModal} from "./ShowMedia.js";
import {createLabelFor} from "./AddMedia.js";
import {createCheckBox} from "./AddMedia.js";

let genreModal = document.querySelector("#genre-mngr-modal");
let genreToggler = document.querySelector("#genre-btn");
let genreForm = document.querySelector('#genre-mngr-form');
let submitHolder = document.querySelector('#submit-holder');

function genDelSubmit(){
	let button = document.createElement("button");
	button.setAttribute("value", "");
	button.id = "genre-remove";
	button.setAttribute("disabled", "");
	let icon = document.createElement("i");
	icon.classList.add("fas");
	icon.classList.add("fa-trash-alt");
	button.append(icon);
	return button;
}
async function deleteGenre(name){
	const fetchoptions = {
		method: 'DELETE',
		headers: {
			'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
		}
	};
	return fetch("rest/user/genres/delete/" + name, fetchoptions)
		.then(function (response){
			if(response.ok) return response;
			else if(response.status===401) console.log("unauthorized");
			else if(response.status===409) console.log("cannot delete");
		});
}
genreToggler.addEventListener("click", function(){
	openModal(genreModal);
	let delBtn = genDelSubmit();
	while(submitHolder.firstChild){
		submitHolder.removeChild(submitHolder.lastChild);
	}
	submitHolder.append(
		delBtn
	);
	genreForm.addEventListener('change', function() {
		if(boxesAreChecked()){
			delBtn.removeAttribute("disabled");
		} else{
			delBtn.setAttribute("disabled", "");
		}
	});
	// TODO: 1 voor 1 een genre deleten blijkt goed te gaan, maar bij meerdere tegelijkertijd gaat alles fout
	delBtn.addEventListener("click", function(){
		let checkboxes = genreForm.querySelectorAll("input[type=checkbox]");
		for(let i=0;i<checkboxes.length;i++){
			if(checkboxes[i].checked){
				deleteGenre(checkboxes[i].name).then(r =>{
					genreList.removeChild(checkboxes[i].parentNode.parentNode);
				});
			}
		}
	});
	populateGenreList()
});
let done = genreModal.querySelector(".save");
done.addEventListener("click", function(){
	closeModal(genreModal);
	genreForm.reset();
	location.reload();
});

function createGenreItem(name){
	let li = document.createElement("li");
	let label = createLabelFor(name);
	label.append(
		createCheckBox(name)
	);
	li.append(label);
	return li;
}

function getGenres(){
	const fetchoptions = {
		method: 'GET',
		headers: {
			'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
		}
	};
	return fetch("rest/user/genres", fetchoptions)
		.then(function (response){
			if(response.ok) return response.json();
			else if(response.status===401) console.log("unauthorized");
		});
}

let genreList = document.querySelector("#genre-list-holder");
function populateGenreList(){
	while (genreList.firstChild) {
		genreList.removeChild(genreList.lastChild);
	}

	getGenres().then(genres => {
		for(let i=0;i<genres.length;i++){
			let name = genres[i].name;
			let li = createGenreItem(name);
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
	let rawName = nameInput.value;
	let newName = rawName.charAt(0).toUpperCase() + rawName.slice(1).toLowerCase();

	const fetchoptions = {
		method: 'POST',
		headers: {
			'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
		}
	};

	fetch("rest/user/genres/add/" + newName, fetchoptions)
		.then(function (response){
			if(response.ok) return response.json();
			else if(response.status===401) console.log("unauthorized");
			else if(response.status===409) console.log("genre already exists");
		}).then(genre => {
			if(genre !== undefined){
				let li = createGenreItem(newName);
				genreList.append(li);
				nameInput.value = "";
			} else{
				alert("Genre already exists");
			}
		});
}
function boxesAreChecked(){
	let checkboxes = genreForm.querySelectorAll("input[type=checkbox]");
	for(let i=0;i<checkboxes.length;i++){
		if(checkboxes[i].checked){
			return true;
		}
	}
	return false;
}