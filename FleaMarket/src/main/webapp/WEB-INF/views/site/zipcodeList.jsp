<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<title>Insert title here</title>
<style>
td {
	font-size: 9pt;
}
</style>

</head>
<body leftmargin="0" , topmargin="0">
	<table width="390" border="0">
		<tr align="center">
			<td width="80">우편번호</td>
			<td>주소</td>
		</tr>
		
		<c:forEach items="${zipcode }" var="address">
			<tr onMouseOver="this.style.background='yellow'"
				onMouseOut="this.style.background=''">
				<td><a
				href="javascript:sendValue('${address.zipcode }','${address.sido } ${address.gugun } ${address.dong } ${address.bunji }')">${address.zipcode }</a></td>
			<td>${address.sido } ${address.gugun } ${address.dong } ${address.bunji }</td>
			</tr>
		</c:forEach>
	
	</table>
	
	<script>
	function sendValue(zip, addr) {
		//선택한 주소 정보를 현재 창을 띄운 오프너창에게 전달~!!
		var str = zip.split("-"); //2개로 쪼개지면서 배열로 나오지만. 자바 스크립트는 자료형이 없고 모두 var로 선언하죠? ㅋ
		//alert(str[0] + "-" + str[1]+"," + addr);

		/*프레임으로 나누어진 브라우저에서 각각의 프레임은 
		전체 브라우저를 parent로 접근이 가능하다.
		opener.form1.post1.value=str[0];이렇게만 하면 전송이 안되죠? */
		parent.opener.userInfo.post1.value = str[0];
		parent.opener.userInfo.post2.value = str[1];
		parent.opener.userInfo.addr1.value = addr;
		parent.close()
	}
</script>
</body>
</html>