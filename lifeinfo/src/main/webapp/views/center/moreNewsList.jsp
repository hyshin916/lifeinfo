
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<script src="./resources/js/httpRequest.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<!-- <link rel="stylesheet" href="./resources/msmart/css/newslist.css" /> -->
<!-- swiper -->
<link rel="stylesheet" href="./resources/css/swiper.min.css">
<!-- swiper -->

<script type="text/javascript"
	src="./resources/msmart/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="./resources/msmart/js/swiper.min.js"></script>
<style>
.swiper-container .swiper-wrapper .swiper-slide a img {
	height: auto;
	width: auto;
	max-height: 200px;
}

.swiper-container .swiper-wrapper .swiper-slide a div {
	text-align: center;
	font-weight: bold;
	font-size: 20px;
	color: #000;
	text-shadow: 1px 1px #000;
	width: 100%;
	bottom: 25px;
	height: 42px;
	position: absolute;
	background: url('./resources/images/msmart_back.png');
	line-height: 40px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>

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
var offset;
var value;
function fnMove(seq){
     offset = $("#news" + seq).offset();
     //alert(offset.top);
     localStorage.setItem('offset',offset.top);
     // $('html, body').animate({scrollTop : offset.top}, 10); 
  	location.href= 'http://${moreNewsURL}:8080/lifeinfo/newsDetail?artid=' + seq + '&section=morenewslist';
  }
function test() {
	value = localStorage.getItem('offset');
	value = parseInt(value+300);
	//alert('tttddklfjslkdfjalsdj');
	$( 'html, body' ).stop().animate( { scrollTop : value});
}

$(function() {
	
	var startPage = false;
	var localPage;
	var page;
	var common = true;
	
	var start = true;
	var totalCnt = ${totalCnt}; 
	
	if (window.performance) {
		  console.info("window.performance work's fine on this browser");
		}
		if (performance.navigation.type == 1) {
		  console.info( "This page is reloaded" );
		  localStorage.removeItem('offset');
		  page = 1;
		  infiniteScrollContent(page);
		 // initFunc(page);
		 // setTimeout(test,2000);
		} else {
			  page = 1;
			  infiniteScrollContent(page);
/* 			 for (page=1;page<5;page++) {
				 getList(page);
				 page = page;
			 }
			 setTimeout(test,5000); */
			 //$('html, body').animate({scrollTop : offset.top}, 10);
		 	 console.info( "This page is not reloaded"); 
		}
		/*  function initFunc(page) {
				if (page != 1){
					localPage = localStorage.getItem('page');
				} else {
					page = page;
				} 
				infiniteScrollContent();
		};  */

    // 스크롤 감지
    var didScroll = false;

    $(window).on('scroll', function() { didScroll = true; });

    setInterval(function() {
        var bottomHeight = $(window).scrollTop() + $(window).height() + 600;
        var docHeight = $(document).height();

        if (didScroll) {
            didScroll = false;
            
          /*   if ($(window).scrollTop() == 0 && startPage) {
            	startPage = false;
    			//getList(parseInt(page-1));
    			$('.movie').remove();
    			if(page!=-1) {
    				page = localStorage.getItem('page',page);
    				alert(parseInt(--page));
    				setTimeout(getList(page),1000);
    				localStorage.setItem('page',page);
    				// initFunc(parseInt(page));
    				
    			}
    		}  */
            if (bottomHeight > docHeight) {
            	//alert(++page);
            	++page;
            	infiniteScrollContent(page)};
        }
    }, 250);
    
    function infiniteScrollContent(page) {
		startPage = true;
    	if ($(location).attr('pathname') == '/lifeinfo/moreNewsList') {
			if (totalCnt+1 > page && start) {
				  start = false;
				  setTimeout(getList(page),1000);
				  localStorage.removeItem('page');
				  localStorage.setItem('page',page);
	          };
		};
    }
    
    function subStr(str) {
    	
    	var cutStr = str.substring(0,30) +'...';
    	
    	return cutStr;
    }
    
    
	var output ='';
	function getList(page){
	    $.ajax({
	        type : 'POST',  
	        dataType : 'json', 
	        data : {"page" : page},
	        url : 'moreNewsList.json',
	        success : function(returnData) {
	            var data = returnData.rows;
	            var toCnt = returnData.toCnt;
	            var html = "";
	            if (returnData.startNum<=returnData.toCnt){
	                if(data.length>0){
	                		output += '';
	                      $.each(data,function(index,item){
	                  		output += '<li class="movie" style="width: 100%; height: 82px; text-align: left; display: inline-block;"><a id="news'+ item.nsid +'" href="javascript:fnMove('+ item.nsid +')">';
	                  		if (item.imgurl == null) {
	                  			output += '<span class="title" style="color: #333; height: 62px; position: absolute; margin: 10px 2px 10px 0px;"><span style="color:#606060;">';
	                  		
	                  		} else {
	                  			output += '<span class="thumb" style="position: absolute;"><img src="' + item.imgurl + '"style="margin: 5px 0 0 0; width: 120px; height: 72px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;"';
		                  		output += 'onerror="this.src=\'http://www.kwnews.co.kr/Site2016/Img/zTopMenuLogo.jpg\';>"</span>';
		                  		output += '<span class="title" style="color: #333; height: 62px; position: absolute; margin: 10px 2px 10px 130px;"><span style="color:#606060;">';
	                  		}
	                  		
	                  		
	                  			if (item.pcode == '0001') {
	                  				output += '<B>[강원일보]</B>';	
	                  			}
	                  			if (item.pcode == '0002') {
	                  				output += '<B>[강원도민일보]</B>';	
	                  			}
	                  			
	                  			output += '</span><br>' + subStr(item.title) + '</span>';
	                  			if (item.imgurl==null) {
	                  				/* output += '<span style="position:absolute;color: #333; padding: 65px 0 0 5px; width: 100%; text-align: left; display: inline-block;" class="author"><img style="padding:0 2px 0 0;" class="author" src="./resources/images/eye_1.png"/>'+item.uv+'</span>'; */
	                  				output += '<span style="position:absolute;color: #333; padding: 65px 0 0 5px; width: 100%; text-align: left; display: inline-block;" class="author"></span>';
	                  			} else {
	                  				output += '<span style="position:absolute;color: #333; padding: 65px 0 0 130px; width: 100%; text-align: left; display: inline-block;" class="author"></span>';
	                  			}
	                  			
	          					output += '<span style="color: #333; padding: 60px 10px 0px 0; width: 100%; right: 40px; text-align: right; display: inline-block;" class="author">';
	          					if (item.author != ''){
	          						output += '[' + item.author +']';
	          					}
	          					output += '</span></a></li><hr style="margin: 0px;">';
	                      });
	                  	  start = true;  
          				  $('#newsList').html(output);
	                }else{
	                //데이터가 없을경우
	                };
	            };
	       },error:function(e){
	           if(e.status==300){
	               alert("데이터를 가져오는데 실패하였습니다.");
	           };
	       }
	    }); 
	}
});
/* var startPage = false;
var localPage;
var page;
var common = true;

if (window.performance) {
	  console.info("window.performance work's fine on this browser");
	}
	if (performance.navigation.type == 1) {
	  console.info( "This page is reloaded" );
	  page = 1;
	  initFunc(page);
	} else {
	  console.info( "This page is not reloaded");
	}

 function initFunc(page) {
	if (page != 1){
		localPage = localStorage.getItem('page');
	} else {
		page = page;
	}    
}; 

			var start = true;
			var totalCnt = ${totalCnt}; 
			$(window).scroll(function(){
				if ($(window).scrollTop() == 0 && startPage) {
						//getList(parseInt(page-1));
						$('.movie').remove();
						if(page!=-1) {
							page = localStorage.getItem('page',page);
							alert(parseInt(--page));
							alert('aaaa');
							  setTimeout(getList(page),1000);
							  common = false;
							localStorage.setItem('page',page);
							// initFunc(parseInt(page));
							startPage = false;
						}
				} 
				if ($(window).scrollTop() >= ($(document).height() - $(window).height()-100) && common) {
					alert('tttt');
					startPage = true;
					if ($(location).attr('pathname') == '/lifeinfo/moreNewsList') {
							if (totalCnt+1 > page && start) {
								  start = false;
								  setTimeout(getList(page),1000);
								  localStorage.removeItem('page');
								  localStorage.setItem('page',page);
					        	  page++;   
					          };
						};
			     } ;
			});
			
 	
		var output ='';
		function getList(page){
			alert('ajax');
		    $.ajax({
		        type : 'POST',  
		        dataType : 'json', 
		        data : {"page" : page},
		        url : 'moreNewsList.json',
		        success : function(returnData) {
		            var data = returnData.rows;
		            var toCnt = returnData.toCnt;
		            var html = "";
		            if (returnData.startNum<=returnData.toCnt){
		                if(data.length>0){
		                		output += '';
		                      $.each(data,function(index,item){
		                  		output += '<li class="movie" style="width: 100%; height: 82px; text-align: left; display: inline-block;"><a id="news'+ item.nsid +'" href="javascript:fnMove('+ item.nsid +')">';
		                  		output += '<span class="thumb" style="position: absolute;"><img src="' + item.imgurl + '"style="margin: 5px 0 0 0; width: 120px; height: 72px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;"';
		                  		output += 'onerror="this.src=\'http://www.kwnews.co.kr/Site2016/Img/zTopMenuLogo.jpg\';"></span>';
		                  		output += '<span class="title" style="color: #333; height: 62px; position: absolute; margin: 10px 2px 10px 130px;"><span style="color:#606060;">';
		                  		
		                  			if (item.pcode == '0001') {
		                  				output += '<B>[강원일보]</B>';	
		                  			}
		                  			if (item.pcode == '0002') {
		                  				output += '<B>[강원도민일보]</B>';	
		                  			}
		                  			
		                  			output += '</span><br>' + item.title + '</span>';
		          					output += '<span style="color: #333; padding: 60px 10px 0px 0; width: 100%; right: 40px; text-align: right; display: inline-block;" class="author">';
		          					if (item.author != ''){
		          						output += '[' + item.author +']';
		          					}
		          					output += '</span></a></li><hr style="margin: 0px;">';
		                      });
		                  	  start = true;  
	          				  $('#newsList').html(output);
		                }else{
		                //데이터가 없을경우
		                };
		            };
		       },error:function(e){
		           if(e.status==300){
		               alert("데이터를 가져오는데 실패하였습니다.");
		           };
		       }
		    }); 
		} */

/*
		 */
</script>
<div>
	<div id="newsListMain">
		<ul id="newsList" style="padding: 2px; list-style: none;"></ul>
	</div>
</div>
<!-- <ul id="msFooterFixMenu">
		<li><img style="width:50px;height:50px;" src="./resources/msmart/skin/default/img/tab_logo.png"><a href="/m/">홈</a></li>
	</ul> -->

