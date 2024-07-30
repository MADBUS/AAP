
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function() {
		var message = "${message}";
		var error = "${error}";
		if (message) {
			alert(message);
		}
		if (error) {
			alert(error);
		}
	}
</script>
</head>
<body>
	<c:choose>
		<c:when test="${empty isLogin || isLogin==false}">
			<h1>카카오 로그인</h1>
			<a
				href="https://kauth.kakao.com/oauth/authorize?client_id=bc19ac7c0d184c8fbf994a386db912f2&redirect_uri=http://localhost:8090/oauth&response_type=code">
				<img src="/resources/loginbtn.png">
			</a>
		</c:when>
		<c:otherwise>
			<h1>로그아웃 버튼</h1>
			<a
				href="https://kauth.kakao.com/oauth/logout?client_id=bc19ac7c0d184c8fbf994a386db912f2&logout_redirect_uri=http://localhost:8090/logout">
				<img src="/resources/loginbtn.png">
			</a>
			<h1>사용자 정보</h1>
			<c:if test="${not empty userInfo}">
				<p>닉네임: ${userInfo.kakao_account.profile.nickname}</p>
				<p>이메일: ${userInfo.kakao_account.email}</p>
				<img src="${userInfo.kakao_account.profile.profile_image_url}"
					alt="Profile Image">
			</c:if>
		</c:otherwise>
	</c:choose>
	<!--Start of Tawk.to Script-->

	<!--End of Tawk.to Script-->
</body>
</html>