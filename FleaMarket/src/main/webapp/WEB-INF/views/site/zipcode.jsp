<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		function sendForm() {
			//우편번호 창에 누군가가 검색버튼을 누르거나 엔터쳤을때~ 이 함수 호출!!
			form1.target = "result";//프레임의 이름을 명시하면 해당 프레임에 전송
			form1.action = "zipcodeList";
			form1.submit();
		}
		function enterKey() {
			//엔터를 쳤을때만 sendForm()호출
			if (event.keyCode == 13) {
				sendForm();
			}
		}
	</script>
</head>
<body leftmargin="0" topmargin="0">
	<table border="0" width="100%">
		<form name="form1" method="post">
			<tr>
				<td align="center" height="100px"><input type="text"
					name="dong" onKeyDown="enterKey()"> <input type="button"
					value="검색" onClick="sendForm()"><br> * 동으로 검색하세요 <br> * 예) 신사 , 신사동</td>
			</tr>
			<tr>
				<td><iframe name="result" frameborder="0" width="100%"
						height="400px" src="zipcodeList"></iframe></td>
			</tr>
		</form>
	</table>
</body>
</html>

</body>

</html>