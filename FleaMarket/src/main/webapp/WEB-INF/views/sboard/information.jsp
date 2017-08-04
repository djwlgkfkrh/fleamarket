<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>회원정보</title>
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
		var zipcode = '${cuserinfo.zipcode}';
		var zip1 = zipcode.substr(0, 3);
		var zip2 = zipcode.substr(3, 3);
		var phone = '${cuserinfo.phone}';
		var hp1 = phone.substr(0, 2);
		var hp2 = phone.substr(2, 4);
		var hp3 = phone.substr(6, 4);
		$('#post1').val(zip1);
		$('#post2').val(zip2);
		$('#hp1').val('0' + hp1);
		$('#hp2').val(hp2);
		$('#hp3').val(hp3);

	}
</script>


</head>
<body>
	<div id="wrap">
		<br> <b><font size="4" color="gray">회 원 정 보</font></b>
		<div id="chk">
		<table class="table">
				<tr>
					<td>아이디</td>
					<td>${cuserinfo.id }</td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td>${cuserinfo.nickname }</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>${cuserinfo.name }</td>
				</tr>
		<c:choose>
			<c:when test="${cuserinfo.zipcode!=''}">
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
									style="width: 310px;" readonly value="${cuserinfo.address }" /></td>
							</tr>

						</table>
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input id="hp1" name="post1" type="text"
						style="width: 40px;" readonly /> - <input name="post2" id="hp2"
						type="text" style="width: 45px;" readonly /> - <input name="post2"
						id="hp3" type="text" style="width: 45px;" readonly /></td>
				</tr>
			</c:when>
			<c:when test="${cuserinfo.zipcode==''}">
			<tr><td colspan="2">추가 정보가 없습니다.</td></tr>
			</c:when>
			</c:choose>
			<tr>
			<td>거래 횟수</td>
			<td>${deal_list.size()} 회</td>
			</tr>
			<tr>
			<td>거래 완료</td>
			<td>${salestatecnt} 회</td>
			</tr>
			</table>
		</div>
	</div>

</body>
</html>