
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

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
							<td><a href='/sboard/read?boardkey=${board.boardkey}'>${board.title}
							[<span style="color:red;"> ${board.commentcnt} </span>]</a></td>
							<td>${board.viewcnt}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${board.regdate}" /></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>

	</div>
	<div class="text-center">
		<ul class="pagination">

			<c:if test="${pageMaker.prev}">
				<li><a
					href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
					<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
				</li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a
					href="list${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>

		</ul>
	</div>
	</br>
	<c:choose>
		<c:when test="${not empty sessionScope.userinfo}">
			<div style="float: right">
				<form action="/sboard/post" width="80%">
					<button class="w3-button w3-dark-grey">
						<i class="fa fa-pencil"></i> Post
					</button>
				</form>
		</c:when>
	</c:choose>
</div>






<br>
<br>
<br>
<br>
</div>
<%@include file="../include/footer.jsp"%>