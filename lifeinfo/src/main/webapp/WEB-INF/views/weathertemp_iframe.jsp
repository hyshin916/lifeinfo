<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>MS마트 eshop 모바일 - 생활뉴스</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=yes, height=device-height, maximum-scale=2.0, target-densityDpi=device-dpi">
<!--<meta http-equiv="Cache-Control" content="no-cache" />-->
<meta name="format-detection" content="telephone=no" />
<link href="./resources/front/css/style.css" type="text/css"
	rel="stylesheet">
<link href="./resources/front/css/jquery-ui.css" type="text/css"
	rel="stylesheet">
<link href="./resources/front/tabmenu/swiper.min.css" type="text/css"
	rel="stylesheet">
<script src="./resources/front/js/jquery-3.2.1.min.js"></script>
<script src="./resources/front/tabmenu/swiper.min.js"></script>
<!--  Author : Shin -->

<script src="./resources/front/js/script.js"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.15/jquery.bxslider.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.15/jquery.bxslider.min.css" rel="stylesheet" /> -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script type="text/javascript">
	function shop_goto() {
		location.href = 'http://ms-eshop.co.kr/';
	}
</script>
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async
	src="https://www.googletagmanager.com/gtag/js?id=G-LX1WXY6SJN"></script>
<script>
	window.dataLayer = window.dataLayer || [];
	function gtag() {
		dataLayer.push(arguments);
	}
	gtag('js', new Date());
	gtag('config', 'G-LX1WXY6SJN');
</script>

</head>
<body>
	<div class="msWrap">

		<!-- 상단메뉴 -->
		<div id="msHeaderApp">
			<!-- msHeader -->
			<c:if test="${appChk eq 0 }">
				<div class="msAppDownload">
					<h1>MS</h1>
					앱 설치하고 혜택받기
					<button class="btnAppDown">앱다운</button>
				</div>
			</c:if>
			<div class="msTopMenu" id="gotop">
				<ul class="msSiteTab">
					<li class="active"><img
						src="./resources/msmart/skin/default/img/mstoday_logo.png"
						class="tab_logo" alt="" /> <span>TODAY뉴스</span></li>
					<li class="nonActive" onclick="shop_goto();"><span>쇼핑하기</span></li>
				</ul>
				<!-- <div class="msSearch">
					<a href="#" class="btn_search">
						검색
					</a>
				</div> -->
			</div>
			<div
				style="position: relative; width: 100%; height: auto; overflow: hidden;">
				<iframe id="my_frame" name="my_frame" onload="processingComplete()"
					style="display: block; width: 100vw; height: 100vh;"
					src="http://www.mstoday.co.kr/index.html" scrolling="yes"
					allowtransparency="true" frameborder="0"
					sandbox="allow-same-origin allow-scripts allow-top-navigation-by-user-activation">
				</iframe>
			</div>
			<ul class="todayFooterFixMenu">
				<li><a href="http://183.111.169.187:8080/lifeinfo/msmart">홈</a>
				</li>
			</ul>
		</div>

	</div>
</body>
</html>


