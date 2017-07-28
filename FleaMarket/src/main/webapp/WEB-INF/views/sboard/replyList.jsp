<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  댓글읽기 -->
	


	<c:forEach items="${reply}" var="Comment">
		<c:set var="cuserkey" value="${Comment.userkey}" />
		<c:set var="secret" value="${Comment.secret}" />
		<div>
			<c:choose>
				<c:when
					test="${uuserkey==buserkey||uuserkey==cuserkey||secret==false}">
					<h4>
						${Comment.userkey} <span class="w3-opacity w3-medium"> <fmt:formatDate
								pattern="yyyy-MM-dd HH:mm" value="${Comment.regdate}" />
						</span>

						<c:choose>
							<c:when test="${cuserkey!=uuserkey&&uuserkey!=null}">
								<span class="w3-opacity w3-medium"><a href="#">답글</a></span>
							</c:when>
							<c:when test="${cuserkey==uuserkey}">
								<span class="w3-opacity w3-medium"> <a href="#"
									onclick="replyModify(${Comment.commentkey})">수정</a> | <a
									href="#" onclick="replyDelete(${Comment.commentkey})">삭제</a>
								</span>
							</c:when>
						</c:choose>
					</h4>
					<p style="margin-left: 10px">${Comment.context}</p>

				</c:when>
				<c:otherwise>
					<p>
						비밀 댓글입니다.<span class="w3-opacity w3-medium"> <fmt:formatDate
								pattern="yyyy-MM-dd HH:mm" value="${Comment.regdate}" />
						</span>
					</p>
				</c:otherwise>
			</c:choose>
		</div>
		<hr style="border: dotted 0.5px; opacity: 0.1; width: 95%;">
	</c:forEach>
</body>
</html>