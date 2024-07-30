<%@include file="includes/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="card mb-4">
    <div class="card-header">
        <i class="fas fa-table me-1"></i> Modify Own Medicine
    </div>
    <div class="card-body">
       	<form action="/addPharm" method="post">
            <table class="datatable-table">
             
                <tr>
                    <td>회사명</td>
                    <td><input type="text" readonly="readonly" name="entpName" value="<c:out value="${entpName}"/>"></td>
                </tr>
                <tr>
                    <td>약품 번호</td>
                    <td><input type="text" readonly="readonly" name="itemSeq" value="<c:out value="${itemSeq}"/>"></td>
                </tr>
                <tr>
                    <td>약품 명</td>
                    <td><input type="text" readonly="readonly" name="itemName" value="<c:out value="${itemName}"/>"></td>
                </tr>
                <tr>
                    <td>효능</td>
                    <td><input type="text" readonly="readonly" name="efcyQesitm" value="<c:out value="${efcyQesitm}"/>"></td>
                </tr>
                <tr>
                    <td>사용법</td>
                    <td><input type="text" readonly="readonly" name="useMethodQesitm" value="<c:out value="${useMethodQesitm}"/>"></td>
                </tr>
                <tr>
                    <td>주성분</td>
                    <td><input type="text" readonly="readonly" name="intrcQesitm" value="<c:out value="${intrcQesitm}"/>"></td>
                </tr>
                <tr>
                    <td>부작용</td>
                    <td><input type="text" readonly="readonly" name="seQesitm" value="<c:out value="${seQesitm}"/>"></td>
                </tr>
                <tr>
                    <td>보관방법</td>
                    <td><input type="text" readonly="readonly" name="depositMethodQesitm" value="<c:out value="${depositMethodQesitm}"/>"></td>
                </tr>
                <tr>
                    <td>약품 이미지</td>
                    <td><img src="<c:out value="${itemImage}"/>"></td>
                </tr>
                <tr>
                    <td>사업자 번호</td>
                    <td><input type="text" readonly="readonly" name="bizrno" value="<c:out value="${bizrno}"/>"></td>
                </tr>
                <tr>
                    <td>유통 기한</td>
                    <td><input type="text" name="dueDate" placeholder="yyyy/mm/dd"></td>
                </tr>
                <tr>
                    <td>남은 수량</td>
                    <td><input type="text" name="amount" placeholder="숫자를 입력 해주세요" /></td>
                </tr>
            </table>

            <input type="submit" value="등록">
        </form>
    </div>
</div>

<%@include file="includes/footer.jsp"%>