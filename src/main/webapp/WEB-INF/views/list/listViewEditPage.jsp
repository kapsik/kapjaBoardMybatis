<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function check_onclick() {
		theForm = document.frm1;
	/* 	alert(theForm.btitle.value);
		alert(theForm.bcontent.value); */
		if(theForm.btitle.value=="" || theForm.bcontent.value==""){
			if(theForm.btitle.value==""){
				alert("제목을 입력하시오");
				return theForm.btitle.focus();
			}else if(theForm.bcontent.value==""){
				alert("내용을 입력하시오");
				return theForm.bcontent.focus();
			}
		}else{
			alert("좋았어");
			theForm.submit();
		}
	}
</script>
<body>
	<div id="listViewEditBody" align="center">
		<form action="listUpdate" name="frm1">
		<table border="1">
			<h1>갑자게시판(수정페이지)</h1>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
			
			<tr>
				<td>${data.bno }</td>
				<td><input hidden="hidden" /><input type="text" name="btitle" placeholder="${data.btitle }"> </td>
				<td><input hidden="hidden" />${data.bwriter }</td>
				<td>${data.bdate }</td>
				<td>${data.bhit }</td>
			</tr>
			<tr>
				<input type="hidden" name="bno" value="${data.bno }">
				<input type="hidden" name="bwriter" value="${data.bwriter }">
				<input type="hidden" name="bdate" value="${data.bdate }">
				<input type="hidden" name="bhit" value="${data.bhit }">
				<td colspan="5"><textarea rows="10" cols="55" name="bcontent" placeholder="${data.bcontent }"></textarea> </td>
			</tr>
		
		</table>
		<table>
			<tr>
				<td><a href="listViewPage"><input type="button" value="목록"></a></td>
				<c:set var="name" value=""></c:set>
				<c:if test="emtpy btitle"></c:if>
				<td><input type="button" value="확인" onclick="check_onclick()"></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>