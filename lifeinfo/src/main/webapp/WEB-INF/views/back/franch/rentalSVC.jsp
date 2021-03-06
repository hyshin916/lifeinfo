
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
	<style>
#sortable {
	list-style: none;
}
</style>
	<link
		href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"
		rel="stylesheet" type="text/css" />
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script type="text/javascript"
		src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(function() {
			
			$("#startDate").datepicker({
				dateFormat : 'yy-mm-dd'
			}).val();
			$("#endDate").datepicker({
				dateFormat : 'yy-mm-dd'
			}).val();

			
			

			$("#testDatepicker").datepicker({
				dateFormat : 'yy-mm-dd'
			}).val();
			$("#testDatepicker1").datepicker({
				dateFormat : 'yy-mm-dd'
			}).val();

			$("#sortable").sortable();

			$("#sortable").disableSelection();

			$(".ui-state-default").click(function(event) {

				var i = $(this).index();
				console.log(i); // 0번째
			});
			$(".sortArticle")
					.click(
							function(event) {
								console.log($('li').length);
								$('#sortable li')
										.each(
												function(e) {
													$(this)
															.attr(
																	'idx',
																	$('li').length
																			- $(
																					this)
																					.index());
													var params = "nsid="
															+ $(this).attr(
																	'nsid')
															+ '&idx='
															+ $(this).attr(
																	'idx');
													$
															.ajax({
																url : "updateOrderByNO",
																type : "POST",
																data : params,
																success : function(
																		args) {
																	console
																			.log('updateOrderByNo : success');
																},
																error : function(
																		e) {
																	alert('에러발생.관리자에게 문의주세요.');
																}
															});
												});
							});
			$(".wrietArticle")
					.click(
							function() {

								$
										.ajax({
											url : "http://${moreNewsURL}:8080/lifeinfo/getArticleNO.json",
											type : "GET",
											dataType : "json",
											success : function(args) {
												console.log(args.articleNO);
												location.href = 'write?articleNO='
														+ args.articleNO;
											},
											error : function(e) {
												alert('관리자에게 문의주세요.');
											}
										});
							});

			$(".deploy").click(function() {

				$.ajax({
					url : "http://${moreNewsURL}:8080/lifeinfo/deploy.json",
					type : "GET",
					dataType : "json",
					success : function(args) {
						alert('배포적용완료');
					},
					error : function(e) {
						alert('관리자에게 문의주세요.');
					}
				});
			});

		});
	</script>
	<script>
		function chkBoxCheck(intChkNumber) {

			for (j = 0; j < 2; j++) {
				if (eval("document.searchFrm.viewYN[" + j + "].checked") == true) {
					document.searchFrm.viewYN[j].checked = false;
					if (j == intChkNumber) {
						document.searchFrm.viewYN[j].checked = true;
					}
				}
			}
		}
	</script>

	<%-- <ul id="sortable">
	<c:forEach var="item" items="${newsList}" varStatus="status">
 		 <li class="ui-state-default" nsid="${item.nsid}"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>
 		 <a href="http://${moreNewsURL}:8080/lifeinfo/back/news/write?view=true&nsid=${item.nsid}<c:if test="${pageView eq '?media=news'}">&media=news</c:if>"><c:if test="${item.pcode eq '0001'}"><B>[강원일보]</B></c:if><c:if test="${item.pcode eq '0002'}"><B>[강원도민일보]</B></c:if>${item.title}</a>
 		 <c:if test="${pageView eq '?media=news'}">[${item.date}]</c:if><c:if test="${pageView ne '?media=news'}">[${item.start_date}]</c:if><B>Line:<span style="color:red;">${item.orderbyNOLine}</span></B></li>
	</c:forEach>
</ul>
<div style="width:100%;text-align:center;">

	<c:choose>
		<c:when test="${pageView eq '?media=news'}">
			<util:pagination url="./list?media=news" name="pageHolder" parameters="title,pcode,lineYN,important,viewYN"/>
		</c:when>
		<c:otherwise>
			<util:pagination url="./list" name="pageHolder" parameters="title,pcode,lineYN,important,viewYN"/>
		</c:otherwise>
	</c:choose>


<form action="<c:if test="${pageView eq '?media=news'}">./list?media=news</c:if><c:if test="${pageView ne '?media=news'}">./list</c:if>" method="POST" name="searchFrm">
 		  <input type="checkbox" name="lineYN" value="Y" ${param.lineYN eq 'Y' ? 'checked' : ''}/><span style="font-size:15px;">라인뉴스</span>
          <c:if test="${pageView eq '?media=news'}">
          <input type="checkbox" name="important" value="Y" ${param.important eq 'Y' ? 'checked' : ''}/><span style="font-size:15px;">주요기사</span>
          </c:if>
          <input type="checkbox" name="viewYN" value="N" ${param.viewYN eq 'N' ? 'checked' : ''} onClick="chkBoxCheck(0);"/><span style="font-size:15px;">비노출기사</span>
          <input type="checkbox" name="viewYN" value="Y" ${param.viewYN eq 'Y' ? 'checked' : ''} onClick="chkBoxCheck(1);"/><span style="font-size:15px;">노출기사</span>
<c:if test="${pageView eq '?media=news'}">
<select name="pcode">
	<option value="0001" ${param.pcode eq '0001' ? 'selected' : ''}>강원일보</option>
	<option value="0002" ${param.pcode eq '0002' ? 'selected' : ''}>강원도민일보</option>
</select>
</c:if>
<input type="text" name="title"/><input type="submit" value="검색"/>
</form>
<button class="sortArticle">정렬수정</button>
<c:if test="${pageView ne '?media=news'}"><button class="wrietArticle">기사작성</button></c:if>

<button class="deploy">디플로이</button>
</div> --%>

	<style>
#loading {
	width: 100%;
	height: 100%;
	top: 0px;
	left: 0px;
	position: fixed;
	display: block;
	opacity: 0.7;
	background-color: #fff;
	z-index: 99;
	text-align: center;
}

#loading-image {
	position: absolute;
	top: 50%;
	left: 50%;
	z-index: 100;
}
</style>
	<script type="text/javascript">
		$(window).load(function() {
			$('#loading').hide();
		});
	</script>
	<div id="loading">
		<img id="loading-image" src="../../resources/franch/img/loading.gif"
			alt="Loading..." />
	</div>

	<h2 class="sub-header">렌탈서비스 접수조회</h2>
	<script>
		var searchRentalSvc = function() {
			
			if (document.franchEvtFrm.startDate.value == null
					|| document.franchEvtFrm.startDate.value == "") {
				alert('시작날짜를 입력해 주세요!');
				document.franchEvtFrm.startDate.focus();
				return false;
			}
			if (document.franchEvtFrm.endDate.value == null
					|| document.franchEvtFrm.endDate.value == "") {
				alert('종료날짜를 입력해 주세요!');
				document.franchEvtFrm.endDate.focus();
				return false;
			}
			loadingCall();
			dpFrm.submit();
		}


		var loadingCall = function() {
			setInterval(function() {
				$('#loading').hide();
			}, 5000);
			$('#loading').show();
		}
	</script>



	<style>
.allUsers_right {
	text-align: right;
}

.allUsers {
	margin: 0 20px;
}
</style>


	<style>
select {
	width: 200px;
	padding: .3em .5em;
	border: 1px solid #999;
	font-family: inherit;
	background: url('../../resources/images/arrow.png') no-repeat 100%;
	background-size: 30px 30px;
	border-radius: 0px;
	-webkit-appearance: none;
	-moz-appearance: none;
	appearance: none;
}

select::-ms-expand {
	display: none;
}
</style>

	<div class="table-responsive">
		<form name="dpFrm" action="./rentalSVC?status=search" method="POST">
			<div>
				<span>업체명 :</span> <span> <select name="rentalStatus" id="rentalStatus">
						<option value="3499" <c:if test="${rentalStatus eq '3499'}">selected</c:if>>넥센타이어렌탈</option>
						<option value="4387" <c:if test="${rentalStatus eq '4387'}">selected</c:if>>SK렌터카</option>
				</select>

				</span> <span>날짜검색 : </span> <span><input type="text"
					name="startDate" id="testDatepicker" value="${param.startDate}"></span>
				<span><input type="text" name="endDate" id="testDatepicker1"
					value="${param.endDate}"></span>
				<button class="btn btn-primary" onclick="searchRentalSvc();">검색</button>
			</div>
		</form>
		<div class="allUsers_right">
			<span class="allUsers">전체 신청 수 : ${totalCount}</span>
		</div>
		<c:if test="${rentalStatus eq '3499'}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>NO</th>
					<th>이용자명</th>
					<th>전화번호</th>
					<th>차종</th>
					<th>타이어사이즈</th>
					<th>지역</th>
					<th>신청날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${rentalList}" varStatus="status">
					<tr>
						<td><c:if test="${totalCount ne null}">${(totalCount-status.index)-((currentPage-1)*displayNum)}</c:if>
							<c:if test="${totalCount eq null}">${status.index + 1}</c:if></td>
						<td>${item.name}</td>
						<td>${item.id}</td>
						<td>${item.kind}</td>
						<td>${item.size}</td>
						<td>${item.local}</td>
						<td>${item.date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		<c:if test="${rentalStatus eq '4387'}">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>NO</th>
					<th>이용자명</th>
					<th>전화번호</th>
					<th>차종</th>
					<th>문의사항</th>
					<th>신청날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${rentalList}" varStatus="status">
					<tr>
						<td><c:if test="${totalCount ne null}">${(totalCount-status.index)-((currentPage-1)*displayNum)}</c:if>
							<c:if test="${totalCount eq null}">${status.index + 1}</c:if></td>
						<td>${item.name}</td>
						<td>${item.id}</td>
						<td>${item.kind}</td>
						<td>${item.rtquestion}</td>
						<td>${item.date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</c:if>
		
		<div style="width: 100%; text-align: center;">
			<%-- <c:if test="${status eq 'evt'}">
				<util:pagination url="./event?status=evtStart&flag=N"
					name="pageHolder" parameters="startDate,endDate" />
			</c:if>
			<c:if test="${status ne 'evt'}">
				<util:pagination url="./event?status=searchDP" name="pageHolder"
					parameters="startDate_1,endDate_1" />
			</c:if> --%>
			<c:if test="${status eq 'rentalSVC'}">
				<util:pagination url="./rentalSVC?status=search" name="pageHolder"
					parameters="startDate,endDate,rentalStatus" />
			</c:if>
		</div>
	</div>

</body>
</html>