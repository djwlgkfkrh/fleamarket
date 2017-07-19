<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<h3>마이 페이지 </h3>
	<br>
	<div class="row">
		<div class="col-sm-4">
		<form action="/mypage/modify">
			<table class="table">
				<thead>
				<tr>
					<th colspan="2">내 정보</th>
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
					<td colspan="2"><button id="modify">정보수정</button></td>
				</tr>
				</tbody>
			</table>
			</form>
		</div>
		<div class="col-sm-6">
			<p>활동 내역</p>
			<p>총 게시글 : 개</p>
			<p>총 댓글 : 개</p>
		</div>
	</div>
</div>
<br>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<div class="col-sm-6">
			<p>내가 쓴 글</p>
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
				<%-- 	
				<c:forEach items="${board }" var="board">
					<tr>
					<td>${board.boardkey}</td>
					<td><a href='/board/read?bno=${board.bno}'>${board.title}</a></td>
					<td>${board.viewcnt}</td>
					<td>${board.regdate}</td>
					</tr>
					</c:forEach>
					 --%>
				</tbody>
			</table>
		</div>
		<div class="col-sm-6">
			<div class="row">
				<p>댓글 단 게시글</p>
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
				<p>내 댓글</p>
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
		</div>
	</div>
</div>
<br>
<br>

<%@include file="../include/footer.jsp"%>