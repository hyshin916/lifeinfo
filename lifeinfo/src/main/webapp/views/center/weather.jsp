
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



<h2 class="sub-header">&nbsp;춘천 날씨</h2>
<div class="table-responsive" style="height:155px">
	<form name="my_form">
		<table class="table table-striped">
			<thead>
			</thead>
			<tbody>
				<tr>
					<td><div style="height:155px">
								<span id="currentValue" class="currentValue">
								</span> 
								<span id="currentTemp" class="currentTemp">
								</span> 
								<span id="minTemp" class="minTemp">
								</span> 
								<span id="maxTemp" class="maxTemp">
								</span>
								<span class="humidityLabel">
								습도</span>
								<span id="humidity" class="humidity">
								</span>
								<span class="windLabel">
								풍속</span>
								<span id="wind" class="wind">
								</span>
								<span class="miseTempLabel">
								미세먼지</span>
								<span id="miseTemp" class="miseTemp">
								</span>
								
						</div></td>
				</tr>
			</tbody>
		</table>
	</form>
</div>

