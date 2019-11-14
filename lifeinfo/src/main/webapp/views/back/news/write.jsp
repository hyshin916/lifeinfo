<%@ page import="java.util.Date" %>
<%@page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
    String ctx = request.getContextPath();    //콘텍스트명 얻어오기.
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SmartEditor</title>

<!-- SmartEditor를 사용하기 위해서 다음 js파일을 추가 (경로 확인) -->
<script type="text/javascript" src="../../resources/SE/js/HuskyEZCreator.js" charset="utf-8"></script>
<!-- jQuery를 사용하기위해 jQuery라이브러리 추가 -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.0.min.js"></script>
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" ></script>

<script type="text/javascript">
var oEditors = [];
$(function(){
      nhn.husky.EZCreator.createInIFrame({
          oAppRef: oEditors,
          elPlaceHolder: "ir1", //textarea에서 지정한 id와 일치해야 합니다. 
          //SmartEditor2Skin.html 파일이 존재하는 경로
          sSkinURI: "../../resources/SE/SmartEditor2Skin.html",  
          htParams : {
              // 툴바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseToolbar : true,             
              // 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
              bUseVerticalResizer : true,     
              // 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
              bUseModeChanger : true,         
              fOnBeforeUnload : function(){
                   
              }
          }, 
          fOnAppLoad : function(){
              //기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
              oEditors.getById["ir1"].exec("PASTE_HTML", [""]);
          },
          fCreator: "createSEditor2"
      });
      
      //저장버튼 클릭시 form 전송
      $("#save").click(function(){
          oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
          $("#frm").submit();
      });   
      $("#update").click(function(){
    	  oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
    	  $("#frm").submit();
      });
      
});
function pasteHTML(filepath){
    var sHTML = '<img src="http://localhost:8080/lifeinfo/resources/images/'+filepath+'">';
    oEditors.getById["ir1"].exec("PASTE_HTML", [sHTML]);
}
</script>
 
</head>
<body>
<script>
$(function() {
  $( "#start_date" ).datepicker({
    dateFormat: 'yy-mm-dd'
  });
  $( "#expire_date" ).datepicker({
	    dateFormat: 'yy-mm-dd'
  });
});
</script>
<link rel="stylesheet" href="//cdn.rawgit.com/fgelinas/timepicker/master/jquery.ui.timepicker.css">
<script src='//cdn.rawgit.com/fgelinas/timepicker/master/jquery.ui.timepicker.js'></script>
<script>
$(function() {
    $('.timepicker').timepicker();
	
    $('.backList').click(function(){
    	location.href = 'list';
    });
    $('.backListNews').click(function(){
    	location.href = 'list?media=news';
    });
});

</script>
<form id="frm" <c:if test="${mode eq 'update'}">action="updateArticle"</c:if> <c:if test="${mode ne 'update'}">action="addArticle"</c:if> method="post" enctype="multipart/form-data">
<c:choose>
<c:when test="${mode eq 'update'}">

<input type="hidden" name="nsid" value="${detail.nsid}"/>

<c:if test="${media eq 'news'}">
<input type="hidden" name="media" value="news"/>
</c:if>


</c:when>
<c:otherwise>
<input type="hidden" name="nsid" value="${param.articleNO}"/>
</c:otherwise>
</c:choose>
<table width="100%">
		<tr>
			<td>분류</td>
			<td>
				<select name="pcode">
				<c:if test="${detail.pcode eq 'M001' || param.media ne 'news'}"><option value="M001">MS생활뉴스</option>
				</c:if>
				<c:if test="${detail.pcode eq '0001' }"><option value="0001">언론사뉴스(강원일보)</option></c:if>
				<c:if test="${detail.pcode eq '0002' }"><option value="0002">언론사뉴스(강원도민일보)</option></c:if>
				</select>
<!-- 				<select name="catecode">
					<option value="C001">정치</option>
					<option value="C002">경제</option>
					<option value="C003">사회</option>
				</select>
 -->				
				</td>
		</tr>
		 <tr>
            <td>노출여부</td>
            <td>노출<input type="radio" id="viewYN" name="viewYN" value="Y"
            <c:if test="${detail.viewYN eq 'Y'}">checked</c:if>
            <c:if test="${mode ne 'update'}">checked</c:if>
            />비노출<input type="radio" id="viewYN" name="viewYN" value="N"
             <c:if test="${detail.viewYN eq 'N'}">checked</c:if>
            /></td>
        </tr>
         <tr>
            <td>메인등록</td>
            <td>등록<input type="radio" id="important" name="important" value="Y"
             <c:if test="${detail.important eq 'Y'}">checked</c:if>
            />비등록<input type="radio" id="important" name="important" value="N"
             <c:if test="${detail.important eq 'N'}">checked</c:if>
              <c:if test="${mode ne 'update'}">checked</c:if>
            /></td>
        </tr>
        <tr>
            <td>라인뉴스</td>
            <td>등록<input type="radio" id="lineYN" name="lineYN" value="Y"
             <c:if test="${detail.lineYN eq 'Y'}">checked</c:if>
            />비등록<input type="radio" id="lineYN" name="lineYN" value="N"
             <c:if test="${detail.lineYN eq 'N'}">checked</c:if>
              <c:if test="${mode ne 'update'}">checked</c:if>
            /></td>
        </tr>
        <tr>
            <td>제목</td>
            <td><input type="text" id="title" name="title" style="width:800px" value="${detail.title}"/></td>
        </tr>
         <tr>
            <td>부제목</td>
            <td><input type="text" id="sub_title" name="sub_title" style="width:800px" value="${detail.sub_title}" placeholder="부제목"/></td>
        </tr>
        <tr>
            <td>내용</td>
            <td>
                <textarea rows="10" cols="30" id="ir1" name="content" style="width:800px; height:650px;">${detail.content}</textarea>
            </td>
        </tr>
        <tr>
            <td>키워드</td>
            <td><input type="text" id="keyword" name="keyword" style="width:800px" value="${detail.keyword}" placeholder="#키워드"/></td>
        </tr>
 <%
 	Date date = new Date();
 	SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
 	SimpleDateFormat hhmm = new SimpleDateFormat("HH:mm");
 	String today = yyyyMMdd.format(date);
 	String time = hhmm.format(date);
 %>       
         <tr>
            <td>게시일자</td>
            <td><input type="text" id="start_date" name="start_date" style="width:300px" <c:if test="${mode eq 'update'}">value="${detail.start_date}"</c:if> <c:if test="${mode ne 'update'}">value="<%=today%>"</c:if> placeholder="년/월/일"/><input type="text" name="startTime" class='timepicker' <c:if test="${mode eq 'update'}">value="${detail.start_time}"</c:if> <c:if test="${mode ne 'update'}">value="<%=time%>"</c:if>placeholder="게시시간 hh:mm"></td>
        </tr>
         <tr>
            <td>종료일자</td>
            <td><input type="text" id="expire_date" name="expire_date" style="width:300px" <c:if test="${mode eq 'update'}">value="${detail.expire_date}"</c:if> <c:if test="${mode ne 'update'}">value="<%=today%>"</c:if> placeholder="년/월/일"/><input type="text" name="endTime" class='timepicker' <c:if test="${mode eq 'update'}">value="${detail.expire_time}"</c:if> <c:if test="${mode ne 'update'}">value="23:59"</c:if> placeholder="종료시간 ss:mm"></td>
        </tr>
        <tr>
						<td>썸네일 업로드</td>
						<td><c:if test="${mode eq 'update'}"><a href="./fileDownload?fileName=${detail.fileName}&fileOriName=${detail.fileOriName}">${detail.fileOriName}</a><input type="file" name="mediaFile"></c:if><c:if test="${mode ne 'update'}"><input type="file" name="mediaFile"></c:if><label style="color:red;">${detail.imgurl}</label></td>
						<input type="hidden" name="fno" value="${detail.fno}"/>
						<input type="hidden" name="fileName" value="${detail.fileName}"/>
						<input type="hidden" name="fileOriName" value="${detail.fileOriName}"/>
		</tr>
		 <tr>
						<td>유투브 동영상ID</td>
						<td><input type="text" name="youtubeID" value="${detail.youtubeID}"></td>
		</tr>
			<tr>
            <td colspan="2">
            	<c:choose>
            		<c:when test = "${mode eq 'update'}">
            		<input type="button" id="update" value="수정"/>
            		</c:when>
            		<c:otherwise>
            		 <input type="button" id="save" value="저장"/>
            		</c:otherwise>
            	</c:choose>
				
				<c:choose>
            		<c:when test = "${media eq 'news'}">
            		 <input type="button" class="backListNews" value="취소"/>
            		</c:when>
            		<c:otherwise>
            		   <input type="button" class="backList" value="취소"/>
            		</c:otherwise>
            	</c:choose>
				
            </td>
        </tr>
</table>
</form>
 
</body>
</html>

