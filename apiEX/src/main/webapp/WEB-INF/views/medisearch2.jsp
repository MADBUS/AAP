<%@include file="includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="card mb-4">
	<div class="card-header">
		<i class="fas fa-table me-1"></i> 약검색
	</div>
	<div class="card-body">
		<table id="datatablesSimple">
			<thead>
				<tr>
					<th>회사명</th>
					<th>약품코드</th>
					<th>약품명</th>
					<th>관리방법</th>
					<th>업로드 날짜
					<th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<th>회사명</th>
					<th>약품코드</th>
					<th>약품명</th>
					<th>관리방법</th>
					<th>업로드 날짜
					<th>
				</tr>
			</tfoot>
			<tbody id="resultTestApi">
			</tbody>
		</table>
	</div>
</div>
</div>
</main>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
	        url: "medsearch",
	        type: "get",
	        contentType: "application/json; charset=utf-8;",
	        dataType: "json",
	        success: function(data) {
	            console.log(data.body.items[0]);
	            $.each(data.body.items, function(index, item) {
	                var tr = $("<tr>");
	                $.each(item, function(key, value) {
	                    //console.log(key);        
	                    if(key=="itemImage"){
	                    	tr.append($("<td>").append($("<img>").attr("src", value)));
	                    }else if (key=="entpName"||key=="itemName"||key=="itemSeq"){
	                        tr.append($("<td>").text(value));
	                    }
	                    
	             	});
	                $('#resultTestApi').append(tr);
	            });
	                // 데이터베이스에 저장할 값을 버튼의 data-* 속성에 포함하여 전송
	             //tr.append($("<td>").html("<button class='addPharm' data-item-id='"+item.id+"'>등록</button>"));
	             
	      

	            // 클릭 이벤트 처리
	             // 버튼 클릭 이벤트 핸들러 추가
/* 	            $(".addPharm").on("click", function() {
	                let currentRow = $(this).closest("tr");
	                let rowData = [];
	                currentRow.find("td").each(function() {
	                    rowData.push($(this).text());
	                });
	                console.log("Row Data: ", rowData);
	                console.log("Row Data:0 ", rowData[0]);
	                self.location=" http://localhost:8090/addmedi?entpName="+rowData[0]+"&itemName="+rowData[1]+"&itemSeq="+rowData[2]; 
	                $.ajax({
	                    url: "/addmedi",
	                    type: "POST",
	                    contentType: "application/json; charset=utf-8;",
	                    data: JSON.stringify({
	                        entpName: rowData[0],
	                        itemName: rowData[1],
	                        itemSeq: rowData[2]
	                    }),
	                    success: function(response) {
	                    	
	                    	String redirectUrl = "localhost:8090/addmedi";
	                    	localStorage.setItem("resultValue", response.resultValue);
	                    	window.location.href = response.redirectUrl; // Redirect to /addmedi after successful AJAX call
	                    }
	                });
	                
	          }); */
	            
	            
	           
	            },
	        error: function() {
	            // 에러 처리
	        }
	    });	
	})
	
	</script>
<%@include file="includes/footer.jsp"%>
