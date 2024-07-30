<%@include file="includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="card mb-4">
	<div class="card-header">
		<i class="fas fa-table me-1"></i> Modify Own Medicine
	</div>
	<div class="card-body">
		<form action="/modsuccess" method="get">
			<table class="datatable-table">
				<tr>
					<td>작성날짜</td>
					<td><c:out value="${prescript.issueDate}" /></td>
				</tr>
				<tr>
					<td>환자명</td>
					<td><c:out value="${prescript.memberName} "></c:out></td>
				</tr>
				<tr>
					<td>주민등록 번호</td>
					<td><c:out value="${prescript.ssn}"></c:out></td>
				</tr>
				<tr>
					<td>처방 기관</td>
					<td><c:out value="${prescript.prescribingInstitution}"></c:out></td>
				</tr>
				<tr>
					<td>처방 기관</td>
					<td><c:out value="${prescript.prescribingInstitution}"></c:out></td>
				</tr>
				<tr>
					<td>처방의</td>
					<td><c:out value="${prescript.prescribingDoctor}"></c:out></td>
				</tr>
				<tr>
					<td>약사명</td>
					<td><c:out value="${prescript.pharmacistName}"></c:out></td>
				</tr>
			</table>
		</form>
	</div>
</div>

<div class="card mb-4">
	<div class="card-header">
		<i class="fas fa-table me-1"></i> 처방전 Detail
	</div>
	<div class="card-body">
		<table id="datatablesSimple">
			<thead>
				<tr>
					<th>NO</th>
					<th>처방전 번호</th>
					<th>약 고유번호</th>
					<th>약이름</th>
					<th>하루 투여량</th>
					<th>총일 투여랑</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${prescriptDetail}" var="prescriptedMed">
					<tr>
						<td><c:out value="${prescriptedMed.prescriptionDetailID}"></c:out></td>
						<td><c:out value="${prescriptedMed.prescriptionID}"></c:out></td>
						<td><c:out value="${prescriptedMed.mediID}"></c:out></td>
						<td><c:out value="${prescriptedMed.itemName}"></c:out></td>
						<td><c:out value="${prescriptedMed.perDays}"></c:out></td>
						<td><c:out value="${prescriptedMed.totalDays}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<button>
	<a href="/delprescript?prescriptionID=<c:out value="${prescript.prescriptionID}"/>" style="text-decoration-line: none; ">삭제</a>
</button>

</div>
</main>
<%@include file="includes/footer.jsp"%>