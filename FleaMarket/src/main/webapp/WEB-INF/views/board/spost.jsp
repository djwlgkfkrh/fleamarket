<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>


<!-- Page Container -->
<div class="w3-content top" style="max-width: 800px;">

	<!-- The Grid -->
	<div class="w3-row-padding">

		<!-- Left Column -->

		<!-- End Left Column -->

		<!-- Right Column -->
		<div class="W3-threequarter">
			<h2 class="w3-text-grey w3-padding-16">
				<i class="material-icons w3-margin-right w3-margin-left"></i> 게시글 작성
			</h2>
			<div class="w3-container w3-card-2 w3-white w3-margin-bottom">

				<!--  포스팅 폼 시작  -->
				<form action="/main/post" method="post"
					enctype="multipart/form-data">
					<div style="padding: 30px">
						<span class="w3-text-grey">제목 &nbsp; &nbsp;</span> <input
							type="text" name="title" size="65%" /><br> <br> <span
							class="w3-text-grey">작성자 &nbsp; &nbsp;</span> .........이름추가
						<!--  사진 첨부 버튼 시작  -->
						<br> <br>
						<div class="w3-container" style="border: solid #bbb 1px;">
							<input type="file" name="file" /> <input type="file" name="file" />
							<input type="file" name="file" />
						</div>
						<!--  사진 첨부 버튼 끝 -->

						<!--  게시글 시작  -->
						<br>
						<textarea name="text" rows="30%" cols="75%"
							style="margin-top: 5px"></textarea>
						<!--  게시글 끝 -->

					</div>
					<div style="padding: 10px">
						<center>
							<input type="reset" value="Reset" class="w3-button"> <input
								type="submit" value="Write" class="w3-button">
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

<%@include file="../include/footer.jsp"%>