<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<style type="text/css">
table,th,td{
	border: 1px solid black;
}
</style>
</head>

<body>

	<h1>수정</h1>
	<form action="/modsuccess" method="get">
	<table>
		<tr>
			<td>회사명</td>
			<td><c:out value="${medi.entpName}"/></td>
		</tr>
		<tr>
			<td>약품 번호</td>
			<td> <c:out value="${medi.itemSeq} "></c:out> </td>
		</tr>
		<tr>
			<td>약품 명</td>
			<td> <c:out value="${medi.itemName }"></c:out> </td>
		</tr>
		<tr>
			<td>유통 기한</td>
			<td>  <input type="text" name="dueDate" value="<fmt:formatDate pattern="yyyy/MM/dd" value="${medi.dueDate}" />"></td>
		</tr>
		<tr>
			<td>남은 수량</td>
			<td> <input type="text" name="amount" value="<c:out value="${medi.amount }"/>"> </td>
		</tr>
	</table>
	<input type="hidden" name="itemSeq" value="${medi.itemSeq }">
	<input type="submit" value="수정완료">
	</form>
	<a href="/deletemedi?itemSeq=${medi.itemSeq}">삭제</a>
	<a href="/mypharm">마이팜</a>
	
	
	
</body>
</html>