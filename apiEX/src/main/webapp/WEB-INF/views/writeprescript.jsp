<%@page import="com.test.api.model.MemberDTO"%>
<%@include file="includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
MemberDTO memberDTO = (MemberDTO) session.getAttribute("member_info");
%>
<div class="card mb-4">
	<div class="card-header">
		<i class="fas fa-table me-1"></i> Prescript
	</div>
	<div class="card-body">
		<form action="insertprescript" method="post">
			<table class="datatable-table">
				<tr>
					<td>환자 성명</td>
					<td><input type="text" name="patientName" id="patientName"></td>
					<td>주민 번호</td>
					<td><input type="text" name="SSN" id="SSN">
					<button type="button" id="lookupBtn">조회</button></td>
					<td>전화 번호</td>
					<td><input type="text" name="phoneNum" id="phoneNum"></td>
					<td><button type="button" id="registerPatient">등록</button></td>
				</tr>
				<tr>
					<td>발행기관</td>
					<td><input type="text" name="prescribingInstitution"
						value="<%=memberDTO.getMemberAddress()%>"></td>
					<td>처방의</td>
					<td><input type="text" name="prescribingDoctor"></td>
					<td>약사명</td>
					<td><input type="text" name="pharmacistName"
						value="<%=memberDTO.getMemberName()%>"></td>
					<td>투약 일수</td>
					<td><input type="text" name="prescriptedDate"></td>
				</tr>
				<tr>
					<td>약 고유번호</td>
					<td><input type="text" name="medicineId" id="medicineId"></td>
					<td>약 이름</td>
					<td><input type="text" name="medicineName" id="medicineName"></td>
					<td>투약량</td>
					<td><input type="text" name="perDays"></td>
					<td>투약일</td>
					<td><input type="text" name="totalDays"></td>
					<td><button type="button" id="addMedicine">등록</button></td>
				</tr>
			</table>
			<table class="datatable-table" id="medicineTable">
				<thead>
					<tr>
						<th>고유번호</th>
						<th>약품명</th>
						<th>투약량</th>
						<th>투약일</th>
						<th>작업</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1<input type="hidden" name="mediID[]" value="1"></td>
						<td>활명수<input type="hidden" name="itemName[]" value="활명수"></td>
						<td>3<input type="hidden" name="pd[]" value="3"></td>
						<td>3<input type="hidden" name="td[]" value="3"></td>
						<td><button type="button" class="deleteBtn">삭제</button></td>
					</tr>
				</tbody>
			</table>
			<input type="submit" value="작성">
		</form>
		<div class="card mb-4">
			<div class="card-header">
				<i class="fas fa-table me-1"></i> Mypharm
			</div>
			<div class="card-body">
				<table id="datatablesSimple">
					<thead>
						<tr>
							<th>고유번호</th>
							<th>회사명</th>
							<th>약품코드</th>
							<th>약품명</th>
							<th>유통기한</th>
							<th>남은수량</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>고유번호</th>
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
								<td><c:out value="${medi.mediID}"></c:out></td>
								<td><c:out value="${medi.entpName}"></c:out></td>
								<td><c:out value="${medi.itemSeq}"></c:out></td>
								<td><a href="#" class="medicine-link"
									data-id="${medi.mediID}" data-name="${medi.itemName}"
									style="text-decoration-line: none;"><c:out
											value="${medi.itemName}"></c:out></a></td>
								<td><fmt:formatDate pattern="yyyy/MM/dd"
										value="${medi.dueDate}" /></td>
								<td><c:out value="${medi.amount}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#lookupBtn").click(function(){
        var ssn = $("#SSN").val();
        $.ajax({
            url: "lookupPatient", // URL of the controller
            type: "post",
            data: { SSN: ssn },
            dataType: "json",
            success: function(response) {
                console.log("response체크"+response.memberName);
                if (response.success) {
                    $("#patientName").val(response.memberName);
                    $("#phoneNum").val(response.phoneNum);
                } else {
                    alert("환자 정보를 찾을 수 없습니다.");
                }
            },
            error: function() {
                alert("오류가 발생했습니다.");
            }
        });
    });

    $("#registerPatient").click(function(){
        var ssn = $("#SSN").val();
        var name = $("#patientName").val();
        var phoneNum = $("#phoneNum").val();
        $.ajax({
            url: "registerpatient", // URL of the controller
            type: "post",
            data: {
                memberName: name,
                ssn: ssn,
                phoneNum: phoneNum
            },
            dataType: "json",
            success: function(response) {
                console.log("response체크"+response);
                if (response) {
                    alert("환자 정보를 추가등록 했습니다.");
                } else {
                    alert("환자 정보를 찾을 수 없습니다.");
                }
            },
            error: function() {
                alert("오류가 발생했습니다.");
            }
        });
    });

    // Add click event listener for medicine links
    $(document).on('click', '.medicine-link', function(e) {
        e.preventDefault();
        var medicineId = $(this).data('id');
        var medicineName = $(this).data('name');
        $('#medicineId').val(medicineId);
        $('#medicineName').val(medicineName);
    });

    // Add medicine to the table
    $("#addMedicine").click(function(){
        var medicineId = $("#medicineId").val();
        var medicineName = $("#medicineName").val();
        var perDays = $("input[name='perDays']").val();
        var totalDays = $("input[name='totalDays']").val();
		console.log("메디슨 아이디찍힘?"+medicineId);
		console.log("메디슨 아이디찍힘?"+medicineName);
		console.log("메디슨 아이디찍힘?"+perDays);
		console.log("메디슨 아이디찍힘?"+totalDays);
        if (medicineId && medicineName && perDays && totalDays) {
            var newRow = '<tr><td>'+medicineId+'<input type="hidden" name="mediID[]" value="'+medicineId+'"></td><td>'+medicineName+'<input type="hidden" name="itemName[]" value="'+medicineName+'"></td><td>'+perDays+'<input type="hidden" name="pd[]" value="'+perDays+'"></td><td>'+totalDays+'<input type="hidden" name="td[]" value="'+totalDays+'"></td><td><button type="button" class="deleteBtn">삭제</button></td></tr>';
            $("#medicineTable tbody").append(newRow);
        } else {
            alert("모든 필드를 입력하세요.");
        }
    });

    // Delete row from table
    $(document).on('click', '.deleteBtn', function() {
        $(this).closest('tr').remove();
    });
});

function ajaxTest() {
    let find = $("#searchInput").val();
    console.log("검색어: " + find);

    $.ajax({
        url: "ajaxTest",
        type: "post",
        dataType: "json",
        data: { "search": find },
        success: function(data) {
            // 결과 테이블을 비웁니다.
            $('.resultTestApi tbody').empty();
            
            // 데이터 구조에 따라 처리합니다.
            // 데이터가 List<MedicineResponse> 형태로 되어 있다고 가정합니다.
            // 데이터가 List<MedicineResponse> 형태로 되어 있다고 가정합니다.
            $.each(data, function(index, response) {
                $.each(response.body.items, function(idx, item) {
                    // 새로운 행 생성
                  
                    var tr = $("<tr>");

                    // 각 항목을 셀로 추가
                    tr.append($("<td>").text(item.entpName));
                    tr.append($("<td>").text(item.itemSeq));
                    tr.append($("<td>").html("<a href='/medidetail?itemSeq=" + item.itemSeq + "'>" + item.itemName + "</a>"));
                    tr.append($("<td>").html("<img src='" + item.itemImage + "' alt='약품 이미지' style='width: 100px; height: auto;'>"));

                    // 행을 테이블에 추가
                    $('.resultTestApi tbody').append(tr);
                });
            });
        },
        error: function(xhr, status, error) {
            console.error("AJAX 요청 실패:", status, error);
        }
    });
}
</script>

<%@include file="includes/footer.jsp"%>