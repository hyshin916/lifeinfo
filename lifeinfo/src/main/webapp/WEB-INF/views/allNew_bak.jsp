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
<script src="./resources/front/js/jquery-3.2.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />

</head>
<body>
	<a class="basic_button1" href="#ex1" rel="modal:open">쿠폰인증</a>

	<script>
		$(document)
				.ready(
						function() {

							$('#cert')
									.on(
											'click',
											function() {
												/*   if($('#passwd').val()=="") {
												          alert("패스워드를 입력해주세요!");
												          return false;
												  }; */
												//      alert("<?=$_ShopInfo->getMemid()?>" + " : " + $('#passwd').val() + " : " +  "<?=$view_board?>" + " : " + "<?=$view_num?>");
												$
														.ajax({
															url : "http://localhost:8080/lifeinfo/msFranch.json?userID=1094275467&passwd=5588&view_num=1379&view_board=webzine",
															dataType : "jsonp",
															jsonp : "callback",
															success : function(
																	resp) {
																if (resp.isMember == '0') {
																	alert("인증실패, 입력 정보를 다시 한번 확인해주시기 바랍니다.");
																} else if (resp.isMember == '1') {
																	alert("인증성공, 회원 인증이 완료되었습니다.");
																}
															}
														});
											});
						});
	</script>


	<div id="ex1" class="modal">
		<p style="font-size: 20px;">사장님! 인증해 주세요!</p>
		<input type="password"
			style="width: 100%; height: 50px; font-size: 20px; color: #e9e9e9; border-radius: 4px;"
			id="passwd" placeholder="패스워드를 입력해주세요."> <input type="button"
			value="인증하기" id="cert"
			style="width: 100%; height: 50px; color: #FFF; background-color: #FF7F00; border-radius: 4px;">

	</div>

</body>
</html>
