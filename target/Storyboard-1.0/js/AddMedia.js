let addBtn = document.querySelector("#add-media");
addBtn.addEventListener("click", addMedia);

let modal = document.querySelector("#add-media-modal");
let modalForm = modal.querySelector("#add-media-form");

// Image preview, this code needs to be active all the time because of the onchange
let imgHolder = document.querySelector("#image-holder");
let imgInput = document.querySelector("#thumbnail");

imgInput.onchange = function(event) {
	let reader = new FileReader();
	reader.onload = function(){
		let dataURL = reader.result;
		let output = imgHolder;
		output.style.backgroundImage = "url("+dataURL+")";
	};
	reader.readAsDataURL(imgInput.files[0]);
	imgInput.style.backgroundColor = "#fff";
};
function resetImgPreview(){
	imgHolder.style.backgroundImage = "";
	imgInput.style.backgroundColor = "";
}

// These functions differ from the usual opening and closing of a modal.
function closeModal(){
	modalForm.reset();
	resetImgPreview();
	modal.style.opacity = "0";
	setTimeout(visible => modal.style.visibility = "hidden", 200);
}
function openModal(){
	resetImgPreview();
	modalForm.reset();
	let formCancel = modal.querySelector(".cancel");
	formCancel.addEventListener("click", closeModal);
	modal.style.visibility = "visible";
	modal.style.opacity = "1";
}
export function createLabelFor(name){
	let label = document.createElement("label");
	label.setAttribute("for", name);
	label.innerText = name;
	return label;
}
export function createNumberInput(name, value){
	let numberInput = document.createElement("input");
	numberInput.setAttribute("type", "number");
	numberInput.setAttribute("placeholder", "0");
	numberInput.setAttribute("name", name);
	numberInput.setAttribute("value", value);
	numberInput.setAttribute("min", "0");
	numberInput.id = name;
	return numberInput;
}
export function createTextInput(name, value){
	(value===undefined) || (value==="undefined") ? value = "" : value;
	let textInput = document.createElement("input");
	textInput.setAttribute("type", "text");
	textInput.setAttribute("placeholder", "No " + name);
	textInput.setAttribute("name", name);
	textInput.setAttribute("value", value);
	textInput.id = name;
	return textInput;
}
export function createCheckBox(name, value){
	let checkbox = document.createElement("input");
	checkbox.setAttribute("type", "checkbox");
	checkbox.setAttribute("value", "true");
	checkbox.setAttribute("name", name);
	if(value){
		checkbox.checked = true;
	}
	checkbox.id = name;
	return checkbox;
}
export function createCheckBoxHidden(name){
	let boxHidden = document.createElement("input");
	boxHidden.setAttribute("type", "hidden");
	boxHidden.setAttribute("value", "false");
	boxHidden.setAttribute("name", name);
	boxHidden.id = name;
	return boxHidden;
}
function populateGenrePicker(){
	let genres = document.querySelector("#genres");
	// remove all options
	while(genres.firstChild){
		genres.removeChild(genres.lastChild);
	}
	//populate options again
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
		}).then(myJson => {
			for(let i=0;i<myJson.length;i++){
				let option = document.createElement("option");
				option.setAttribute("name", "genre");
				option.setAttribute("value", myJson[i].name);
				option.innerText = myJson[i].name;
				genres.append(option);
				$('.selectpicker').selectpicker('refresh');
			}
	});
	$('.selectpicker').selectpicker('render');
}
populateGenrePicker();

function validateForm(){
	let required = modalForm.querySelectorAll("[required]");
	let valid = [];
	required.forEach((input) => {
		if(input.value !== "" && input.value !== null){
			valid.push(true);
		} else{
			valid.push(false);
		}
	});
	if(valid.includes(false)){
		return false;
	}
	return true;
}
function postFormTo(resource){
	if(validateForm()){
		let formData = new FormData(document.querySelector("#add-media-form"));
		let encData = new URLSearchParams(formData.entries());

		const fetchoptions = {
			method: 'POST',
			headers: {
				'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
			},
			body:encData
		};

		return fetch("rest/user/"+resource, fetchoptions)
			.then(function (response){
				if(response.ok) return response.json();
				else if(response.status===401) console.log("unauthorized")
			})
	} else{
		return new Promise((resolve, reject) => reject);
	}
}
export function addMedia(){
	let allMenuItems = document.querySelector("#main-nav").children;
	let currentCat;

	// set the current category
	for(let i=0; i<allMenuItems.length;i++){
		if(allMenuItems[i].classList.contains("active")){
			currentCat = allMenuItems[i].querySelector(".nav-label").innerHTML;
		}
	}
	// remove all previously added details
	let detailsContainer = modalForm.querySelector("#media-details-container");
	while (detailsContainer.firstChild) {
		detailsContainer.removeChild(detailsContainer.lastChild);
	}
	// remove all classes
	for(let i=0;i<detailsContainer.classList.length; i++){
		detailsContainer.classList.remove(detailsContainer.classList[i]);
	}
	// add the col class again
	detailsContainer.classList.add("col-4");
	switch(currentCat) {
		case "anime":
			detailsContainer.append(
				createLabelFor("season"),
				createNumberInput("season"),
				createLabelFor("episode"),
				createNumberInput("episode"),
				createLabelFor("link"),
				createTextInput("link")
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
	openModal();
	modalForm.querySelector(".save").addEventListener("click", function(){
		postFormTo(currentCat).then(r => r);
	});
}