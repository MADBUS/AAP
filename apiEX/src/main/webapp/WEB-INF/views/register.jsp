<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Login - SB Admin</title>
<link href="../resources/css/styles.css" rel="stylesheet" />
<script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body class="bg-primary">
    <div id="layoutAuthentication">
        <div id="layoutAuthentication_content">
            <main>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-5">
                            <div class="card shadow-lg border-0 rounded-lg mt-5">
                                <div class="card-header">
                                    <h3 class="text-center font-weight-light my-4">Signin</h3>
                                </div>
                                <form name="registerForm" action="/user/register" method="post"
                                    enctype="multipart/form-data" onsubmit="return validateForm()">
                                    <div class="card-body" >
                                        <table>
                                            <tbody>
                                                <tr>
                                                    <td>Email</td>
                                                    <td><input type="text" readonly="readonly"
                                                        name="memberEmail" value="${kakaoEmail}"></td>
                                                </tr>
                                                <tr>
                                                    <td>PW</td>
                                                    <td><input type="password" name="memberPw"></td>
                                                </tr>
                                                <tr>
                                                    <td>Confirm PW</td>
                                                    <td><input type="password" name="memberPwConfirm"></td>
                                                </tr>
                                                <tr>
                                                    <td>NAME</td>
                                                    <td><input type="text" name="memberName"></td>
                                                </tr>
                                                <tr>
                                                    <td>INSTITUTION</td>
                                                    <td><input type="text" name="memberAddress"></td>
                                                </tr>
                                                <tr>
                                                    <td>INSTITUTION TEL</td>
                                                    <td><input type="text" name="memberPhone"></td>
                                                </tr>
                                                <tr>
                                                    <td>Select File</td>
                                                    <td><input type="file" name="file"></td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="card-footer text-center py-3">
                                        <div class="small">
                                            <input class="btn" type="submit" value="SignIn">
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
        <div id="layoutAuthentication_footer">
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid px-4">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; Your Website 2023</div>
                        <div>
                            신원 확인까지 최소 3일에서 7일까지 걸립니다.
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="../resources/js/scripts.js"></script>
    <script type="text/javascript">
    function validateForm() {
        // 정규식 패턴
        var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,20}$/;

        // 입력 필드 값
        var memberPw = document.forms["registerForm"]["memberPw"].value;
        var memberPwConfirm = document.forms["registerForm"]["memberPwConfirm"].value;

        // 유효성 검사

        if (!passwordPattern.test(memberPw)) {
            alert("Password must be consist of 8 through 20 words which includes at least of one upper letter, one lowwer letter, one number and one special character.");
            return false;
        }

        if (memberPw !== memberPwConfirm) {
            alert(" not match up  PW and ConfirmPW");
            return false;
        }

        return true; // 유효성 검사를 통과한 경우 폼을 제출합니다.
    }
    </script>
</body>
</html>
