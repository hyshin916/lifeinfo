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
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes, height=device-height, maximum-scale=2.0, target-densityDpi=device-dpi">
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<script type="text/javascript">
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


			<nav class="msCategory">
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
				</div>
			</nav>
			<script>
				var swiper = new Swiper('.swiper-container1', {
					slidesPerView : 4,
					spaceBetween : 0,
					freeMode : true
				/*   pagination: {
				     el: '.swiper-pagination',
				     clickable: true,
				   },*/
				});
			</script>

		</div>
		<!-- 상단메뉴 -->
		<!--상단메뉴 끝-->
		<div class="new_contents">
			<!--날씨 컨텐츠 시작-->
<%-- 			<div class="weather_wrap">
				<tiles:insertAttribute name="main" />
			</div> --%>
			<!--날씨 컨텐츠 끝-->
		<tiles:insertAttribute name="mslifeList" />
		</div>
		<!--날씨 컨텐츠 끝-->
		<!--유튜브 시작-->
		<tiles:insertAttribute name="mainYoutube" />
		<!--유튜브 끝-->
		
	
		<!--언론사 주요뉴스 시작-->
		<tiles:insertAttribute name="mainNews" />
		<!--언론사 주요뉴스 끝-->

		<!--언론별 카드뉴스 시작-->

		<!--언론별 카드뉴스 끝-->
		<!--뉴스토픽 시작-->
		<tiles:insertAttribute name="newsall" />
		<!--뉴스토픽 끝-->
					<!--날씨 컨텐츠 시작-->
 			<div class="weather_wrap">
				<tiles:insertAttribute name="main" />
			</div> 
			<!--날씨 컨텐츠 끝-->
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
        <!-- 하단메뉴/카피라이트 -->
        <div id="msFooter">
          <!-- msFooter -->
          <h4>(주)엠에스투데이</h4>
          <p>대표 : 이진혁</p>
          <p>주소 : 강원도 춘천시 동면 춘천순환로 600</p>

          <div class="helpDesk">
            <span class="telephone">고객센터 : 033-256-3300</span>
        <p>(평일 AM 09:00~PM 18:00, 토/일/공휴일 휴무)</p>
          </div>

          <p>
            사업자번호 : 221-81-33427
          </p>
          <p>통신판매신고번호 : 제2011-강원-0001호</p><br>
          <p>발행인 : 이진혁</p>
          <p>편집인 : 김기섭
          <p>청소년보호책임자 : 김기섭
          <p>
          </p>
          <br>
          <p>엠에스투데이 모든 콘텐츠(영상,기사, 사진)는 </p>
          <p>저작권법의 보호를 받는 바,무단 전재와 복사, 배포 등을 금합니다.</p>

          <p class="copyright">Copyright (C) 2019 엠에스투데이. All rights
            reserved.</p>
        </div>
        <!-- 하단메뉴/카피라이트 -->
	</div>
</body>
</html>


