<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<center style="margin-top:50px">
<img src="/resources/image/FleaLogo1.png"	style="margin-bottom:50px"></center>
<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<h3>마이 페이지</h3>
	<br>
	<div class="row">
		<div class="col-sm-4">
			<form name="form1" method="get">
				<input type="hidden" name="userkey" value="${userinfo.userkey}" />
				<table class="table">
					<thead>
						<tr>
							<th>내 정보</th>
							<th style="color: red;">${msg}</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>아이디</td>
							<td>${userinfo.id}</td>
						</tr>
						<tr>
							<td>이름</td>
							<td>${userinfo.name}</td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td>${userinfo.nickname}</td>
						</tr>
						<tr>
							<td>포인트</td>
							<td>${userinfo.point}</td>
						</tr>
						<tr>
							<td colspan="2"><input type="button" id="modify"
								class="w3-button w3-yellow" value="정보수정" /></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div class="col-sm-6">
			<p>
			<h4>활동 내역</h4>
			</p>
			<br>
			<p>
				총 게시글 :<span style="color: red;"> ${b_mycount}</span> 개
			</p>
			<p>
				총 댓글 : <span style="color: red;">${c_mycount}</span> 개
			</p>
			<p>
				거래 횟수 :<span style="color: red;">${deal_list.size()}</span> 회
			</p>
			<p>
				거래 완료 :<span style="color: red;"> ${salestatecnt}</span> 회
			</p>
			<p>
				거래 중 :<span style="color: red;"> ${saleing}</span> 회
			</p>			
		</div>
	</div>
</div>
<br>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<div class="col-sm-6">
			<p>
			<h4>내가 쓴 글</h4>
			</p>
			<table class="table table-hover" >
				<thead >
					<tr>
						<th>글 번호</th>
						<th style="text-align:center" width="50%">글 제목</th>
						<th>조회수</th>
						<th style="text-align:center">날짜</th>
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
				<p><h4>내 댓글</h4></p>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>글 번호</th>
							<th style="text-align:center" width="50%">댓글 내용</th>
							<th style="text-align:center">날짜</th>
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
					</tbody>
				</table>
			
		</div>
	</div>
</div>
<br>
<br>
<script>
	$(document).ready(function() {
		$("#modify").click(function() {
			// 확인 대화상자    
			if (confirm("수정하시겠습니까?")) {
				document.form1.action = "/mypage/modify";
				document.form1.submit();
			}
		});
	});
</script>
<%@include file="../include/footer.jsp"%>