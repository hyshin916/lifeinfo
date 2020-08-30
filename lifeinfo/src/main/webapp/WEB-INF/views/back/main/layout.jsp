
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>ms CMS</title>

<!-- Bootstrap core CSS -->
<link href="../../resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="../../resources/css/dashboard.css" rel="stylesheet">

</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">ms CMS</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<c:if test="${groupID eq 'admin' || groupID eq 'ms_002' }">
					<li><a href="../franch/list">착한가게목록</a></li>
					<li><a href="../franch/franchWrite">착한가게등록</a></li>
					<li><a href="../franch/statisList">착한가게통계</a></li>
					</c:if>
				</ul>
				<!-- <form class="navbar-form navbar-right" name="searchForm"
					action="search" method="POST">
					<span><input type="text" id="datepicker1" name="startDate"></span>
					<span>~</span>
					<span><input type="text" id="datepicker2" name="endDate"></span>
					<span><input type="submit" value="검색"></span>
					<input type="text" class="form-control" placeholder="Search..."
						name="searchValue">

				</form> -->
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div id="shinnav" class="col-sm-3 col-md-2 sidebar">
				<div><span><p>${memName} 님 반갑습니다.</p></span><button class="btn btn-primary" onclick="javascript:location.href='../../logout'">로그아웃</button></div>
<style>
ul ul {display :none;}
</style>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script>
 $(document).ready(function(){
	 $('.menu').on('click',function(){
		 $('ul ul').css('display','none');
	 	 var a = $(this).attr('id');
	 	 $('.'+a).css('display','block');
	 });
 });
</script>


<ul class="nav nav-sidebar">
<%-- <c:forEach var="item" items="${menuList}" varStatus = "status">
<li><c:if test="${item.menu_order eq 0}"><a href="#" class="menu" id="menu_${item.menu_id}">${item.menu_name}</a></c:if>
	<ul class="menu_${item.menu_id}">
    <c:forEach var="item_sub" items="${menuList}" varStatus = "status">
			<c:if test="${item.menu_parent eq item_sub.menu_parent}"><c:if test="${item_sub.menu_order eq 1}"><li><a href="${item_sub.menu_link}">${item_sub.menu_name}</a></li></c:if></c:if>
			<c:if test="${item.menu_parent eq item_sub.menu_parent}"><c:if test="${item_sub.menu_order eq 2}"><li><a href="${item_sub.menu_link}">${item_sub.menu_name}</a></li></c:if></c:if>
	</c:forEach>
	</ul>
</li>
</c:forEach> --%>
<c:forEach var="item" items="${menuList}" varStatus = "status">
			<c:if test="${item.menu_order eq 0}"><li><a href="${item.menu_link}" style="color:#FF7F00;"><span class="glyphicon glyphicon-check" aria-hidden="true"></span><B>${item.menu_name}</B></a></li></c:if>
			<c:if test="${item.menu_order eq 1}"><li><a href="${item.menu_link}">&nbsp;&nbsp;▶ ${item.menu_name}</a></li></c:if>
			<c:if test="${item.menu_order eq 2}"><li><a href="${item.menu_link}">&nbsp;&nbsp;▶ ${item.menu_name}</a></li></c:if>
			<c:if test="${item.menu_order eq 3}"><li><a href="${item.menu_link}">&nbsp;&nbsp;▶ ${item.menu_name}</a></li></c:if>
			<c:if test="${item.menu_order eq 4}"><li><a href="${item.menu_link}">&nbsp;&nbsp;▶ ${item.menu_name}</a></li></c:if>
</c:forEach>
</ul>
				<ul class="nav nav-sidebar">
					<!-- <li><a href="list">MS생활뉴스</a></li>
					<li><a href="list?media=news">언론사뉴스</a></li>
					<li><a href="statistics">통계</a></li> -->
				</ul>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <div class="table-responsive">
            <table class="table table-striped">
            <tiles:insertAttribute name="main"/>
            </table>
          </div>
        </div>
		</div>

	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="../../resources/js/bootstrap.min.js"></script>
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->

	
</body>
</html>
