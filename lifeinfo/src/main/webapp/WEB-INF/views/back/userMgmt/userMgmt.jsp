
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
	<!-- Bootstrap core CSS -->
	<link href="../../resources/css/bootstrap.min.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<link href="../../resources/css/dashboard.css" rel="stylesheet">
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

	<SCRIPT LANGUAGE="JavaScript">
		function chkBoxCheck(intChkNumber,group_id) {
			$("input[name=chkMenu]").prop("checked",false);

			// 체크박스 갯수만큼 반복문을 돌면서
			for (j = 0; j < 3; j++) {

				// 체크박스가 선택되어 있으면
				if (eval("document.myForm.checkGroup[" + j + "].checked") == true) {

					// 우선 체크박스의 속성을 선택되지 않음으로 하고
					document.myForm.checkGroup[j].checked = false;
					// 사용자가 클릭한 체크박스와 프로그래밍적으로 돌고 있는
					// 체크박스의 번호가 같으면
					if (j == intChkNumber) {
							$
									.ajax({
										url : "./groupMenu",
										type : "GET",
										dataType : "json",
										data : {
											'group_id' : group_id
										},
										success : function(resp) {
											$
													.each(
															resp,
															function(k, v) {
																for (var i = 0; i < v.length; i++) {
																	document
																			.getElementById(v[i]).checked = true;
																}
															});
										},
										error : function(e) {
											alert('관리자에게 문의주세요.');
										}
									});

						// 이런 경우만 체크박스가 선택되도록 한다...
						document.myForm.checkGroup[j].checked = true;
					}
				}
			}
		}
	</script>
	<h2 class="sub-header">그룹권한등록</h2>
	<h3>권한그룹</h3>
	<div class="row" style="width: 100%;">
		<form name="myForm">
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						aria-label="..." name="checkGroup"
						onclick="chkBoxCheck(0,'admin');" value="admin">
					</span> <input type="text" class="form-control" aria-label="..."
						value="관리자" readOnly>
				</div>
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						aria-label="..." name="checkGroup"
						onclick="chkBoxCheck(1,'ms_001');" value="ms_001">
					</span> <input type="text" class="form-control" aria-label="..."
						value="일반그룹" readOnly>
				</div>
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						aria-label="..." name="checkGroup"
						onclick="chkBoxCheck(2,'ms_002');" value="ms_002">
					</span> <input type="text" class="form-control" aria-label="..."
						value="매장그룹" readOnly>
				</div>
				<!-- /input-group -->
			</div>
		</form>
		<!-- /.col-lg-6 -->

	</div>
	<!-- /.row -->
	<hr>
	<h3>접근 메뉴</h3>
	<div class="row" style="width: 100%;">
		<form name="myForm1">
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						name="chkMenu" id="0001" aria-label="...">
					</span> <input type="text" class="form-control" aria-label="..."
						value="착한가게관리">
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-lg-6 -->
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						name="chkMenu" id="0002" aria-label="...">
					</span> <input type="text" class="form-control" aria-label="..."
						value="착한가게등록">
				</div>
				<!-- /input-group -->
			</div>
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						name="chkMenu" id="0003" aria-label="...">
					</span> <input type="text" class="form-control" aria-label="..."
						value="이용자통계">
				</div>
				<!-- /input-group -->
			</div>
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						name="chkMenu" id="0004" aria-label="...">
					</span> <input type="text" class="form-control" aria-label="..."
						value="앱DB확인수정">
				</div>
				<!-- /input-group -->
			</div>
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						name="chkMenu" id="0005" aria-label="...">
					</span> <input type="text" class="form-control" aria-label="..."
						value="사용자관리">
				</div>
			</div>
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						name="chkMenu" id="0006" aria-label="...">
					</span> <input type="text" class="form-control" aria-label="..."
						value="그룹권한등록">
				</div>
			</div>
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						name="chkMenu" id="0007" aria-label="...">
					</span> <input type="text" class="form-control" aria-label="..."
						value="사용자승인">
				</div>
			</div>
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						name="chkMenu" id="0008" aria-label="...">
					</span> <input type="text" class="form-control" aria-label="..."
						value="신규프로젝트마일스톤">
				</div>
			</div>
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						name="chkMenu" id="0009" aria-label="...">
					</span> <input type="text" class="form-control" aria-label="..."
						value="뉴스파서시작/종료">
				</div>
			</div>
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						name="chkMenu" id="0010" aria-label="...">
					</span> <input type="text" class="form-control" aria-label="..."
						value="이용자 추첨이벤트">
				</div>
			</div>
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						name="chkMenu" id="0011" aria-label="...">
					</span> <input type="text" class="form-control" aria-label="..."
						value="렌탈서비스 접수조회">
				</div>
			</div>
			<div class="col-lg-6">
				<div class="input-group">
					<span class="input-group-addon"> <input type="checkbox"
						name="chkMenu" id="0012" aria-label="...">
					</span> <input type="text" class="form-control" aria-label="..."
						value="렌탈서비스 접수조회(코웨이)">
				</div>
			</div>
			<!-- /input-group -->
		</form>
	</div>
	<!-- /input-group -->

	<button type="button" class="btn btn-default" id="addGrpMenu"
		style="margin-top: 5px;">저장</button>

</body>
</html>