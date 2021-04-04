<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>할 일 등록</title>
</head>
<body class="register">
	<section class="whitebox">
		<article class="register_head">
			<span>할 일 등록</span>
		</article>

		<article class="register_todo">
			<form class="register_form" action="TodoAdd" method="post">
				<span class="input_items">어떤 일인가요?</span><br/>
				<input class="input_text" type="text" maxlength="24" name="title" placeholder="swift 공부하기(24자까지)" required/><br/> 
				
				<span class="input_items">누가 할 일인가요?</span><br/>
				<input id="input_name" class="input_text" type="text" name="name" placeholder="홍길동" required/><br/> 
				
				<span class="input_items">우선순위를 선택하세요.</span><br/>
				<nav class="prioprity">
					<input type="radio" name="sequence" value="1" required/>
					<span>1순위</span>
					<input type="radio" name="sequence" value="2"/>
					<span>2순위</span>
					<input type="radio" name="sequence" value="3"/>
					<span>3순위</span>
				</nav>

				<a id="main_page" href="displayTable">&lt;이전</a>

				<nav class="submit_init">
					<input type="submit" name="submit" value="제출"/>
					<input type="reset" value="내용지우기"/>
				</nav>
			</form>
		</article>
	</section>
</body>
</html>