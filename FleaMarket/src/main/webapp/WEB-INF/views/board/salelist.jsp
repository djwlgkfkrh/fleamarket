
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<div class="col-sm-12">
			<p>삽니다</p>
			<table class="table table-hover" style="text-align: center">
				<thead>
					<tr>
						<th>글 번호</th>
						<th>글 제목</th>
						<th>조회수</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${list}" var="board">
						<tr>
							<td style="width: 100px;">${board.boardkey}</td>
							<td><a href='/board/read?boardkey=${board.boardkey}'>${board.title}</a></td>
							<td style="width: 100px">${board.viewcnt}</td>
							<td style="width: 100px">${board.regdate}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>

	</div>
	<div style="float: right">
	<form action="/board/spost" width="80%">
		<button class="w3-button w3-dark-grey">
			<i class="fa fa-pencil"></i> Post
		</button>

	</form>
</div>
</div>

<%@include file="../include/footer.jsp"%>