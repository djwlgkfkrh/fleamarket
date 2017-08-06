<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>


<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<h2 class="w3-text-grey w3-padding-16">
			<i class="material-icons w3-margin-right w3-margin-left"></i> 게시글 작성
		</h2>

		<!--  포스팅 폼 시작  -->
		<form id="post" action="/sboard/post" method="post" enctype="multipart/form-data" value="checkValue()">
			<div style="padding: 30px">
				<table class="w3-table w3-bordered w3-large">
					<tr>
						<td><input type="text" name="group1" /></td>
						<td><input type="text" name="group2" /></td>
					</tr>
					<tr>
						<td style="width: 100px;"><span class="w3-text-grey">제목
						</span></td>
						<td><input type="text" class="w3-input w3-animate-input" name="title" /></td>
					<tr>
						<td style="width: 100px;"><span class="w3-text-grey">작성자
						</span></td>
						<td>${userinfo.nickname}<input type="hidden" value="${userinfo.userkey}" name="userkey" />
						<input type="hidden" value="${userinfo.nickname}" name="nickname" /></td>

						<!--  사진 첨부 버튼 시작  -->
					<tr>
						<td><span class="w3-text-grey">사진첨부</td>
						<td><input type="file" name="file" /></td>
						<td><input type="file" name="file" /></td>
						<td><input type="file" name="file" /></td>

					</tr>
				</table>
				<!--  사진 첨부 버튼 끝 -->

				<!--  게시글 시작  -->
				<br>
				<textarea class="w3-input w3-border w3-round" name="text" rows="30%"
					cols="75%" style="margin-top: 5px"></textarea>
				<!--  게시글 끝 -->

			</div>

			<div style="padding: 10px">
				<center>
					<input type="reset" value="Reset" class="w3-button" /> 
					<input type="submit" value="Write" class="w3-button" />
				</center>
			</div>

		</form>

		<!--  포스팅 폼 끝 -->

		<!-- End Right Column -->
	</div>

	<!-- End Grid -->
</div>

<!-- End Page Container -->
<script>
function checkValue() {
	
    var form = document.post;
    
    if (!form.group1.value) {
       alert("대분류를 입력하세요.");
       return false;
       }
    if (!form.group2.value) {
       alert("소분류를 입력하세요.");
       return false;
    }
    if (!form.title.value) {
       alert("글제목을 입력하세요.");
       return false;
       }
    if (!form.text.value) {
        alert("글내용을 입력하세요.");
        return false;
        }
    if (!form.file.value) {
        alert("첨부파일을 모두 입력하세요.");
        return false;
        }
 
 }


</script>


<%@include file="../include/footer.jsp"%>