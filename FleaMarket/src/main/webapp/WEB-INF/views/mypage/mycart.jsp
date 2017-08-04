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
						<c:forEach items="${cart_list}" var="cart" varStatus="status">
		<%-- 				<c:forEach items="${filelist}" var="filelist"> --%>
						<c:set value="${cart.userkey}" var="cuser" />
						<c:set value="${cart.boardkey}" var="cboard" />
						<c:set value="${board.boardkey}" var="bboard" />
						<c:if test="${cuser==userinfo.userkey && bboard==cboard}">
							<tr>
								<td>${board.boardkey}</td>
								<td>${board.salestate}</td>
								<!-- image -->
								<td>	
									<img style="margin-left: 36%;"
										src="${pageContext.request.contextPath}/resources/upload/${filelist[status.index].fname}"
										width="300" height="300">
									<br>
								
								</td>
								
                              <!--  image -->
								<td><a href='/sboard/read?boardkey=${board.boardkey}'>${board.title}</a></td>
								<td>${board.viewcnt}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${board.regdate}" /></td>
							</tr>
							</c:if>
						</c:forEach>
						</c:forEach>
<%-- </c:forEach> --%>
					</tbody>
				</table>
			</div>

		</div>



	</div>
</div>
<br>
<br>

<%@include file="../include/footer.jsp"%>