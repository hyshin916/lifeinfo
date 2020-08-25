$(function() {
  $('#login_btn').click(function(){
	  
		$.ajax({
			url : "franch.json",
			dataType : "json",
			/*data :{userID:$('#userID').val(),userPassword:$('#userPassword').val()},*/
			data :{userID:$('#userID').val()},
			type : "POST",
			async : "true",
			success : function(resp) {
				if (resp.result == '0') {
					 swal("인증실패", "입력 정보를 다시 한번 확인해주시기 바랍니다.", "error", {button: "확인",});
				} else if (resp.result == '1') {
					 swal(resp.franchName, resp.comment, "success", {button: "확인",});
				}
			},
			error : function(resp) {
				 swal("인증실패", "관리자에게 문의주세요.", "error", {button: "확인",});
			}
			
		});
	
	
	  
   
  //  swal("인증실패", "입력 정보를 다시 한번 확인해주시기 바랍니다.", "error", {button: "확인",});
  });

  $(".box-flow").flowBanner({
    control: true,
    //speed: 20
  });

   $("#edd").css("visibility", "visible").animate({opacity:1});

});

(function($) {

  function funLoad(){
        var Cheight = $(window).height();
        $('.container').css({'height':Cheight+'px'});
    }
    window.onload = funLoad;
    window.onresize = funLoad;

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
          flowPause();
        }).on("mouseleave", function() {
          flowPlay();
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


$(document).ready(function(){

});
