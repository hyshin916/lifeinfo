
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
<!-- 20.03.27 Author : Mr.shin -->
<script src="../../resources/js/login/login.js"></script>
<!-- 20.03.27 Author : Mr.shin -->
	<style>
body {
	/* background-color: #25274d; */
	
}

.contact {
	padding: 4%;
	height: auto;
}

.col-md-3 {
	background: #ff9b00;
	padding: 4%;
	border-top-left-radius: 0.5rem;
	border-bottom-left-radius: 0.5rem;
}

.contact-info {
	margin-top: 10%;
}

.contact-info img {
	margin-bottom: 15%;
}

.contact-info h2 {
	margin-bottom: 10%;
}

.col-md-9 {
	background: #fff;
	padding: 3%;
	border-top-right-radius: 0.5rem;
	border-bottom-right-radius: 0.5rem;
}

.contact-form label {
	font-weight: 600;
}

.contact-form button {
	background: #25274d;
	color: #fff;
	font-weight: 600;
	width: 25%;
}

.contact-form button:focus {
	box-shadow: none;
}
</style>
	<h2 class="sub-header">착한가게 등록</h2>
	<div class="row" style="width:100%;">
		<div class="col-md-9">
			<form name="">
				<div class="contact-form">
					<div class="form-group">
						<input type="hidden" name="no" id="no" value="${sellerInfo.no}">
						<label class="control-label col-sm-2" for="name">상호명:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name"
								placeholder="상호명 입력" name="name" value="${sellerInfo.name}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="sellerCd">업체코드:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="sellerCd"
								placeholder="업체코드 입력(게시판글번호4자리)" name="sellerCd"  value="${sellerInfo.sellerCd}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="passwd">패스워드:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="passwd" maxlength="4"
								placeholder="업체사장님이 입력하실 패스워드 입력" name="passwd"  value="${sellerInfo.passwd}">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="comment">메모:</label>
						<div class="col-sm-10">
							<textarea class="form-control" rows="5" id="comment">${sellerInfo.comment}</textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2">타임돼지:</label>
						<div class="col-sm-10">
							<input type="checkbox" class="custom-control-input" id="timepig">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<c:if test="${param.flag ne 'view'}"><button type="button" class="btn btn-default" id="register">등록</button></c:if>
							<c:if test="${param.flag eq 'view'}"><button type="button" class="btn btn-default" id="update">수정</button></c:if>
							<c:if test="${param.flag eq 'view'}"><button type="button" class="btn btn-default" id="delete">삭제</button></c:if>
							<button type="reset" class="btn btn-default">초기화</button>
							<button type="button" class="btn btn-default" onclick="javascript:location.href='./list';">목록</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>