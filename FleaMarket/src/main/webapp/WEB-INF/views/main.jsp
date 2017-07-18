<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link href="https://fonts.googleapis.com/css?family=Athiti|Oswald|Roboto+Condensed" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Open Sans", sans-serif
}

input[type=text] {
	width: 100%;
	box-sizing: border-box;
	border: 2px solid #f5ab2d;
	border-radius: 4px;
	font-size: 14px;
	background-color: white;
	background-position: 10px 10px;
	background-repeat: no-repeat;
	padding: 10px 15px 10px 40px;
	margin: 0px 0px 8px 0px;
}

input[type=submit] {
	width: 15%;
	background-color: #f5ab2d;
	color: white;
	padding: 10px 10px;
	position: inherit;
	margin: 2px 0px 5px 0px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

@font-face {
	font-family: 'icomoon';
	src: url('../fonts/icomoon/icomoon.eot');
	src: url('../fonts/icomoon/icomoon.eot?#iefix')
		format('embedded-opentype'), url('../fonts/icomoon/icomoon.woff')
		format('woff'), url('../fonts/icomoon/icomoon.ttf') format('truetype'),
		url('../fonts/icomoon/icomoon.svg#icomoon') format('svg');
	font-weight: normal;
	font-style: normal;
}
/* General button style (reset) */
.btn {
	border: none;
	font-family: inherit;
	font-size: inherit;
	color: inherit;
	background: none;
	cursor: pointer;
	padding: 15px 19px;
	display: inline-block;
	margin: 0px 0px;
	text-transform: uppercase;
	letter-spacing: 1px;
	font-weight: 700;
	outline: none;
	position: relative;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

.btn:after {
	content: '';
	position: absolute;
	z-index: -1;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

/* Button 5 */
.btn-5 {
	background: #f5ab2d;
	color: #fff;
	height: 70px;
	min-width: 90px;
	line-height: 24px;
	font-size: 16px;
	overflow: hidden;
	-webkit-backface-visibility: hidden;
	-moz-backface-visibility: hidden;
	backface-visibility: hidden;
}

.btn-5:active {
	background: #f5ab2d;
	top: 0px;
}

.btn-5 span {
	display: inline-block;
	width: 100%;
	height: 100%;
	-webkit-transition: all 0.3s;
	-webkit-backface-visibility: hidden;
	-moz-transition: all 0.3s;
	-moz-backface-visibility: hidden;
	transition: all 0.3s;
	backface-visibility: hidden;
}

.btn-5:before {
	position: absolute;
	height: 100%;
	width: 100%;
	line-height: 2.5;
	font-size: 180%;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
}

.btn-5:active:before {
	color: #703b87;
}

/* Button 5a */
.btn-5a:hover span {
	-webkit-transform: translateY(300%);
	-moz-transform: translateY(300%);
	-ms-transform: translateY(300%);
	transform: translateY(300%);
}

.btn-5a:before {
	left: 0;
	top: -100%;
}

.btn-5a:hover:before {
	top: 0;
}

footer {
	color: #ffffff
}
</style>
<body class="w3-theme-l5">

	<!-- Navbar -->
	<div class="w3-top" style="background-color: #ffffff">
		<div class="w3-bar w3-left-align w3-large">

			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-grey w3-large"
				href="javascript:void(0);" onclick="openNav()">	
				<i class="fa fa-bars"></i></a> 
				
				<a href="#" class="w3-bar-item w3-padding-large">
				<img src="resources/img/logo.png"></a>


			<form action="main/setting" width="80%">
			<button class="btn btn-5 btn-5a w3-right">
				<i class="fa fa-cog fa-spin" style="font-size: 20px"></i>
				<span>Settings</span>
			</button>
			</form>

		</div>

	</div>


	<!-- Page Container -->
	<div class="w3-container w3-content"
		style="max-width: 1400px; margin-top: 80px">
		<!-- The Grid -->
		<div class="w3-row">
			<!-- Left Column -->
			<div class="w3-col m4">
				<!-- Profile -->
				<div class="w3-card-2 w3-round w3-white">
					<div class="w3-container" style="color: #382100">
						<h4 class="w3-center">${userinfo.userid}</h4>
						<p class="w3-center">
							<img src="resources/img/my1.jpg" class="w3-circle"
								style="height: 106px; width: 106px" alt="Avatar">
						</p>
						<hr>
		
						<p>
							<i class="fa fa-home fa-fw w3-margin-right "></i> ${userinfo.username}
						</p>
						<p>
							<i class="fa fa-envelope fa-fw w3-margin-right"></i> ${userinfo.useremail}
						</p>
					</div>
				</div>
				<br>

				<!-- Accordion -->
				<div class="w3-card-2 w3-round">
					<div class="w3-white">
						<button onclick="myFunction('Demo1')"
							class="w3-button w3-block w3-left-align "
							style="background-color: #f5ab2d; color: #ffffff">
							<i class="fa fa-circle-o-notch fa-fw w3-margin-right"></i> 
							My Groups
						</button>
						<div id="Demo1" class="w3-hide w3-container">
							<p>Some text..</p>
						</div>
						<button onclick="myFunction('Demo2')"
							class="w3-button w3-block w3-left-align"
							style="background-color: #f5ab2d; color: #ffffff">
							<i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i> 
							My Events
						</button>
						<div id="Demo2" class="w3-hide w3-container">
							<p>Some other text..</p>
						</div>
						<button onclick="myFunction('Demo3')"
							class="w3-button w3-block w3-left-align"
							style="background-color: #f5ab2d; color: #ffffff">
							<i class="fa fa-users fa-fw w3-margin-right"></i> My Photos
						</button>
						<div id="Demo3" class="w3-hide w3-container">
							<div class="w3-row-padding">
								<br>
								<div class="w3-half">
									<img src="resources/img/my1.jpg" style="width: 100%"
										class="w3-margin-bottom">
								</div>
								<div class="w3-half">
									<img src="resources/img/my2.jpg" style="width: 100%"
										class="w3-margin-bottom">
								</div>

							</div>
						</div>
					</div>
				</div>
				<br>

				<!-- Interests -->
				<div class="w3-card-2 w3-round w3-white w3-hide-small">
					<div class="w3-container">
						<p>Interests</p>
						<p>
							<span class="w3-tag w3-small " style="background-color: #f5ab2d">News</span>
							<span class="w3-tag w3-small " style="background-color: #ffe366">Labels</span>
							<span class="w3-tag w3-small " style="background-color: #f7ca00">Games</span>
							<span class="w3-tag w3-small " style="background-color: #f5ab2d">Friends</span>
							<span class="w3-tag w3-small " style="background-color: #ffe366">Games</span>
							<span class="w3-tag w3-small " style="background-color: #f4d442">Friends</span>
							<span class="w3-tag w3-small " style="background-color: #ffe366">Food</span>
							<span class="w3-tag w3-small " style="background-color: #f7ca00">Design</span>
							<span class="w3-tag w3-small " style="background-color: #ffe366">Art</span>
							<span class="w3-tag w3-small " style="background-color: #f5ab2d">Photos</span>
						</p>
					</div>
				</div>
				<br>

				<!-- Alert Box -->
				<div
					class="w3-container w3-display-container w3-round w3-border w3-theme-border w3-margin-bottom w3-hide-small"
					style="background-color: #ffffff">
					<span onclick="this.parentElement.style.display='none'"
						class="w3-button w3-display-topright"> <i
						class="fa fa-remove"></i>
					</span>
					<p>
						<strong>Hey!</strong>
					</p>
					<p>People are looking at your profile. Find out who.</p>
				</div>

				<!-- End Left Column -->
			</div>
			
			

			<!-- Middle Column -->
			<div class="w3-col m8">


				<div class="w3-row-padding">
					<div class="w3-col m12">
						<div class="w3-card-2 w3-round w3-white">
							<div class="w3-container w3-padding">
								<h6 class="w3-opacity">Find friends by 2GETHER</h6>
								
								<!--  친구 찾는 검색 창 시작 -->
								<!--<form>
									<input
										style="background-image: url('resources/img/searchicon.png'); background-size: 27px;"
										type="text" name="search" placeholder="Search..">
								</form>
								  -->
								<!--  친구 찾는 검색 창  끝 -->
								
								
								<!--  포스팅 페이지로 넘어가는 버튼 시작 -->
							<form action="main/post" width="80%">
							
								<button class="w3-button"
									style="background-color: #f5ab2d; color: #ffffff">
									
									<i class="fa fa-pencil"></i> Post
								</button>	
								
							</form>
							
							<!--  포스팅 페이지로 넘어가는 버튼 끝 -->
							
							</div>
						</div>
					</div>
				</div>


	 		<c:forEach items="${list}" var="BoardVO"> 
					<div class="w3-container w3-card-2 w3-white w3-round w3-margin">
						<br> <img src="resources/img/1.jpg" alt="Avatar"
							class="w3-left w3-circle w3-margin-right" style="width: 60px">
						<span class="w3-right w3-opacity">1 min</span>
						
						${userinfo.userid}
						<h4></h4>
						<br>
						<hr class="w3-clear">
						
						<p>
						 ${BoardVO.boardpic},
						 ${BoardVO.boardtxt}
						</p>
						
						<div class="w3-row-padding" style="margin: 0 -16px">
							<div class="w3-half">
								<img src="resources/img/1.jpg" onclick="onClick(this)"
									style="width: 100%" class="w3-margin-bottom w3-hover-opacity"
									alt="비가 내리고 음악이 흐르면,,">
							</div>
							<div class="w3-half ">
								<img src="resources/img/2.jpg" onclick="onClick(this)"
									style="width: 100%" class="w3-margin-bottom w3-hover-opacity"
									alt="rain..rain..">
							</div>
						</div>

						<!-- Modal for full size images on click-->
						<div id="modal01" class="w3-modal w3-black" onclick="this.style.display='none'">
							<span class="w3-button w3-large w3-black w3-display-topright"
								title="Close Modal Image"><i class="fa fa-remove"></i></span>
							<div
								class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
								<img id="img01" class="w3-image">
								<p id="caption" class="w3-opacity w3-large"></p>
							</div>
						</div>

						<button type="button" class="w3-button w3-margin-bottom "
							style="background-color: #f5ab2d; color: #ffffff"
							onclick="likeFunction(this)">
							<i class="fa fa-thumbs-up"></i> Like
						</button>

						<button type="button" class="w3-button w3-margin-bottom"
							style="background-color: #f5ab2d; color: #ffffff"
							onclick="myFunction('demo1')" id="myBtn">
							<i class="fa fa-comment"></i> Comment
						</button>




						<!-- 리플달기-->
					<div class="w3-margin-bottom" id="demo1" style="display: none">
						<div class="w3-row">

							<form action="" width="80%">
								<input type="text" id="fname" name="firstname"
									style="background-image: url('resources/img/edit.png'); background-size: 27px;">
								<input type="submit" value="Ripple" class="w3-button">
							</form>
							<hr>
							<div class="w3-col l2 m3">
								<img src="resources/img/my1.jpg" style="width: 90px;">
							</div>
							<div class="w3-col l10 m9">
								<h4>
									Mustafa Seven <span class="w3-opacity w3-medium">May 3,
										2015, 6:32 PM</span>
								</h4>
								<p>Great blog post! Following</p>
							</div>
						</div>
					</div>
				<!--  리플달기 끝! -->

					</div>
				</c:forEach> 


				<!-- End Middle Column -->
			</div>



		</div>

		<!-- End Grid -->
	</div>

	<!-- End Page Container -->
	</div>
	<br>

	<!-- Footer -->
	<footer class="w3-container w3-padding-10"
		style="background-color: #f5ab2d" align="center" color="#d3d3d3">
	<!-- <h5>2GETHER</h5> -->
	<p>
		Copyrightⓒ2017 By 2GETHER. All right reserved.<br> ⓒ2017 06.22
		LTD. All rights reserved.
	</p>
	</footer>

	<script>
		
		// Accordion
		function myFunction(id) {
			var x = document.getElementById(id);
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
				x.previousElementSibling.className += " w3-theme-d1";
			} else {
				x.className = x.className.replace("w3-show", "");
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace(" w3-theme-d1", "");
			}
		}

		// Used to toggle the menu on smaller screens when clicking on the menu button
		function openNav() {
			var x = document.getElementById("navDemo");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}

		//Modal Image Gallery
		function onClick(element) {
			document.getElementById("img01").src = element.src;
			document.getElementById("modal01").style.display = "block";
			var captionText = document.getElementById("caption");
			captionText.innerHTML = element.alt;
		}

		// Toggle between hiding and showing blog replies/comments
		document.getElementById("myBtn").click();
		function myFunction(id) {
			var x = document.getElementById(id);
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}

		function likeFunction(x) {
			x.style.fontWeight = "bold";
			x.innerHTML = "? Liked";
		}
	</script>

</body>
</html>