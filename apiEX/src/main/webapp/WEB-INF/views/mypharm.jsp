<%@include file="includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


			<div class="row">
				<div class="col-xl-6">
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-chart-area me-1"></i> Area Chart Example
						</div>
						<div class="card-body">
							<canvas id="myAreaChart" width="100%" height="40"></canvas>
						</div>
					</div>
				</div>
				<div class="col-xl-6">
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-chart-bar me-1"></i> Bar Chart Example
						</div>
						<div class="card-body">
							<canvas id="myBarChart" width="100%" height="40"></canvas>
						</div>
					</div>
				</div>
			</div>
			<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-table me-1"></i> Mypharm
				</div>
				<div class="card-body">
					<table id="datatablesSimple">
						<thead>
							<tr>
								<th>회사명</th>
								<th>약품코드</th>
								<th>약품명</th>
								<th>유통기한</th>
								<th>남은수량</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>회사명</th>
								<th>약품코드</th>
								<th>약품명</th>
								<th>유통기한</th>
								<th>남은수량</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${myPharm}" var="medi">
								<tr>
									<td><c:out value="${medi.entpName }"></c:out></td>
									<td><c:out value="${medi.itemSeq }"></c:out></td>
									<td><a href="/modifymed?mediID=<c:out value="${medi.mediID}"/>" style="text-decoration-line: none; "><c:out value="${medi.itemName }"></c:out></a></td>
									<td><fmt:formatDate pattern="yyyy/MM/dd" value="${medi.dueDate}" /></td>
									<td><c:out value="${medi.amount}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
			</div>
		</div>
	</main>
<%@include file="includes/footer.jsp"%>
