
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<script>
	function moveURL(url) {
		var broswerInfo = navigator.userAgent;
		if(broswerInfo.indexOf("Version")>-1){
			window.WishroomAndroidApp.newsMove(url);
		} else {
			location.href = url;
		}
	}
	function openPress(press) {
		if (press == 'kwnews') {
			  if($('#kwnews').css('display') == 'none'){
			        $('#kwnews').show();
			        $('#kwnewsA').attr('class','active');
			        $('#kadoA').attr('class','');
			        $('#bomnaeA').attr('class','');
			        $('#kado').hide();
			        $('#bomnae').hide();
			        $('#moreNewsListA').show();
			        		        
			    }
		}
		if (press == 'kado') {
			  if($('#kado').css('display') == 'none'){
			        $('#kado').show();
			        $('#kadoA').attr('class','active');
			        $('#kwnewsA').attr('class','');
			        $('#bomnaeA').attr('class','');
			        $('#kwnews').hide();
			        $('#bomnae').hide();
			        $('#moreNewsListA').show();
			        $('#moreNewsListA').attr('href','http://${moreNewsURL}:8080/lifeinfo/morekadoNewsList');
			    }
		}
		if (press == 'bomnae') {
			  if($('#bomnae').css('display') == 'none'){
			        $('#bomnae').show();
			        $('#bomnaeA').attr('class','active');
			        $('#kwnewsA').attr('class','');
			        $('#kadoA').attr('class','');
			        $('#kwnews').hide();
			        $('#kado').hide();
			        $('#moreNewsListA').hide();
			  }
		} 
	}
	
</script>
<div class="report_news_wrap">
	<div class="all_title">
		<h4><p><span>언론사</span> 주요뉴스</p></h4>
	</div>
	<link href="./resources/front/css/owl.carousel.css" type="text/css" rel="stylesheet">
	<script src="./resources/front/js/owl.carousel.min.js"></script>
	<script src="./resources/js/impnews.js"></script>
</div>
<!--언론별 카드뉴스 시작-->
<div class="artistlist_wrap">
	<div class="artistlist01">
		<!-- <div class="artistlist01_header">
			<img src="./resources/front/img/zTopMenuLogo.png" alt="">
		</div> -->
		<div class="artistlist01_content line">
			<ul class="artist_ul">
				<script src="./resources/js/newslist.js"></script>
			</ul>
			<a id="moreNewsListA" href="http://${moreNewsURL}:8080/lifeinfo/moreNewsList" class="btn_add">더보기</a>
		</div>
	</div>
	<div class="artistlist01">
		<!-- <div class="artistlist01_header">
			<img
				src="http://ph.kado.net/adcontent/content_file/0422ef20e472e70c4e6caab65a27cec1.png"
				alt="">
		</div> -->
		<div class="artistlist01_content">
			<ul class="artist_ul">
				<script src="./resources/js/kadoNewslist.js"></script>
			</ul>
			<a id="moreNewsListA" href="http://${moreNewsURL}:8080/lifeinfo/morekadoNewsList" class="btn_add">더보기</a>
		</div>
	</div>
</div>
<!--언론별 카드뉴스 끝-->