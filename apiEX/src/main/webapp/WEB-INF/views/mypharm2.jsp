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
	<h1>My Pharm</h1>
 	<label for="mediSearch">약품명 입력:</label>
 	<input type="text" id="mediSearch">
 	<button onclick ="mediSearch()">검색</button>
	<table>
		<thead>
			<tr>
				<th>회사명</th>
				<th>약품코드</th>
				<th>약품명</th>
				<th>유통 기한</th>
				<th>남은 수량</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${myPharm }" var="medi">
				<tr>
					<td> <c:out value="${medi.entpName }"></c:out> </td>
					<td> <c:out value="${medi.itemSeq }"></c:out> </td>
					<td> <c:out value="${medi.itemName }"></c:out> </td>
					<td> <fmt:formatDate pattern="yyyy/MM/dd" value="${medi.dueDate}" /> </td>
					<td> <c:out value="${medi.amount}"></c:out> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button><a href="/test">약 추가</a></button>
	<button><a href="/prescription">약 처방</a></button>	
	<script type="text/javascript">
	function mediSearch() {
		let get = $("#mediSearch").val()
		self.location = "/mypharmsearch?itemName="+get;
	}
	</script>
</body>
</html>