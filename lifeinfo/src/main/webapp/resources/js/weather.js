var output = '';
$(document)
		.ready(
				function() {
					// https://api.openweathermap.org/data/2.5/forecast?q=Chuncheon&appid=4cacfeb31c3db06c06ff3c3b2960fd54
					var apiURI = "https://api.openweathermap.org/data/2.5/weather?q=Chuncheon&appid=4cacfeb31c3db06c06ff3c3b2960fd54";
					$
							.ajax({
								url : apiURI,
								dataType : "json",
								type : "GET",
								async : "true",
								success : function(resp) {

									// console.log(resp);
									// console.log("현재온도 : "+ (resp.main.temp-
									// 273.15) );
									$("#currentTemp")
											.html(
													"<B>"
															+ parseInt(resp.main.temp - 273.15)
															+ " ℃" + "<B>");
									$("#minTemp")
											.text(
													parseInt(resp.main.temp_min - 273.15)
															+ " ℃   ~ ");
									$("#maxTemp")
											.text(
													parseInt(resp.main.temp_max - 273.15)
															+ " ℃");
									$("#humidity")
											.text(
													parseInt(resp.main.humidity)
															+ " %");
									$("#wind").text(
											parseInt(resp.wind.speed) + " m/s");

									// console.log("현재습도 : "+
									// resp.main.humidity);
									// console.log("날씨 : "+ resp.weather[0].main
									// );
									var weatherIcon = '<img src="http://openweathermap.org/img/wn/' +  resp.weather[0].icon   + '@2x.png"/>';
									$("#currentValue").html(weatherIcon);

									// console.log("상세날씨설명 : "+
									// resp.weather[0].description );
									// console.log("날씨 이미지 : "+
									// resp.weather[0].icon );
									// console.log("바람 : "+ resp.wind.speed );
									// console.log("나라 : "+ resp.sys.country );
									// console.log("도시이름 : "+ resp.name );
									// console.log("구름 : "+ (resp.clouds.all)
									// +"%" );

									var className = "wi wi-owm-"
											+ resp.weather[0].id;
									$("#weatherIcon").attr("class", className);

									/*
									 * var imgURL =
									 * "http://openweathermap.org/img/w/" +
									 * resp.weather[0].icon + ".png";
									 * $("#weatherIcon").attr("src", imgURL);
									 */
								}
							})
					var apiURI = "mise.json";

					$.ajax({
						url : apiURI,
						dataType : "json",
						type : "GET",
						async : "true",
						success : function(resp) {
							if (resp.mise == 1) {
								output += '<img style="width:50px;height:50px;" src="./resources/images/weather01.png"/>';
								$('#miseTemp').html(output);
							}
							if (resp.mise == 2) {
								output += '<img style="width:50px;height:50px;" src="./resources/images/weather02.png"/>';
								$('#miseTemp').html(output);
							}
							if (resp.mise == 3) {
								output += '<img style="width:50px;height:50px;" src="./resources/images/weather03.png"/>';
								$('#miseTemp').html(output);
							}
							if (resp.mise == 4) {
								output += '<img style="width:50px;height:50px;" src="./resources/images/weather04.png"/>';
								$('#miseTemp').html(output);
							}
						}
					})
				});