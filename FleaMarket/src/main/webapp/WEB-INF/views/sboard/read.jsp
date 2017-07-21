<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../include/header.jsp"%>


<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<h2 class="w3-text-grey w3-padding-16">
			<i class="material-icons w3-margin-right w3-margin-left"></i>${boardinfo.title}</h2>

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
					<td colspan="2">${userinfo.nickname}</td>
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

		<!--  게시글 끝 -->
	</div>
	<form action="/sboard/list" method="post">
		<div style="padding: 10px">

			<center><!-- 이전글/다음글 쿼리문 수정하기 -->
				<a class="w3-button"
					href=/sboard/read?boardkey=${board.boardkey}>▲이전글</a> <input
					type="submit" value="목록으로" class="w3-button" /> <a
					class="w3-button" href=/sboard/read?boardkey=${board.boardkey}>▼다음글</a>
			</center>
		</div>

	</form>

	<!--  포스팅 폼 끝 -->

	<!-- End Right Column -->
</div>



<%@include file="../include/footer.jsp"%>