<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="resources/css/htmlEx.css" rel="stylesheet" type="text/css"/>
<!-- <link href="../../resources/css/htmlEx.css" rel="stylesheet" type="text/css"/> -->
<title>MY TITLE</title>
<script type="text/javascript">
	/* when web browser started and after document is ready*/
	window.onload = function(){
		console.log("onload");
		var txtIn = document.getElementById("txtIn");
	}
	
	/* use innerHTML for change text*/
	function fnAddTxt(){
		document.getElementById("p1").innerHTML = txtIn.value;
	}
	
	/* create Element appendChild*/
	function fnCreateChild(){
		var input = document.createElement("input");
		document.body.appendChild(input);
	}
</script>
</head>
<body>
	<p id="p1">html excercise</p>
	<input type="text" id="txtIn" name="txtIn"/>
	<input type="button" id="btn" value="눌러" onclick="fnAddTxt();">
	<input type="button" id="btnCreate" value="노드생성" onclick="fnCreateChild();">
</body>
</html>