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
							<td>회사명</td>
							<td><c:out value="${medi.entpName}" /></td>
						</tr>
						<tr>
							<td>약품 번호</td>
							<td><c:out value="${medi.itemSeq} "></c:out></td>
						</tr>
						<tr>
							<td>약품 명</td>
							<td><c:out value="${medi.itemName }"></c:out></td>
						</tr>
						<tr>
							<td>유통 기한</td>
							<td><input type="text" name="dueDate"
								value="<fmt:formatDate pattern="yyyy/MM/dd" value="${medi.dueDate}" />"></td>
						</tr>
						<tr>
							<td>남은 수량</td>
							<td><input type="text" name="amount"
								value="<c:out value="${medi.amount }"/>"></td>
						</tr>

					</table>
					<input type="hidden" name="mediID" value="${medi.mediID }">
					<input type="submit" value="수정">
					<button> <a href="/deletemedi?mediID=${medi.mediID}" style="text-decoration-line: none; color: black;">삭제</a></button>
					</form>
				</div>
			</div>
		</div>
	</main>
	<%@include file="includes/footer.jsp"%>