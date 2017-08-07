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

		<form name="group" action="/sboard/buypost" method="post"
			enctype="multipart/form-data">
			<input type="hidden" name="group2"> <input type="hidden"
				name="nickname" value="${userinfo.nickname}" />
			<div style="padding: 30px">
				<table class="w3-table w3-bordered w3-large">
					<tr>
						<td colspan="2"><span class="w3-text-grey">카테고리 선택</span></td>
						<td>
							<!--  Search start --> <%@include
								file="../include/selectpost.jsp"%> <!--  Search End -->
						</td>
					</tr>
					<tr>
						<td style="width: 100px;"><span class="w3-text-grey">제목
						</span></td>
						<td><input type="text" class="w3-input w3-animate-input"
							name="title" /></td>
					<tr>
						<td style="width: 100px;"><span class="w3-text-grey">작성자
						</span></td>
						<td>${userinfo.nickname}<input type="hidden"
							value="${userinfo.nickname}" name="nickname" /> <input
							type="hidden" value="${userinfo.userkey}" name="userkey" /></td>
					</tr>
				</table>
				<!--  사진 첨부 버튼 끝 -->

				<!--  게시글 시작  -->
				<br>
				<textarea name="text" class="w3-input w3-border w3-round" rows="30%"
					cols="75%" style="margin-top: 5px"></textarea>

				<!--  게시글 끝 -->

			</div>

			<div style="padding: 10px">
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
		document.location.href = '/sboard/salelist';
	});
</script>


<%@include file="../include/footer.jsp"%>