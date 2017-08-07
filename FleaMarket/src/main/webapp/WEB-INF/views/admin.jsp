
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="include/header.jsp"%>
<center style="margin-top: 50px">
	<img src="/resources/image/FleaLogo1.png" style="margin-bottom: 50px">
</center>
<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<div class="col-sm-12">
			<!--  Search start -->
			<br> <br>
			<!--  Search End -->
			<h2>신고된 글 목록</h2>
			<br> <br>
			<table class="table table-hover w3-centered"
				style="text-align: center">
				<thead>
					<tr>
						<th style="width: 100px;">글 번호</th>
						<th style="width: 100px;">판매상태</th>
						<th>글 제목</th>
						<th style="width: 100px;">조회수</th>
						<th style="width: 200px;">날짜</th>
						<th style="width: 100px;">복원</th>
						<th style="width: 100px;">삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${reportlist}" var="reportlist">
						<tr>

							<td>${reportlist.boardkey}</td>
							<td>${reportlist.salestate}</td>
							<td><a href='/sboard/read?boardkey=${reportlist.boardkey}'>${reportlist.title}
									[<span style="color: red;"> ${reportlist.commentcnt} </span>]
							</a></td>
							<td>${reportlist.viewcnt}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${reportlist.regdate}" /></td>
							<td><a href='/admin/return?boardkey=${reportlist.boardkey}'>복원</a></td>
							<td><a href='/admin/delete?boardkey=${reportlist.boardkey}'>삭제</a></td>
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
					href="salelist${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
					<a href="salelist${pageMaker.makeSearch(idx)}">${idx}</a>
				</li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a
					href="salelist${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>

		</ul>
	</div>
	<br>

	
</div>
<%@include file="include/footer.jsp"%>