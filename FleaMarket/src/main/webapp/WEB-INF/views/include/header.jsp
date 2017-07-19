<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>

<title>Flea Market</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

.Mymodal-content {
	margin: auto;
	background-color: #fff;
	position: relative;
	padding: 10;
	outline: 0;
	width: 600px
}
/* Add a gray background color and some padding to the footer */
footer {
	background-color: #f2f2f2;
	padding: 25px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse w3-border-white">
		<div class="container-fluid w3-light-blue ">
			<div class="navbar-header ">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand  w3-text-white " href="#">Flea Market</a>
			</div>
			<div class="collapse navbar-collapse " id="myNavbar">
				<ul class="nav navbar-nav ">
					<li><a class="w3-text-white" href="#">About</a></li>
					<li><a class="w3-text-white" href="#">About</a></li>
					<li><a class="w3-text-white" href="#">Gallery</a></li>
					<li><a class="w3-text-white" href="#">Contact</a></li>
				</ul>


			
					<ul class=" nav navbar-nav navbar-right">
					<li class="w3-text-white"
							style="font-size: 15px; margin-top: 13px;">${user.nickname}님 환영합니다.</li>
					</ul>
			
			</div>
		</div>
		
	</nav>

	<div class="jumbotron">
		<div class="container text-center">
			<h1>My Portfolio</h1>
			<p>Some text that represents "Me"...</p>
		</div>
	</div>