<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/header.jsp"%>
<script>
	function myFunction() {
		document.getElementById("cmodify");
	}
</script>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<h2 class="w3-text-grey w3-padding-16">
			<i class="material-icons w3-margin-right w3-margin-left"></i>${boardinfo.title}
		</h2>

		<!--  포스팅 폼 시작  -->
		<div style="padding: 30px">
			<table class="w3-table w3-bordered w3-large w3-centered">
				<tr>
					<td><span class="w3-text-grey">카테고리 </span></td>
					<td>${boardinfo.group1}</td>
					<td>${boardinfo.group2}</td>
				</tr>
				<tr>
					<td><span class="w3-text-grey">제목 </span></td>
					<td colspan="2">${boardinfo.title}</td>
				<tr>
					<td style="width: 100px;"><span class="w3-text-grey">작성자
					</span></td>
					<td colspan="2">${boarduser.nickname}</td>
				</tr>
				<tr>
					<td><span class="w3-text-grey">작성날짜</span></td>
					<td colspan="2"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
							value="${boardinfo.regdate}" /></td>
				</tr>
				<tr>
					<td><span class="w3-text-grey">판매상태</span></td>
					<td colspan="2"><span class="w3-text-grey">${boardinfo.salestate}
					</span></td>
				</tr>
			</table>
			<br>
			<div class="w3-input w3-border w3-round"
				style="margin-top: 5px; width: 100%; min-height: 230px; text-align: left !important">${boardinfo.text}
				<img src="${pageContext.request.contextPath}/images/${fileVO.fileData}">
			</div>
			<!--  게시글 끝 -->
		</div>

		<hr>
		<!--  댓글부분 -->
		<div style="text-align: left !important; margin-left: 50px">

			<div id="listReply"></div>


			<!--  댓글쓰기영역 -->
			<div>
				<c:choose>
					<c:when test="${not empty sessionScope.userinfo}">
						<div class="w3-row w3-section">
							<label class="w3-text-blue"><br>댓글쓰기</label> <br>
							<table>
								<tr>
									<td><textarea name="context" id="context"
											class=" w3-border w3-light-grey" cols="100%"></textarea></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp; <input class="w3-check"
										type="checkbox" id="secret" name="secret">비밀댓글
									</td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="button" id="replyAdd" class="w3-blue w3-button">등록</button>
									</td>
								</tr>
							</table>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
</div>
<!--  게시글 끝 -->

<form action="/sboard/list" method="post">
	<div style="padding: 10px">
		<center>
			<a class="w3-button"
				href='/sboard/beforeread?boardkey=${boardinfo.boardkey}'>▼이전글</a> <input
				type="submit" value="목록으로" class="w3-button" /> <a
				class="w3-button"
				href='/sboard/afterread?boardkey=${boardinfo.boardkey}'>▲다음글</a>
		</center>
	</div>

</form>
<h4 class="modal-title"></h4>
<!--   끝 -->

<script>
	function replyDelete(commentkey) {
		$.ajax({
			type : 'POST',
			url : '/reply/delete?commentkey=' + commentkey,
			success : function() {
				console.log("삭제 성공");
				listReply();
			}
		});
	}
	$("#replyAdd").click(
			function() {
				var context = $('#context').val();
				var boardkey = "${boardinfo.boardkey}";
				var userkey = "${userinfo.userkey}";
				var secret = $('input:checkbox[id="secret"]').is(":checked");
				var vo = "boardkey=" + boardkey + "&context=" + context
						+ "&userkey=" + userkey + "&secret=" + secret;
				$.ajax({
					type : 'post',
					url : '/reply/addReply',
					data : vo,
					success : function() {
						console.log("등록 성공");
						listReply();
					}
				});
			});

	function listReply() {
		console.log("list들어옴");
		var boardkey = "${boardinfo.boardkey}";
		$.ajax({
			type : "get",
			url : "/reply/list?boardkey=" + boardkey,
			success : function() {
				console.log("성공");
				var output = "<table>";
				for ( var i in result) {
					output += "<tr>";
					output += "<td> sssss </td>";
					output += "<tr>";
				}
				output += "</table>";
				$("#listReply").html(output);
			}
		});
	}
	function replyModify(commentkey, boardkey) {
		document.replyForm.action = "/reply/modify?commentkey=" + commentkey
				+ "&boardkey=" + boardkey;
		document.replyForm.submit();
	}
</script>

<%@include file="../include/footer.jsp"%>