
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
	<script type="text/javascript" src="./resources/js/textSize.js"></script>
<div style="margin:0 0 0 20px;">
<!-- <a href=javascript:SetFontSize('B')><img style="width:30px;height:30px;" src="./resources/images/plus.png"/></a> <a href=javascript:SetFontSize('S')><img style="width:30px;height:30px;" src="./resources/images/minus.png"/></a> -->
<img style="width:30px;height:30px;" src="./resources/images/hand.png"/>
</div>
	<div class="divPadding">
		<img class="imgURL" src="${detailView.imgurl}">
	</div>
	<div data-role="content" class="divPadding" id="guljasize">
		<article>
			<section
				class="copyright">
				${detailView.content}</section>
			<c:if test="${detailView.pcode eq '0001'}"><div style="margin: 0 5px 30px 5px;"><p>저작권자 ⓒ 강원일보, 무단 전재 및 재배포 금지</p></div></c:if>
			<c:if test="${detailView.pcode eq '0002'}"><div style="margin: 0 5px 30px 5px;"><p>저작권자 ⓒ 강원도민일보 (http://www.kado.net) 무단전재 및 재배포 금지</p></div></c:if>
			
		</article>
		
	</div>
	<!-- <ul id="msFooterFixMenu">
		<li><img style="width:50px;height:50px;" src="./resources/msmart/skin/default/img/tab_logo.png"><a href="/m/">홈</a></li>
	</ul> -->
