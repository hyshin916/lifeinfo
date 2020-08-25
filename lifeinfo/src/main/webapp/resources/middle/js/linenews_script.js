$(function() {
    var len1= $('.box-flow2 li').length;
    var num1 = $('.box-flow2 li a p').height();
    var len2= $('.box-flow3 li').length;
    var num2 = $('.box-flow3 li a p').height();
    var len3= $('.box-flow4 li').length;
    var num3 = $('.box-flow4 li a p').height();

    for(var i=0;i<len1;i++)
    {
      if($('.box-flow2 li').eq(i).find("a").find("p").height()<30)
      {
        $('.box-flow2 li').eq(i).find("a").find("p").css("line-height","41px");
      }
    }

    for(var i=0;i<len2;i++)
    {
      if($('.box-flow3 li').eq(i).find("a").find("p").height()<30)
      {
        $('.box-flow3 li').eq(i).find("a").find("p").css("line-height","41px");
      }
    }

    for(var i=0;i<len3;i++)
    {
      if($('.box-flow4 li').eq(i).find("a").find("p").height()<30)
      {
        $('.box-flow4 li').eq(i).find("a").find("p").css("line-height","41px");
      }
    }

  $(".box-flow2").flowBanner({
    control: true,
    //speed: 20
  });

  $(".box-flow3").flowBanner({
    control: true,
    //speed: 20
  });

  $(".box-flow4").flowBanner({
    control: true,
    //speed: 20
  });

   $("#edd2").css("visibility", "visible").animate({opacity:1});
   $("#edd3").css("visibility", "visible").animate({opacity:1});
   $("#edd4").css("visibility", "visible").animate({opacity:1});

});

(function($) {

  function funLoad(){
  //      var Cheight = $(window).height();
    //    $('.container').css({'height':Cheight+'px'});
    }
//    window.onload = funLoad;
  //  window.onresize = funLoad;

  $.fn.extend({
    flowBanner: function(options) {

      var defaults = {
        control: false,
        speed: 10,
        ctrlSelector: 'box-flow-ctrl',
        wrapSelector: 'box-flow-wrap',
        playSelector: 'btn-play',
        pauseSelector: 'btn-pause',
        playText: '재생',
        pauseText: '일시정지',
      };

      var opt = $.extend(defaults, options);

      return this.each(function() {
        var o = opt;
        var left = 0;
        var timer = '';
        var ctrl = o.control;
        var speed = o.speed;
        var ctrlSelector = o.ctrlSelector;
        var wrapSelector = o.wrapSelector;
        var playSelector = o.playSelector;
        var pauseSelector = o.pauseSelector;
        var playText = o.playText;
        var pauseText = o.pauseText;
        var $box = $(this);
        var $wrap = '<div class="' + wrapSelector + '"><\/div>';
        var $banner = $box.children("li");
        var $bannerSize = $banner.length;
        var $bannerW = $banner.outerWidth(true);
        var $ctrlHtml = '';
        $ctrlHtml += '<div class="' + ctrlSelector + '">';
        $ctrlHtml += '	<button type="button" class="' + playSelector + '">' + playText + '<\/button>';
        $ctrlHtml += '	<button type="button" class="' + pauseSelector + '">' + pauseText + '<\/button>';
        $ctrlHtml += '<\/div>';


        $box.wrap($wrap);
        $box.width($bannerW * $bannerSize);
        flowPlay();

        if (ctrl) {
          $box.parent().before($ctrlHtml);

          $box.parent().prev('.' + ctrlSelector).on("click", "button", function(e) {
            e.preventDefault;

            if ($(this).hasClass(playSelector)) {
              flowPause();
              flowPlay();
            }

            if ($(this).hasClass(pauseSelector)) {
              flowPause();
            }
          });
        }

        $box.on("mouseenter", function() {
          //flowPause();
        }).on("mouseleave", function() {
          //flowPlay();
        });

        $banner.on("focusin", "a", function() {
          flowPause();
        }).on("focusout", "a", function() {
          flowPause();
          flowPlay();
        });

        function flow() {

          if (Math.abs(left) >= $bannerW) {
            left = 0;
            $box.children("li").first().appendTo($box);
          }

          left = left - 1;
          $box.css({
            'left': left
          });

        }

        function flowPause() {
          clearInterval(timer);
        }

        function flowPlay() {
          timer = setInterval(flow, speed);
        }

      });
    }
  });
})(jQuery);
