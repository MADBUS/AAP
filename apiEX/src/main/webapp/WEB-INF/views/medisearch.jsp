<%@include file="includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="card mb-4">
	<div class="card-header">
		<i class="fas fa-table me-1"></i> 약 검색
	</div>
	<div class="card-body">
		<table id="datatablesSimple">
			<thead>
				<tr>
					<th>회사명</th>
					<th>약품코드</th>
					<th>약품명</th>
					<th>제품번호</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>회사명</th>
					<th>약품코드</th>
					<th>약품명</th>
					<th>제품번호</th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach items="${testapi}" var="response">
					<c:forEach items="${response.body.items}" var="medi">
						<tr>
							<td><c:out value="${medi.entpName }"></c:out></td>
							<td><c:out value="${medi.itemSeq }"></c:out></td>
							<td><a
								href="/addmedi?entpName=${medi.entpName}&itemName=${medi.itemName}&itemSeq=${medi.itemSeq}&efcyQesitm=${medi.efcyQesitm}&useMethodQesitm=${medi.useMethodQesitm}&intrcQesitm=${medi.intrcQesitm}&seQesitm=${medi.seQesitm}&depositMethodQesitm=${medi.depositMethodQesitm}&itemImage=${medi.itemImage}&bizrno=${medi.bizrno}"
								style="text-decoration-line: none;"><c:out
										value="${medi.itemName }"></c:out></a></td>
							<td><c:out value="${medi.bizrno}"></c:out></td>
						</tr>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</div>
</main>

<%@include file="includes/footer.jsp"%>
