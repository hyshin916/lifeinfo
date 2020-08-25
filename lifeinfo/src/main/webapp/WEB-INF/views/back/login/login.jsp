
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 뷰포트 -->
<meta name="viewport" content="width=device-width" initial-scale="1">
<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>
<!-- 스타일시트 참조  -->
<link rel="stylesheet" href="./resources/franch/css/bootstrap.min2.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!-- 20.03.25 Author : Mr.shin -->
<script src="./resources/js/login/login.js"></script>
<!-- 20.03.25 Author : Mr.shin -->

<!-- 부트스트랩 JS  -->
<script src="./resources/franch/js/bootstrap.js"></script>


<title>CMS로그인페이지</title>
</head>
<style>
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}
s
.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
<body>
	<div class="container">

		<form class="form-signin">
			<h2 class="form-signin-heading">ms CMS</h2>
			<label for="inputEmail" class="sr-only">Email address</label> <input
				type="email" id="user_id" class="form-control"
				placeholder="Email address" required autofocus> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="user_passwd" class="form-control"
				placeholder="Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="button"
				id="loginBtn">로그인</button>
				<button class="btn btn-lg btn-primary btn-block" type="button"
				id="mem_register">회원가입</button>
		</form>

	</div>
</body>
</html>