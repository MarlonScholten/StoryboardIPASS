import {openModal} from "./ShowMedia.js";
import {closeModal} from "./ShowMedia.js";
import {createLabelFor} from "./AddMedia.js";
import {createCheckBox} from "./AddMedia.js";
import {createCheckBoxAlt} from "./AddMedia.js";

let genreModal = document.querySelector("#genre-mngr-modal");
let genreToggler = document.querySelector("#genre-btn");
let genreForm = document.querySelector('#genre-mngr-form');
let submitHolder = document.querySelector('#submit-holder');

function genDelSubmit(){
	let button = document.createElement("button");
	button.setAttribute("type", "submit");
	button.setAttribute("form", "genre-mngr-form");
	button.id = "genre-remove";
	// button.setAttribute("disabled", "");
	let icon = document.createElement("i");
	icon.classList.add("fas");
	icon.classList.add("fa-trash-alt");
	button.append(icon);
	return button;
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
	// genreForm.addEventListener('change', function() {
	// 	if(boxesAreChecked()){
	// 		delBtn.removeAttribute("disabled");
	// 	} else{
	// 		delBtn.setAttribute("disabled", "true");
	// 	}
	// });
	delBtn.addEventListener("click", function(){
		let formData = new FormData(genreForm);
		let encData = new URLSearchParams(formData.entries());

		const fetchoptions = {
			method: 'DELETE',
			headers: {
				'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
			},
			body:encData
		};

		return fetch("rest/user/genres/delete", fetchoptions)
			.then(function (response){
				if(response.ok) return response;
				else if(response.status===401) console.log("unauthorized")
			})
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
	let label = createLabelFor(name);
	let option = document.createElement("option");
	option.setAttribute("value", name);
	option.setAttribute("id", name);
	$(option).mousedown(function(){
		let $self = $(this);

		if ($self.prop("selected"))
			$self.prop("selected", false);
		else
			$self.prop("selected", true);

		return false;
	});
	option.append(
		label
	);
	return option;
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
	// let checkboxes = genreForm.querySelectorAll("input[type=checkbox]");
	// for(let i=0;i<checkboxes.length;i++){
	// 	if(checkboxes[i].checked){
	// 		return true;
	// 	}
	// }
	// return false;
	return true;
}