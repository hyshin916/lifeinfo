$(document).ready(function(){
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
    $('#search_btn').click(function(){
      $('.search_layer').slideToggle();
      $('#text1').focus();
    });
    $("#back").click(function(){
     window.history.back();
   });

   $('.iconSpan1').click(function(){
      jQuery('.img_wrap02').css("width", "65%");
      jQuery('.content_list').css("display", "flex");
      jQuery('.content01').css("width", "100%");
      jQuery('.contents_list_wrap ul li').css("width", "100%");
      jQuery('.content_list').css("border-radius", "0px");
      jQuery('.max_line').css("min-height", "0px");
      jQuery('.content01 p').css("margin-bottom", "20px");
      jQuery('.max_line p').css("font-size", "1.2em");
      jQuery('.content_list').css("border-top", "0");
      jQuery('.content01 p').css("margin-top", "3px");
      jQuery('.contents_list_wrap ul li').css("margin-left", "0%");
      jQuery('.contents_list_wrap ul li').css("margin-right", "0%");


   })
    var windowWidth = 0;
   $( window ).resize(function() {
    windowWidth = $( window ).width();
  });


   $('.iconSpan2').click(function(){
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


      if(windowWidth>640)
      {
        jQuery('.contents_list_wrap ul li').css("width", "28%");
      }
      else{
        jQuery('.contents_list_wrap ul li').css("width", "45%");
      }
   })
});
