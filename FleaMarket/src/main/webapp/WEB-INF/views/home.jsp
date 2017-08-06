<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="include/header.jsp"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<center style="margin-top: 50px">
	<img src="/resources/image/Flea90.png" width="95%" height="650">
</center>
<br>
<br>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px;">
	<div class="row">
		<div class="col-sm-4"></div>
		<!-- <form name="homesearch" method="post"> -->
		<div class="input-group col-sm-4">
			<input type="text" class="form-control" id="keywordInput"
				value='${cri.keyword}' name="keyword">
			<div class="input-group-btn">
				<button class="btn btn-default w3-blue" type="button" id='searchBtn'>
					<i class="glyphicon glyphicon-search">Search</i>
				</button>
			</div>
		</div>
		<!-- </form> -->

		<br> <br>
		<div class="col-sm-4"></div>
	</div>
	<div class="col-sm-12">
		<div id="searchResultDiv"></div>
	</div>
</div>
<br>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">

		<div class="col-sm-6">
			<h3>실시간 인기 글</h3>
			<br>
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
							<c:choose>
							<c:when test="${popularBoard.salestate==0}">
							<td>거래전</td>
							<td><a href='/sboard/read?boardkey=${popularBoard.boardkey}'>${popularBoard.title}</a></td>
							</c:when>
							<c:when test="${popularBoard.salestate==1}">
							<td>거래중</td>
							<td><a href='/sboard/read?boardkey=${popularBoard.boardkey}'>${popularBoard.title}</a></td>
							</c:when>
							<c:when test="${popularBoard.salestate==2}">
							<td>거래완료</td>
							<td>${popularBoard.title}</td>
							</c:when>
							</c:choose>
							<td>${popularBoard.viewcnt}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${popularBoard.regdate}" /></td>
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
					href="home/${pageMaker.makeSearch(pageMaker.startPage)-1 }">&laquo;</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
					<a href="home/${pageMaker.makeSearch(idx)}">${idx}</a>
				</li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a
					href="home/${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>

		</ul>
	</div>


</div>


<script>
	var result = '${msg}';
	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
		location.replace(self.location);
	}
</script>

<script>

	$('#searchBtn').on(
			"click",
			function(event) {
				document.location.href = 'home?pagemaker='
						+ '${pageMaker.makeQuery(1)}' + '&keyword='
						+ $('#keywordInput').val();

			});
</script>

<%@include file="include/footer.jsp"%>