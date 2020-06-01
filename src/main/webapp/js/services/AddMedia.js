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
function createSeasonLabel(){
	let seasonlabel = document.createElement("label");
	seasonlabel.setAttribute("for", "season");
	seasonlabel.innerText = "Season";
	return seasonlabel;
}
function createSeasonInput(){
	let seasoninput = document.createElement("input");
	seasoninput.setAttribute("type", "number");
	seasoninput.id = "season";
	seasoninput.setAttribute("placeholder", "0");
	return seasoninput;
}
function createEpisodeLabel(){
	let episodelabel = document.createElement("label");
	episodelabel.setAttribute("for", "episode");
	episodelabel.innerText = "Episode";
	return episodelabel;
}
function createEpisodeInput(){
	let episodeinput = document.createElement("input");
	episodeinput.setAttribute("type", "number");
	episodeinput.id = "episode";
	episodeinput.setAttribute("placeholder", "0");
	return episodeinput;
}
function createLinkLabel(){
	let linklabel = document.createElement("label");
	linklabel.setAttribute("for", "link");
	linklabel.innerText = "Link";
	return linklabel;
}
function createLinkInput(){
	let linkinput = document.createElement("input");
	linkinput.setAttribute("type", "text");
	linkinput.id = "link";
	linkinput.setAttribute("placeholder", "No link");
	return linkinput;
}
function createPageLabel(){
	let pagelabel = document.createElement("label");
	pagelabel.setAttribute("for", "page");
	pagelabel.innerText = "Page";
	return pagelabel;
}
function createPageInput(){
	let pageinput = document.createElement("input");
	pageinput.setAttribute("type", "number");
	pageinput.id = "page";
	pageinput.setAttribute("placeholder", "0");
	return pageinput;
}
function createAuthorLabel(){
	let authorlabel = document.createElement("label");
	authorlabel.setAttribute("for", "author");
	authorlabel.innerText = "Author";
	return authorlabel;
}
function createAuthorInput(){
	let authorinput = document.createElement("input");
	authorinput.setAttribute("type", "text");
	authorinput.id = "author";
	authorinput.setAttribute("placeholder", "No author");
	return authorinput;
}
function createChapterLabel(){
	let chapterlabel = document.createElement("label");
	chapterlabel.setAttribute("for", "chapter");
	chapterlabel.innerText = "Chapter";
	return chapterlabel;
}
function createChapterInput(){
	let chapterinput = document.createElement("input");
	chapterinput.setAttribute("type", "number");
	chapterinput.id = "chapter";
	chapterinput.setAttribute("placeholder", "0");
	return chapterinput;
}
function createHiddenType(){
	let typeInput = document.createElement("input");
	typeInput.setAttribute("type", "hidden");
	return typeInput;
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
	hidden.setAttribute("name", "type");
	hidden.setAttribute("id", "type");
	switch(currentCat) {
		case "anime":
			detailsContainer.classList.add("details-"+currentCat);
			hidden.setAttribute("value", currentCat);
			detailsContainer.append(
				createSeasonLabel(),
				createSeasonInput(),
				createEpisodeLabel(),
				createEpisodeInput(),
				createLinkLabel(),
				createLinkInput(),
				hidden);
			break;
		case "books":
			detailsContainer.classList.add("details-"+currentCat);
			hidden.setAttribute("value", currentCat);
			detailsContainer.append(
				createAuthorLabel(),
				createAuthorInput(),
				createPageLabel(),
				createPageInput(),
				hidden
			);
			break;
		case "manga":
			detailsContainer.classList.add("details-"+currentCat);
			detailsContainer.append(
				createChapterLabel(),
				createChapterInput(),
				createLinkLabel(),
				createLinkInput()
			);
			break;
		case "movies":
			detailsContainer.classList.add("details-"+currentCat);
			break;
		case "shows":
			detailsContainer.classList.add("details-"+currentCat);
			break;
	}
	openModal();
}