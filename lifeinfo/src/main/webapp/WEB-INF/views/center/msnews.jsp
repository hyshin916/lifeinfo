
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<script src="./resources/js/httpRequest.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	/* $( document ).ready( function() {
	
	
		
		
		function translateText(userLang) {
			var sourceText ="2件】卫衣男士长袖t恤保暖上衣潮流秋衣加绒加厚打底衫男冬季衣服买一送一 2件仅89！加绒不加价！";
			$.ajax({
				type : "POST",
				data : '&source=zh-CN&target=' + userLang +'&format=html&q=' + sourceText,
				url  : 'https://www.googleapis.com/language/translate/v2?key=AIzaSyCldGxkwmDK3LOj23QBYWYwHkKhFSKWoz0',
				
				success : function(response) {
					alert(response.data.translations[0].translatedText);
				}
			
				
				
			});
			
		}
		translateText('ko');
	} );
	
	
 */

</script>
<style type = "text/css"> <!-- 로딩바스타일 -->
body
{
 text-align: center;
 margin: 0 auto;
}
#Progress_Loading
{
 position: absolute;
 left: 50%;
 top: 50%;
}
</style>
<script>
	$( document ).ready( function() {
		
		$('#Progress_Loading').hide();
		
		$('#exportExcel').on('click',function(){
			
			$('#Progress_Loading').show();
			var temp1 = '';
			
			for (i=0;i<my_form.mycheck.length;i++) {
				if (my_form.mycheck[i].checked == true) {
				//alert(my_form.mycheck[i].value);
				var resultCode = my_form.mycheck[i].value ;
				var chkCP = document.getElementsByName("cp")[i].value;
					temp1 += resultCode +":" +chkCP +",";
				}
			}
			
			sendRequest("export","param="+$('#productCode').text()+"::"+ temp1 + this.flag,exportExcel,"POST");
	
			
			function exportExcel(){
				
				if(httpRequest.readyState == 4){
					
					if(httpRequest.status == 200){
						$('#Progress_Loading').hide();
						alert('insert success!');
				
					}
				}
			}
		})
	
	} );

</script>

<script type="text/javascript">
var param = '';
var flag = '';
var cateName = '';
var gubun = '';
var funcName = '';
var selectID = '';
var lastCode1 = '';
var lastCode2 = '';
var lastCode3 = '';
var callBack = '';



function madeCateCode(temp) {
	var selectValue = document.getElementById('selectSpan4');
	var label_add = document.createElement('label');
	label_add.setAttribute('id','productCode');
	label_add.innerHTML = '<B style="color:blue">' + temp + '</B>';
	selectValue.appendChild(label_add);
}

var labelCnt = 0;

function commonList(temp) {
	if (document.getElementById(this.cateName) == null) {
		var label_add = document.createElement('label');
		label_add.setAttribute('id',this.cateName + '00');
		label_add.innerHTML = '&nbsp;'+ this.gubun +'&nbsp;';
/* 		
		var madeSpan = document.createElement('span');
		madeSpan.setAttribute('id',this.selectID); */
		var selectValue = document.getElementById(this.selectID);
		selectValue.appendChild(label_add);
		//madeSpan.appendChild(label_add);
		var madeSelect  = document.createElement('select');
		madeSelect.setAttribute('id',this.cateName);
		madeSelect.setAttribute('onchange',this.funcName);
		var comTag = selectValue.appendChild(madeSelect);
		var codeTemp = '<option value="">-선택하세요-</option>';
		for (var i=0; i<temp.length; i++) {
			codeTemp +='<option value="'+temp[i]+'">'+temp[i]+'</option>';
		}
		comTag.innerHTML=codeTemp;
		document.getElementById(this.selectID).appendChild(madeSelect);
		
	} else {
		
/* 		alert(this.cateName);
		alert(this.selectID); */
		if (this.cateName == 'category2') {
			

		    if (document.getElementById("productCode")!=null) {
		    	document.getElementById("productCode").remove();
		    }
			
			var c1 = document.getElementById('category200');
			var c2 =  document.getElementById('category300');
			var c3 =  document.getElementById('category400');
			if( c1 !=null) {
				//document.getElementById('category200').remove();
				document.getElementById('category2').remove();
			}
			if (c2 != null) {
				document.getElementById('category300').remove();
				document.getElementById('category3').remove();
			}
			if (c3 != null) {
				document.getElementById('category400').remove();
				document.getElementById('category4').remove();
			}
		} 
		if (document.getElementById(this.cateName)!=null) {
			document.getElementById(this.cateName).remove();
		}
		
/* 		
		var madeSpan = document.createElement('span');
		madeSpan.setAttribute('id',this.selectID); */
		var selectValue = document.getElementById(this.selectID);
		//madeSpan.appendChild(label_add);
		var madeSelect  = document.createElement('select');
		madeSelect.setAttribute('id',this.cateName);
		madeSelect.setAttribute('onchange',this.funcName);
		var comTag = selectValue.appendChild(madeSelect);
		var codeTemp = '<option value="">-선택하세요-</option>';
		for (var i=0; i<temp.length; i++) {
			codeTemp +='<option value="'+temp[i]+'">'+temp[i]+'</option>';
		}
		comTag.innerHTML=codeTemp;
		document.getElementById(this.selectID).appendChild(madeSelect);
	}
}

function codeList(){
	sendRequest("codelist","param=" + this.param +'&flag='+ this.flag,loadedCodes,"GET");
}

function loadedCodes(){
	
	if(httpRequest.readyState == 4){
		
		if(httpRequest.status == 200){
			
			var temp = httpRequest.responseText;
			
			if (callBack == 'codeCnt') {
				madeCateCode(temp);
			} else {
				var temp1 = temp.split(',');
				commonList(temp1);
			}
		}
	}
}

function madeCodeLabel() {
	if(httpRequest.readyState == 4){
		
		if(httpRequest.status == 200){
			
			var temp = httpRequest.responseText;
			madeCateCode(temp);
	
		}
	}
}


function testChk() {
	if(my_form.all_select.checked == true) {
		for (i=0;i<my_form.mycheck.length;i++) {
			my_form.mycheck[i].checked = true;
		}
	} else {
		for (i=0;i<my_form.mycheck.length;i++) {
			my_form.mycheck[i].checked = false;
		}
	}
}

function testChk1() {
 	for (i=0;i<document.getElementsByName("cp1").length;i++) {
 		var test = parseInt(document.getElementsByName("cp1")[i].getAttribute("data")) * parseInt(document.getElementById("ncnt").value);
		var test1 = parseInt(document.getElementById("margin").value) + parseInt(test);
		document.getElementsByName("cp")[i].setAttribute('value',parseInt(test1));
 		document.getElementsByName("cp")[i].innerHTML = parseInt(test1);
	} 
}

function categoryEvent() {
	
 	var selectValue = document.getElementById("category1");
	var temp =selectValue.options[selectValue.selectedIndex].value;
	this.param = temp;
	this.flag = 'large';
	this.cateName = 'category2';
	this.gubun = '중분류';
	this.funcName = 'categoryEvent1()';
	this.selectID = 'selectSpan1';
	this.callBack = 'large';
	codeList();
}
function categoryEvent1() {
	
	var selectValue = document.getElementById("category2");
	var temp = selectValue.options[selectValue.selectedIndex].value;
	this.param = temp;
	this.flag = 'small';
	this.cateName = 'category3';
	this.gubun = '소분류';
	this.funcName = 'categoryEvent2()';
	this.selectID = 'selectSpan2';
	this.callBack = 'small';
	codeList();
}

function categoryEvent2() {
	
	var selectValue = document.getElementById("category3");
	var temp = selectValue.options[selectValue.selectedIndex].value;
	this.param = temp;
	this.flag = 'detailView';
	this.cateName = 'category4';
	this.gubun = '세부분류';
	this.funcName = 'categoryEvent3()';
	this.selectID = 'selectSpan3';
	this.callBack = 'detailView';
	codeList();
}

function categoryEvent3() {
	
	    if (document.getElementById("productCode")!=null) {
	    	document.getElementById("productCode").remove();
	    }
		
		var selectValue = document.getElementById("category1");
		var temp =selectValue.options[selectValue.selectedIndex].value;
		this.lastCode1 = temp;
		var selectValue = document.getElementById("category2");
		var temp =selectValue.options[selectValue.selectedIndex].value;
		this.lastCode2 = temp;
		var selectValue = document.getElementById("category3");
		var temp =selectValue.options[selectValue.selectedIndex].value;
		this.lastCode3 = temp;
		var selectValue = document.getElementById("category4");
		var temp =selectValue.options[selectValue.selectedIndex].value;
		this.lastCode4 = temp;
	//	alert(this.lastCode1 + ":" +this.lastCode2 + ":" +this.lastCode3 +":"+this.lastCode4);
		
		this.callBack = 'codeCnt';
	//	alert(this.param = this.lastCode1 + ":" +this.lastCode2 + ":" +this.lastCode3  + ":" +this.lastCode4);
		this.param = this.lastCode1 + ":" +this.lastCode2 + ":" +this.lastCode3  + ":" +this.lastCode4;
		this.flag = 'codeCnt';
		
		codeList();

}

</script>
			<!-- <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main"> -->
				<h2 class="sub-header">News Detail</h2>
				<div class="table-responsive">
					<form name="my_form">
					<table class="table table-striped">
						<thead>
						</thead>
						<tbody>
								<%-- <tr>
								<td><img src="${newsInfo.detailImgURL}" width="300px" height="200px"/></td>
								</tr> --%>
								<tr>
								<td><div><p>${newsInfo.detail}</p></div></td>
								</tr>
						</tbody>
					</table>
					</form>
				</div>
	