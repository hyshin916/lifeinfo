function getLocation() {
  
  if (navigator.geolocation) { // GPS를 지원하면
    navigator.geolocation.getCurrentPosition(function(position) {
      document.getElementById("main_frame").src='https://192.168.0.13:8080/open/positionInfra?x=' + position.coords.longitude + '&y=' +position.coords.latitude;
    }, function(error) {
      console.error(error);
    }, {
      enableHighAccuracy: false,
      maximumAge: 0,
      timeout: Infinity
    });
  } else {
    alert('GPS를 지원하지 않습니다');
  }
}
<!--getLocation();-->