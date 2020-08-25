<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<title>[MS투데이] 2차 채용공고</title>
	<meta name="HandheldFriendly" content="True" />
	<meta name="MobileOptimized" content="320" />
	<meta name="viewport" content="width=device-width, target-densitydpi=160dpi, initial-scale=1" />
	<script src="./resources/today/js/ios-orientationchange-fix.min.js"></script>
	<style>
@charset "utf-8";
@import url(http://cdn.jsdelivr.net/font-nanum/1.0/nanumbarungothic/nanumbarungothic.css);
body{
	font-family: "Nanum Barun Gothic", sans-serif;
}
	h1 {
		font-size: 20px;
	}
	div {
		width: 100%;
	}
	img[usemap] {
		border: none;
		height: auto;
		max-width: 100%;
		width: auto;
	}
	p{
		font-size: 15px;
		color : #333;
		padding: 5px;
		font-weight: 500;
	}
	span{
		color : #ffc000;
		font-weight: bold;
		text-decoration: underline;
	}

@media (min-width:1024px) and (max-width:1920px){
	div{
		text-align: center;
	}
	img[usemap] {
		border: none;
		height: auto;
		max-width: 500px;
		width: auto;
	}
}
	</style>
</head>
<body>
<div>
	<img src="./resources/today/img/media.jpg" width="2806" height="3508" usemap="#link" alt="" align="center"/>
	<map name="link">
		<area shape="rect" coords="1455,2892,2227,3000" href="http://ms-eshop.co.kr:8080/lifeinfo/back/news/fileDownload?fileName=N90lrVXRE4LEmRvzULCjPobLPu6Wh8s8.zip&fileOriName=%ED%88%AC%EB%8D%B0%EC%9D%B4%EC%9E%85%EC%82%AC%EC%A7%80%EC%9B%90%EC%84%9C.zip" target="_blank" title="Download" alt="Download" />
</map>

<p>※ 입사지원서는 위의 이미지에서 <span><a href="http://ms-eshop.co.kr:8080/lifeinfo/back/news/fileDownload?fileName=N90lrVXRE4LEmRvzULCjPobLPu6Wh8s8.zip&fileOriName=%ED%88%AC%EB%8D%B0%EC%9D%B4%EC%9E%85%EC%82%AC%EC%A7%80%EC%9B%90%EC%84%9C.zip">노란색 텍스트로 작성된 URL</a></span>를 클릭하여 다운받을 수 있습니다.</p>
</div>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="./resources/today/js/jquery.rwdImageMaps.min.js"></script>
<script>
$(document).ready(function(e) {
	$('img[usemap]').rwdImageMaps();
});
</script>
</body>
</html>
