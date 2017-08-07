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
							<th>글 번호</th>
							<th>대분류</th>
							<th>소분류</th>
							<th style="width: 70%;">내용</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="board">
							<c:forEach items="${cart_list}" var="cart" varStatus="status">

								<c:set value="${cart.userkey}" var="cuser" />
								<c:set value="${cart.boardkey}" var="cboard" />
								<c:set value="${board.boardkey}" var="bboard" />
								<c:if test="${cuser==userinfo.userkey && bboard==cboard}">
									<c:set value="${board.report}" var="report" />
									<c:choose>
										<c:when test="${report==true}">
											<tr>
												<td colspan="8">신고된 글입니다.</td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td>${board.boardkey}</td>
												<td>${board.group1}</td>
												<td>${board.group2}</td>
												<!-- image -->
												<td><a href='/sboard/read?boardkey=${board.boardkey}'><img
														style="margin-left:30px; float: left; width: 100px; height: 100px;"
														alt="이미지 없음"
														src="${pageContext.request.contextPath}/resources/upload/${filelist[status.index].fname}"
														> ${board.title}<br>
														작성자 : ${board.nickname} <br> 판매상태 : <c:choose>
															<c:when test="${board.salestate==0}">판매중</c:when>
															<c:when test="${board.salestate==1}">거래중</c:when>
															<c:when test="${board.salestate==2}">거래완료</c:when>
														</c:choose><br> <fmt:formatDate pattern="yyyy-MM-dd HH:mm"
															value="${board.regdate}" /> </a></td>

												<!--  image -->
												<td>${board.viewcnt}</td>

											</tr>
										</c:otherwise>
									</c:choose>
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