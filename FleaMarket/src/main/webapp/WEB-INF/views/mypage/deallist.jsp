<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<center style="margin-top: 50px">
	<img src="/resources/image/FleaLogo1.png" style="margin-bottom: 50px">
</center>
<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<h3>거래 내역</h3>
	<br>
	<div class="col-sm-12">
		<table class="table table-hover w3-centered"
			style="text-align: center">
			<thead>
				<tr>
					<th style="width: 100px;">거래번호</th>
					<th style="width: 100px;">글번호</th>
					<th>글 제목</th>
					<th style="width: 120px;">글쓴이</th>
					<th style="width: 120px;">주문상태</th>
					<th style="width: 120px;">조회</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="userkey" value="${userinfo.userkey }" />
				<c:forEach items="${deal_list}" var="deal" varStatus="status">
					<c:set var="buyuserkey" value="${deal.buyuserkey}" />
					<c:set var="saleuserkey" value="${deal.saleuserkey}" />
					<c:if test="${deal.salestate!=5}">
						<!-- 거래테이블에 내 유저키가 맞는게 있으면 -->
						<c:if test="${buyuserkey==userkey||saleuserkey==userkey}">
							<tr>
								<td>${deal.dealkey}</td>
								<td id="boardkey${status.count}">${deal.boardkey}</td>
								<td><a href='/sboard/read?boardkey=${deal.boardkey}'>${deal.title}</a></td>
								<td>유저닉네임</td>
								<td><input type="hidden" id="dealkey${status.count}"
									value="${deal.dealkey}" /> <!-- 거래진행 단계 choose --> <c:choose>
										<c:when test="${deal.salestate eq 0}">

											<!-- 판매자일때와 구매자일때 상황이 조금 달라서 choose -->
											<c:choose>
												<c:when test="${saleuserkey==userkey}">
													<input type="button" class="btn w3-blue" value="입금대기"
														id="step1" disabled style="color: gray;" /></td>
								</c:when>
								<c:when test="${buyuserkey==userkey}">
									<input type="button" class="btn w3-blue" value="입금대기"
										id="step1" onclick="openDeal(${status.count})" />
									</td>
								</c:when>
								</c:choose>
								<!--  판매자와 구매자 차이 choose끝-->
								</c:when>
								<c:when test="${deal.salestate eq 1}">
									<input type="button" class="btn w3-blue" value="배송대기"
										onclick="openDeal1(${status.count})" />
									<input type="hidden" id="saleuserkey${status.count}"
										value="${saleuserkey}" />
									<input type="hidden" id="buyuserkey${status.count}"
										value="${buyuserkey}" />
									</td>
								</c:when>
								<c:when test="${deal.salestate eq 2}">
									<input type="button" class="btn w3-blue" value="배송중"
										onclick="openDeal2(${status.count})" />
									<input type="hidden" id="buyuserkey${status.count}"
										value="${buyuserkey}" />
									</td>
								</c:when>
								<c:when test="${deal.salestate eq 3}">
									<input type="button" class="btn w3-blue" value="거래완료"
										onclick="openDeal2(${status.count})" />
									<input type="hidden" id="buyuserkey${status.count}"
										value="${buyuserkey}" />
									</td>
								</c:when>

								<c:when test="${deal.salestate eq 4}">
									<c:choose>
										<c:when test="${buyuserkey==userkey}">
											<input type="button" class="btn w3-blue" value="반품확인"
												id="step4" disabled style="color: gray;" />
											</td>
										</c:when>
										<c:when test="${saleuserkey==userkey}">
											<input type="button" class="btn w3-blue" value="반품확인"
												id="step4" onclick="openDeal3(${status.count})" />
											<input type="hidden" id="buyuserkey${status.count}"
												value="${buyuserkey}" />
											</td>
										</c:when>
									</c:choose>
								</c:when>
								</c:choose>
								<td><button type="button" class="btn w3-blue" id="step1"
										onclick="detail()">조회</button></td>
							</tr>
						</c:if>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br> <br> <br> <br> <br> <br> <br> <br>
	<br>
	<table style="width: 100%;">
		<tr style="border: 1px solid black; border-collapse: collapse;">
			<td>
				<h3>1.입금대기중</h3>
				<p>결제를 완료해주세요</p>
			</td>
			<td>
				<h3>2.결제완료</h3>
				<p>결제를 완료해주세요</p>
			</td>
			<td>
				<h3>3.배송준비</h3>
				<p>결제를 완료해주세요</p>
			</td>
			<td>
				<h3>4.배송중</h3>
				<p>결제를 완료해주세요</p>
			</td>
			<td>
				<h3>5.배송완료</h3>
				<p>결제를 완료해주세요</p>
			</td>
		</tr>
	</table>
	<br> <br>
	<div id="detailDiv"></div>
	<br> <br>
</div>


<script id="detailDivTemplate" type="text/x-handlebars-template"> 
<table class="table table-hover w3-centered"
			style="text-align: center">
<tr><td>주문번호</td><td>ㄴㅇㄹ</td><td>날짜</td><td>{{dealregdate}}</td></tr>
			</table>
{{seller}}{{boardtitle}}{{money}}{{packageNumber}}{{address}}{{number}}  
</script>


<script>

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
		var saleuserkey = $('#saleuserkey'+str).val();
		var buyuserkey = $('#buyuserkey'+str).val();
			
		window.name = "parentForm";
		window.open("site/delivery?boardkey=" + boardkey+"&dealkey="+dealkey+"&saleuserkey="+saleuserkey
				+"&buyuserkey="+buyuserkey, "dealForm",
				"width=600, height=650, resizable = no, scrollbars = no");
	}
	//배송중 and 거래완료
	function openDeal2(str) {
		var boardkey = $('#boardkey'+str).html();
		var dealkey = $('#dealkey'+str).val();
		var buyuserkey = $('#buyuserkey'+str).val();
			
		window.name = "parentForm";
		window.open("site/dealcomplete?boardkey=" + boardkey+"&dealkey="+dealkey+"&buyuserkey="+buyuserkey, "dealForm",
				"width=600, height=650, resizable = no, scrollbars = no");
	}
	//반품확인
	function openDeal3(str) {
		var boardkey = $('#boardkey'+str).html();
		var dealkey = $('#dealkey'+str).val();
		var buyuserkey = $('#buyuserkey'+str).val();
			
		window.name = "parentForm";
		window.open("site/reason?boardkey=" + boardkey+"&dealkey="+dealkey+"&buyuserkey="+buyuserkey, "dealForm",
				"width=600, height=650, resizable = no, scrollbars = no");
	}
	var printData = function (replyArr, targetDiv, handleBarTemplateName){
		   var template =Handlebars.compile(handleBarTemplateName.html());
		   var html =template(replyArr);
		   targetDiv.html(html);
		}

	function detail(){
			$.ajax({
			type : "POST",
			url : "/dealinfo",
			success : function(result) {
				document.getElementById("detailDiv").innerHTML = "";
				printData(result, $("#detailDiv"),$("#detailDivTemplate"));
				}
			
		});
	}
</script>
<%@include file="../include/footer.jsp"%>