$(document).ready(function(){
  $('#slider').bxSlider({
  speed: 500,
  pause: 2000,
  autoDelay:2000,
  auto: true,
  pager: ($("#slider li").length > 1) ? true: false,
  touchEnabled: ($("#slider li").length > 1) ? true: false,
  responsive:true,
  controls: false,
});

});
