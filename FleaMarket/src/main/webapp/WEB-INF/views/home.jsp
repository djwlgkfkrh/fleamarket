<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="include/header.jsp"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<center style="margin-top: 50px">
	<img src="/resources/image/Flea90.png" width="90%" height="650">
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
						<th>글 번호</th>
						<th>판매상태</th>
						<th style="width: 40%">글 제목</th>
						<th>조회수</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${popularBoard}" var="popularBoard">
						<c:set value="${popularBoard.report}" var="report" />
						<c:choose>
							<c:when test="${report==true}">
								<tr>
									<td colspan="8">신고된 글입니다.</td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td>${popularBoard.boardkey}</td>
									<c:choose>
										<c:when test="${popularBoard.salestate==0}">
											<td>거래전</td>
											<td><a
												href='/sboard/read?boardkey=${popularBoard.boardkey}'>${popularBoard.title}</a></td>
										</c:when>
										<c:when test="${popularBoard.salestate==1}">
											<td>거래중</td>
											<td><a
												href='/sboard/read?boardkey=${popularBoard.boardkey}'>${popularBoard.title}</a></td>
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
							</c:otherwise>
						</c:choose>
					</c:forEach>

				</tbody>
			</table>
		</div>
		<div class="col-sm-6">
			<h3>
				About <span class="w3-text-red">FLEA MARKET</span>
			</h3>
			<br>
			<table class="table table-bordered" style="text-align: center">
				<tr>
					<td>회원수</td>
					<td>${fleaMarket.usercount}</td>
				</tr>
				<tr>
					<td>게시글 수</td>
					<td>${fleaMarket.boardcount}</td>
				</tr>
				<tr>
					<td>총 거래수</td>
					<td>${fleaMarket.dealcount}</td>
				</tr>



			</table>
			<br>
			<h4>안전 거래 기능이란?</h4>

			<img src="/resources/image/deal.JPG"
				style="margin-bottom: 50px; width: 60%; float: left;"> <br>
			<p>안전거래 시스템이란 구매자와 판매자 사이의 거래에 FLEA MARKET 이 함께 참여하여 판매자는 구매자의
				입금을 걱정없이 배송할 수 있으며 구매자는 판매자의 물건에 점수를 매겨야 입금이 가능하도록 하는 시스템으로써 구매자와
				판매자 사이의 신뢰가능한 중고거래를 도와주는 시스템입니다.</p>
		</div>

	</div>
	<br>


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