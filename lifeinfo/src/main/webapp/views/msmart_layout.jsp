<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!doctype html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MS mart</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
		<meta http-equiv="Cache-Control" content="no-cache" />
		<meta name="format-detection" content="telephone=no" />
		<meta name="Keywords" content="ms,mart,msmart">
		<meta name="Description" content="ms마트 메인페이지">

		<link rel="stylesheet" href="http://getmall.co.kr/css/fontstyle.css" />
		<link rel="stylesheet" href="./resources/msmart/css/common.css" />
		<link rel="stylesheet" href="./resources/msmart/css/swiper.min.css" />
		<script type="text/javascript" src="./resources/msmart/js/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="./resources/msmart/js/swiper.min.js"></script>
	<style>
	.shinClass {
	display: inline;
	color: blue;};
	</style>
	</head>
	<body>
		<div class="msWrap">

			<!-- 상단메뉴 -->
			<div id="msHeaderApp"><!-- msHeader -->
				<div class="msAppDownload">
					<h1>MS</h1>
					앱 설치하고 혜택받기
					<button class="btnAppDown">앱다운</button>
				</div>

				<div class="msTopMenu">
					<ul class="msSiteTab">
						<li class="active">
							<img src="./resources/msmart/skin/default/img/tab_logo.png" class="tab_logo" alt="" />
							<span>생활정보</span>
						</li>
						<li onclick="location.href='list'">쇼핑하기</li>
					</ul>
					<div class="msSearch">
						<a href="#" class="btn_search"><!-- 검색 --></a>
					</div>
				</div>

				<div class="msNotice">
					<p><script src="./resources/js/result.js"></script></p>
				</div>

				<nav class="msCategory">
					<ul class="swiper-wrapper">
						<li class="swiper-slide"><a href="#" class="active">홈</a></li>
						<li class="swiper-slide"><a href="#">뉴스</a></li>
						<li class="swiper-slide"><a href="#">내가 전하는 우리지역 소식</a></li>
						<li class="swiper-slide"><a href="#">날씨정보</a></li>
						<li class="swiper-slide"><a href="#">영화정보</a></li>
						<li class="swiper-slide"><a href="#">지역축제</a></li>
						<li class="swiper-slide"><a href="#">장애인 시설안내</a></li>
					</ul>
					<script>
						var swiper = new Swiper('.msCategory', {
							slidesPerView: 'auto',
							spaceBetween: 10, //메뉴간 여백
							freeMode: true
						});
					</script>
				</nav>
			</div>
			<!-- 상단메뉴 -->


			<!-- 메인본문 -->
			<div id="msContents"><!-- msContents -->
				<!-- 메인본문(슬라이드 배너) -->
				<div class="mainVisiulBanner">
					<ul class="swiper-wrapper">
						<li class="swiper-slide"><img src="./resources/msmart/pr_banner1.jpg" alt="" /></li>
						<li class="swiper-slide"><img src="./resources/msmart/pr_banner1.jpg" alt="" /></li>
						<li class="swiper-slide"><img src="./resources/msmart/pr_banner1.jpg" alt="" /></li>
					</ul>
					<div class="swiper-pagination"></div>
					<script>
						var swiper = new Swiper('.mainVisiulBanner', {
							pagination: {
								el: '.swiper-pagination',
								type: 'fraction',
							},
						});
					</script>
				</div>
				<!-- 메인본문(슬라이드 배너) -->


				<!-- 메인본문(본문 내용) -->
				<div class="mainContents">
					<!-- 생활정보 내용출력 -->
					<tiles:insertAttribute name="mainNews" />
				</div>
				<!-- 메인본문(본문 내용) -->
			</div>
			<!-- 메인본문 -->

			<!-- 하단메뉴/카피라이트 -->
			<div id="msFooter"><!-- msFooter -->
				<h4>(주)무상엠에스마트</h4>
				<p>대표 : 이원복</p>
				<p>주소 : 강원도 춘천시 충열로 79번길 37(우두동)</p>

				<div class="helpDesk">
					<span class="telephone">고객센터 : 033-243-8888</span> <a href="http://msmartshop.getmall.kr/m/board_list.php?board=qna" class="prqna">고객문의 게시판</a>
					<p>(평일 AM 09:00~PM 04:00, 토/일/공휴일 휴무)</p>
				</div>

				<p>사업자번호 : 221-81-33427 <a href="http://www.ftc.go.kr/www/bizCommList.do?key=232" class="bizcheck">사업자정보 확인</a></p>
				<p>통신판매신번호 : 제2011-강원-0001호</p>
				<p>개인정보관리자 : 이우균 차장(master@msretall.co.kr)<p>
				<p><a href="http://msmartshop.getmall.kr/m/agreement.php" class="policy">이용약관</a> <a href="http://msmartshop.getmall.kr/m/protect.php" class="protect">개인정보취급방침</a></p>

				<p class="copyright">Copyright (C) (주)무상엠에스마트. All rights reserved.</p>
			</div>
			<!-- 하단메뉴/카피라이트 -->

		</div><!-- msWrap -->
	</body>
</html>

