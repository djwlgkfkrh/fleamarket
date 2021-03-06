<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%@include file="../include/header.jsp"%>
<center style="margin-top: 50px">
	<img src="/resources/image/FleaLogo1.png" style="margin-bottom: 50px">
</center>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<h2 class="w3-text-grey w3-padding-16">
			<i class="material-icons w3-margin-right w3-margin-left"></i> 게시글 작성
		</h2>


		<!--  포스팅 폼 시작  -->
		<form name="group" action="/sboard/salepost" method="post" enctype="multipart/form-data" onsubmit="return checkValue()">
			<input type="hidden" name="group2">

			<div style="padding: 30px">
				<table class="w3-table w3-bordered w3-large">
					<tr>
						<td colspan="2"><span class="w3-text-grey">카테고리 선택</span></td>
						<td colspan="2">
							<!--  Search start --> <%@include
								file="../include/selectpost.jsp"%> <!--  Search End -->
						</td>
					</tr>
					<tr>
						<td style="width: 100px;"><span class="w3-text-grey">제목</span></td>
						<td><input type="text" class="w3-input w3-animate-input"
							name="title" /></td>
					<tr>
						<td style="width: 100px;"><span class="w3-text-grey">작성자</span></td>
						<td>${userinfo.nickname}
						<input type="hidden" value="${userinfo.nickname}" name="nickname"/>
						<input type="hidden" value="${userinfo.userkey}" name="userkey" /></td>
						<!--  사진 첨부 버튼 시작  -->
					<tr>
						<td><span class="w3-text-grey">사진첨부</span></td>
						<td><input type="file" name="file" id="file1" /></td>
						<td><input type="file" name="file" id="file2" /></td>
						<td><input type="file" name="file" id="file3" /></td>
					</tr>
					<!--  사진 첨부 버튼 끝 -->
				</table>


				<!--  게시글 시작  -->
				<br>
				<textarea class="w3-input w3-border w3-round" name="text" rows="30%"
					cols="75%" style="margin-top: 5px"></textarea>
				<!--  게시글 끝 -->

			</div>

			<div style="padding: 10px;">

				<input type="submit" value="Write" class="w3-button" /> <input
					type="reset" value="Reset" class="w3-button" />
				<button id="cancel" type="button" class="w3-button">Cancel</button>
			</div>


		</form>
		<!--  포스팅 폼 끝 -->

		<!-- End Right Column -->
	</div>

	<!-- End Grid -->
</div>

<!-- End Page Container -->

<script>
	function getSubValue(k) {

		console.log(" =========get group2  :::: " + k + "====================");
		var group2 = k;

		document.forms.group.group2.value = group2;

	}

	//상위 셀렉트로 하위 셀렉트 제어하기

		function showSub(obj) {
		

		console.log(obj);
		
		f = document.forms.group;

		if (obj == null) {

			f.SUB0.style.display = "";
			f.SUB1.style.display = "none";
			f.SUB2.style.display = "none";
			f.SUB3.style.display = "none";
			f.SUB4.style.display = "none";

		} else if (obj == "전자제품") {

			f.SUB0.style.display = "none";
			f.SUB1.style.display = "";
			f.SUB2.style.display = "none";
			f.SUB3.style.display = "none";
			f.SUB4.style.display = "none";

		} else if (obj == "사무용품") {

			f.SUB0.style.display = "none";
			f.SUB1.style.display = "none";
			f.SUB2.style.display = "";
			f.SUB3.style.display = "none";
			f.SUB4.style.display = "none";

		} else if (obj == "취미용품") {

			f.SUB0.style.display = "none";
			f.SUB1.style.display = "none";
			f.SUB2.style.display = "none";
			f.SUB3.style.display = "";
			f.SUB4.style.display = "none";

		} else if (obj == "생활용품") {

			f.SUB0.style.display = "none";
			f.SUB1.style.display = "none";
			f.SUB2.style.display = "none";
			f.SUB3.style.display = "none";
			f.SUB4.style.display = "";

		}
	}
	$("#cancel").click(function() {
		document.location.href = '/sboard/buylist';
	});

	
	
		function checkValue() {
					
		   if (!$('#file1').val()) {
			         alert("파일1을 첨부하세요.");
			         return false;
			         }
		   if (!$('#file2').val()) {
		         alert("파일2을 첨부하세요.");
		         return false;
		         }
		   if (!$('#file3').val()) {
		         alert("파일3을 첨부하세요.");
		         return false;
		         }
		      if (!form.text.value) {
			         alert("글내용을 입력하세요.");
			         return false;
			
		   }
		}
	

</script>


<%@include file="../include/footer.jsp"%>

		