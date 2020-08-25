
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<script type="text/javascript" src="./resources/js/weather.js"></script>
<style>

.currentValue {
	font-size : 20px;
	position: absolute; 
	margin: 0px 0px 0px 10px;
}
.currentTemp {
 font-size: 20px;
 position: absolute;
 margin: 35px 0px 0px 10px;	
}
.minTemp {
	font-size: 12px;
	position: absolute; 
	margin: 60px 0px 0px 10px;
}
.maxTemp {
	font-size: 12px; 
	position: absolute;
	margin: 60px 0px 0px 52px;
}
.humidityLabel {
	font-size: 12px;
	position: absolute;
	margin: 30px 0px 0px 95px;
}
.humidity {
	font-size: 12px;
	position: absolute;
	margin: 30px 0px 0px 125px;
}

.windLabel {
	font-size: 12px;
 	position: absolute; 
	margin: 10px 0px 0px 95px;
}
.wind {
	font-size: 12px;
	position: absolute;
	margin: 10px 0px 0px 125px;
}
.miseTempLabel {
	font-size: 12px;
	position: absolute;
	margin: 10px 0px 0px 170px;
}
.miseTemp {
	font-size: 20px; 
	position: absolute;
	margin: 32px 0px 0px 170px;
}

</style>



<div class="weather_head">
	<div class="all_title">
		<h4><p>오늘의 <span>날씨</span></p></h4>
	</div>
	<div class="address">
		<a href="#"><img src="./resources/front/img/marker2.png"
			alt="maker"></a> <span>강원도 춘천시</span>
	</div>
</div>
<div class="weather_condition">
	  <table style="text-align:center;padding: 0 2% 2% 2%;color: #222;">
		<tr>
			  <td rowspan="2" style="width:20%;"><span id="currentValue"></span></td>
			  <td colspan="3" style="text-align:left;"><p id="currentValueTxt"></p></td>
			  <td style="text-align:right;">미세먼지</td>
		</tr>
		<tr>
		          <td><p><span><span id="currentTemp"></span><span class="small_p">℃</span></span></p></td>
				  <td style="text-align:left;"><p>풍속 : <span id="wind" style="font-size:1.5rem;"></span> m/s</p></td>
            <td style="text-align:left;"><p>습도 : <span id="humidity" style="font-size:1.5rem;"></span>%</p></td>
            <td style="color:#CE3636;text-align:right;"><p id="miseTxt"></p></td>
		</tr>
	</table>
</div>

