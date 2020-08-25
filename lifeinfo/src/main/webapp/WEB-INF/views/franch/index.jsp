
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 뷰포트 -->
<meta name="viewport" content="width=device-width" initial-scale="1">
<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>
<!-- 스타일시트 참조  -->
<link rel="stylesheet" href="./resources/franch/css/bootstrap.min.css">
<link rel="stylesheet" href="./resources/franch/css/style.css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<!-- 애니매이션 담당 JQUERY -->

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
 <!-- 부트스트랩 JS  -->
<script src="./resources/franch/js/bootstrap.js"></script>
<script src="./resources/franch/js/script.js"></script>

<title>MS마트 앱회원 인증서비스</title>
</head>

<body>
 <!-- 로긴폼 -->

 <div class="container">
   <div class="form_center">
  <div class="col-lg-4" style="background-color:#ffffff;">
    <a href="#"><img src="./resources/franch/img/wooridongnae.png" alt=""></a>
  </div>
  <div class="col-lg-4">
  <!-- 점보트론 -->
   <div class="jumbotron">

   <form method="post" action="franch" id="franchFrm">
    <h3 style="text-align: center; margin-top:0; margin-bottom:11px;"> MS앱 회원 인증 </h3>
    <div class="form-group">
     <input type="text" class="form-control" placeholder="전화번호" id="userID" name="userID" maxlength="20">
    </div>
<!-- 
    <div class="form-group">
     <input type="password" class="form-control" placeholder="비밀번호" id="userPassword" name="userPassword" maxlength="20">
    </div> -->
<!--     <label><input type="checkbox" name="number" value="number"> 전화번호 저장</label> -->
    <input type="button" id="login_btn" class="btn btn-primary form-control" value="인증하기">
    <a href="http://ms-eshop.co.kr/m/member_join.php">회원가입</a>
    <!-- <a href="http://ms-eshop.co.kr/m/findpwd.php">아이디/비밀번호 찾기</a> -->
   </form>
  </div>

   <div class="footer">
    <p><span class="sm-text">(주)</span>무상엠에스마트</p>
    <p><span class="icon1"></span>강원도 춘천시 충열로 79번길(우두동)</p>
    <p><span class="icon2"></span>033-243-8888</p>
    <p>(평일 AM 09:00~PM 18:00,토/일/공휴일 휴무)</p>
   </div>

<div id="edd" style="visibility:hidden;opacity:0">
   <ul class="box-flow">
    <li>
      <img src="./resources/franch/img/banner1.jpg" alt="배너 1" />
    </li>
    <li>
      <img src="./resources/franch/img/banner2.jpg" alt="배너 2" />
    </li>
    <li>
      <img src="./resources/franch/img/banner3.jpg" alt="배너 3" />
    </li>
    <li>
      <img src="./resources/franch/img/banner1.jpg" alt="배너 1" />
    </li>
    <li>
      <img src="./resources/franch/img/banner2.jpg" alt="배너 2" />
    </li>
    <li>
     <img src="./resources/franch/img/banner3.jpg" alt="배너 3" />
    </li>
   </ul>
  </div>
 </div>
</div>
</div>

</body>

</html>
