<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
<script>
	$( document ).ready( function() {
	
	
		
		
		function translateText(userLang) {
			var sourceText ="의상	";
			$.ajax({
				type : "POST",
				data : '&source=ko&target=' + userLang +'&format=html&q=' + sourceText,
				url  : 'https://www.googleapis.com/language/translate/v2?key=c4d170ed2da499abbaa1a3d8523e5c2a20a39dd8',
				
				success : function(response) {
					alert(response.data.translations[0].translatedText);
				}
				
				
			});
			
		}
		
	
	} );
	
	
	translateText(zh-CN);

</script>
	<title>Home</title>
</head>
<body>
<p>Date: <input type="text" id="datepicker"></p>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
