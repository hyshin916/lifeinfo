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
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta name="format-detection" content="telephone=no" />
<meta name="Keywords" content="ms,mart,msmart">
<meta name="Description" content="ms마트 메인페이지">
<!-- 날씨정보 -->
<link href="./resources/css/weather-icons.css" rel="stylesheet">
<link href="./resources/css/weather-icons-wind.css" rel="stylesheet">
<link href="./resources/css/weather-icons-wind.min.css" rel="stylesheet">
<link href="./resources/css/weather-icons.min.css" rel="stylesheet">
<!-- 날씨정보 -->
<link rel="stylesheet" href="http://getmall.co.kr/css/fontstyle.css" />
<link rel="stylesheet" href="./resources/msmart/css/common.css" />
<link rel="stylesheet" href="./resources/msmart/css/swiper.min.css" />

<!--  Author : Shin -->
<script src="./resources/js/httpRequest.js"></script>
<script src="./resources/js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="./resources/css/news.css">
<link rel="stylesheet" href="./resources/css/newsDetail.css">
<script type="text/javascript"
	src="./resources/js/jquery.simplyscroll.js"></script>
<link rel="stylesheet" href="./resources/css/jquery.simplyscroll.css"
	media="all" type="text/css">
<!--  Author : Shin -->
<script type="text/javascript">
      (function($) {
        $(function() {
          $("#scroller").simplyScroll();
        });
      })(jQuery);
      function shop_goto() {
    	  location.href='http://ms-eshop.co.kr/';
      }
</script>
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async
	src="https://www.googletagmanager.com/gtag/js?id=G-LX1WXY6SJN"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
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
						src="./resources/msmart/skin/default/img/tab_logo.png"
						class="tab_logo" alt="" /> <span>TODAY뉴스</span></li>
					<li class="nonActive" onclick="shop_goto();"><span>쇼핑하기</span></li>
				</ul>
				<!-- <div class="msSearch">
					<a href="#" class="btn_search">
						검색
					</a>
				</div> -->
			</div>

			<%-- 	<div class="msNotice">
				<div class="scrollNews"><script src="http://${moreNewsURL}:8080/lifeinfo/resources/js/linenews.js"></script></div>
				<!-- <div style="width:300px;">
				  <p><span class="marquee"><span>The quick brown fox jumps over the lazy dog.</span></span></p>
				</div> -->
			</div> --%>

			<nav class="msCategory">
				<!-- <ul class="swiper-wrapper">
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
						slidesPerView : 'auto',
						spaceBetween : 10, //메뉴간 여백
						freeMode : true
					});
				</script> -->

				<link rel="stylesheet" href="./resources/tabmenu/swiper.min.css">
				<style>
html, body {
	position: relative;
	height: 100%;
}

body {
	background: #eee;
	font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
	font-size: 14px;
	color: #000;
	margin: 0;
	padding: 0;
}

.swiper-container {
	width: 100%;
	height: 100%;
}

.swiper-slide {
	text-align: center;
	font-size: background: #fff;
	/* Center slide text vertically */
	display: -webkit-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	-webkit-box-pack: center;
	-ms-flex-pack: center;
	-webkit-justify-content: center;
	justify-content: center;
	-webkit-box-align: center;
	-ms-flex-align: center;
	-webkit-align-items: center;
	align-items: center;
}
</style>
				<div class="swiper-container1">

					<ul class="swiper-wrapper">

						<li class="swiper-slide"><a href="#" class="active">생활뉴스</a></li>
						<li class="swiper-slide"><a
							href="javascript:alert('준비중입니다.');">우리동네<br>소식
						</a></li>
						<li class="swiper-slide"><a
							href="javascript:alert('준비중입니다.');">MS추천<br>알뜰쇼핑
						</a></li>
						<li class="swiper-slide"><a
							href="javascript:alert('준비중입니다.');">MS검색<br>랭킹
						</a></li>
					</ul>
					<!-- Add Pagination -->


				</div>

				<!-- Swiper JS -->

				<script src="./resources/tabmenu/swiper.min.js"></script>


				<!-- Initialize Swiper -->

				<script>
    var swiper = new Swiper('.swiper-container1', {
      slidesPerView: 4,
      spaceBetween: 0,
      freeMode: true
     /*  pagination: {
        el: '.swiper-pagination',
        clickable: true,
      }, */
    });
  </script>



			</nav>

		</div>
		<!-- 상단메뉴 -->


		<!-- 메인본문 -->
		<div id="msContents">
			<!-- msContents -->
			<!-- 메인본문(슬라이드 배너) -->

			<div class="mainContents" style="padding: 20px 20px; height: 140px;">
				<!-- 생활정보 내용출력 -->
				<tiles:insertAttribute name="main" />
			</div>



			<!-- 	<div class="mainVisiulBanner">


						<ul class="swiper-wrapper">
					<li class="swiper-slide"><img
						src="./resources/msmart/pr_banner1.jpg" alt="" /></li>
					<li class="swiper-slide"><img
						src="./resources/msmart/pr_banner1.jpg" alt="" /></li>
					<li class="swiper-slide"><img
						src="./resources/msmart/pr_banner1.jpg" alt="" /></li>
				</ul>
				<div class="swiper-pagination"></div>
				<script>
					var swiper = new Swiper('.mainVisiulBanner', {
						pagination : {
							el : '.swiper-pagination',
							type : 'fraction',
						},
					});
				</script>
			</div> -->
			<!-- 메인본문(슬라이드 배너) -->


			<div id="msContents">
				<div class="mainContents">
					<!-- 생활정보 내용출력 -->
					<tiles:insertAttribute name="mslifeList" />
				</div>

			</div>

			<div id="msContents">
				<div class="mainContents">
					<tiles:insertAttribute name="mainYoutube" />
				</div>
			</div>

			<!-- 메인본문(본문 내용) -->
			<div id="msContents">
				<div class="mainContents">
					<!-- 생활정보 내용출력 -->
					<tiles:insertAttribute name="mainNews" />
				</div>
			</div>

			<div id="msContents">
				<div class="mainContents">
					<!-- 생활정보 내용출력 -->
					<tiles:insertAttribute name="newsall" />
				</div>
			</div>

			<div id="msContents">
				<div class="mainContents">
					<!-- 생활정보 내용출력 -->
					<tiles:insertAttribute name="oilInfoList" />
				</div>
			</div>
			<style>
.move_scroll {
	position: fixed;
	right: 7px;
	bottom: 82px;
	z-index: 100;
}

.move_scroll .top {
	border-radius: 4px;
	width: 30px;
	line-height: 30px;
	background: rgba(255, 255, 255, 0.70);
	border: 1px solid #dddddd;
	color: #dddddd;
	text-align: center;
	-webkit-transform: rotate(180deg);
	transform: rotate(180deg);
	margin: 5px 0 0 0;
}

.move_scroll .bottom {
	border-radius: 4px;
	width: 30px;
	line-height: 30px;
	background: rgba(255, 255, 255, 0.70);
	border: 1px solid #dddddd;
	color: #dddddd;
	text-align: center;
	-webkit-transform: rotate(0deg);
	transform: rotate(0deg);
	margin: 5px 0 0 0;
}
</style>
			<div class="move_scroll">
				<a href="#gotop" rel="external"><div class="top">
						<img src="./resources/images/icon_arrow_bottom01.png">
					</div></a> <a href="#msFooter" rel="external"><div class="bottom">
						<img src="./resources/images/icon_arrow_bottom01.png">
					</div></a>
			</div>
			<%-- 			<div id="msContents">
				<div class="mainContents">
					<!-- 생활정보 내용출력 -->
					<tiles:insertAttribute name="festival" />
				</div>
			</div> --%>

			<!-- <div class="iframeDiv nate_agree">
				<iframe
					src="https://192.168.0.13:8443/lifeinfo/positionInfra?x=127.76898559999998&y=37.876531199999995"
					id="main_frame" scrolling="no" frameborder="0"></iframe>
			</div> -->
			<!-- 메인본문(본문 내용) -->
		</div>
		<!-- 메인본문 -->

		<link rel="stylesheet" href="./resources/css/jquery-ui.css">
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script>
 
  $(document).ready(function(){
	  $("#dialog").dialog({
		  create:function(){
				$(this).parent().css({position:"fixed"});
				$(this).parent().css({top:"0px"});
				$(this).parent().css({bottom:"80px"});
				$(this).parent().css({overflow:"auto"});
			},
			autoOpen:false,
			title: '사업자정보확인',
			modal: true,
			width: '92%',
			height: 'auto'
		}); 
  });
  function companyPOP() {
		$("#dialog").dialog("open");
		var aIframe = document.createElement("iframe");
		aIframe.style.width = "100%";
		aIframe.style.height = "600px";
		aIframe.frameborder = "0";
		aIframe.src = "http://www.ftc.go.kr/www/bizCommList.do?key=232";
		document.getElementById("dialog").appendChild(aIframe);
  	}
  </script>
		<style>
.ui-widget-overlay {
	background: #aaaaaa;
	opacity: .3;
	filter: Alpha(Opacity = 30);
}

.ui-widget-shadow {
	margin: -8px 0 0 -8px;
	padding: 8px;
	background: #aaaaaa;
	opacity: .3;
	filter: Alpha(Opacity = 30);
	border-radius: 8px;
}

.ui-dialog .ui-dialog-content {
	padding: 0.5em 0em;
	height: 100% !important;
}
</style>
		<div style="background-color: #fff;" id="dialog" title="사업자정보확인">
		</div>
		<!-- 하단메뉴/카피라이트 -->
		<div id="msFooter">
			<!-- msFooter -->
			<h4>(주)무상엠에스마트</h4>
			<p>대표 : 이원복</p>
			<p>주소 : 강원도 춘천시 충열로 79번길 37(우두동)</p>

			<div class="helpDesk">
				<span class="telephone">고객센터 : 033-243-8888</span><a
					href="http://ms-eshop.co.kr/m/board_list.php?board=qna"
					class="prqna">고객문의</a><a
					href="http://ms-eshop.co.kr/m/venderProposal.php"
					class="vdproposal">입점문의</a>
				<p>(평일 AM 09:00~PM 18:00, 토/일/공휴일 휴무)</p>
			</div>

			<p>
				사업자번호 : 221-81-33427 <a href="javascript:companyPOP()"
					class="bizcheck">사업자정보 확인</a>
			</p>
			<p>통신판매신고번호 : 제2011-강원-0001호</p>
			<p>개인정보관리자 : 이진혁 계장(webmaster@msretail.co.kr)
			<p>
			<p>
				<a href="http://ms-eshop.co.kr/m/agreement.php" class="policy">이용약관</a>
				<a href="http://ms-eshop.co.kr/m/privercy.php" class="protect">개인정보취급방침</a>
			</p>
			<br>
			<p>(주)무상엠에스마트는 통신판매중개자로서 거래당사자가 아니며,</p>
			<p>입점판매자의 상품정보 및 거래에 대해 (주)무상엠에스마트는 일체의 책임을 지지 않습니다.</p>

			<p class="copyright">Copyright (C) (주)무상엠에스마트. All rights
				reserved.</p>
		</div>
		<!-- 하단메뉴/카피라이트 -->

	</div>
	<!-- msWrap -->
</body>
</html>

