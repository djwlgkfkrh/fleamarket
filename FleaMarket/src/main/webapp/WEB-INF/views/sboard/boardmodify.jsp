<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%@include file="../include/header.jsp"%>
<center style="margin-top: 50px">
	<img src="/resources/image/FleaLogo1.png" style="margin-bottom: 50px">
</center>

<div class="container-fluid bg-3 text-center" style="max-width: 1400px">
	<div class="row">
		<h2 class="w3-text-grey w3-padding-16">
			<i class="material-icons w3-margin-right w3-margin-left"></i> 게시글 작성
		</h2>

		<!--  포스팅 폼 시작  -->
		<form action="/sboard/boardmodify" method="post" enctype="multipart/form-data">
			<div style="padding: 30px">
			<input type="hidden" name="boardkey" value="${boardinfo.boardkey }"/>
				<table class="w3-table w3-bordered w3-large">
					<tr>
						<!-- 
						<td colspan="2"><span class="w3-text-grey">카테고리 선택</span></td>
						<td><select class="w3-select w3-border" name="group1">
								<option value="" disabled selected>Choose your option</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
						</select></td>
						<td><select class="w3-select w3-border" name="group2">
								<option value="" disabled selected>Choose your option</option>
								<option value="1">Option 1</option>
								<option value="2">Option 2</option>
								<option value="3">Option 3</option>
						</select></td> -->
						<td><input type="text" name="group1" value="${boardinfo.group1}"/></td>
						<td><input type="text" name="group2" value="${boardinfo.group2}"/></td>
					</tr>

					<tr>
						<td style="width: 100px;"><span class="w3-text-grey">제목</span></td>
						<td><input type="text" class="w3-input w3-animate-input" name="title" value="${boardinfo.title}"/></td>
					<tr>
						<td style="width: 100px;"><span class="w3-text-grey">작성자</span></td>
						<td>${userinfo.nickname}<input type="hidden" value="${userinfo.userkey}" name="userkey" /></td>
					</tr>

					<tr>
						<td><span class="w3-text-grey">작성날짜</span></td>
						<td colspan="2"> <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardinfo.regdate}"/>${boardinfo.regdate}</td>
					</tr>
					<tr>
						<td><span class="w3-text-grey">판매상태</span></td>
						<td colspan="2"><span class="w3-text-grey">${boardinfo.salestate}
					</tr>


					<!--  사진 첨부 시작  -->
					<tr>
						<td><span class="w3-text-grey">사진첨부</td>
						<td><input type="file" name="file" value="${getFile.fname}"/></td>
						<td><input type="file" name="file" value="${getFile.fname}"/></td>
						<td><input type="file" name="file" value="${getFile.fname}"/></td>
					</tr> <!--  사진 첨부 버튼 끝 -->
					
				</table>
				


				<!--  게시글 시작  -->
				<br>

				<div class="w3-input w3-border w3-round"  rows="70%" cols="30%" style="margin-top: 5px" >
				<br><br>
					<c:forEach var="getFile" items="${fileinfo}">
						<img style="margin-left:10%;" src="${pageContext.request.contextPath}/resources/upload/${getFile.fname}" width="300" height="300">
					</c:forEach>
					<br><br><br><br>
					<textarea style="margin-bottom:5;" rows="10" cols="120" name="text" value="${boardinfo.text}">${boardinfo.text}</textarea>
		
				</div>

			</div>
			<!--  게시글 끝 -->


			<div style="padding: 10px">
				<center>
					<input type="reset" value="Reset" class="w3-button w3-dark-grey" />
					<input type="submit" value="Modify" class="w3-button w3-dark-grey" />
				</center>
			</div>

		</form>

		<!--  포스팅 폼 끝 -->

		<!-- End Right Column -->
	</div>

	<!-- End Grid -->
</div>

<!-- End Page Container -->



<%@include file="../include/footer.jsp"%>