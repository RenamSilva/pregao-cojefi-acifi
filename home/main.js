// let btn = document.querySelector("#btn");
// let sideBar = document.querySelector(".sideBar");

// btn.onclick = function() {
//     sideBar.classList.toggle("active");
// }
// let open = true

// document.querySelector('#btn').addEventListener('focusin', e => {
//     open = !open;
//     toggleMenu()
// })

// document.querySelector('#btn').addEventListener('focusout', e => {
//     open = false;

//     toggleMenu()
// })

// function toggleMenu(){
//     if (open){
//         document.querySelector('#menu_lateral').style.marginLeft = 0
//         return
//     }
//     document.querySelector('#menu_lateral').style.marginLeft = 100
// }






const options = {
	method: 'GET',
	headers: {
		'X-RapidAPI-Host': 'free-to-play-games-database.p.rapidapi.com',
		'X-RapidAPI-Key': 'SIGN-UP-FOR-KEY'
	}
};

fetch('https://free-to-play-games-database.p.rapidapi.com/api/game?id=452', options)
	.then(response => response.json())
	.then(response => console.log(response))
	.catch(err => console.error(err));