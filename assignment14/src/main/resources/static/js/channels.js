const username = sessionStorage.getItem('username');
const userId = sessionStorage.getItem('userId');

if(username){
	document.getElementById('wecomeMessage').textContent = `welcome, ${username}`;
} else{
	window.location.href='/welcome';
}

//
//if(!username || !userId){
//	window.location.href = '/welcome';
//}