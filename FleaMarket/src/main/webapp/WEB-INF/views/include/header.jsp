<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<li><a class="w3-text-white" href="/salelist">삽니다</a></li>
					<li><a class="w3-text-white" href="#">팝니다</a></li>
					<li><a class="w3-text-white" href="#">사기꾼list</a></li>
				</ul>


				<c:choose>
					<c:when test="${not empty sessionScope.userinfo}">
						<form action="/logout" method="post">
							<ul class=" nav navbar-nav navbar-right">
								<li class="w3-text-white"
									style="font-size: 15px; margin-top: 13px;"> ${sessionScope.userinfo.nickname}님
									환영합니다.</li>
								<li>
									<button type="submit" class="btn w3-light-blue w3-text-white">
										<span style="font-size: 20px; margin-top: 5px;"
											class="glyphicon glyphicon-log-out"></span> Logout</button>
								</li>
							</ul>
						</form>
					</c:when>
					
					<c:otherwise>
						<form action="/login" method="post">
							<ul class=" nav navbar-nav navbar-right">
								<li class="w3-text-white"
									style="font-size: 15px; margin-top: 13px;">ID</li>
								<li><input type="text" class="w3-input w3-light-blue"
									name="id" style="border-bottom: 1px solid #ffffff !important"
									size="5" class="w3-light-blue" /></li>

								<li class="w3-text-white"
									style="font-size: 15px; margin-top: 13px;">PW</li>
								<li><input type="password" class="w3-input w3-light-blue"
									name="pw" style="border-bottom: 1px solid #ffffff !important"
									size="5" class="w3-light-blue" /></li>
								<li>
									<button type="submit" class="btn w3-light-blue w3-text-white">
										<span style="font-size: 20px; margin-top: 5px;"
											class="glyphicon glyphicon-log-in"></span> Login</button>
								</li>

								<li>
									<button type="button" class="btn w3-light-blue w3-text-white"
										data-toggle="modal" data-target="#myModal">

										<span style="font-size: 20px; margin-top: 5px;"
											class="glyphicon glyphicon-user"></span> Join Us
									</button> <!-- Modal -->
								</li>
							</ul>
						</form>

						<div class="modal fade" id="myModal" role="dialog">
							<div class="modal-dialog modal-lg">
								<div class="w3-modal-content" style="width: 400px !important">
									<div class="modal-header ">
										<button type="button" class="close w3-text-white"
											data-dismiss="modal">&times;</button>
										<h4 class="modal-title w3-text-blue">Join Us</h4>
									</div>
									<form action="/join" method="post">
										<div class="modal-body " style="float: center !important">

											<table class="w3-text-blue" style="padding: 15px;">
												<tr>
													<td>이름</td>
													<td><input type="text" size="20" name="name" />
												</tr>
												<tr>
													<td>아이디</td>
													<td><input type="text" size="20" name="id" />
												</tr>
												<tr>
													<td>닉네임</td>
													<td><input type="text" size="20" name="nickname" />
												</tr>
												<tr>
													<td>비밀번호</td>
													<td><input type="password" size="20" name="pw" />
												</tr>

											</table>

										</div>
										<div class="modal-footer ">
											<input type="submit" value="Join"
												class="btn btn-default w3-text-blue" />
											<button type="button" class="btn btn-default w3-text-blue"
												data-dismiss="modal">Close</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</c:otherwise>
				</c:choose>

			</div>
		</div>

	</nav>

	<div class="jumbotron">
		<div class="container text-center">
			<h1>My Portfolio</h1>
			<p>Some text that represents "Me"...</p>
		</div>
	</div>