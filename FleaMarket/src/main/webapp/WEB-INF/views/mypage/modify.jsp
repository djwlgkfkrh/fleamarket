<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<h3>마이 페이지</h3>
	<br>
	<div class="row">
		<div class="col-sm-4">
			<form role="form" action="/mypage/complete" method="post">
				<input type="hidden" name="userkey" value="${userinfo.userkey}" />
				<table class="table">
					<thead>
						<tr>
							<th colspan="2">내 정보</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>아이디</td>
							<td><input type="hidden" name="id" value="${userinfo.id}" />${userinfo.id}</td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input type="hidden" name="name"
								value="${userinfo.name}" />${userinfo.name}</td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td><input type="text" name="nickname"
								value="${userinfo.nickname}" /></td>
						</tr>
						<tr>
							<td>포인트</td>
							<td><input type="hidden" name="point"
								value="${userinfo.point}" />${userinfo.point}</td>
						</tr>
					</tbody>
				</table>
				<input type="submit" value="완료" />
				<!-- <button type="button" id="cancle">취소</button> -->
				<button type="button" id="pwmodify" data-toggle="modal"
					data-target="#pwModal">비밀번호 변경</button>
				<button type="button" id="deletebtn" data-toggle="modal"
					data-target="#delModal">회원탈퇴</button>
			</form>
		</div>
		<!--  비밀번호 변경 모달-->
		<div class="modal fade" id="pwModal" role="dialog">
			<div class="modal-dialog modal-lg">
				<div class="w3-modal-content" style="width: 400px !important">
					<div class="modal-header ">
						<button type="button" class="close w3-text-white"
							data-dismiss="modal">&times;</button>
						<h4 class="modal-title w3-text-blue">비밀번호 변경</h4>
					</div>
					<form name="changePw" action="/mypage/changePw" method="post"
						onSubmit="return checkIt()">
						<div class="modal-body " style="float: center !important">
							<input type="hidden" name="mid" value="${userinfo.id}" /> <input
								type="hidden" name="id" value="${userinfo.id}" />
							<table class="w3-text-blue" style="padding: 15px;">
								<tr>
									<td>현재 비밀번호</td>
									<td><input type="password" name="mpw"></td>
								</tr>
								<tr>
									<td>변경할 비밀번호</td>
									<td><input type="password" size="20" name="pw" />
								</tr>
								<tr>
									<td>비밀번호 확인</td>
									<td><input type="password" size="20" name="pw1" />
								</tr>
							</table>
						</div>
						<div class="modal-footer ">
							<input type="submit" value="변경"
								class="btn btn-default w3-text-blue" />
							<button type="button" class="btn btn-default w3-text-blue"
								data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 비밀번호 변경 모달 끝 -->

		<!--  회원탈퇴 모달-->
		<div class="modal fade" id="delModal" role="dialog">
			<div class="modal-dialog modal-lg">
				<div class="w3-modal-content" style="width: 400px !important">
					<div class="modal-header ">
						<button type="button" class="close w3-text-white"
							data-dismiss="modal">&times;</button>
						<h4 class="modal-title w3-text-blue">회원탈퇴</h4>
					</div>
					<form name="deleteUserForm" method="post">
						<div class="modal-body " style="float: center !important">
							<input type="hidden" name="did" value="${userinfo.id}" />
							<table class="w3-text-blue" style="padding: 15px;">
								<tr>
									<td>현재 비밀번호</td>
									<td><input type="password" name="dpw"></td>
								</tr>
							</table>
						</div>
						<div class="modal-footer ">
							<input type="button" value="탈퇴" id="deleteUser"
								class="btn btn-default w3-text-blue" />
							<button type="button" class="btn btn-default w3-text-blue"
								data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 회원탈퇴 모달 끝 -->



		<div class="col-sm-6">
			<p><h4>활동 내역</h4></p>
			<p>총 게시글 : ${mycount} 개</p>
			<p>총 댓글 : ${c_mycount} 개</p>
		</div>
	</div>
</div>
<br>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<div class="col-sm-6">
			<p><h4>내가 쓴 글</h4></p>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>글 번호</th>
						<th>글 제목</th>
						<th>조회수</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${b_list }" var="board">
						<tr>
							<td>${board.boardkey}</td>
							<td><a href='/sboard/read?boardkey=${board.boardkey}'>${board.title}</a></td>
							<td>${board.viewcnt}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${board.regdate}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-sm-6">
			<div class="row">
				<p><h4>댓글 단 게시글</h4></p>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>글 번호</th>
							<th>글 제목</th>
							<th>조회수</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
			<div class="row">
				<p><h4>내 댓글</h4></p>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>글 번호</th>
							<th>글 제목</th>
							<th>조회수</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${c_list }" var="comment">
							<tr>
								<td>${comment.boardkey}</td>
								<td><a href='/sboard/read?boardkey=${comment.boardkey}'>${comment.context}</a></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${comment.regdate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<br>
<br>
<script>
	//비밀번호 변경 시 두번입력 확인
	function checkIt() {
		/* var pw=${userinfo.pw};
	현재 비밀번호도 바로 확인하게끔?
		 if(document.changePw.mpw.value!=pw){
		     alert("joinform : 전화번호를 입력하지 않으셨습니다.");
		     return false;
		 } */
		if (document.changePw.pw.value != document.changePw.pw1.value
				|| document.changePw.pw.value == ""
				|| document.changePw.pw1.value == "") {
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}
	}
	//회원탈퇴 확인 창
	$(document).ready(function() {
		$("#deleteUser").click(function() {
			if (confirm("탈퇴하시겠습니까?")) {
				document.deleteUserForm.action = "/mypage/deleteUser";
				document.deleteUserForm.submit();
			}
		});
	});
</script>
<%@include file="../include/footer.jsp"%>