<%@include file="includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="card mb-4">
	<div class="card-header">
		<i class="fas fa-table me-1"></i> 처방전
	</div>
	<div class="card-body">
		<table id="datatablesSimple">
			<thead>
				<tr>
					<th>조제일</th>
					<th>NO</th>
					<th>고객명</th>
					<th>주민 번호</th>
					<th>처방 기관</th>
					<th>처방의</th>
					<th>약사명</th>
					<th>일수</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>조제일</th>
					<th>NO</th>
					<th>고객명</th>
					<th>주민 번호</th>
					<th>처방 기관</th>
					<th>처방의</th>
					<th>약사명</th>
					<th>일수</th>
				</tr>
			</tfoot>
			<tbody>
				<c:forEach items="${prescriptList}" var="cusData">
					<tr >
						<td><fmt:formatDate pattern="yyyy/MM/dd"
								value="${cusData.issueDate}" /></td>
						<td><a href="/modifyprescript?prescriptionID=<c:out value="${cusData.prescriptionID}"/>" style="text-decoration-line: none; "><c:out value="${cusData.prescriptionID}"></c:out></a></td>
						<td><c:out value="${cusData.memberName}"></c:out></td>
						<td><c:out value="${cusData.ssn}"></c:out></td>
						<td><c:out value="${cusData.prescribingInstitution}"></c:out></td>
						<td><c:out value="${cusData.prescribingDoctor}"></c:out></td>
						<td><c:out value="${cusData.pharmacistName}"></c:out></td>
						<td><c:out value="${cusData.prescriptedDate}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>



</div>
</main>

<%@include file="includes/footer.jsp"%>
