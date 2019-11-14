$(document).ready(function(){


      var windowWidth = 0;
      var ini_h = 0;
      var h = 0;
      var h2= 0;

      var galery_onoff = false; //갤러리형 버튼이 눌렸을 때 변경되는 값(=갤러리버튼 스위치)
      var width_onoff = false; // 모바일 기기 너비가 세로 or 가로모드(반대)로 변경되었을 때의 값(=너비변경 스위치)

  windowWidth = $( window ).width();
  h2 = $('.contents_list_wrap ul').height();

  $( window ).resize();


  $('.slider').bxSlider({
    speed: 1000,
    auto: true,
  });

  $('.text_slider').bxSlider({
    speed: 1000,
    auto: false,
  });

  $('ul.tabs li').click(function(){
    var tab_id = $(this).attr('data-tab');

    $('ul.tabs li').removeClass('current');
    $('.tab-content').removeClass('current');

    $(this).addClass('current');
    $("#"+tab_id).addClass('current');
  });
  var size = $('.topic_list li').length;
  var cnt = -1;
  var timer = 0, delay = 1000;

  timer = setInterval(make, delay);

  function make(){
    $('.topic_list li').eq(cnt).removeClass('test');
    add();
   if(cnt > size-1)
   {
       cnt = -1;
   }
}

  function add(){
    cnt++;
    $('.topic_list li').eq(cnt).addClass('test');
    }
});

$(function(){
//  $( window ).resize();

      var check_onoff = false; //더블클릭 체크
      var num = 0;


$(window).on("orientationchange",function(){

  onoff2 = false;
  jQuery('.contents_list_wrap ul').css("height", "auto");

  if(galery_onoff !=true)
  {
    jQuery('.contents_list_wrap ul').css("height", "auto");
    var num2 = $('.contents_list_wrap ul').height();
    jQuery('.contents_list_wrap ul').css("height", num2);
    if(width_onoff!=false)
    {
      jQuery('.contents_list_wrap ul').css("height", "auto");
      $('.contents_list_wrap ul').resize();
      width_onoff=false;
    }
    else{
    //  jQuery('.contents_list_wrap ul').css("height", "auto");
    //  var num3 = $('.contents_list_wrap ul').height();
    //  jQuery('.contents_list_wrap ul').css("height", num3);
      width_onoff=false;
    }
  }
  else{
    $('.contents_list_wrap ul').resize();
  }

//  if(width_onoff!=false)
//  {
//    $('.contents_list_wrap ul').resize();
//    width_onoff=false;
//  }
  //else{
  //  var num3 = $('.contents_list_wrap ul').height();
  //  jQuery('.contents_list_wrap ul').css("height", num3);
  //  width_onoff = true;
//  }

    //width_onoff = false; // 모바일 기기 너비 스위치가 눌려짐

  width_onoff = true;

//  jQuery('.contents_list_wrap ul').css("height", "auto");
//  var num2 = $('.contents_list_wrap ul').height();

//   alert(num2);
//  jQuery('.contents_list_wrap ul').css("height", num2);
//  $('.contents_list_wrap ul').resize();
});

    $('#search_btn').click(function(){
      $('.search_layer').slideToggle();
      $('#text1').focus();
    });
    $("#back").click(function(){
     window.history.back();
   });

   $('.iconSpan1').click(function(){
  //   check_onoff = false;
       galery_onoff = false;
    //  var num = 0;
  //    num = $('.contents_list_wrap ul li').height();
    //  num = num * $('.contents_list_wrap ul li').length;

      //jQuery('.contents_list_wrap ul').css("height", );
      jQuery('.img_wrap02').css("width", "65%");
      jQuery('.content_list img').css("min-height", "100%");
      jQuery('.content_list').css("display", "flex");
      jQuery('.content01').css("width", "100%");
      jQuery('.contents_list_wrap ul li').css("width", "100%");
      jQuery('.content_list').css("border-radius", "0px");
      jQuery('.max_line').css("min-height", "0px");
      jQuery('.content01 p').css("margin-bottom", "20px");
      jQuery('.max_line p').css("font-size", "1.1em");
      jQuery('.content_list').css("border-top", "0");
      jQuery('.content01 p').css("margin-top", "3px");
      jQuery('.contents_list_wrap ul li').css("margin-left", "0%");
      jQuery('.contents_list_wrap ul li').css("margin-right", "0%");
      jQuery('.contents_list_wrap ul li').css("width", "100%");
      //$('.contents_list_wrap ul').resize();
      jQuery('.contents_list_wrap ul').css("height", "auto");
      jQuery('.contents_list_wrap ul').css("width", "100%");
   })

   $(window).on("resize", function(event){
    // jQuery('.contents_list_wrap ul').css("height", "auto");
     //jQuery('.contents_list_wrap ul').css("width", "100%");
    //  alert($(this).width());
  //  jQuery('.contents_list_wrap ul').css("height", "auto");
    //  alert("a");

  //  $('.contents_list_wrap ul').resize();
  //  onoff2=false;

  //  if(onoff2!=false)
  //  {
  //    var num2 = $('.contents_list_wrap ul').height();
  //    jQuery('.contents_list_wrap ul').css("height", num2);
  //    $('.contents_list_wrap ul').resize();
//}
});

    //alert(ini_h);

  // $( window ).resize(function() {
  //   $('.contents_list_wrap ul').resize();


  //  jQuery('.contents_list_wrap ul').css("height", "auto");
//    windowWidth = $( window ).width();
  //  h = $('.contents_list_wrap ul').height();

    //jQuery('.contents_list_wrap ul').css("height", h);
  //  jQuery('.contents_list_wrap ul').css("width", "100%");

  //  jQuery('.contents_list_wrap ul li').css("width", "46%");

//  });
   $('.contents_list_wrap ul').resize(function() {
//       h = $('.contents_list_wrap ul').height();      //  jQuery('.contents_list_wrap ul').css("height", h);

      jQuery('.contents_list_wrap ul').css("height", "auto");

      num = $('.contents_list_wrap ul').height()/2.5;

    //  alert(num);

      jQuery('.contents_list_wrap ul').css("height", num);
      galery_onoff = false;
      width_onoff = false;


      if(check_onoff!=false)
      {
        alert(num);
        jQuery('.contents_list_wrap ul').css("height", num);
      }
    // alert("a");
   });

  //h2 = $('.contents_list_wrap ul').height();


   $('.iconSpan2').click(function(){

       galery_onoff = true;

       jQuery('.img_wrap02').css("width", "100%");
       jQuery('.content_list').css("display", "block");
       jQuery('.content01').css("width", "100%");
       jQuery('.contents_list_wrap ul li').css("margin-left", "2.5%");
       jQuery('.contents_list_wrap ul li').css("margin-right", "1%");

       jQuery('.content_list').css("border-radius", "5px");
       jQuery('.max_line').css("min-height", "70px");
       jQuery('.contents_list_wrap ul li').css("top", "-150px");
       jQuery('.max_line p').css("font-size", "1em");
       jQuery('.content01 p').css("margin-top", "10px");
       jQuery('.content_list').css("border-top", "1px solid #EAEAEA");

       jQuery('.contents_list_wrap ul li').css("width", "46%");
       $('.contents_list_wrap ul').resize();
        check_onoff = true;
    //      $('.contents_list_wrap ul').resize();
   })
});
