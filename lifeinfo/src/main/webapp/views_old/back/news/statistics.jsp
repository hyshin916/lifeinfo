
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://localhost:8080/tlds/util.tld" prefix="util"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" ></script>
<div class="container-fluid">
		<div class="row">
          <div class="table-responsive">
           <h2 style="font-size:20px;">라인뉴스</h2>
            <table class="table table-striped">
            	<tr>
            		<th>등록날짜</th>
            		<th>제목</th>
            		<th>조회수</th>
            		<th>게시일자</th>
            		<th>종료일자</th>
            	</tr>
				<c:forEach var="item" items="${artLineList}" varStatus="status">
						<tr>
							<td>${item.date}</td>
							<td>${item.title}</td>
							<td>${item.uv}</td>
							<td>${item.start_date}</td>
							<td>${item.expire_date}</td>
						</tr>
				</c:forEach>
            </table>
            <hr>
            <h2 style="font-size:20px;">언론사주요뉴스</h2>
            <table class="table table-striped">
            	<tr>
            		<th>등록날짜</th>
            		<th>제목</th>
            		<th>조회수</th>
            		<th>게시일자</th>
            		<th>종료일자</th>
            	</tr>
				<c:forEach var="item" items="${newsImpList}" varStatus="status">
						<tr>
							<td>${item.date}</td>
							<td>${item.title}</td>
							<td>${item.uv}</td>
							<td>${item.start_date}</td>
							<td>${item.expire_date}</td>
						</tr>
				</c:forEach>
            </table>
                <hr>
            <h2 style="font-size:20px;">생활뉴스</h2>
            <table class="table table-striped">
            	<tr>
            		<th>등록날짜</th>
            		<th>제목</th>
            		<th>조회수</th>
            		<th>게시일자</th>
            		<th>종료일자</th>
            	</tr>
				<c:forEach var="item" items="${lifeMainList}" varStatus="status">
						<tr>
							<td>${item.date}</td>
							<td>${item.title}</td>
							<td>${item.uv}</td>
							<td>${item.start_date}</td>
							<td>${item.expire_date}</td>
						</tr>
				</c:forEach>
            </table>
          </div>
        </div>
		</div>

</body>
</html>