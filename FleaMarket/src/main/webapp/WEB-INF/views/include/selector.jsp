<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form name="group">
	<select id="group1" class="w3-select w3-border" style="width: 125" name=""
		onChange="showSub(this.options[this.selectedIndex].value);">
		<option value=""
			<c:out value= "${cri.group1 == 'null' ?'selected':''}"/>>대분류</option>
		<option value="전자제품"
			<c:out value= "${cri.group1 eq '전자제품' ?'selected':''}"/>>전자제품</option>
		<option value="사무용품"
			<c:out value="${cri.group1 eq '사무용품' ?'selected':''}"/>>사무용품</option>
		<option value="취미용품"
			<c:out value="${cri.group1 eq '취미용품' ?'selected':''}"/>>취미용품</option>
		<option value="생활용품"
			<c:out value="${cri.group1 eq '생활용품' ?'selected':''}"/>>생활용품</option>
	</select> <select id="group2" class="w3-select w3-border" name="SUB0"
		style="display:; width: 125"
		onChange="getSubValue(this.options[this.selectedIndex].value);">
		<option value=""
			<c:out value="${cri.group2  == 'null' ?'selected':''}"/>>소분류</option>
	</select> <select id="group2" class="w3-select w3-border" name="SUB1"
		style="display: none; width: 125"
		onChange="getSubValue(this.options[this.selectedIndex].value);">
		<option value="주방가전"
			<c:out value="${cri.group2 eq'주방가전' ?'selected':''}"/>>주방가전</option>
		<option value="생활가전"
			<c:out value="${cri.group2 eq '생활가전' ?'selected':''}"/>>생활가전</option>
		<option value="컴퓨터/노트북"
			<c:out value="${cri.group2 eq '컴퓨터/노트북' ?'selected':''}"/>>컴퓨터/노트북</option>
		<option value="난방기"
			<c:out value="${cri.group2 eq '난방기' ?'selected':''}"/>>난방기</option>
		<option value="핸드폰/태블릿"
			<c:out value="${cri.group2 eq '핸드폰/태블릿' ?'selected':''}"/>>핸드폰/태블릿</option>
	</select> <select id="group2" class="w3-select w3-border" name="SUB2"
		style="display: none; width: 125"
		onChange="getSubValue(this.options[this.selectedIndex].value);">
		<option value="사무실용품"
			<c:out value="${cri.group2 eq '사무실용품' ?'selected':''}"/>>사무실용품</option>
		<option value="종이류"
			<c:out value="${cri.group2 eq '종이류' ?'selected':''}"/>>종이류</option>
		<option value="펜/샤프"
			<c:out value="${cri.group2 eq '펜/샤프' ?'selected':''}"/>>펜/샤프</option>
		<option value="노트"
			<c:out value="${cri.group2 eq '노트' ?'selected':''}"/>>노트</option>
		<option value="문구용"
			<c:out value="${cri.group2 eq '문구용' ?'selected':''}"/>>문구용</option>
	</select> <select id="group2" class="w3-select w3-border" name="SUB3"
		style="display: none; width: 125"
		onChange="getSubValue(this.options[this.selectedIndex].value);">
		<option value="운동기구"
			<c:out value="${cri.group2 eq '운동기구' ?'selected':''}"/>>운동기구</option>
		<option value="해양스포츠용품"
			<c:out value="${cri.group2 eq '해양스포츠용품' ?'selected':''}"/>>해양스포츠용품</option>
		<option value="산악용품"
			<c:out value="${cri.group2 eq '산악용품' ?'selected':''}"/>>산악용품</option>
		<option value="조깅용품"
			<c:out value="${cri.group2 eq '조깅용품' ?'selected':''}"/>>조깅용품</option>
		<option value="비행용품"
			<c:out value="${cri.group2 eq '비행용품' ?'selected':''}"/>>비행용품</option>
	</select> <select id="group2" class="w3-select w3-border" name="SUB4"
		style="display: none; width: 125"
		onChange="getSubValue(this.options[this.selectedIndex].value);">
		<option value="편의용품"
			<c:out value="${cri.group2 eq '편의용품' ?'selected':''}"/>>편의용품</option>
		<option value="청소용품"
			<c:out value="${cri.group2 eq '청소용품' ?'selected':''}"/>>청소용품</option>
		<option value="주방용품"
			<c:out value="${cri.group2 eq '주방용품' ?'selected':''}"/>>주방용품</option>
		<option value="침구류"
			<c:out value="${cri.group2 eq '침구류' ?'selected':''}"/>>침구류</option>
		<option value="가구류"
			<c:out value="${cri.group2 eq '가구류' ?'selected':''}"/>>가구류</option>
	</select>

</form>









<script language="javascript">
	//상위 셀렉트로 하위 셀렉트 제어하기
	function showSub(obj) {
		console.log(obj);
		f = document.forms.group;

		if (obj == null) {

			f.SUB0.style.display = "";
			f.SUB1.style.display = "none";
			f.SUB2.style.display = "none";
			f.SUB3.style.display = "none";
			f.SUB4.style.display = "none";

		} else if (obj == "전자제품") {

			f.SUB0.style.display = "none";
			f.SUB1.style.display = "";
			f.SUB2.style.display = "none";
			f.SUB3.style.display = "none";
			f.SUB4.style.display = "none";

		} else if (obj == "사무용품") {

			f.SUB0.style.display = "none";
			f.SUB1.style.display = "none";
			f.SUB2.style.display = "";
			f.SUB3.style.display = "none";
			f.SUB4.style.display = "none";

		} else if (obj == "취미용품") {

			f.SUB0.style.display = "none";
			f.SUB1.style.display = "none";
			f.SUB2.style.display = "none";
			f.SUB3.style.display = "";
			f.SUB4.style.display = "none";

		} else if (obj == "생활용품") {

			f.SUB0.style.display = "none";
			f.SUB1.style.display = "none";
			f.SUB2.style.display = "none";
			f.SUB3.style.display = "none";
			f.SUB4.style.display = "";

		}
	}
</script>

