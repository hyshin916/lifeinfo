var httpRequest=null;   

function getXMLHttpRequest(){

	if(window.ActiveXObject){ //IE

		try{
			return new ActiveXObject("Msxml2.XMLHttp");
		}catch(e){

			try{
				return new ActiveXObject("Microsoft.XMLHttp");
			}catch(e){

				return null;

			}
		}


	}else if(window.XMLHttpRequest){  //IE를 제외

		return new XMLHttpRequest();		

	}else{

		return null;
	}

};

function sendRequest(url,params,callback,method){

	httpRequest = getXMLHttpRequest();

	var httpMethod = method?method:'GET';
	
	if(httpMethod!='GET' && httpMethod!='POST'){

		httpMethod='GET';
	}

	var httpParams=(params==null || params=="")?null:params;

	var httpUrl=url;

	if(httpMethod=='GET' && httpParams!=null){

		httpUrl=httpUrl+"?"+httpParams;

	}
	
	
	httpRequest.open(httpMethod,httpUrl,true);
	httpRequest.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
	httpRequest.onreadystatechange=callback;
	httpRequest.send(httpMethod=='POST'?httpParams:null);


};