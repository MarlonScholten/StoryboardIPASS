let addBtn = document.querySelector("#add-media");
addBtn.addEventListener("click", addMedia);

let modal = document.querySelector("#add-media-modal");
let modalForm = modal.querySelector("#add-media-form");

function closeModal(){
	modalForm.reset();
	modal.style.opacity = "0";
	setTimeout(visible => modal.style.visibility = "hidden", 200);
}
function openModal(){
	let formCancel = modal.querySelector(".cancel");
	formCancel.addEventListener("click", closeModal);
	modal.style.visibility = "visible";
	modal.style.opacity = "1";
}
function createLabelFor(name){
	let label = document.createElement("label");
	label.setAttribute("for", name);
	label.innerText = name;
	return label;
}
function createNumberInput(name){
	let numberInput = document.createElement("input");
	numberInput.setAttribute("type", "number");
	numberInput.setAttribute("placeholder", "0");
	numberInput.setAttribute("name", name);
	numberInput.id = name;
	return numberInput;
}
function createTextInput(name){
	let textInput = document.createElement("input");
	textInput.setAttribute("type", "text");
	textInput.setAttribute("placeholder", "No " + name);
	textInput.id = name;
	return textInput;
}
function createHiddenType(){
	let typeInput = document.createElement("input");
	typeInput.setAttribute("type", "hidden");
	typeInput.setAttribute("name", "type");
	typeInput.setAttribute("id", "type");
	return typeInput;
}
function createCheckBox(name){
	let checkbox = document.createElement("input");
	checkbox.setAttribute("type", "checkbox");
	checkbox.setAttribute("value", "true");
	checkbox.setAttribute("name", name);
	checkbox.id = name;
	return checkbox;
}
function createCheckBoxHidden(name){
	let boxHidden = document.createElement("input");
	boxHidden.setAttribute("type", "hidden");
	boxHidden.setAttribute("value", "false");
	boxHidden.setAttribute("name", name);
	boxHidden.id = name;
	return boxHidden;
}
function postFormTo(resource){
	let formData = new FormData(document.querySelector("#add-media-form"));
	let encData = new URLSearchParams(formData.entries());

	const fetchoptions = {
		method: 'POST',
		headers: {
			'Authorization': 'Bearer ' + window.sessionStorage.getItem("myJWT")
		},
		body:encData
	};

	return fetch("rest/user/"+resource, fetchoptions,)
		.then(function (response){
			if(response.ok) return response.json();
			else if(response.status===401) console.log("unauthorized")
		}).then(myJson => myJson)
}
function addMedia(){
	let allMenuItems = document.querySelector("#main-nav").children;
	let currentCat;

	for(let i=0; i<allMenuItems.length;i++){
		if(allMenuItems[i].classList.contains("active")){
			currentCat = allMenuItems[i].querySelector(".nav-label").innerHTML;
		}
	}

	let detailsContainer = modalForm.querySelector("#media-details-container");
	while (detailsContainer.firstChild) {
		detailsContainer.removeChild(detailsContainer.lastChild);
	}
	for(let i=0;i<detailsContainer.classList.length; i++){
		detailsContainer.classList.remove(detailsContainer.classList[i]);
	}
	detailsContainer.classList.add("col-4");

	let hidden = createHiddenType();
	switch(currentCat) {
		case "anime":
			hidden.setAttribute("value", currentCat);
			detailsContainer.append(
				createLabelFor("season"),
				createNumberInput("season"),
				createLabelFor("episode"),
				createNumberInput("episode"),
				createLabelFor("link"),
				createTextInput("link"),
				hidden
			);
			break;
		case "books":
			hidden.setAttribute("value", currentCat);
			detailsContainer.append(
				createLabelFor("author"),
				createTextInput("author"),
				createLabelFor("page"),
				createNumberInput("page"),
				hidden
			);
			break;
		case "manga":
			hidden.setAttribute("value", currentCat);
			detailsContainer.append(
				createLabelFor("chapter"),
				createNumberInput("chapter"),
				createLabelFor("link"),
				createTextInput("link"),
				hidden
			);
			break;
		case "movies":
			hidden.setAttribute("value", currentCat);
			detailsContainer.append(
				createLabelFor("director"),
				createTextInput("director"),
				createLabelFor("watched"),
				createCheckBox("watched"),
				createCheckBoxHidden("watched"),
				hidden
			);
			break;
		case "shows":
			hidden.setAttribute("value", currentCat);
			detailsContainer.append(
				createLabelFor("season"),
				createNumberInput("season"),
				createLabelFor("watched"),
				createCheckBox("watched"),
				createCheckBoxHidden("watched"),
				hidden
			);
			break;
	}
	openModal();
	modalForm.querySelector(".save").addEventListener("click", function(){
		postFormTo(currentCat).then(r => console.log(r));
	});
}