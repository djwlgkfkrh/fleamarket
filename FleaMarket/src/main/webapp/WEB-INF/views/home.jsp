<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<%@include file="include/header.jsp"%>

<center style="margin-top: 50px">
	<img src="/resources/image/Flea90.png" width="95%" height="650">
</center>

<br>
<br>
<br>


<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<div class="col-sm-12">
			<!-- <form name="homesearch" method="post"> -->
			<table>
				<tr>
					<td><input type="text" name="keyword" id="keywordInput"
						value='${cri.keyword}'></td>
					<td><button id='searchBtn' type="button">Search</button></td>
				</tr>
			</table>
			<!-- </form> -->

			<br>
			<div id="searchResultDiv"></div>


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

<script id="searchResultTemplate" type="text/x-handlebars-template">
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
{{#each .}}
<tr>
				<td>{{boardkey}}</td>
				<td>{{salestate}}</td>
				<td><a href='/sboard/read?boardkey={{boardkey}}'>{{title}}</a></td>
				<td>{{viewcnt}}</td>
				<td>{{prettifyDate regdate}}</td>
			</tr>
{{/each}}
	</tbody>
</table>
</script>

<script>
	var result = '${msg}';

	if (result == 'SUCCESS') {
		alert("처리가 완료되었습니다.");
		location.replace(self.location);
	}
</script>

<script>
	Handlebars.registerHelper("prettifyDate", function(timeValue) {
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	});
	var printData = function(replyArr, targetDiv, handleBarTemplateName) {
		var template = Handlebars.compile(handleBarTemplateName.html());
		var html = template(replyArr);
		targetDiv.html(html);
	}
	$('#searchBtn').on(
			"click",
			function(event) {
				$.ajax({
					type : 'post',
					url : 'home?pagemaker=' + '${pageMaker.makeQuery(1)}'
							+ '&keyword=' + $('#keywordInput').val(),

					success : function(result) {
						console.log("성공");
						for ( var i in result) {
							console.log(result[i].boardkey);
						}
						printData(result, $("#searchResultDiv"),
								$("#searchResultTemplate"));

					}
				});

			});
</script>



<%@include file="include/footer.jsp"%>