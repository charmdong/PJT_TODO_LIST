/**
 * 특정 button 이벤트리스너 추가
 */
document.addEventListener('DOMContentLoaded', function() {
	let buttons = document.querySelectorAll(".change_type");
	for (var index = 0; index < buttons.length; index++) {
		buttons[index].addEventListener("click", updateType);
	}
})

/**
 * @param event
 * @return
 * @exception
 */
function updateType(event) {
	let buttonNode = event.target;
	let id = event.target.dataset.id;
	let type = event.target.dataset.type;
	let sendData = "id=" + id + "&type=" + type;
	let openRequest = new XMLHttpRequest();

	openRequest.open("POST", "./TodoUpdate", true);
	openRequest.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	openRequest.onreadystatechange = function() {
		if(openRequest.readyState !== XMLHttpRequest.DONE){
			return;
		}
		
		if(openRequest.status === 200 && openRequest.response === "success"){
			changeList(buttonNode, type);
		} else {
			alert("+ 업데이트에 실패했습니다. +");
		}
	};
	openRequest.send(sendData);	
};

/**
 * @param req, id, type
 * @return
 * @exception
 */
function changeList(buttonNode, type) {
	let move = buttonNode.parentNode;

	if (type === "TODO") {
		let todoList = document.querySelector("#todo");

		buttonNode.setAttribute("data-type", "DOING");
		document.querySelector("#doing").appendChild(move);
	} else {
		let doingList = document.querySelector("#doing");
		
		move.removeChild(buttonNode);
		document.querySelector("#done").appendChild(move);
	}
}