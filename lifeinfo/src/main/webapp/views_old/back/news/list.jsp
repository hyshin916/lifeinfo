
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
	list-style : none;
}

</style>
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" ></script>
<script>
$(function() {

    $("#sortable").sortable();

    $("#sortable").disableSelection();

    $(".ui-state-default").click(function(event) {
   	 
        var i = $(this).index();  
        console.log(i);  // 0번째
    });
    $(".sortArticle").click(function(event) {
    	console.log($('li').length);
    	  $('#sortable li').each( function(e) {
    		  $(this).attr('idx',$('li').length - $(this).index());
    		  var params = "nsid=" + $(this).attr('nsid') + '&idx=' +  $(this).attr('idx');
    		  $.ajax({
    			  url : "updateOrderByNO",
    			  type : "POST",
    			  data : params,
    			  success:function(args) {
    				  console.log('updateOrderByNo : success');
    			  },
    			  error:function(e) {
    				  alert('에러발생.관리자에게 문의주세요.');
    			  }
    		  });
    	  });
    });
    $(".wrietArticle").click(function(){
    	
    	$.ajax({
    		url : "http://${moreNewsURL}:8080/lifeinfo/getArticleNO.json",
    		type : "GET",
    		dataType : "json",
    		success : function(args) {
    			console.log(args.articleNO);
    			location.href = 'write?articleNO=' + args.articleNO; 
    		},
    		error : function(e)	 {
    			alert('관리자에게 문의주세요.');
    		}
    	});
     });
    
    $(".deploy").click(function(){
    	
    	$.ajax({
    		url : "http://${moreNewsURL}:8080/lifeinfo/deploy.json",
    		type : "GET",
    		dataType : "json",
    		success : function(args) {
				alert('배포적용완료');
    		},
    		error : function(e)	 {
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

<ul id="sortable">
	<c:forEach var="item" items="${newsList}" varStatus="status">
 		 <li class="ui-state-default" nsid="${item.nsid}"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>
 		 <a href="http://${moreNewsURL}:8080/lifeinfo/back/news/write?view=true&nsid=${item.nsid}<c:if test="${pageView eq '?media=news'}">&media=news</c:if>"><c:if test="${item.pcode eq '0001'}"><B>[강원일보]</B></c:if><c:if test="${item.pcode eq '0002'}"><B>[강원도민일보]</B></c:if>${item.title}</a>
 		 <c:if test="${pageView eq '?media=news'}">[${item.date}]</c:if><c:if test="${pageView ne '?media=news'}">[${item.start_date}]</c:if></li>
	</c:forEach>
</ul>
<div style="width:100%;text-align:center;">
	<util:pagination url="./list" name="pageHolder" parameters="title,pcode,lineYN,important,viewYN"/>
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
</div>


</body>
</html>