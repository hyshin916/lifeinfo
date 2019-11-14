function isCellPhone(p) {
	p = p.split('-').join('');
	var regPhone = /^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;
	return regPhone.test(p);
}
function runPasswdReset() {
	var result = isCellPhone($('#id').val());
	if (result == true) {
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "../passwdReset.json",
			data : {
				"id" : $('#id').val()
			},
			success : function(resp) {
				var resultYN = confirm("고객님의 정보는 다음과 같습니다." + "\n[핸드폰번호] :"
						+ resp.id + "\n[이름] :" + resp.name + "\n[주소] :"
						+ resp.address + "\n\n패스워드 초기화를 진행하시겠습니까?");
				console.log(resultYN);

				if (resultYN == true) {
					$.ajax({
						type : "POST",
						dataType : "json",
						url : "../passwdReset.json",
						data : {
							"id" : $('#id').val(),
							"result" : "Y"
						},
						success : function(resp) {
							if (resp.init == 'initalized') {
								alert('고객님의 패스워드가 "1234" 로 초기화 되었습니다.');
								location.href = "reset";
							}
						},
						error : function(e) {
							alert('초기화 실패!관리자에게 문의주세요.');
						}
					}); // inner ajax
				} // if

			}, //success
			error : function(e) {
				alert('구 홍보앱 회원이 아닙니다.관리자에게 문의주세요.');
			}
		}); // outer ajax
	} else {
		alert('다시 입력해 주세요.');
		$('#id').focus();
	}
	; // if
} // func
$(function() {

	$("#id").keydown(function(key) {
		if (key.keyCode == 13) {
			runPasswdReset();
		}

	});

	$('#reset').click(function() {
		runPasswdReset();
	});

});