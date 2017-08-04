
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
#myul {
	list-style-type: none;
	overflow: hidden;
	float: right;
}

#myul li {
	padding: 2px;
	display: inline;
	float: left;
}
</style>
<%@include file="../include/header.jsp"%>
<center style="margin-top: 50px">
	<img src="/resources/image/FleaLogo1.png" style="margin-bottom: 50px">
</center>
<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<div class="col-sm-12">

			<!--  Search start -->


			<ul id="myul">
				<li><%@include file="../include/selector.jsp"%></li>
				<li><input class="w3-input w3-border " type="text"
					name='keyword' id="keywordInput" value='${cri.keyword}' /></li>
				<li><button class="w3-button w3-red" id='searchBtn'>
						<i class="fa fa-search"> </i> Search
					</button></li>
			</ul>
			<br>
			<br>

			<!--  Search End -->

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

					<c:forEach items="${buylist}" var="board">
						<tr>
							<td>${board.boardkey}</td>
							<td>${board.salestate}</td>
							<td><a href='/sboard/read?boardkey=${board.boardkey}'>${board.title}
									[<span style="color:red">${board.commentcnt}</span>]

							</a></td>
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
					href="buylist${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
					<a href="buylist${pageMaker.makeSearch(idx)}">${idx}</a>
				</li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a
					href="buylist${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>

		</ul>
	</div>
	<br>


	<c:choose>
		<c:when test="${not empty sessionScope.userinfo}">
			<div style="float: right">
				<form action="/sboard/buypost" width="80%">
					<button class="w3-button w3-blue">
						<i class="fa fa-pencil"></i> Post
					</button>
				</form>
			</div>
		</c:when>
	</c:choose>

</div>

<br>
<br>


<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
		location.replace(self.location);
	}
</script>

<script>
	var group2; /* $(document).ready(function() { */

	function getSubValue(obj) {

		console.log(" getSubValue : " + obj);

		group2 = obj;
	}

	$('#searchBtn').on(
			"click",
			function(event) {
				console.log("group2 : " + group2);

				self.location = "buylist" + '${pageMaker.makeQuery(1)}'
						+ "&group1=" + $("#group1 option:selected").val()
						+ "&group2=" + group2 + "&keyword="
						+ $('#keywordInput').val();

			});
</script>





<%@include file="../include/footer.jsp"%>