
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

<title>Crawling Product information</title>

<link href="./resources/css/weather-icons.css" rel="stylesheet">
<link href="./resources/css/weather-icons-wind.css" rel="stylesheet">
<link href="./resources/css/weather-icons-wind.min.css" rel="stylesheet">
<link href="./resources/css/weather-icons.min.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="./resources/css/dashboard.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
.shinClass {
	display: inline;
	color: blue;
}
;
</style>
</head>

<style>
.iframe100 {
	display: block;
	border: none;
	height: 100vh;
	width: 100vw;
}
</style>
<body>


		<!-- <script src="./resources/js/jquery.min.js"/> -->
	<img src="./resources/images/msmart.jpg" />
	<div style="width: 100%;">
		<script src="./resources/js/result.js"></script>
	</div>
	<tiles:insertAttribute name="main" />
 	<tiles:insertAttribute name="mainNews" /> 
<tiles:insertAttribute name="festival" /> 
	<%-- <tiles:insertAttribute name="positionInfra" /> --%>

	<script>
		function setIFrameHeight(obj) {

			if (obj.contentDocument) {

				obj.height = obj.contentDocument.body.offsetHeight + 40;
			} else {

				obj.height = obj.contentWindow.document.body.scrollHeight;

			}

		}
	</script>
	<style>
.agree_iframe .iframeDiv {
	width: 698px;
	height: 500px;
	margin-bottom: -1px;
	border: 1px solid #d9d9d9;
	overflow: scroll;
	overflow-x: hidden;
	-webkit-overflow-scrolling: touch;
}

iframe {
	overflow: hidden;
	display: inline-block;
	width: 100%;
	height: 2000px;
	border: 0;
	background: transparent;
}
</style>
	<div class="iframeDiv nate_agree">
		<iframe
			src="https://192.168.0.13:8443/open/positionInfra?x=127.76898559999998&y=37.876531199999995"
			id="main_frame" scrolling="no" frameborder="0"></iframe>
	</div>
<link rel="stylesheet"
		href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="./resources/js/bootstrap.min.js"></script>
	<script src="./resources/js/infra.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="../../assets/js/vendor/holder.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			$("#datepicker1").datepicker({
				dateFormat : 'yy-mm-dd',
			});
			$("#datepicker2").datepicker({
				dateFormat : 'yy-mm-dd',
			});
		});
	</script>
	<script type="text/javascript">
		$('#shinnav').find('ul>li').bind('click', function() {

			$except = $(this);
			$except.attr('class', 'active');
			$('#shinnav').find('ul>li').not($except).removeClass('active');

		});
	</script>
	<script src="./resources/js/common.js"></script>
</body>
</html>
