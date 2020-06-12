let mediaContainer = document.querySelector("#media-container");

let allMenuItems = document.querySelector("#main-nav").children;
let currentCat;

// set the current category
for(let i=0; i<allMenuItems.length;i++){
	if(allMenuItems[i].classList.contains("active")){
		currentCat = allMenuItems[i].querySelector(".nav-label").innerHTML;
	}
}

switch(currentCat) {
	case "anime":
		mediaContainer.append(

		);
		break;
	case "books":
		mediaContainer.append(

		);
		break;
	case "manga":
		mediaContainer.append(

		);
		break;
	case "movies":
		mediaContainer.append(

		);
		break;
	case "shows":
		mediaContainer.append(

		);
		break;
}