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
				"id" : $('#id').val(),
				"result" : "gu_s"
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
							"result" : "gu_y"
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

function new_runPasswdReset() {
	var result = isCellPhone($('#new_id').val());
	if (result == true) {
		$.ajax({
			type : "POST",
			dataType : "json",
			url : "../passwdReset.json",
			data : {
				"id" : $('#new_id').val(),
				"result" : "new_s"
			},
			success : function(resp) {
				var resultYN = confirm("고객님의 정보는 다음과 같습니다." + "\n[핸드폰번호] :"
						+ resp.id + "\n[이름] :" + resp.name + "\n[주소] :"
						+ resp.address + "\n[고객코드] :" + resp.coad + "\n[카드번호] :" + resp.cardno + "\n\n패스워드 초기화를 진행하시겠습니까?");
				console.log(resultYN);

				if (resultYN == true) {
					$.ajax({
						type : "POST",
						dataType : "json",
						url : "../passwdReset.json",
						data : {
							"id" : $('#new_id').val(),
							"passwd" : $('#passwd').val(),
							"no_coad" : $('#no_coad').val(),
							"no_card_sc" : $('#no_card_sc').val(),
							"name" : $('#new_name').val(),
							"nickname" : $('#nickname').val(),
							"result" : "new_y"
						},
						success : function(resp) {
							if (resp.init == 'initalized') {
								alert('고객님의 정보가 초기화 되었습니다.');
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
				alert('신규앱(쇼핑몰) 앱 회원이 아닙니다.관리자에게 문의 또는 신규회원 가입대상 입니다.');
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
	$('#passwd').keydown(function(key) {
		if (key.keyCode == 13) {
			new_runPasswdReset();
		}
	});
	
	$('#reset').click(function() {
		runPasswdReset();
	});
	
	$("#new_id").keydown(function(key) {
		if (key.keyCode == 13) {
			new_runPasswdReset();
		}

	});
	$("#new_name").keydown(function(key) {
		if (key.keyCode == 13) {
			new_runPasswdReset();
		}

	});
	$("#nickname").keydown(function(key) {
		if (key.keyCode == 13) {
			new_runPasswdReset();
		}

	});
	$('#new_reset').click(function() {
		new_runPasswdReset();
	});
	
	
});