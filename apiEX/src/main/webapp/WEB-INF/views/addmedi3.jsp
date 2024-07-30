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

	<h1>약 등록</h1>
	<form action="/addPharm" method="post">
	<table>
		<tr>
			<td>회사명</td>
			<td><input type="text" readonly="readonly" name="entpName" value="<c:out value="${entpName}"/>"></td>
		</tr>
		<tr>
			<td>약품 번호</td>
			<td> <input type="text" readonly="readonly" name="itemSeq" value="<c:out value="${itemSeq} "></c:out>"> </td>
		</tr>
		<tr>
			<td>약품 명</td>
			<td> <input type="text" readonly="readonly" name="itemName" value="<c:out value="${itemName }"></c:out>"> </td>
		</tr>
		<tr>
			<td>유통 기한</td>
			<td>  <input type="text" name="dueDate" placeholder="yyyy/mm/dd"></td>
		</tr>
		<tr>
			<td>남은 수량</td>
			<td> <input type="text" name="amount" placeholder="숫자를 입력 해주세요"/> </td>
		</tr>
	</table>
	
	<input type="submit" value="등록">
	</form>
	<a href="/test">약검색</a>
	<a href="/mypharm">마이팜</a>
	
	
	
</body>
</html>