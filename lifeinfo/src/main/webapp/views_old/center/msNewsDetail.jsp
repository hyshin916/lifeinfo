
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<link rel="stylesheet" href="./resources/css/detailNews.css">

	<article>
		<section
			class="title">
			<B>"${detailView.title}"</B>
		</section>
	</article>
	<div style="text-align:right;">
		<%-- <span style="font-size:14px;"><img src="./resources/images/eye_1.png" style="margin:0 3px 0 0;"/>${detailView.uv}</span> --%>
		<span class="date">[${detailView.date}]</span>
	</div>
	<div class="divPadding">
			<c:if test="${detailView.youtubeID ne ''}">
				<iframe id="ytplayer" type="text/html" width="100%" height="200"
			  	src="https://www.youtube.com/embed/${detailView.youtubeID}?autoplay=1"
			 	 frameborder="0"></iframe>
			</c:if>		
	</div>
<script type="text/javascript" src="./resources/js/textSize.js"></script>
<div style="margin:0 0 0 20px;">
<a href=javascript:SetFontSize('B')><img style="width:30px;height:30px;" src="./resources/images/plus.png"/></a> <a href=javascript:SetFontSize('S')><img style="width:30px;height:30px;" src="./resources/images/minus.png"/></a>
</div>
	<div data-role="content" class="divPadding" id="guljasize">
		<article>
			<section
				class="copyright">
				${detailView.content}</section>
		</article>
		
	</div>
	<!-- <ul id="msFooterFixMenu">
		<li><img style="width:50px;height:50px;" src="./resources/msmart/skin/default/img/tab_logo.png"><a href="/m/">홈</a></li>
	</ul> -->
