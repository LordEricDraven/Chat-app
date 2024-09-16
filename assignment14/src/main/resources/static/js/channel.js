const channelId = window.location.pathname.split('/').pop();
const username = sessionStorage.getItem('username');
const userId = sessionStorage.getItem('userId');

function sendMessage(){
	const message = document.getElementById('messageInput').value;
	
	if(!message.trim() || !userId){
		console.error('Messageor userId missing.')
		return;
	}
	
	fetch(`/channels/${channelId}/messages/send`, {
		method: 'POST',
		headers: {'Content-Type': 'application/x-www-form-urlencoded'},
		body: new URLSearchParams({ userId: userId, messageContent: message})
	})
	.then(response => {
		if(!response.ok){
			throw new Error('Error sending message: ' + response.statusText);
		}
		return response.json();
	})
	.then(data => {
		console.log('Message sent successfully:', data);
		document.getElementById('messageInput').value = '';
		pollMessages();
	})
	.catch(error => console.error('Error sending message:', error));
}

function pollMessages(){
	fetch(`/channels/${channelId}/messages`)
	.then(response => response.json())
	.then(messages => {
		const chatWindow = document.getElementById('chatWindow');
		chatWindow.innerHTML = '';
		
		messages.forEach(message => {
			const messageElement = document.createElement('div');
			messageElement.classList.add('message-item');
			
			const timestamp = new Date(message.timestamp).toLocaleTimeString([],{hour: '2-digit', minute:'2-digit'});
//			messageElement.textContent = `${message.username}: ${message.messageContent} ${timestamp}`;
			messageElement.innerHTML = `
				<span class="username">${message.username}:</span>
				<span class="message-content">${message.messageContent}</span>
				<span class="timestamp">${timestamp}</span>
			`;
			chatWindow.appendChild(messageElement);
		});
		chatWindow.scrollTop = chatWindow.scrollHeight;
	})
	.catch(error => console.error('Error fetching messages:', error));
}

document.getElementById('sendButton').addEventListener('click', sendMessage);

document.getElementById('messageInput').addEventListener('keydown', (event) => {
	if (event.key === 'Enter'){
		event.preventDefault();
		sendMessage();
	}
})

setInterval(pollMessages, 500);

document.addEventListener('DOMContentLoaded', () =>{
	fetch(`/channels/${channelId}/details`)
	.then(response => response.json())
	.then(channel => {
		document.getElementById('channelName').textContent = `Channel: ${channel.name}`;
	});
});