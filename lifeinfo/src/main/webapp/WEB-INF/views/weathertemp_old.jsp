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
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=0, user-scalable=no, target-densitydpi=medium-dpi" />
<!--<meta http-equiv="Cache-Control" content="no-cache" />-->
<meta name="format-detection" content="telephone=no" />
<link href="./resources/front/css/style.css" type="text/css" rel="stylesheet">
<link href="./resources/front/css/jquery-ui.css" type="text/css" rel="stylesheet">
<link href="./resources/front/tabmenu/swiper.min.css" type="text/css" rel="stylesheet">
<script src="./resources/front/js/jquery-3.2.1.min.js"></script>
<script src="./resources/front/tabmenu/swiper.min.js"></script>
<script src="./resources/front/js/script.js"></script>
<!--  Author : Shin -->
<script>
      (function($) {
        $(function() {
          $("#scroller").simplyScroll();
        });
      })(jQuery);
      function shop_goto() {
    	  location.href='http://ms-eshop.co.kr/';
      }
</script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
</head>
<body>
  <div class="msWrap">
    <!--상단메뉴-->
    <!-- 상단메뉴 -->
		<div id="msHeaderApp">
			<!-- msHeader -->

			<div class="msAppDownload">
				<h1>MS</h1>
				앱 설치하고 혜택받기
				<button class="btnAppDown">앱다운</button>
			</div>

			<div class="msTopMenu" id="gotop">
				<ul class="msSiteTab">
					<li class="active"><img
						src="./resources/front/img/tab_logo.png"
						class="tab_logo" alt="" /> <span>생활정보</span></li>
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
           <li class="swiper-slide"><a href="javascript:alert('준비중입니다.');">우리동네<br>소식</a></li>
           <li class="swiper-slide"><a href="javascript:alert('준비중입니다.');">MS추천<br>알뜰쇼핑</a></li>
           <li class="swiper-slide"><a href="javascript:alert('준비중입니다.');">MS검색<br>랭킹</a></li>
         </ul>
       </div>
    <!-- Add Pagination -->

  <!-- Swiper JS -->

<script src="./resources/front/tabmenu/swiper.min.js"></script>


<!-- Initialize Swiper -->

 <script>
    var swiper = new Swiper('.swiper-container1', {
      slidesPerView: 4,
      spaceBetween: 0,
      freeMode: true
   /*   pagination: {
        el: '.swiper-pagination',
        clickable: true,
      },*/
    });
  </script>



			</nav>

		</div>
		<!-- 상단메뉴 -->
    <!--상단메뉴 끝-->
  <div class="new_contents">
    <!--날씨 컨텐츠 시작-->
    <div class="weather_wrap">
      <div class="weather_head">
        <div class="all_title">
          <h4><span>오늘의 날씨</span></h4>
        </div>
        <div class="address">
            <a href="#"><img src="./resources/front/img/marker2.png" alt="maker"></a>
          <span>강원도 춘천시 후평동</span>
        </div>
      </div>
      <div class="weather_condition">
        <table style="text-align:center;padding:5%;">
          <tr>
            <td  rowspan="3" style="width:20%; height: 100px; ">
              <img src="./resources/front/img/cloud.png" alt="">
            </td>
            <td colspan="2" style="text-align:left;"><p>흐림</p></td>
            <td>미세먼지</td>
          </tr>
          <tr>
            <td colspan="2" style="height: 50px;text-align:left;"><p><span>15<span class="small_p">℃</span></span></p></td>
            <td>
              <img src="./resources/front/img/weather04.png" alt="">
            </td>
          </tr>
          <tr>
            <td style="text-align:left;"><p>풍속 : 5 m/s</p></td>
            <td style="text-align:left;"><p>습도 : 55%</p></td>
            <td style="color:#ff0000;"><p>매우나쁨</p></td>
          </tr>
        </table>
      </div>
    </div><!--날씨 컨텐츠 끝-->
    <!--생활뉴스 컨텐츠 시작-->
      <div class="lifenew_wrap">
        <div class="all_title">
          <h4><span>MS생활뉴스</span></h4>
        </div>
      <div class="ms_new_wrap">
        <div class="img_slider">
          <ul class="text_slider">
          <li>
          <div class="article_box">
            <a href="#">
                <img src="./resources/front/img/ex9.png" width="550" alt="">
                <div>
                    <h3>| 생활</h3>
                    <p class="text_num">11월 첫 월요일 오전 맑음...미세먼지 등 대기환경도 맑아</p>
                    <p>MS투데이</p>
                </div>
            </a>
            <a href="#">
                <img src="./resources/front/img/ex.jpg" width="550" alt="">
                <div>
                    <h3>| 생활</h3>
                    <p class="text_num">11월 첫 월요일 오전 맑음...미세먼지 등 대기환경도 맑아</p>
                    <p>MS투데이</p>
                </div>
            </a>
            <a href="#">
                <img src="./resources/front/img/ex8.png" width="550" alt="">
                <div>
                    <h3>| 생활</h3>
                    <p class="text_num">11월 첫 월요일 오전 맑음...미세먼지 등 대기환경도 맑아</p>
                    <p>MS투데이</p>
                </div>
            </a>
        </div>
        </li>
        <li>
          <div class="article_box">
            <a href="#">
                <img src="./resources/front/img/ex9.png" width="550" alt="">
                <div>
                    <h3>| 생활</h3>
                    <p class="text_num">11월 첫 월요일 오전 맑음...미세먼지 등 대기환경도 맑아</p>
                    <p>MS투데이</p>
                </div>
            </a>
            <a href="#">
                <img src="./resources/front/img/ex.jpg" width="550" alt="">
                <div>
                    <h3>| 생활</h3>
                    <p class="text_num">11월 첫 월요일 오전 맑음...미세먼지 등 대기환경도 맑아</p>
                    <p>MS투데이</p>
                </div>
            </a>
            <a href="#">
                <img src="./resources/front/img/ex.jpg" width="550" alt="">
                <div>
                    <h3>| 생활</h3>
                    <p class="text_num">11월 첫 월요일 오전 맑음...미세먼지 등 대기환경도 맑아</p>
                    <p>MS투데이</p>
                </div>
            </a>
        </div>
        </li>

        <li>
          <div class="article_box">
            <a href="#">
                <img src="./resources/front/img/ex2.jpg" width="550" alt="">
                <div>
                    <h3>| 생활</h3>
                    <p class="text_num">11월 첫 월요일 오전 맑음...미세먼지 등 대기환경도 맑아</p>
                    <p>MS투데이</p>
                </div>
            </a>
            <a href="#">
                <img src="./resources/front/img/ex.jpg" width="550" alt="">
                <div>
                    <h3>| 생활</h3>
                    <p class="text_num">11월 첫 월요일 오전 맑음...미세먼지 등 대기환경도 맑아</p>
                    <p>MS투데이</p>
                </div>
            </a>
            <a href="#">
                <img src="./resources/front/img/ex.jpg" width="550" alt="">
                <div>
                    <h3>| 생활</h3>
                    <p class="text_num">11월 첫 월요일 오전 맑음...미세먼지 등 대기환경도 맑아</p>
                    <p>MS투데이</p>
                </div>
            </a>
        </div>
        </li>
          </ul>
          <a href="#"><div class="add_btn"><p>더보기</p></div></a>
      </div>
    </div>
      </div>
      <!--날씨 컨텐츠 끝-->
      <!--언론사 주요뉴스 시작-->
      <div class="report_news_wrap">
        <div class="all_title">
          <h4><span>언론사 주요뉴스</span></h4>
          </div>
          <div class="img_slider">
            <ul class="slider">
              <li><img src="./resources/front/img/ex5.jpg" alt="" /><p>"유치원 '입학전쟁' 사라진다"</p></li>
              <li><img src="./resources/front/img/ex5.jpg" alt="" /><p>"유치원 '입학전쟁' 사라진다"</p></li>
              <li><img src="./resources/front/img/ex5.jpg" alt="" /><p>"유치원 '입학전쟁' 사라진다"</p></li>
            </ul>
          </div>
      </div>
      <!--언론사 주요뉴스 끝-->
      <!--유튜브 시작-->
      <div class="youtube_wrap">
        <iframe src="https://www.youtube.com/embed/i-sX0qKNR0w" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
      </div>
      <!--유튜브 끝-->
      <!--언론별 카드뉴스 시작-->
      <div class="artistlist_wrap">
        <div class="artistlist01">
          <div class="artistlist01_header">
            <img src="./resources/front/img/zTopMenuLogo.jpg" alt="">
          </div>

          <div class="artistlist01_content line">
            <ul>
              <li>
                <div class="artist_contents">
                  <img src="./resources/front/img/ex4.png" alt="">
                  <div class="subject">
                    <p>한림-KOICA글로벌연수 참여국 대사 초청회의</p>
                  </div>
                </div>
              </li>
              <li>
                <div class="artist_contents">
                  <img src="./resources/front/img/ex4.png" alt="">
                  <div class="subject">
                    <p>한림-KOICA글로벌연수 참여국 대사 초청회의</p>
                  </div>
                </div>
              </li>
            </ul>
            <a href="board.html">더보기</a>
          </div>
        </div>
        <div class="artistlist01">
          <div class="artistlist01_header">
            <img src="http://ph.kado.net/adcontent/content_file/0422ef20e472e70c4e6caab65a27cec1.png" alt="">
          </div>
          <div class="artistlist01_content">
            <ul>
              <li>
                <div class="artist_contents">
                  <img src="./resources/front/img/ex.jpg" alt="">
                  <div class="subject">
                    <p>춘천 전지역 멧돼지 총기포획 실시</p>
                  </div>
                </div>
              </li>
              <li>
                <div class="artist_contents">
                  <img src="./resources/front/img/ex.jpg" alt="">
                  <div class="subject">
                    <p>춘천 전지역 멧돼지 총기포획 실시</p>
                  </div>
                </div>
              </li>
            </ul>
            <a href="#">더보기</a>
          </div>
        </div>
        </div>
        <!--언론별 카드뉴스 끝-->
        <!--뉴스토픽 시작-->
        <div class="newstopic_wrap">
          <div class="all_title">
            <h4><span>뉴스 토픽</span></h4>
            </div>
          <ul class="topic_list">
            <li><a href="#"><span class="cd_num">1</span>정부, WTO 개도국 특혜 포기..강원도 농민 반발</a></li>
            <li><a href="#"><span class="cd_num">2</span>정부, WTO 개도국 특혜 포기..강원도 농민 반발</a></li>
            <li><a href="#"><span class="cd_num">3</span>정부, WTO 개도국 특혜 포기..강원도 농민 반발</a></li>
            <li><a href="#"><span class="cd_num">4</span>정부, WTO 개도국 특혜 포기..강원도 농민 반발</a></li>
            <li><a href="#"><span class="cd_num">5</span>정부, WTO 개도국 특혜 포기..강원도 농민 반발</a></li>
            <li><a href="#"><span class="cd_num">6</span>정부, WTO 개도국 특혜 포기..강원도 농민 반발</a></li>
            <li><a href="#"><span class="cd_num">7</span>정부, WTO 개도국 특혜 포기..강원도 농민 반발</a></li>
            <li><a href="#"><span class="cd_num">8</span>정부, WTO 개도국 특혜 포기..강원도 농민 반발</a></li>
            <li><a href="#"><span class="cd_num">9</span>정부, WTO 개도국 특혜 포기..강원도 농민 반발</a></li>
            <li><a href="#"><span class="cd_num">10</span>정부, WTO 개도국 특혜 포기..강원도 농민 반발</a></li>
          </ul>
        </div>
        <!--뉴스토픽 끝-->
        <!--유가정보 시작-->
        <div class="oil_info_wrap">
          <div class="all_title title_bt">
            <h4><span>우리동네 유가정보 <span class="txt_color">TOP5</span></span></h4>
            </div>
          <!-- * 카카오맵 - 지도퍼가기 -->
        <!-- 1. 지도 노드 -->
        <div id="daumRoughmapContainer1572400127966" class="root_daum_roughmap root_daum_roughmap_landing" style="width:100%;max-width:100%;height:auto;border:0;left: -9px;top:-8px;"></div>
        <!--
        	2. 설치 스크립트
        	* 지도 퍼가기 서비스를 2개 이상 넣을 경우, 설치 스크립트는 하나만 삽입합니다.
        -->
        <script class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>
        <!-- 3. 실행 스크립트 -->
        <script>
        	new daum.roughmap.Lander({
        		"timestamp" : "1572400127966",
        		"key" : "vn3z",
        		"mapHeight" : "auto"
        	}).render();
        </script>
        <div class="oil_table">
            <ul class="box_tab tabs">
              <li class="tab01 tab-link current" data-tab="tab-1">휘발유</li>
              <li class="tab02" data-tab="tab-2">경유</li>
            </ul>
            <!--유가정보 시작-->
            <div id="tab-1" class="oil_list_wrap01 tab-content current">
            <ul>
              <li>
                <div class="oil_list">
                  <img src="./resources/front/img/marker2.png" alt="maker2">
                  <p class="add_img">농협주유소</p>
                  <p><span>1,109 원</span></p>
                  <a href="#">찾기</a>
                </div>
              </li>
              <li>
                <div class="oil_list">
                  <img src="./resources/front/img/marker2.png" alt="marker2">
                  <p class="add_img">농협주유소</p>
                  <p><span>1,109 원</span></p>
                  <a href="#">찾기</a>
                </div>
              </li>
              <li>
                <div class="oil_list">
                  <img src="./resources/front/img/marker2.png" alt="marker2">
                  <p class="del_img">농협주유소</p>
                  <p><span>1,109 원</span></p>
                  <a href="#">찾기</a>
                </div>
              </li>
              <li>
                <div class="oil_list">
                  <img src="./resources/front/img/marker2.png" alt="marker2">
                  <p class="add_img">농협주유소</p>
                  <p><span>1,109 원</span></p>
                  <a href="#">찾기</a>
                </div>
              </li>
              <li>
                <div class="oil_list">
                  <img src="./resources/front/img/marker2.png" alt="marker2">
                  <p class="del_img">농협주유소</p>
                  <p><span>1,109 원</span></p>
                  <a href="#">찾기</a>
                </div>
              </li>
            </ul>
            </div>
            <!--유가정보 끝-->
            <div id="tab-2" class="oil_list_wrap02 tab-content">
            <ul>
              <li>
                <div class="oil_list">
                  <img src="./resources/front/img/marker2.png" alt="marker2">
                  <p class="add_img">호반주유소</p>
                  <p><span>1,509 원</span></p>
                  <a href="#">찾기</a>
                </div>
              </li>
              <li>
                <div class="oil_list">
                  <img src="./resources/front/img/marker2.png" alt="maker2">
                  <p class="add_img">호반주유소</p>
                  <p><span>1,509 원</span></p>
                  <a href="#">찾기</a>
                </div>
              </li>
              <li>
                <div class="oil_list">
                  <img src="./resources/front/img/marker2.png" alt="marker2">
                  <p class="add_img">호반주유소</p>
                  <p><span>1,509 원</span></p>
                  <a href="#">찾기</a>
                </div>
              </li>
              <li>
                <div class="oil_list">
                  <img src="./resources/front/img/marker2.png" alt="maker2">
                  <p class="add_img">호반주유소</p>
                  <p><span>1,509 원</span></p>
                  <a href="#">찾기</a>
                </div>
              </li>
              <li>
                <div class="oil_list">
                  <img src="./resources/front/img/marker2.png" alt="">
                  <p class="del_img">호반주유소</p>
                  <p><span>1,509 원</span></p>
                  <a href="#">찾기</a>
                </div>
              </li>
            </ul>
            </div>
            <!--유가정보 끝-->
         </div>
        </div>
        <!--유가정보 끝-->
        <!-- 하단메뉴/카피라이트 -->
        <div id="msFooter">
          <!-- msFooter -->
          <h4>(주)무상엠에스마트</h4>
          <p>대표 : 이원복</p>
          <p>주소 : 강원도 춘천시 충열로 79번길 37(우두동)</p>

          <div class="helpDesk">
            <span class="telephone">고객센터 : 033-243-8888</span><a href="http://ms-eshop.co.kr/m/board_list.php?board=qna" class="prqna">고객문의</a><a href="http://ms-eshop.co.kr/m/venderProposal.php" class="vdproposal">입점문의</a>
        <p>(평일 AM 09:00~PM 18:00, 토/일/공휴일 휴무)</p>
          </div>

          <p>
            사업자번호 : 221-81-33427 <a
              href="javascript:companyPOP()"
              class="bizcheck">사업자정보 확인</a>
          </p>
          <p>통신판매신고번호 : 제2011-강원-0001호</p>
          <p>개인정보관리자 : 이진혁 계장(webmaster@msretail.co.kr)
          <p>
          <p>
            <a href="http://ms-eshop.co.kr/m/agreement.php"
              class="policy">이용약관</a> <a
              href="http://ms-eshop.co.kr/m/privercy.php" class="protect">개인정보취급방침</a>
          </p>
          <br>
          <p>(주)무상엠에스마트는 통신판매중개자로서 거래당사자가 아니며,</p>
          <p>입점판매자의 상품정보 및 거래에 대해 (주)무상엠에스마트는 일체의 책임을 지지 않습니다.</p>

          <p class="copyright">Copyright (C) (주)무상엠에스마트. All rights
            reserved.</p>
        </div>
        <!-- 하단메뉴/카피라이트 -->
      </div>
    </div>
</body>
</html>


