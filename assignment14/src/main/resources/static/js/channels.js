document.addEventListener('DOMContentLoaded', () =>{
	const username = sessionStorage.getItem('username');
	const userId = sessionStorage.getItem('userId');

if(username){
	document.getElementById('welcomeMessage').textContent = `Welcome, ${username}`;
} else{
	window.location.href='/welcome';
}
});
