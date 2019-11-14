
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!-- swiper -->
<link rel="stylesheet" href="./resources/css/swiper.min.css">
<!-- swiper -->

<style>
.swiper-container .swiper-wrapper .swiper-slide a img {
	height: auto;
	width: auto;
	max-height : 200px;
}

.swiper-container .swiper-wrapper .swiper-slide a div {
	text-align: center;
	/* font-weight: bold; */
	font-size: 20px;
	color: #000;
	/* text-shadow: 1px 1px #000; */
	width: 100%;
	bottom: 25px;
	height: 42px;
	position: absolute;
	background : url('./resources/images/msmart_back.png');
	line-height: 40px;
	
	white-space: nowrap; overflow: hidden; text-overflow: ellipsis;
	
}
</style>
<h2 style="margin:10px 0 10px 5px;">&nbsp;&nbsp;언론사 주요뉴스</h2>
<div class="swiper-container" style="text-align:center;">
<div class="swiper-wrapper" style="transition-duration: 0ms; transform: translate3d(0px, 0px, 0px);">
	<script src="./resources/js/impnews.js"></script>
</div>
<div class="swiper-pagination"></div>
<div class="swiper-button-next"></div>
<div class="swiper-button-prev"></div>
</div>

<script src="./resources/js/swiper.min.js"></script>

<!-- Initialize Swiper -->
<script>
var swiper = new Swiper('.swiper-container', {
	spaceBetween : 30,
	centeredSlides : true,
	autoplay : {
		delay : 2500,
		disableOnInteraction : false,
	},
	pagination : {
		el : '.swiper-pagination',
		clickable : true,
	},
	navigation : {
		nextEl : '.swiper-button-next',
		prevEl : '.swiper-button-prev',
	},
});
</script>

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
<style>
@media all and (min-width:768px) {
.viewCntPrt {
	width:100%;height:5px;text-align:right;
	font-size: 15px;
}


.viewCntPrt	.viewCnt {
		margin:25px 3px 0 0;
	}

}

@media all and (min-width:360px) and (max-width:640px) {
.viewCntPrt {
	width:100%;height:5px;text-align:right;
	font-size: 12px;
}

.viewCntPrt	.viewCnt {
		margin:10px 3px 0 0;
	}

}
@media all and (max-width:320px) {
.viewCntPrt {
	width:100%;height:5px;text-align:right;
	font-size: 12px;
}

.viewCntPrt	.viewCnt {
		margin:10px 3px 0 0;
	}

}
/* .viewCntPrt {
	width:100%;height:5px;text-align:right;
	font-size : 12px;
}
.viewCntPrt	.viewCnt {
		margin:10px 3px 0 0;
	}
 */
</style>
<script>
	$(function() {
		$('.alt_1_detail_link').each(function() {
			var length = 30;
			$(this).each(function() {
				if ($(this).text().length >= length) {
					$(this).text($(this).text().substr(0, length) + '...');
				}
			});
		});
	});	
	
</script>
 <nav class="msCategory">
				<div class="swiper-container2">

					<ul class="swiper-wrapper">
						<li class="swiper-slide"><a href="javascript:openPress('kwnews');" class="active" id="kwnewsA">강원일보</a></li>
						<li class="swiper-slide"><a href="javascript:openPress('kado');" id="kadoA">강원도민일보</a></li>
					<!-- 	<li class="swiper-slide"><a href="javascript:openPress('bomnae');" id="bomnaeA">봄내소식지</a></li> -->
					</ul>

				</div>

				<script>
					var swiper = new Swiper('.swiper-container2', {
						slidesPerView : 2,
						spaceBetween : 1,
						freeMode : true
						
					});
				</script>
</nav>
<!-- <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
<div style="width:100%;margin:10px;">
    <!-- <span style="position:absolute;"><h2 class="sub-header">&nbsp;언론사뉴스</h2></span> -->
    <div style="position:relative;top:5px;right:25px;width:100%;text-align:right;"><span><a id="moreNewsListA" href="http://${moreNewsURL}:8080/lifeinfo/moreNewsList">더보기></a></span></div>
</div>
<form name="my_form">

	<ul class="article_list_type1" id="kwnews" style="display:block;">
			<script src="./resources/js/newslist.js"></script>
	</ul>
	<ul class="article_list_type1" id="kado" style="display:none;">
			<script src="./resources/js/kadoNewslist.js"></script>
	</ul>
	<ul class="article_list_type1" id="bomnae" style="display:none;">
			<iframe src="./resources/BOMNAE_345/index.html" frameborder="0" width="100%" height="500" marginwidth="0" marginheight="0"></iframe>
	</ul>


</form>
