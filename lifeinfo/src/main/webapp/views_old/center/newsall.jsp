
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<style>
.newsallClass {
	text-align: left;
	margin: 5px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
<div class="main">
	<h2 class="sub-header">&nbsp;많이 본 뉴스</h2>
	<div class="table-responsive">
		<div>
			<ul id="articleList">
				<script src="./resources/js/newsall.js"></script>
			</ul>
		</div>
	</div>
</div>

