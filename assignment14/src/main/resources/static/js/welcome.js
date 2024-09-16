const storedUsername = sessionStorage.getItem('username');
const storedUserId = sessionStorage.getItem('userId');

if (storedUsername && storedUserId) {
	window.location.href = '/channels';
}

function createUser(event){
	event.preventDefault();
	
	const username = document.getElementById('username').value;
	
	fetch('/users/create', {
		method: 'POST',
		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		body: new URLSearchParams({ username: username})
	})
	.then(response => response.json())
	.then(data => {
		sessionStorage.setItem('username', data.username);
		sessionStorage.setItem('userId', data.userId);
		
		window.location.href = '/channels';
	})
	.catch(error => console.error('Error:', error));
}