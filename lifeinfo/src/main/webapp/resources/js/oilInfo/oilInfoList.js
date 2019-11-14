
window.kakao=window.kakao||{},window.kakao.maps=window.kakao.maps||{},window.daum&&window.daum.maps?window.kakao.maps=window.daum.maps:(window.daum=window.daum||{},window.daum.maps=window.kakao.maps),function(){function a(a){var t={};return a.replace(/[?&]+([^=&]+)=([^&]*)/gi,function(a,e,o){t[e]=o}),t}function t(a){a&&document.write('<script charset="UTF-8" src="'+a+'"></script>')}function e(){if(S.length){var a=o(R[S.shift()],e);a.start()}else n()}function o(a,t){var e=document.createElement("script");
return e.charset="utf-8",e.onload=t,e.onreadystatechange=function(){/loaded|complete/.test(this.readyState)&&t()},{start:function(){e.src=a||"",document.getElementsByTagName("head")[0].appendChild(e),e=null}}}function n(){for(;I[0];)I.shift()();r.readyState=2}var r=kakao.maps=kakao.maps||{};if(void 0===r.readyState)r.onloadcallbacks=[],r.readyState=0;else if(2===r.readyState)return;r.VERSION={ROADMAP:"1906plw",ROADMAP_SUFFIX:"",HYBRID:"1906plw",SR:"3.00",ROADVIEW:"7.00",
ROADVIEW_FLASH:"190723",BICYCLE:"6.00",USE_DISTRICT:"1906plw",SKYVIEW_VERSION:"160114",SKYVIEW_HD_VERSION:"160107"},r.RESOURCE_PATH={ROADVIEW_AJAX:"//t1.daumcdn.net/roadviewjscore/core/css3d/190723/standard/1563862560801/roadview.js"};for(var s,i="https:"==location.protocol?"https:":"http:",d="",c=document.getElementsByTagName("script"),E=c.length;s=c[--E];)if(/\/(beta-)?dapi\.kakao\.com\/v2\/maps\/sdk\.js\b/.test(s.src)){d=s.src;break}c=null;var I=r.onloadcallbacks,S=["v3"],_="",R={v3:i+"//t1.daumcdn.net/mapjsapi/js/main/4.1.8/kakao.js",
services:i+"//s1.daumcdn.net/svc/attach/U03/cssjs/mapapi/libs/1.0.1/1515130215283/services.js",drawing:i+"//t1.daumcdn.net/mapjsapi/js/libs/drawing/1.2.5/drawing.js",clusterer:i+"//s1.daumcdn.net/svc/attach/U03/cssjs/mapapi/libs/1.0.6/1460434272434/clusterer.js"},l=a(d);_=l.appkey,_&&(r.apikey=_),r.version="4.1.8";var u=l.libraries;if(u&&(S=S.concat(u.split(","))),"false"!==l.autoload){for(var E=0,p=S.length;E<p;E++)t(R[S[E]]);r.readyState=2}r.load=function(a){switch(I.push(a),r.readyState){case 0:r.readyState=1,e();break;case 2:n()}}}();
function searchAddrFunc(idx,new_adr,os_nm) 
	{
						var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
					    mapOption = {
					        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
					        level: 3 // 지도의 확대 레벨
					    };  

					// 지도를 생성합니다    
					var map = new kakao.maps.Map(mapContainer, mapOption); 

					// 주소-좌표 변환 객체를 생성합니다
					var geocoder = new kakao.maps.services.Geocoder();

					// 주소로 좌표를 검색합니다
					geocoder.addressSearch(new_adr, function(result, status) {

					    // 정상적으로 검색이 완료됐으면 
					     if (status === kakao.maps.services.Status.OK) {

					        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

					        // 결과값으로 받은 위치를 마커로 표시합니다
					        var marker = new kakao.maps.Marker({
					            map: map,
					            position: coords
					        });

					        // 인포윈도우로 장소에 대한 설명을 표시합니다
					        var infowindow = new kakao.maps.InfoWindow({
					            content: '<div style="width:150px;text-align:center;padding:6px 0;">' + new_adr +'(' + os_nm + ')</div>'
					        });
					        infowindow.open(map, marker);

					        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
					        map.setCenter(coords);
					    } 
					});
					
					}
					
$(document)
		.ready(
				function() {
					tabA01Func();
					// https://api.openweathermap.org/data/2.5/forecast?q=Chuncheon&appid=4cacfeb31c3db06c06ff3c3b2960fd54
					$('#tabA01').on('click',function(){
						tabA01Func();
					});
				
					function tabA01Func() {
						var apiURI = "oilInfo.json?oilKind=A01";
						var result = '';
						$('#tab01-1').remove();
						$.ajax({
							url : apiURI,
							dataType : "json",
							type : "GET",
							async : "true",
							success : function(resp) {
								var rtnData = resp.list
								result += '<ul id="tab01-1" class="panel is-selected">';
					        	
								
								$.each(rtnData,function(index,item){
										
											if (index+1<4) {
												result += '<li class="tab01" style="font-size:20px;color:#ff8c00;"><span class="innerNO"><B>' + parseInt(index+1) + '<B></span><B>' + numberWithCommas(item.price)  +'<B> 원  <B>' +  item.os_nm + '<B><span id="mainAdr'+ index   +'" onclick="searchAddrFunc(\''+ index +'\',\'' + item.new_adr +'\',\'' + item.os_nm +'\')" style="font-size:15px;color:#424242;position:absolute;margin:0 0 0 5px;">>찾기</span></li>';
											} else {
												result += '<li class="tab01" style="font-size:15px;color:#424242;"><span class="innerNO"><B>' + parseInt(index+1) + '<B></span><B>' + numberWithCommas(item.price)  +'<B> 원  <B>' +  item.os_nm + '<B><span id="mainAdr'+ index   +'" onclick="searchAddrFunc(\''+ index +'\',\'' + item.new_adr +'\',\'' + item.os_nm +'\')" style="font-size:15px;color:#424242;position:absolute;margin:0 0 0 5px;">>찾기</span></li>';
											}
									});
								result += '</ul>';
								 $('.tabPanel').html(result);
								// console.log("현재온도 : "+ (resp.main.temp-
								// 273.15) );
								 $('#mainAdr0').trigger("click");
							}
						})
						
					};
					
						$('#tabA02').on('click',function(){
							var apiURI = "oilInfo.json?oilKind=A02";
							var result = '';
							$('#tab02-1').remove();
							$.ajax({
								url : apiURI,
								dataType : "json",
								type : "GET",
								async : "true",
								success : function(resp) {
									var rtnData = resp.list
									result += '<ul id="tab02-1" class="panel is-selected">';
						        	
									
									$.each(rtnData,function(index,item){
											
												if (index+1<4) {
													result += '<li class="tab02" style="font-size:20px;color:#ff8c00;"><span class="innerNO"><B>' + parseInt(index+1) + '<B></span><B>' + numberWithCommas(item.price)  +'<B> 원  <B>' +  item.os_nm + '<B><span id="mainAdr'+ index   +'" onclick="searchAddrFunc(\''+ index +'\',\'' + item.new_adr +'\',\'' + item.os_nm +'\')" style="font-size:15px;color:#424242;position:absolute;margin:0 0 0 5px;">>찾기</span></li>';
												} else {
													result += '<li class="tab02" style="font-size:15px;color:#424242;"><span class="innerNO"><B>' + parseInt(index+1) + '<B></span><B>' + numberWithCommas(item.price)  +'<B> 원  <B>' +  item.os_nm + '<B><span id="mainAdr'+ index   +'" onclick="searchAddrFunc(\''+ index +'\',\'' + item.new_adr +'\',\'' + item.os_nm +'\')" style="font-size:15px;color:#424242;position:absolute;margin:0 0 0 5px;">>찾기</span></li>';
												}
										});
									result += '</ul>';
									 $('.tabPanel').html(result);
									// console.log("현재온도 : "+ (resp.main.temp-
									// 273.15) );
								}
							})
						});
					
				
					function numberWithCommas(x) {
					    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
					}

				});