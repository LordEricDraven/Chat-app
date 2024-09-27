document.addEventListener('DOMContentLoaded', () =>{
	const username = sessionStorage.getItem('username');


if(username){
	document.getElementById('welcomeMessage').textContent = `Welcome, ${username}`;
} else{
	window.location.href='/welcome';
}
});
