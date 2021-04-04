<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>나의 해야할 일들</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<section class="whitebox">
		<article class="main_header">
			<span id="rotated_text">나의 해야할 일들</span>
		</article>

		<article class="new_register">
			<nav><a href="TodoForm">새로운 TODO 등록</a></nav>
		</article>

		<article class="table">
			<nav class="all_list">
				<ul id="todo" class="list">
					<li class="list_header">TODO</li>
					<c:forEach var="task" items="${todoList }">
						<li class="task_box">
							<span class="task_title">${task.getTitle() }<br/></span>
							<span class="task_info">등록날짜: ${task.getRegdate() }, ${task.getName() }, 우선순위 ${task.getSequence() }</span>
							<button class="change_type" data-id="${task.getId()}" data-type="${task.getType() }">-&gt;</button>
						</li>
					</c:forEach>
				</ul>

				<ul id="doing" class="list">
					<li class="list_header">DOING</li>
					<c:forEach var="task" items="${doingList }">
						<li class="task_box">
							<span class="task_title">${task.getTitle() }</span><br/>
							<span class="task_info">등록날짜: ${task.getRegdate() }, ${task.getName() }, 우선순위 ${task.getSequence() }</span>
							<button class="change_type" data-id="${task.getId()}" data-type="${task.getType() }">-&gt;</button>
						</li>
					</c:forEach>
				</ul>

				<ul id="done" class="list">
					<li class="list_header">DONE</li>
					<c:forEach var="task" items="${doneList }">
						<li class="task_box">
							<span class="task_title">${task.getTitle() }</span><br/>
							<span class="task_info">등록날짜: ${task.getRegdate() }, ${task.getName() }, 우선순위 ${task.getSequence() }</span>	
						</li>
					</c:forEach>
				</ul>
			</nav>
		</article>
	</section>
	<script type="text/javascript" src="js/script.js"></script>
</body>
</html>