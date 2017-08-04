<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


			<select  id="group1" class="w3-select" style="width:250" name="group1" onChange="showSub(this.options[this.selectedIndex].value);">
			
				<option value="" >대분류</option>
				<option value="전자제품">전자제품</option>
				<option value="사무용품">사무용품</option>
				<option value="취미용품">취미용품</option>
				<option value="생활용품">생활용품</option>
			</select> 
			
			
			<select id="SUB0"  class="w3-select" style="display: ;width:250" onChange="getSubValue(this.options[this.selectedIndex].value);">
				<option value="">소분류</option>
			</select>  
			
			<select id="SUB1"  class="w3-select" style="display: none; width:250" onChange="getSubValue(this.options[this.selectedIndex].value);">
			 	<option value="주방가전">주방가전</option>
				<option value="생활가전">생활가전</option>
				<option value="컴퓨터/노트북">컴퓨터/노트북</option>
				<option value="난방기">난방기</option>
				<option value="핸드폰/태블릿">핸드폰/태블릿</option> 
			</select> 
			
			<select id="SUB2"  class="w3-select" style="display: none;width:250" onChange="getSubValue(this.options[this.selectedIndex].value);">
			
	 		<option value="사무실용품">사무실용품</option>
				<option value="종이류">종이류</option>
				<option value="펜/샤프">펜/샤프</option>
				<option value="노트">노트</option>
				<option value="문구용">문구용</option>
			</select> 
			
			<select id="SUB3" class="w3-select"  style="display: none;width:250" onChange="getSubValue(this.options[this.selectedIndex].value);">
				<option value="운동기구">운동기구</option>
				<option value="해양스포츠용품">해양스포츠용품</option>
				<option value="산악용품">산악용품</option>
				<option value="조깅용품">조깅용품</option>
				<option value="비행용품">비행용품</option>
			</select> 

			<select id="SUB4" class="w3-select" style="display: none;width:250" onChange="getSubValue(this.options[this.selectedIndex].value);">
				<option value="편의용품">편의용품</option>
				<option value="청소용품">청소용품</option>
				<option value="주방용품">주방용품</option>
				<option value="침구류">침구류</option>
				<option value="가구류">가구류</option>
			</select> 



	