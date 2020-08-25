
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>MS마트 eshop 모바일 - 생활뉴스</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes, height=device-height, maximum-scale=3.0, target-densityDpi=device-dpi" />
<!--<meta http-equiv="Cache-Control" content="no-cache" />-->
<meta name="format-detection" content="telephone=no" />
<link href="./resources/front/detail/css/style.css" type="text/css" rel="stylesheet">
<link href="./resources/front/detail/css/reset.css" type="text/css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<script src="./resources/front/detail/js/jquery.event.scroll.js"></script>
<script src="./resources/front/detail/js/jquery-3.2.1.min.js"></script>
<script src="./resources/front/detail/js/script.js"></script>
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="http://code.jquery.com/mobile/1.2.1/jquery.mobile-1.2.1.min.js"></script>
</head>
<body>
  <div class="wrap">
    <!--상단메뉴-->
    <div class="ofhd_float btTop">
    					<div class="ofhd_float_inner">
    						<a id="back" href="javascript:history.back();" class="ofhd_float_back _BACK">←</a>
                <div class="ofhd_logo">
                <a href="#"><img src="./resources/front/detail/img/toplogo.png" alt=""></a>
                </div>
    					</div>
            </div>
        <div class="table_contents">
          <article>
            <h1>${detailView.title}</h1>
            <div style="text-align:right;">
            <img style="width:30px;height:30px;" src="./resources/images/hand.png"/>
              <span class="date">${detailView.date}</span>
            </div>
            <div class="content">
            <c:if test="${detailView.youtubeID ne ''}">
				<iframe id="ytplayer" type="text/html" width="100%" height="200"
			  	src="https://www.youtube.com/embed/${detailView.youtubeID}?autoplay=1"
			 	 frameborder="0"></iframe>
			</c:if>	
             <img src="${detailView.imgurl}" style="width:100%;">
             ${detailView.content}
             <br>
             <br>
             <c:if test="${detailView.pcode eq '0001'}"><저작권자 ⓒ 강원일보, 무단 전재 및 재배포 금지></c:if>
			<c:if test="${detailView.pcode eq '0002'}"><저작권자 ⓒ 강원도민일보 (http://www.kado.net) 무단전재 및 재배포 금지></c:if>
            </div>
          </article>
        <!-- 내용 -->
        </div>
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

  <p class="copyright">Copyright (C) 2019 <span>엠에스투데이</span>. All rights
    reserved.</p>
</div>
<!-- 하단메뉴/카피라이트 -->
    </div>
</body>
</html>
