
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


</head>
<script src="../../resources/js/jquery-3.2.1.min.js"></script>
<script src="../../resources/js/passwd/reset.js"></script>
<body>
	<div class="container" style="text-align: center;width:100%;">
		<h2>신규앱(쇼핑몰) 회원정보(비밀번호,이름,닉네임) 초기화</h2>
		<p style="color:black;font-size:20px;">[신규앱에서 본인인증 및 비번초기화 원활하지  않을 시 대응]</p>
		<p style="color:blue;">※ 비빌번호는 기재된 비밀번호로 초기화 되며 개인적으로 비번변경시 '쇼핑몰 내 비밀번호 초기화' 기능을 안내해 주시 길 바랍니다.</p>
		<p style="color:blue;">※ 추가정보 입력시 같이 초기화 됩니다.</p>
		<p style="color:red;">※ 최초 신규 회원가입 본인인증 시 반드시 핸드폰 실 소유자와 명의자가 일치해야 합니다.</p>
		<form class="form-inline" role="form">
		<table class="table table-striped">
			<tr>
				<td><input onkeypress="if(event.keyCode==13){return false;}" type="text"
				class="form-control" placeholder="핸드폰 번호" id="new_id"></td>
				<td><input onkeypress="if(event.keyCode==13){return false;}" type="password"
				class="form-control" placeholder="초기화 패스워드" id="passwd"></td>
				<td><input onkeypress="if(event.keyCode==13){return false;}" type="text"
				class="form-control" placeholder="이름" id="new_name"></td>
				<td><input onkeypress="if(event.keyCode==13){return false;}" type="text"
				class="form-control" placeholder="닉네임" id="nickname"></td>
				<c:if test="${groupID eq 'admin' || groupID eq 'ms_001'}">
				<td><input onkeypress="if(event.keyCode==13){return false;}" type="text"
				class="form-control" placeholder="회원코드" id="no_coad"></td>
				<td><input onkeypress="if(event.keyCode==13){return false;}" type="text"
				class="form-control" placeholder="회원카드번호" id="no_card_sc"></td>
				</c:if>
			    <td><input type="button" class="btn btn-primary" value="초기화" id="new_reset"></td>
			</tr>
		</table>
				
		</form>
	</div>


	<div class="container" style="text-align: center;width:100%;">
	
		<h2>구 홍보앱 회원정보(패스워드) 초기화</h2>
		<p style="color:black;font-size:20px;">[신규앱에 한번도 로그인 하지 않은 구 홍보앱 고객이 비번이 생각나지 않을 시 대응]</p>
		<p style="color:blue;">※ 비빌번호는 1234로 초기화 되며 개인적으로 비번변경시 '쇼핑몰 내 비밀번호 초기화' 기능을 안내해 주시 길 바랍니다.</p>
		<form class="form-inline" role="form">
		<table class="table table-striped">
			<tr><td><input onkeypress="if(event.keyCode==13){return false;}" type="text"
				class="form-control" placeholder="핸드폰 번호" id="id"><input
				type="button" class="btn btn-primary" value="초기화" id="reset"></td>
			</tr>
			</table>
		</form>
	</div>

</body>
</html>
