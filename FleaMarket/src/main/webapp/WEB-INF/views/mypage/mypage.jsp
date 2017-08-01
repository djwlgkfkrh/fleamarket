<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<h3>마이 페이지</h3>
	<br>
	<div class="row">
		<div class="col-sm-4">
			<form name="form1" method="get">
				<input type="hidden" name="userkey" value="${userinfo.userkey}" />
				<table class="table">
					<thead>
						<tr>
							<th>내 정보</th>
							<th style="color: red;">${msg}</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>아이디</td>
							<td>${userinfo.id}</td>
						</tr>
						<tr>
							<td>이름</td>
							<td>${userinfo.name}</td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td>${userinfo.nickname}</td>
						</tr>
						<tr>
							<td>포인트</td>
							<td>${userinfo.point}</td>
						</tr>
						<tr>
							<td colspan="2"><input type="button" id="modify"
								value="정보수정" /></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		<div class="col-sm-4">
			<table class="table table-hover">
				<thead>
					<tr>
						<th colspan="3">거래 내역</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="userkey" value="${userinfo.userkey }" />
					<c:forEach items="${deal_list}" var="deal" varStatus="status">
						<c:set var="buyuserkey" value="${deal.buyuserkey}" />
						<c:set var="saleuserkey" value="${deal.saleuserkey}" />
						<c:if test="${buyuserkey==userkey||saleuserkey==userkey}">
							<tr>
								<td id="boardkey${status.count}">${deal.boardkey}</td>
								<td><a href='/sboard/read?boardkey=${deal.boardkey}'>제목</a></td>
								<td><input type="hidden" id="dealkey${status.count}" value="${deal.dealkey}" />
								
								<!-- 거래진행 단계 choose -->
								<c:choose>
								<c:when test="${deal.salestate eq 0}">
								
								<!-- 판매자일때와 구매자일때 상황이 조금 달라서 choose -->
								<c:choose>
								<c:when test="${buyuserkey==userkey}">
								<input type="button" value="입금대기" id="step1"
									onclick="openDeal(${status.count})" disabled style="color:gray;"/></td>
									</c:when>
									<c:when test="${saleuserkey==userkey}">
									<input type="button" value="입금대기" id="step1"
									onclick="openDeal(${status.count})" />
									</td>
									</c:when>
									</c:choose>
									<!--  판매자와 구매자 차이 choose끝-->
									</c:when>
									<c:when test="${deal.salestate eq 1}">
								<input type="button" value="배송대기"
									onclick="openDeal1(${status.count})" />
									<input type="hidden" id="buyuserkey${status.count}" value="${buyuserkey}" />
									</td>
									</c:when>
									<c:when test="${deal.salestate eq 2}">
								<input type="button" value="배송중"
									onclick="openDeal2(${status.count})" /></td>
									</c:when>
									<c:when test="${deal.salestate eq 3}">
								<input type="button" value="거래완료"
									onclick="openDeal3(${status.count})" /></td>
									</c:when>
								</c:choose>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-sm-4">
			<p>
			<h4>활동 내역</h4>
			</p>
			<br>
			<p>
				총 게시글 :<span style="color: red;"> ${b_mycount}</span> 개
			</p>
			<p>
				총 댓글 : <span style="color: red;">${c_mycount}</span> 개
			</p>

		</div>
	</div>
</div>
<br>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<div class="col-sm-6">
			<p>
			<h4>내가 쓴 글</h4>
			</p>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>글 번호</th>
						<th>글 제목</th>
						<th>조회수</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${b_list }" var="board">

						<tr>
							<td>${board.boardkey}</td>
							<td><a href='/sboard/read?boardkey=${board.boardkey}'>${board.title}</a></td>
							<td>${board.viewcnt}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
									value="${board.regdate}" /></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		<div class="col-sm-6">
			<div class="row">
				<p>
				<h4>댓글 단 게시글</h4>
				</p>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>글 번호</th>
							<th>글 제목</th>
							<th>조회수</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
			<div class="row">
				<p>
				<h4>내 댓글</h4>
				</p>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>글 번호</th>
							<th>댓글 내용</th>
							<th>날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${c_list }" var="comment">
							<tr>
								<td>${comment.boardkey}</td>
								<td><a href='/sboard/read?boardkey=${comment.boardkey}'>${comment.context}</a></td>
								<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
										value="${comment.regdate}" /></td>
							</tr>
						</c:forEach>
					</tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<br>
<br>
<script>
	$(document).ready(function() {
		$("#modify").click(function() {
			// 확인 대화상자    
			if (confirm("수정하시겠습니까?")) {
				document.form1.action = "/mypage/modify";
				document.form1.submit();
			}
		});
	});
	
	//거래화면 띄우기
	function openDeal(str) {
		var boardkey = $('#boardkey'+str).html();
		var dealkey = $('#dealkey'+str).val();
			
		window.name = "parentForm";
		window.open("site/deal?boardkey=" + boardkey+"&dealkey="+dealkey, "dealForm",
				"width=600, height=650, resizable = no, scrollbars = no");
	}
	//배송대기
	function openDeal1(str) {
		var boardkey = $('#boardkey'+str).html();
		var dealkey = $('#dealkey'+str).val();
		var buyuserkey = $('#buyuserkey'+str).val();
			
		window.name = "parentForm";
		window.open("site/delivery?boardkey=" + boardkey+"&dealkey="+dealkey+"&buyuserkey="+buyuserkey, "dealForm",
				"width=600, height=650, resizable = no, scrollbars = no");
	}
	//배송중
	function openDeal2(str) {
		var boardkey = $('#boardkey'+str).html();
		var dealkey = $('#dealkey'+str).val();
			
		window.name = "parentForm";
		window.open("site/deliverying?boardkey=" + boardkey+"&dealkey="+dealkey, "dealForm",
				"width=600, height=650, resizable = no, scrollbars = no");
	}
	//거래완료
	function openDeal3(str) {
		var boardkey = $('#boardkey'+str).html();
		var dealkey = $('#dealkey'+str).val();
			
		window.name = "parentForm";
		window.open("site/dealcomplete?boardkey=" + boardkey+"&dealkey="+dealkey, "dealForm",
				"width=600, height=650, resizable = no, scrollbars = no");
	}
</script>
<%@include file="../include/footer.jsp"%>