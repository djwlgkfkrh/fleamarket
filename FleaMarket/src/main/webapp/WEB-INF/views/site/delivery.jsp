<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>구매자 정보</title>
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
		var zipcode = '${buy.zipcode}';
		var zip1 = zipcode.substr(0, 3);
		var zip2 = zipcode.substr(3, 3);
		var phone = '${buy.phone}';
		var hp1 = phone.substr(0, 2);
		var hp2 = phone.substr(2, 4);
		var hp3 = phone.substr(6, 4);
		$('#post1').val(zip1);
		$('#post2').val(zip2);
		$('#hp1').val('0'+hp1);
		$('#hp2').val(hp2);
		$('#hp3').val(hp3);
		

	}

	function delivery() {
		var deliverykey=$('#deliveryNum').val();
		var dealkey='${deal_list.dealkey}';
		var vo="deliverykey="+deliverykey+"&dealkey="+dealkey;
		console.log(vo);
		if(confirm("운송번호 맞나요?")){
		$.ajax({
			type : 'post',
			url : '/site/deliverying',
			data : vo,
			success : function(result) {
				console.log("delivery성공");
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
									style="width: 310px;" readonly value="${buy.address }"/></td>
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
<c:set var="userkey" value="${userinfo.userkey }" />
<c:set var="buykey" value="${buyuser.userkey }" />
<c:if test="${buykey==userkey}">
<b><font size="4" color="gray">운송장 입력</font></b>
<input type="text" id="deliveryNum"/><input type="button" onclick="delivery()" value="배송"/>
</c:if>
		</div>
	</div>
</body>

</html>