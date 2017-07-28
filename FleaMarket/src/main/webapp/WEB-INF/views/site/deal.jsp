<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>거 래 하 기</title>
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
	function deal() {
		if(checkValue()){
		var userkey="${userinfo.userkey}";
		var address=$('#addr1').val()+$('#addr2').val();
		var zipcode=$('#post1').val()+$('#post2').val();
		var phone=$('#hphone1').val()+$('#hphone2').val()+$('#hphone3').val();
		var vo="address="+address+"&zipcode="+zipcode+"&phone="+phone+"&userkey="+userkey;
		console.log(vo);
		if(confirm("거래하시겠습니까?")){
		$.ajax({
			type : 'post',
			url : '/site/dealing',
			data : vo,
			success : function(result) {
				console.log("deal성공");
				window.close();
			}
		});
		}
		}
	}

	function checkValue() {
	/* 	var form = document.userInfo; */
var hp=String($('#hphone2').val()).length;
var hp2=String($('#hphone3').val()).length;
		if (!$('#money').val()) {
			alert("거래금액을 입력하세요.");
			return false;
		}

		if (!$('#post1').val() || !$('#post2').val() || !$('#addr1').val()) {
			alert("주소를 입력하세요.");
			return false;
		}
		if (!$('#addr2').val()) {
			alert("나머지 주소를 입력하세요.");
			return false;
		}
		if (!$('#hphone2').val()) {
			alert("핸드폰 번호를 입력하세요.");
			return false;
		}
		if (hp != 4) {
			alert("4자리를 입력하세요.");
			return false;
		} 

		if (!$('#hphone3').val()) {
			alert("핸드폰 번호를 입력하세요.");
			return false;
		}
		
		if (hp2 != 4) {
			alert("4자리를 입력하세요.");
			return false;
		}  
		return true;
	}
	function openZip() {
		//새창을 띄운다!! 새창을 띄우는거는 window객체에서 open이라는 메서드로 제공합니다
		//인수 3개 (주소, 이름, 사이즈)
		window.open("zipcode", "zipcode", "width=400,height=500");
	}
</script>


</head>
<body>
	<div id="wrap">
		<br> <b><font size="4" color="gray">결제하기</font></b>
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
							<td>1</td>
							<td>1</td>
						</tr>
						<tr>
							<td colspan="2"><strong>거래금액 : <input type="text"
									name="money" id="money" style="width: 150px;" />원
							</strong></td>
						</tr>
					</tbody>
				</table>
			</table>
			<br> <b><font size="4" color="gray">배송지 정보</font></b>
			<table class="table">
				<tr>
					<td>주소</td>
					<td><table class="table">
							<tr>
								<td width="120"><input id="post1" name="post1" type="text"
									style="width: 35px;" readonly /> - <input name="post2" id="post2"
									type="text" style="width: 35px;"readonly /></td>
								<td><input type="button" onClick="openZip()"
									value="우편번호 검색" /></td>
							</tr>
							<tr>
								<td colspan="2"><input id="addr1" name="addr1" type="text"
									style="width: 310px;" readonly/></td>
							</tr>
							<tr>
								<td colspan="2"><input id="addr2" name="addr2" type="text"
									style="width: 310px;" /></td>
							</tr>
						</table></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><label> <select id="hphone1" name="hphone1">
								<option>010</option>
								<option>011</option>
								<option>016</option>
								<option>017</option>
								<option>018</option>
								<option>019</option>
						</select>
					</label> - <input type="text" id="hphone2" name="hphone2"
						style="width: 50px;" maxlength="4" /> - <input type="text"
						id="hphone3" name="hphone3" style="width: 50px;" maxlength="4" /></td>
				</tr>
				<tr>
					<td colspan="2"><button type="button" onclick="deal()">거래하기</button>
						<input type="button" id="deal" value="취소" onclick="window.close()"></td>
				</tr>
			</table>


		</div>
	</div>
</body>

</html>