
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<link rel="stylesheet" href="./resources/css/oil/oilInfo.css"/>
<script type="text/javascript" src="./resources/js/oilInfo/oilInfo.js"></script>

<div class="main">
	<h2 class="sub-header" style="margin-bottom:10px;">&nbsp;우리동네 유가정보(TOP10)</h2>
	<div id="map" style="width:100%;height:250px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=02c3548457af307b1ca1d674ef8399d6&libraries=services"></script>
<script type="text/javascript" src="./resources/js/oilInfo/oilInfoList.js"></script>
	<div class="table-responsive">
		<div>
<div class="main-tab">
    <ul class="tabList-v1" data-tab="tabs">
        <li id="tabA01" class="tabItem is-selected"><a href="#tab01-1">휘발유</a></li>
        <li id="tabA02" class="tabItem"><a href="#tab01-2">경유</a></li>
    </ul>
    <div class="tabPanel">
    
    </div>
</div>
		</div>
	</div>
</div>

