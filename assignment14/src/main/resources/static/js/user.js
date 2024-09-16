const username = sessionStorage.getItem('username');
const userId = sessionStorage.getItem('userId');

if(!username || !userId){
	window.location.href = '/welcome';
} else {  // bypasses user page and only allows welcome or channels page. User page not needed for this assignment
	window.location.href = '/channels';
}



function displayUsername(){
	const username = sessionStorage.getItem('username');
	if(username) {
		document.getElementById('usernameDisplay').textContent = `Username: ${username}`;
	} else {
		document.getElementById('usernameDisplay').textContent = 'No user found.';
	}
}

function deleteUser(){
	sessionStorage.removeItem('username');
	sessionStorage.removeItem('userId');
	document.getElementById('usernameDisplay').textContent = 'User deleted.';
}

function goTOChannels(){
	window.location.href = '/channels';
}

document.getElementById('deleteUserButton').addEventListener('click', deleteUser);

window.onload = displayUsername;