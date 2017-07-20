<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>post</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link
	href="https://fonts.googleapis.com/css?family=Athiti|Oswald|Roboto+Condensed"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Open Sans", sans-serif
}

footer {
	color: #ffffff
}

input[type=text] {
	display: inline-block;
	border: 2px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	color: #2d2d2d;
	font-size: 1em;
	margin: 10px 0;
	width: 100%;
}

textarea {
	width: 100%;
	padding: 2px 2px;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	background-color: #ffffff;
	font-size: 1em;
	resize: none;
	color: #2d2d2d;
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
	padding: 10px 14px;
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

.btn1 {
	border: none;
	font-family: inherit;
	font-size: inherit;
	color: inherit;
	background: none;
	cursor: pointer;
	padding: 0px 0px;
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

.top {
	margin-top: 2.5cm;
}

.hov {
	background-color: #ffffff;
	padding: 1px;
}

.hov:hover {
	background-color: #f5ab2d;
	color: #ffffff;
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

input[type=reset] {
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
</style>

</head>

<body class="w3-theme-l5">

	<!-- Navbar -->
	<div class="w3-top" style="background-color: #ffffff">
		<div class="w3-bar w3-left-align w3-large">

			<a
				class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-grey w3-large"
				href="javascript:void(0);" onclick="openNav()"> <i
				class="fa fa-bars"></i>
			</a> <a href="#" class="w3-bar-item w3-padding-large"> <img
				src="resources/img/logo.png"></a>

			<button class="btn btn-5 btn-5a w3-right">
				<i class="material-icons" style="font-size: 30px; color: #ffffff">portrait</i>
				<span>MY SNS</span>
			</button>

		</div>
	</div>

	<!-- Page Container -->
	<div class="w3-content top" style="max-width: 800px;">

		<!-- The Grid -->
		<div class="w3-row-padding">

			<!-- Left Column -->


			<!-- End Left Column -->


			<!-- Right Column -->
			<div class="W3-threequarter">

				<div class="w3-container w3-card-2 w3-white w3-margin-bottom">
					<h2 class="w3-text-grey w3-padding-16">

						<i
							class="material-icons w3-margin-right w3-xxlarge w3-margin-left">face</i>
						Post Write
					</h2>


					<!--  포스팅 폼 시작  -->
					<form action="/main/post" method="post"
						enctype="multipart/form-data">
						<div style="padding: 30px">

							<!--  사진 첨부 버튼 시작  -->


							<input type="file" name="file" />
							<!--  <button class="btn1">
								 <i class="material-icons" style="font-size: 36px; color: #f5ab2d">insert_photo</i>
								 </button>
								  -->

							<!--  사진 첨부 버튼 끝 -->

							<!--  게시글 시작  -->
							<textarea id="boardtxt" name="boardtxt" rows="25" cols="50"
								style="margin-top: 5px"></textarea>
							<!--  게시글 끝 -->

						</div>

						<div style="padding: 10px">

							<center>
								<input type="submit" value="Write" class="w3-button"> <input
									type="reset" value="Reset" class="w3-button">
							</center>

						</div>
					</form>

					<!--  포스팅 폼 끝 -->




					<!-- End Right Column -->
				</div>

				<!-- End Grid -->
			</div>

			<!-- End Page Container -->
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
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
</body>
</html>