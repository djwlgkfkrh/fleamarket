<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@include file="../include/header.jsp"%>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>


<center style="margin-top: 50px">
	<img src="/resources/image/FleaLogo1.png" style="margin-bottom: 50px">
</center>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<h2 class="w3-text-grey w3-padding-16">
			<i class="material-icons w3-margin-right w3-margin-left"></i>${boardinfo.title}
		</h2>
		<!--  포스팅 폼 시작  -->
		<div style="padding: 30px">
			<table class="w3-table w3-bordered w3-large w3-centered">
				<tr>
					<td><span class="w3-text-grey">카테고리 </span></td>
					<td>${boardinfo.group1}</td>
					<td>${boardinfo.group2}</td>
				</tr>
				<tr>
					<td><span class="w3-text-grey">제목 </span></td>
					<td colspan="2">${boardinfo.title}</td>
				<tr>
					<td style="width: 100px;"><span class="w3-text-grey">작성자
					</span></td>
					<td colspan="2">${boarduser.nickname}</td>
				</tr>
				<tr>
					<td><span class="w3-text-grey">작성날짜</span></td>
					<td colspan="2"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
							value="${boardinfo.regdate}" /></td>
				</tr>
				<tr>
					<td><span class="w3-text-grey">판매상태</span></td>
					<td colspan="2"><span class="w3-text-grey">${boardinfo.salestate}



							<div class="w3-input w3-border w3-round" style="margin-top: 5px; width: 100%; min-height: 230px; text-align: left !important">
								<c:forEach var="getFile" items="${fileinfo}">
									<img style="margin-left: 36%;"
										src="${pageContext.request.contextPath}/resources/upload/${getFile.fname}"
										width="300" height="300">
									<br>
								</c:forEach>
								<br>
								<br> ${boardinfo.text} <br> <br>


							</div> <!-- 포스팅 글 수정/삭제 버튼 출력 시작  -->
							<div>
								<c:set var="userkey" value="${userinfo.userkey}" />
								<c:set var="b_userkey" value="${boardinfo.userkey}" />

								<table style="margin-left: 80%">
									<tr>
										<td><c:if test="${userkey == b_userkey}">
												<form action="./delete" method="post">
													<input type="hidden" name="boardkey"
														value="${boardinfo.boardkey}" />
													<button class="w3-button w3-dark-grey">Delete</button>
												</form></td>
										<td>
											<form action="./boardmodify">
												<input type="hidden" name="boardkey"
													value="${boardinfo.boardkey}" />
												<button class="w3-button w3-dark-grey">Modify</button>
											</form> </c:if>
										</td>
									</tr>
								</table>

							</div> <!-- 포스팅 글 수정/삭제 버튼 출력 끝  -->


					</span></td>
				</tr>
			</table>
			<br>

			<!--  게시글 끝 -->
		</div>

		<!-- 찜하기부분 -->
		<c:choose>
			<c:when test="${not empty sessionScope.userinfo}">
				<c:set value="${cart}" var="cart" />
				<c:choose>
					<c:when test="${cart==0}">
						<center>
							<button class=" btn w3-white w3-card"
								style="width: 100px; height: 90px; text-align: center"
								onclick="heart();">
								<div class="w3-container" onmouseover="mouseOver()"
									onmouseout="mouseOut()">
									<span id="heart"
										style="font-size: 50px; color: red; margin-top: 5px;"
										class=" glyphicon glyphicon-heart-empty"></span><br> <span
										style="color: red; font-size: 15px">찜하기</span>
								</div>
							</button>

						</center>
					</c:when>
					<c:otherwise>
					<center>
							<button class=" btn w3-white w3-card"
								style="width: 100px; height: 90px; text-align: center"
								onclick="dealheart();">
								<div class="w3-container">
									<span id="heart"
										style="font-size: 50px; color: red; margin-top: 5px;"
										class=" glyphicon glyphicon-heart"></span><br> <span
										style="color: red; font-size: 15px">찜하기</span>
								</div>
							</button>

						</center>
					</c:otherwise>
				</c:choose>
			</c:when>
		</c:choose>
		<script>
			function mouseOver() {
				document.getElementById("heart").className = "glyphicon glyphicon-heart";
			}
			function mouseOut() {
				document.getElementById("heart").className = "glyphicon glyphicon-heart-empty";
			}
			function heart() {
				console.log("heart");
				var boardkey = "${boardinfo.boardkey}";
				var userkey = "${userinfo.userkey}";
				var vo = "boardkey=" + boardkey + "&userkey=" + userkey;
				$.ajax({
					type : 'post',
					url : '/sboard/cart',
					data : vo,
					success : function(result) {
						
						window.location.reload(true);
					}
				});
			}
			function dealheart() {
				console.log("heart");
				var boardkey = "${boardinfo.boardkey}";
				var userkey = "${userinfo.userkey}";
				var vo = "boardkey=" + boardkey + "&userkey=" + userkey;
				$.ajax({
					type : 'post',
					url : '/sboard/dealcart',
					data : vo,
					success : function(result) {
						window.location.reload(true);
					}
				});
			}
		</script>
		<hr>
		<!--  댓글부분 -->
		<div style="text-align: left !important; margin-left: 50px">
			<button type="button" onclick="listReplyBtn()"
				class="w3-blue w3-button">댓글보기</button>
			<br>
			<div id="listReply"></div>
			<!--  댓글쓰기영역 -->
			<div>
				<c:choose>
					<c:when test="${not empty sessionScope.userinfo}">
						<div class="w3-row w3-section">
							<label class="w3-text-blue"><br>댓글쓰기</label> <br>
							<table>
								<tr>
									<td><textarea name="context" id="context"
											class=" w3-border w3-light-grey" cols="100%"></textarea></td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp; <input class="w3-check"
										type="checkbox" id="secret" name="secret">비밀댓글
									</td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;
										<button type="button" onclick="replyAdd()"
											class="w3-blue w3-button">등록</button>
									</td>
								</tr>
							</table>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
</div>
<!--  게시글 끝 -->
<!--  select List -->
<form action="/sboard/list" method="post">

	<input type="hidden" name="boardkey" value="${boardinfo.boardkey}" />
	<div style="padding: 10px">
		<center>
			<a class="w3-button"
				href='/sboard/beforeread?boardkey=${boardinfo.boardkey}'>▼이전글</a> <input
				type="submit" value="목록으로" class="w3-button" /> <a
				class="w3-button"
				href='/sboard/afterread?boardkey=${boardinfo.boardkey}'>▲다음글</a>
		</center>
	</div>

</form>

<!--   끝 -->


<!--   끝 -->

<script id="replyread" type="text/x-handlebars-template"> 

{{#unless parent_key}}
<div id="reply_div">
{{#isBoarduser userkey secret}}
<h4>
{{nickname}} <span class="w3-opacity w3-medium">{{prettifyDate regdate}}
</span>
{{#isMe userkey}}
<span class="w3-opacity w3-medium"><a  onclick="replySubBtn({{commentkey}})">답글</a></span>
{{/isMe}}

{{#isMeq userkey}}
<span class="w3-opacity w3-medium"> <a 
		onclick="replyModifyBtn({{commentkey}})">수정</a> | <a
		 onclick="replyDelete({{commentkey}})">삭제</a>
	</span>
{{/isMeq}}
<p style="margin-left: 10px">{{context}}</p>


{{else}}
<p>
비밀 댓글입니다.<span class="w3-opacity w3-medium"> {{prettifyDate regdate}}
	</span>
</p>
{{/isBoarduser}}
</div>

{{else}}				
<div id="reply_div" style="margin-left: 30px">
{{#isBoarduser userkey secret}}
<h4>
{{nickname}} <span class="w3-opacity w3-medium">{{prettifyDate regdate}}
</span>
{{#isMe userkey}}
<span class="w3-opacity w3-medium"><a  onclick="replySubBtn({{commentkey}})">답글</a></span>
{{/isMe}}

{{#isMeq userkey}}
<span class="w3-opacity w3-medium"> <a 
		onclick="replyModifyBtn({{commentkey}})">수정</a> | <a
		 onclick="replyDelete({{commentkey}})">삭제</a>
	</span>
{{/isMeq}}
<p style="margin-left: 10px">{{context}}</p>


{{else}}
<p>
비밀 댓글입니다.<span class="w3-opacity w3-medium"> {{prettifyDate regdate}}
	</span>
</p>
{{/isBoarduser}}

</div>
{{/unless}}

<hr style="border: dotted 0.5px; opacity: 0.1; width: 95%;">
</script>
<script id="listReply2d" type="text/x-handlebars-template">
<br>
<table>
<tr>
<td><textarea name="mcontext" id="mcontext"	class=" w3-border w3-light-grey" cols="80%"></textarea></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp; <input class="w3-check"
type="checkbox" id="msecret" name="msecret">비밀댓글
</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;
<button type="button" onclick="replyModify({{commentkey}})"
class="w3-blue w3-button">수정</button></td>
</tr>
</table>
<hr style="border: dotted 0.5px; opacity: 0.1; width: 95%;">
</script>

<script id="listReply3d" type="text/x-handlebars-template">
<table>
<tr>
<td><textarea name="rcontext" id="rcontext"	class=" w3-border w3-light-grey" cols="80%"></textarea></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp; <input class="w3-check"
type="checkbox" id="rsecret" name="rsecret">비밀댓글
</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;
<button type="button" onclick="replySub({{commentkey}})"
class="w3-blue w3-button">완료</button></td>
</tr>
</table>
</script>
<script>
	Handlebars.registerHelper('isMe', function(userkey, options) {
		var uuserkey = "${userinfo.userkey}";
		if (userkey != uuserkey && uuserkey != null) {
			return options.fn(this);
		} else {
			return options.inverse(this);
		}
	});
	Handlebars.registerHelper('isMeq', function(userkey, options) {
		var uuserkey = "${userinfo.userkey}";
		if (userkey == uuserkey) {
			return options.fn(this);
		} else {
			return options.inverse(this);
		}
	});
	Handlebars.registerHelper('isBoarduser',
			function(userkey, secret, options) {
				var buserkey = "${boardinfo.userkey}";
				var uuserkey = "${userinfo.userkey}";
				if (buserkey == uuserkey || uuserkey == userkey
						|| secret == false) {
					return options.fn(this);
				} else {
					return options.inverse(this);
				}
			});
	Handlebars.registerHelper("prettifyDate", function(timeValue) {
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	});
	var printData1 = function(replyArr, targetDiv, handleBarTemplateName) {
		var template = Handlebars.compile(handleBarTemplateName.html());
		$(targetDiv).append(template(replyArr));
	}
	var printData2 = function(replyArr, targetDiv) {
		var theTemplateScript = $("#listReply2d").html();
		var theTemplate = Handlebars.compile(theTemplateScript);
		$(targetDiv).append(theTemplate(replyArr));
	}
	var printData3 = function(replyArr, targetDiv) {
		var theTemplateScript = $("#listReply3d").html();
		var theTemplate = Handlebars.compile(theTemplateScript);
		$(targetDiv).append(theTemplate(replyArr));
	}
	function listReplyBtn() {
		console.log("listReplyBtn");
		listReply();
	}
	function replyModifyBtn(commentkey) {
		listReply2(commentkey);
	}
	function replySubBtn(commentkey) {
		listReply3(commentkey);
	}
	function replyAdd() {
		var context = $('#context').val();
		var boardkey = "${boardinfo.boardkey}";
		var userkey = "${userinfo.userkey}";
		var nickname = "${userinfo.nickname}";
		var secret = $('input:checkbox[id="secret"]').is(":checked");
		var vo = "boardkey=" + boardkey + "&context=" + context + "&userkey="
				+ userkey + "&secret=" + secret + "&nickname=" + nickname;
		$.ajax({
			type : 'post',
			url : '/reply/addReply',
			data : vo,
			success : function(result) {
				
				listReply();
				
			}
		});
	}
	function replyDelete(commentkey) {
		console.log("replyDelete");
		$.ajax({
			type : 'post',
			url : '/reply/delete/' + commentkey,
			dataType : 'text',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "post"
			},
			success : function(result) {
				listReply();
			}
		});
	}
	function listReply() { //대댓글이 가능하도록 얘랑 templete or handlerbar 수정하기
		var boardkey = "${boardinfo.boardkey}";
		var uuserkey = "${userinfo.userkey}";
		var buserkey = "${boardinfo.userkey}";
		$.ajax({
			type : "POST",
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			url : "/reply/list?boardkey=" + boardkey,
			success : function(result) {
				document.getElementById("listReply").innerHTML = "";
				for ( var i in result) {
					printData1(result[i], $("#listReply"), $("#replyread"));
				}
			}
		});
	}
	
	function replyModify(commentkey) {
		var context = $('#mcontext').val();
		var secret = $('input:checkbox[id="msecret"]').is(":checked");
		var vo = "context=" + context + "&secret=" + secret;
		$.ajax({
			type : 'post',
			data : vo,
			url : '/reply/modify/' + commentkey,
			success : function() {
				listReply();
			}
		});
	}
	function listReply2(commentkey) {
		var boardkey = "${boardinfo.boardkey}";
		$
				.ajax({
					type : "POST",
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "POST"
					},
					url : "/reply/list?boardkey=" + boardkey,
					success : function(result) {
						document.getElementById("listReply").innerHTML = "";
						for ( var i in result) {
							if (commentkey == result[i].commentkey) {
								printData2(result[i], $("#listReply"),
										$("#replyread2"));
							} else {
								printData1(result[i], $("#listReply"),
										$("#replyread"));
							}
						}
					}
				});
	}
	function listReply3(commentkey) {
		var boardkey = "${boardinfo.boardkey}";
		$
				.ajax({
					type : "POST",
					headers : {
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "POST"
					},
					url : "/reply/list?boardkey=" + boardkey,
					success : function(result) {
						document.getElementById("listReply").innerHTML = "";
						for ( var i in result) {
							if (commentkey == result[i].commentkey) {
								printData1(result[i], $("#listReply"),
										$("#replyread"));
								printData3(result[i], $("#listReply"),
										$("#replyread2"));
							} else {
								printData1(result[i], $("#listReply"),
										$("#replyread"));
							}
						}
					}
				});
	}
	function replySub(commentkey) {
		console.log("replySub들어옴");
		var boardkey = "${boardinfo.boardkey}";
		var nickname = "${userinfo.nickname}";
		var userkey = "${userinfo.userkey}";
		var context = $('#rcontext').val();
		var secret = $('input:checkbox[id="rsecret"]').is(":checked");
		var vo = "boardkey=" + boardkey + "&userkey=" + userkey + "&context="
				+ context + "&secret=" + secret + "&nickname=" + nickname;
		$.ajax({
			type : 'post',
			data : vo,
			url : '/reply/replySub/' + commentkey,
			success : function() {
				console.log("replysub성공");
				listReply();
			}
		});
	}
</script>

<%@include file="../include/footer.jsp"%>