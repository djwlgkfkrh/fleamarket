<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<center style="margin-top: 50px">
	<img src="/resources/image/FleaLogo1.png" style="margin-bottom: 50px">
</center>
<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<h3>내 장바구니</h3>
	<br>
	<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
		<div class="row">
			<div class="col-sm-12">
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

						<c:forEach items="${list}" var="board">
							<tr>
								<td>${board.boardkey}</td>
								<td>${board.salestate}</td>
								<td><a href='/sboard/read?boardkey=${board.boardkey}'>${board.title}</a></td>
								<td>${board.viewcnt}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${board.regdate}" /></td>
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

<%@include file="../include/footer.jsp"%>