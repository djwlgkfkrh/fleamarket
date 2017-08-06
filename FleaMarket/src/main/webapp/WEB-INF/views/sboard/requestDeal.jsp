<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>거 래 신 청</title>
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
function makedeal() {
	var money=$('#money').val();
	var boardkey="${board.boardkey}";
	var title="${board.title}";
	var nickname="${board.nickname}";
	if(${sale}){
	var buyuserkey="${cuserinfo.userkey}";
	var saleuserkey="${userinfo.userkey}";
	}else{ 
	var saleuserkey="${cuserinfo.userkey}";
	var buyuserkey="${userinfo.userkey}";
	}
	var vo="money="+money+"&buyuserkey="+buyuserkey+"&boardkey="+boardkey+"&saleuserkey="+saleuserkey
	+"&title="+title+"&nickname="+nickname;
	console.log(vo);
	
	if(confirm("거래 정보 확인한거 맞으신가요?")){
	$.ajax({
		type : 'post',
		url : '/site/makedeal',
		data : vo,
		success : function(result) {
			console.log("거래신청");
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
		<br> <b><font size="4" color="gray">거 래 신 청</font></b>
		<div id="chk">
		<table class="table">
				<tr>
					<td>거래 금액</td>
					<td><input type="text" id="money"/></td>
				</tr>
				<tr>
					<td>거래 신청인</td>
					<td>${userinfo.id }</td>
				</tr>
				<tr>
					<td>거래 상대방</td>
					<td>${cuserinfo.id }</td>
				</tr>
		
			</table>
			<input type="button" onclick="makedeal()" id="makedealBtn" value="거래신청"/>
		</div>
	</div>

</body>
</html>