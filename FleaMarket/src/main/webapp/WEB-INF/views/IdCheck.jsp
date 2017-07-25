<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>아이디 중복 체크</title>

<style type="text/css">
#wrap {
	width: 490px;
	text-align: center;
	margin: 0 auto 0 auto;
}

#chk {
	text-align: center;
}

#cancelBtn {
	visibility: visible;
}

#useBtn {
	visibility: hidden;
}
</style>

</head>
<body onload="pValue()">
	<script type="text/javascript">
		/* 
		    var httpRequest = null;
		    
		    // httpRequest 객체 생성
		    function getXMLHttpRequest(){
		        var httpRequest = null;
		    
		        if(window.ActiveXObject){
		            try{
		                httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
		            } catch(e) {
		                try{
		                    httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		                } catch (e2) { httpRequest = null; }
		            }
		        }
		        else if(window.XMLHttpRequest){
		            httpRequest = new window.XMLHttpRequest();
		        }
		        return httpRequest;    
		    }
		 */

		// 회원가입창의 아이디 입력란의 값을 가져온다.
		function pValue() {
			document.getElementById("userId").value = opener.document.joinUser.id.value;
		}

		// 아이디 중복체크
		function idCheck() {

			var checkid = $('#userId').val();

			if (!checkid) {
				alert("아이디를 입력하지 않았습니다.");
				return false;
			}
			/*   else if((id < "0" ||id > "9") && (id < "A"|| id> "Z") && (id < "a" || id > "z")){ 
			      alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
			      return false;
			  } */
			else {
				$.ajax({
					type:"GET",		
					data : {
								checkid : checkid
							},
							url : '/userIdCheck/'+checkid,
							success : function(data) {
								if (data == 'YES') {
									document.getElementById("cancelBtn").style.visibility = 'hidden';
									document.getElementById("useBtn").style.visibility = 'visible';
									document.getElementById("msg").innerHTML = "사용 가능한 아이디입니다.";
								} else if (data == 'NO') {
									alert("사용할수없는 아이디입니다.");
									document.getElementById("cancelBtn").style.visibility = 'visible';
									document.getElementById("useBtn").style.visibility = 'hidden';
									document.getElementById("msg").innerHTML = "";
								}
							}
						});
			}
		}

		// 사용하기 클릭 시 부모창으로 값 전달 
		function sendCheckValue() {
			// 중복체크 결과인 idCheck 값을 전달한다.
			opener.document.joinUser.idDuplication.value = "idCheck";
			// 회원가입 화면의 ID입력란에 값을 전달
			opener.document.joinUser.id.value = document
					.getElementById("userId").value;

			if (opener != null) {
				opener.chkForm = null;
				self.close();
			}
		}
	</script>
	<div id="wrap">
		<br> <b><font size="4" color="gray">아이디 중복체크</font></b>
		<hr size="1" width="460">
		<br>
		<div id="chk">
			<form id="checkForm">
				<input type="text" name="checkid" id="userId"> <input
					type="button" value="중복확인" onclick="idCheck()">
			</form>
			<div id="msg"></div>
			<br> <input id="cancelBtn" type="button" value="취소"
				onclick="window.close()"><br> <input id="useBtn"
				type="button" value="사용하기" onclick="sendCheckValue()">
		</div>
	</div>
</body>
</html>