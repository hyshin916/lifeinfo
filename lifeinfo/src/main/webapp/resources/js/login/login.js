$(document).ready(function() {

	$('#loginBtn').on('click', function() {
		runStart();
	});

	$("#user_passwd").keydown(function(key) {
		if (key.keyCode == 13) {
			runStart();
		}

	});

	var runStart = function(){
		$.ajax({
			url : './login',
			dataType : 'json',
			type : 'POST',
			data : {
				user_id : $('#user_id').val(),
				user_passwd : $('#user_passwd').val()
			},
			async : true,
			success : function(resp) {
				if (resp.chkMember == 1) {
					alert('인증성공!');
					
					if (resp.chkGroup == 'admin' || resp.chkGroup == 'ms_002' ) {
						location.href = './back/franch/list';
					} else if (resp.chkGroup == 'general') {
						location.href = './back/passwd/reset';
					}
				
				} else if (resp.chkMember == 0) {
					alert('인증실패!다시 시도해 주세요!');
					$('#user_passwd').focus();
					return;
				}
			},
			error : function() {
				alert('관리자에게 문의주세요.');
			}
		});
	};
	
	
	$('#register').on('click', function() {
		if ($('#name').val() == '') {
			alert('상호명을 입력해 주세요!')
			$('#name').focus();
			return false;
		}
		if ($('#sellerCd').val() == '') {
			alert('업체코드를 입력해 주세요!')
			$('#sellerCd').focus();
			return false;
		} 
		if ($('#passwd').val() == '') {
			alert('패스워드를 입력해 주세요!')
			$('#passwd').focus();
			return false;
		} 
		var eventYN = __rtnEventYN();
		$.ajax({
			url : './franchWrite',
			dataType : 'json',
			type : 'POST',
			data : {
				name : $('#name').val(),
				sellerCd : $('#sellerCd').val(),
				passwd : $('#passwd').val(),
				comment : $('#comment').val(),
				event : eventYN,
				useCnt : $('#usecnt').val(),
				flag : 'register'
			},
			async : true,
			success : function(resp) {
				if (resp.result == 'success') {
					alert('등록완료');
				} else if (resp.result == 'fail') {
					alert('업체코드중복 또는 DB에러 입니다.');
				}
			},
			error : function() {
				alert('시스템에러!관리자에게 문의주세요.');
			}
		});
	});

			var __rtnEventYN = function() {

				var eventYN;
				if ($("input:checkbox[id='timepig']").is(":checked") == true) {
					eventYN = "Y";
				} else {
					eventYN = "N";
				}
				return eventYN;

			};
	
	$('#update').on('click', function() {
		if ($('#name').val() == '') {
			alert('상호명을 입력해 주세요!')
			$('#name').focus();
			return false;
		}
		if ($('#sellerCd').val() == '') {
			alert('업체코드를 입력해 주세요!')
			$('#sellerCd').focus();
			return false;
		} 
		if ($('#passwd').val() == '') {
			alert('패스워드를 입력해 주세요!')
			$('#passwd').focus();
			return false;
		} 
		var eventYN = __rtnEventYN();
		
		$.ajax({
			url : './franchWrite',
			dataType : 'json',
			type : 'POST',
			data : {
				no : $('#no').val(),
				name : $('#name').val(),
				sellerCd : $('#sellerCd').val(),
				passwd : $('#passwd').val(),
				comment : $('#comment').val(),
				event : eventYN,
				useCnt : $('#usecnt').val(),
				flag : 'update'
			},
			async : true,
			success : function(resp) {
				if (resp.result == 'success') {
					alert('수정완료');
				} else if (resp.result == 'fail') {
					alert('업체코드중복 또는 DB에러 입니다.');
				}
			},
			error : function() {
				alert('시스템에러!관리자에게 문의주세요.');
			}
		});
	});
	$('#delete').on('click', function() {
		$.ajax({
			url : './franchWrite',
			dataType : 'json',
			type : 'POST',
			data : {
				no : $('#no').val(),
				flag : 'delete'
			},
			async : true,
			success : function(resp) {
				if (resp.result == 'success') {
					alert('삭제완료');
					location.href = './list';
				} 
			},
			error : function() {
				alert('시스템에러!관리자에게 문의주세요.');
			}
		});
	});
	
	
	$('#mem_register').on('click', function() {
	
		window.open("./memRegister","MemRegister","width=700px,height=700px");
	/*	$.ajax({
			url : './franchWrite',
			dataType : 'json',
			type : 'POST',
			data : {
				no : $('#no').val(),
				name : $('#name').val(),
				sellerCd : $('#sellerCd').val(),
				passwd : $('#passwd').val(),
				comment : $('#comment').val(),
				flag : 'update'
			},
			async : true,
			success : function(resp) {
				if (resp.result == 'success') {
					alert('수정완료');
				} else if (resp.result == 'fail') {
					alert('업체코드중복 또는 DB에러 입니다.');
				}
			},
			error : function() {
				alert('시스템에러!관리자에게 문의주세요.');
			}
		});*/
	});
	

				$('#mem_add').on('click', function() {
				if ($('#chkID').val() == '') {
					alert('중복체크를 진행해주세요!');
					return false;
				}

				if ($('#mem_passwd').val() != $('#passwdCfm').val()) {
					alert('패스워드를 확인해주세요.');
					return false;
				}
				$.ajax({
					url : './addMember',
					dataType : 'json',
					type : 'POST',
					data : {
						mem_id : $('#mem_id').val(),
						mem_passwd : $('#mem_passwd').val(),
						mem_name : $('#mem_name').val()
					},
					async : true,
					success : function(resp) {
						if (resp.result == 'success') {
							alert('정상적으로 등록신청 되었습니다.');
							window.close();
						} else if (resp.result == 'fail') {
							alert('회원등록신청 실패!');
						}

					},
					error : function() {
						alert('시스템에러!관리자에게 문의주세요.');
					}
				});

			});

				
	$('#duplicateID').on('click', function() {
				$.ajax({
					url : './chkUserID',
					dataType : 'json',
					type : 'POST',
					data : {
						mem_id : $('#mem_id').val()
					},
					async : true,
					success : function(resp) {

						if (resp.chkID == '1') {
							alert('사용하실수 없는 ID 입니다.');
						} else if (resp.chkID == '0') {
							alert('사용하실수 있는 ID 입니다.');
							$('#chkID').val(resp.chkID);
						}
						
					},
					error : function() {
						alert('시스템에러!관리자에게 문의주세요.');
					}
				});
			});
	
	$('#addGrpMenu').on('click', function() {
		
		var group_id;
		var chkGroupMenu = [];
		$("input[name='checkGroup']:checked").each(function(){
			group_id =$(this).val();
		});
		
		$("input[name='chkMenu']:checked").each(function(){
			chkGroupMenu.push($(this).attr('id'));
		});
		$.ajax({
			url : './addGrpMenu',
			dataType : 'json',
			type : 'POST',
			data : {
				'group_id' : group_id,
				'chkGrpMenu' : chkGroupMenu
			},
			async : true,
			success : function(resp) {

				if (resp.chkID == '1') {
					alert('사용하실수 없는 ID 입니다.');
				} else if (resp.chkID == '0') {
					alert('사용하실수 있는 ID 입니다.');
					$('#chkID').val(resp.chkID);
				}
				
			},
			error : function() {
				alert('시스템에러!관리자에게 문의주세요.');
			}
		});
	});
	
	
	
});