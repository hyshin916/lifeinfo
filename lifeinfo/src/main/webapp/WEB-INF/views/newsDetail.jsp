


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
<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum=scale=1.0,minimum-scale=1.0,user-scalable=no">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1" />
<link rel="icon" href="../../favicon.ico">

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.js"></script>
<title>Crawling Product information</title>

<!-- Bootstrap core CSS -->
<link href="http://${moreNewsURL}:8080/lifeinfo/resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="http://${moreNewsURL}:8080/lifeinfo/resources/css/dashboard.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<!-- <script src="../../assets/js/ie-emulation-modes-warning.js"></script> -->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=G-LX1WXY6SJN"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());
  gtag('config', 'G-LX1WXY6SJN');
</script>
</head>
<link rel="stylesheet" href="http://${moreNewsURL}:8080/lifeinfo/resources/css/newsDetail.css" />
<script>
	$(document).ready(function() {

		$('.newsBack').on('click', function() {
			history.back();
		});

		$('.homeBack').on('click', function() {
			location.href = "http://ms-eshop.co.kr/";
		});

	});

</script>

<body>
<div data-role="page"
	style="background-image: linear-gradient(#fff, #fff);">
	<div data-role="header" data-position="fixed">
		<c:if test="${section eq 'morenewslist'}"><a href="http://${moreNewsURL}:8080/lifeinfo/moreNewsList"></c:if>
			<img src="http://${moreNewsURL}:8080/lifeinfo/resources/images/back.png"
			style="float: left; margin: 15px; width: 30px; height: 30px;" 
			class="newsBack">
			<c:if test="${section eq 'morenewslist'}"></a></c:if>
			
		<h3>
		<c:if test="${section eq 'morenewslist'}"><a href="http://ms-eshop.co.kr/"></c:if>
			<img
				style="position: relative; margin: 10px; width: 100px; height: 20px;"
				src="http://${moreNewsURL}:8080/lifeinfo/resources/msmart/skin/default/img/tab_logo.png" class="homeBack"><c:if test="${section eq 'morenewslist'}"></a></c:if>
		</h3>
	</div>

	<tiles:insertAttribute name="main" />
	
<%-- 	<div style="height:50px;" data-role="footer" data-position="fixed">
		<c:if test="${section eq 'morenewslist'}"><a style="position:absolute;"   href="http://${moreNewsURL}:8080/lifeinfo/moreNewsList"></c:if>
		<img src="http://${moreNewsURL}:8080/lifeinfo/resources/images/back.png"
			style="float: left; margin: 15px; width: 20px; height: 20px;"
			class="newsBack"><c:if test="${section eq 'morenewslist'}"></a></c:if>
		<h3>
		<c:if test="${section eq 'morenewslist'}"><a  style="position:relative;left:15px;" href="http://ms-eshop.co.kr/"></c:if>
			<img style="margin: 2px 100px 2px 60px; width: 20px; height: 20px;"
				src="http://${moreNewsURL}:8080/lifeinfo/resources/images/home.png" class="homeBack"><c:if test="${section eq 'morenewslist'}"></a></c:if>
		</h3>
	</div> --%>
</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="http://${moreNewsURL}:8080/lifeinfo/resources/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<!-- 	<script src="../../assets/js/vendor/holder.js"></script> -->
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<!-- 	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script> -->
<!--   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"> -->
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker1" ).datepicker({
        dateFormat: 'yy-mm-dd',
    });
    $( "#datepicker2" ).datepicker({
        dateFormat: 'yy-mm-dd',
    });
  } );
  </script>
	<script type="text/javascript">
		$('#shinnav').find('ul>li').bind('click', function() {

			$except = $(this);
			$except.attr('class', 'active');
			$('#shinnav').find('ul>li').not($except).removeClass('active');

		});
	</script>
	<script src="http://${moreNewsURL}:8080/lifeinfo/resources/js/common.js"></script>
</body>
</html>
