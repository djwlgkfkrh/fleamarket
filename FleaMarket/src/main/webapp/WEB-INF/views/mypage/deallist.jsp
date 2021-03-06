<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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

								<td>${deal.nickname}</td>
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
										onclick="detail(${deal.dealkey})">조회</button></td>
							</tr>
						</c:if>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<br> <br> <br> <br> <br> <br> <br> <br>
	<br>
	<div id="statetable"></div>

	<br> <br>
	<div id="detailDiv"></div>
	<br> <br>
</div>

<script id="stateTableTemplate" type="text/x-handlebars-template"> 
<table style="width: 100%;">
		<tr style="border: 1px solid black; border-collapse: collapse;">
			<td>{{#istrue salestateNum 0}}
						<h3 style="color: red">1.입금대기</h3>
					{{else}}
						<h3>1.입금대기</h3>
					{{/istrue}}

				<p>결제를 완료해주세요 </p>	</td>
			<td>{{#istrue salestateNum 1}}
						<h3 style="color: red">2.결제완료/배송대기</h3>
					{{else}}
						<h3>2.결제완료/배송대기</h3>
					{{/istrue}}

				<p>주문정보를 확인하고 배송을 준비중입니다</p></td>
			<td>{{#istrue salestateNum 2}}
						<h3 style="color: red">3.배송 중</h3>
				{{else}}
						<h3>3.배송 중</h3>
					{{/istrue}}
				<p>물품이 발송되었습니다</p></td>
			<td>{{#istrue salestateNum 3}}
						<h3 style="color: red">4.거래완료</h3>
					{{else}}
						<h3>4.거래완료</h3>
					{{/istrue}}
				<p>거래확인으로 거래가 종료됩니다</p></td>
			<td>{{#istrue salestateNum 4}}
						<h3 style="color: red">반품 신청</h3>
					{{else}}
						<h3>반품신청</h3>
					{{/istrue}}

				<p>반품배송중입니다. </p>	</td>
		</tr>
	</table>
</script>
<script id="detailDivTemplate" type="text/x-handlebars-template"> 
<table class="table table-hover w3-centered"
			style="text-align: center">
<tr><td>주문번호</td><td>{{dealkey}}</td><td>날짜</td><td>{{regdate}}</td></tr>
<tr><td>판매자</td><td>{{seller}}</td><td>구매자</td><td>{{buyer}}</td></tr>
<tr><td>글제목</td><td>{{boardtitle}}</td><td>가격</td><td>{{money}}</td></tr>
<tr><td>상태</td><td>{{salestate}}</td><td>운송장번호</td><td>{{deliverykey}}</td></tr>
<tr><td>주소</td><td>{{address}}</td><td>전화번호</td><td>{{number}}</td></tr>
			</table>

</script>


<script>
Handlebars.registerHelper('istrue', function(salestateNum, num,options) {
	if (salestateNum == num) {
		return options.fn(this);
	} else {
		return options.inverse(this);
	}
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

	function detail(dealkey){
		console.log(dealkey+"..");
			$.ajax({
			type : "POST",
			url : "/dealinfo/"+dealkey,
			success : function(result) {
				document.getElementById("detailDiv").innerHTML = "";
				document.getElementById("statetable").innerHTML = "";
				printData(result, $("#statetable"),$("#stateTableTemplate"));
				printData(result, $("#detailDiv"),$("#detailDivTemplate"));
				
				}
			
		});
	}
</script>
<%@include file="../include/footer.jsp"%>