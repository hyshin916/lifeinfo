
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>MSmart</title>

<!-- Bootstrap core CSS -->
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../resources/css/dashboard.css" rel="stylesheet">
</head>
<script src="../resources/js/jquery-3.2.1.min.js"></script>
<script src="../resources/js/passwd/reset.js"></script>
<body>
	<div class="container" style="text-align: center;">
		<h2>앱 패스워드 초기화</h2>
		<form class="form-inline" role="form">
			<input onkeypress="if(event.keyCode==13){return false;}" type="text"
				class="form-control" placeholder="핸드폰 번호" id="id"> <input
				type="button" class="btn btn-primary" value="초기화" id="reset">
		</form>
	</div>

</body>
</html>
