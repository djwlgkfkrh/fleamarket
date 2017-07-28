<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<%@include file="../include/header.jsp"%>

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
					<!--  사진 첨부 버튼 시작  -->
				</tr>
				<tr>
					<td><span class="w3-text-grey">작성날짜</span></td>
					<td colspan="2"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
							value="${boardinfo.regdate}" /></td>
				</tr>
				<tr>
					<td><span class="w3-text-grey">판매상태</span></td>
					<td colspan="2"><span class="w3-text-grey">${boardinfo.salestate}
					</span></td>
				</tr>
			</table>
			<br>
			<div class="w3-input w3-border w3-round"
				style="margin-top: 5px; width: 100%; min-height: 230px; text-align: left !important">${boardinfo.text}</div>
			<!--  게시글 끝 -->
		</div>

		<hr>
		<!--  댓글부분 -->
		<div style="text-align: left !important; margin-left: 50px">
			<button type="button" id="listReplyBtn" class="w3-blue w3-button">댓글보기</button>
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
										<button type="button" id="replyAdd" class="w3-blue w3-button">등록</button>
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

<form action="/sboard/list" method="post">
	<div style="padding: 10px; align: center;">
		<a class="w3-button"
			href='/sboard/beforeread?boardkey=${boardinfo.boardkey}'>▼이전글</a> <input
			type="submit" value="목록으로" class="w3-button" /> <a class="w3-button"
			href='/sboard/afterread?boardkey=${boardinfo.boardkey}'>▲다음글</a>
	</div>

</form>

<!--   끝 -->

<script id="replyread" type="text/x-handlebars-template"> 
{{#each .}}
<div>
{{#isBoarduser userkey secret}}
<h4>
{{userkey}} <span class="w3-opacity w3-medium">{{prettifyDate regdate}}
</span>
{{#isMe userkey}}
<span class="w3-opacity w3-medium"><a href="#">답글</a></span>
{{/isMe}}

{{#isMeq userkey}}
<span class="w3-opacity w3-medium"> <a href="#"
		onclick="replyModify({{commentkey}})">수정</a> | <a
		href="#" onclick="replyDelete({{context}})">삭제</a>
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
<hr style="border: dotted 0.5px; opacity: 0.1; width: 95%;">
{{/each}}
</script>


<script>
Handlebars.registerHelper('isMe', function(userkey,options) {

	var uuserkey = "${userinfo.userkey}";
	if (userkey!=uuserkey&&uuserkey!=null) {
		return options.fn(this);
	} else {
		return options.inverse(this);
	}
});


Handlebars.registerHelper('isMeq', function(userkey,options) {

	var uuserkey = "${userinfo.userkey}";
	if (userkey==uuserkey) {
		return options.fn(this);
	} else {
		return options.inverse(this);
	}
});
	Handlebars.registerHelper('isBoarduser', function(userkey,secret,options) {
		var buserkey = "${boardinfo.userkey}";
		var uuserkey = "${userinfo.userkey}";
		if (buserkey == uuserkey||uuserkey==userkey||secret==false) {
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
	$(document).ready(
			function() {
				$("#replyAdd").click(
						function() {
							var context = $('#context').val();
							var boardkey = "${boardinfo.boardkey}";
							var userkey = "${userinfo.userkey}";
							var secret = $('input:checkbox[id="secret"]').is(
									":checked");
							var vo = "boardkey=" + boardkey + "&context="
									+ context + "&userkey=" + userkey
									+ "&secret=" + secret;
							$.ajax({
								type : 'post',
								url : '/reply/addReply',
								data : vo,
								success : function(result) {
									console.log("replyAdd 성공");
									listReply();
								}
							});
						});

				var printData = function(replyArr, targetDiv,
						handleBarTemplateName) {

					console.log("printData 성공");
					var template = Handlebars.compile(handleBarTemplateName
							.html());
					var html = template(replyArr);
					targetDiv.html(html);

				}

				function replyDelete(commentkey) {
					$.ajax({
						type : 'POST',
						url : '/reply/delete?commentkey=' + commentkey,
						headers : {
							"Content-Type" : "application/json",
							"X-HTTP-Method-Override" : "POST"
						},
						success : function() {
							console.log("삭제 성공");
							listReply();
						}
					});
				}
				$("#listReplyBtn").click(function() {
					console.log("listReplyBtn");
					listReply();
				});

				function listReply() {
					console.log("list들어옴");
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
							for ( var i in result) {
								printData(result, $("#listReply"),
										$("#replyread"));
							}
						}

					});
				}
			});
	function replyModify(commentkey) {
		$.ajax({
			type : 'POST',
			url : '/reply/modify?commentkey=' + commentkey,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			success : function() {
				console.log("삭제 성공");
				listReply();
			}
		});
	}
</script>

<%@include file="../include/footer.jsp"%>