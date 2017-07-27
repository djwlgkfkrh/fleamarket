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
	function checkValue() {
		var form = document.userInfo;

		if (!form.money.value) {
			alert("거래금액을 입력하세요.");
			return false;
		}

		if (!form.address.value) {
			alert("주소를 입력하세요.");
			return false;
		}

		if (!form.hphone2.value) {
			alert("핸드폰 번호를 입력하세요.");
			return false;
		}
		if (form.hphone2.value.length != 4) {
			alert("4자리를 입력하세요.");
			return false;
		}

		if (!form.hphone3.value) {
			alert("핸드폰 번호를 입력하세요.");
			return false;
		}
		if (form.hphone3.value.length != 4) {
			alert("4자리를 입력하세요.");
			return false;
		}
	}
	function openZip() { 
		 //새창을 띄운다!! 새창을 띄우는거는 window객체에서 open이라는 메서드로 제공합니다
		 //인수 3개 (주소, 이름, 사이즈)
		 window.open("zipcode","zipcode","width=400,height=500"); 
		}

</script>
</head>
<body>
	<div id="wrap">
		<br> <b><font size="4" color="gray">결제하기</font></b>
		<hr size="1" width="460">
		<div id="chk">
			<form action="/site/dealing" method="post" name="userInfo"
				onsubmit="return checkValue()">
				<table class="table" align="center">
					<table class="table">
						<thead>
							<tr>
								<th>거래번호</th>
								<th>게시글 제목</th>
								<th>거래자</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td colspan="3"><strong>거래금액 : <input type="text"
										name="money" style="width: 150px;" />원
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
									<td width="120"><input name="post1" type="text" style="width:35px; "/> - 
									<input name="post2" type="text" style="width:35px; " /></td>
									<td><input type="button" onClick="openZip()" value="우편번호 검색"/></td>
								</tr>
								<tr>
									<td colspan="2"><input name="addr1" type="text"
										style="width: 310px;" /></td>
								</tr>
								<tr>
									<td colspan="2"><input name="addr2" type="text"
										style="width: 310px;" /></td>
								</tr>
							</table></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><label> <select name="select">
									<option>010</option>
									<option>011</option>
									<option>016</option>
									<option>017</option>
									<option>018</option>
									<option>019</option>
							</select>
						</label> - <input type="text" name="hphone2" style="width: 50px;"
							maxlength="4" /> - <input type="text" name="hphone3"
							style="width: 50px;" maxlength="4" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="거래하기" /> <input
							type="button" value="취소" onclick="window.close()"></td>
					</tr>
				</table>
			</form>

		</div>
	</div>
</body>
</html>