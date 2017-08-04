<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<center style="margin-top: 50px">
	<img src="/resources/image/Flea90.png" width="95%" height="650">
</center>
<br>
<br>


<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<h2>실시간 인기 글</h2>
		<div class="col-sm-6">

			<table class="table table-hover w3-centered"
				style="text-align: center">
				<thead>
					<tr>
						<th style="width: 100px;">글 번호</th>
						<th style="width: 100px;">판매상태</th>
						<th>글 제목</th>
						<th style="width: 100px;">조회수</th>
						<th style="width: 200px;">날짜</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${popularBoard}" var="popularBoard">
						<tr>
							<td>${popularBoard.boardkey}</td>
							<td>${popularBoard.salestate}</td>
							<td><a href='/sboard/read?boardkey=${popularBoard.boardkey}'>${popularBoard.title}</a></td>
							<td>${popularBoard.viewcnt}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${popularBoard.regdate}" /></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>

	</div>
</div>
<%@include file="include/footer.jsp"%>