<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>거래 완료</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style type="text/css">
#wrap {
	width: 490px;
	text-align: center;
	margin: 0 auto 0 auto;
}

#chk {
	text-align: center;
}
</style>
<script type="text/javascript">
	//창 열릴때 자동으로 되니?
	window.onload = function() {
		// 실행할 자바스크립트 함수
		var zipcode = '${buyuser.zipcode}';
		var zip1 = zipcode.substr(0, 3);
		var zip2 = zipcode.substr(3, 3);
		var phone = '${buyuser.phone}';
		var hp1 = phone.substr(0, 2);
		var hp2 = phone.substr(2, 4);
		var hp3 = phone.substr(6, 4);
		$('#post1').val(zip1);
		$('#post2').val(zip2);
		$('#hp1').val('0'+hp1);
		$('#hp2').val(hp2);
		$('#hp3').val(hp3);
		

	}
	//택배 조회
	function checkdeliver() {
		
		var parcel=$('#parcel').val();
		var url="";
		if(parcel=="대한통운"){
			url="https://www.doortodoor.co.kr/parcel/pa_004.jsp";
		}else if(parcel=="한진택배"){
			url="http://www.hanjin.co.kr/Delivery_html/inquiry/personal_inquiry.jsp";
		}else if(parcel=="우체국택배"){
			url="https://service.epost.go.kr/iservice/usr/trace/usrtrc001k01.jsp";
		}
		window.name = "parentForm";
		window.open(url);
	}
	//물건 받았을때 거래완료
	function complete() {
		var money="${deal_list.money}";
		var dealkey="${deal_list.dealkey}";
		var userkey="${deal_list.saleuserkey}";
		var vo="userkey="+userkey+"&money="+money+"&dealkey="+dealkey;
		console.log(vo);
		if(confirm("물건을 받은게 맞나요?")){
		$.ajax({
			type : 'post',
			url : '/site/complete',
			data : vo,
			success : function(result) {
				console.log("거래완료성공");
				opener.parent.location.reload();
				window.close();
			}
		});
		}
	}
</script>


</head>
<body>
	<div id="wrap">
		<br> <b><font size="4" color="gray">배송지 정보</font></b>
		<hr size="1" width="460">
		<div id="chk">

			<input type="hidden" name="id" value="${userinfo.id}" />
			<table class="table" align="center">
				<table class="table">
					<thead>
						<tr>
							<th>게시글 제목</th>
							<th>거래자</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${boardinfo.title }</td>
							<td>${boarduser.nickname }</td>
						</tr>
						<tr>
							<td colspan="2"><strong>입금액 : ${deal_list.money } 원
							</strong></td>
						</tr>
					</tbody>
				</table>
			</table>
			<br> <b><font size="4" color="gray">배송지 정보</font></b>
			<table class="table">
				<tr>
					<td>주소</td>
					<td>
						<table class="table">
							<tr>
								<td colspan="2" width="120"><input id="post1" name="post1"
									type="text" style="width: 35px;" readonly /> - <input
									name="post2" id="post2" type="text" style="width: 35px;"
									readonly /></td>
							</tr>
							<tr>
								<td colspan="2"><input id="addr1" name="addr1" type="text"
									style="width: 310px;" readonly value="${buyuser.address }"/></td>
							</tr>

						</table>
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input id="hp1" name="post1"
									type="text" style="width: 40px;" readonly /> - <input
									name="post2" id="hp2" type="text" style="width: 45px;"
									readonly />- <input
									name="post2" id="hp3" type="text" style="width: 45px;"
									readonly /></td>
				</tr>
			</table>
<hr size="1" width="460">

<b><font size="4" color="gray">운송 번호</font></b>
<input type="text" id="deliveryNum" value="${deal_list.deliverykey }" readonly />
<label> <select id="parcel" name="parcel">
								<option>우체국택배</option>
								<option>대한통운</option>
								<option>한진택배</option>
						</select>
<input type="button" value="조회" onclick="checkdeliver()"/>
		</div>
		<hr size="1" width="460">
		<div align="center">
	<c:set var="userkey" value="${userinfo.userkey }" />
<c:set var="buykey" value="${buyuser.userkey }" />
<!--구매자일때만 거래완료 보이게  -->
<c:if test="${buykey==userkey}">
<!-- 구매완료를 한 상태하면 버튼 안보이게  -->
<c:if test="${deal_list.salestate!=3}">
		<input type="button" value="거래완료" onclick="complete()"/>
		</c:if>
		</c:if>
		</div>
		<c:if test="${deal_list.salestate==3}">
		거래가 완료되었습니다.
		</c:if>
	</div>
</body>

</html>