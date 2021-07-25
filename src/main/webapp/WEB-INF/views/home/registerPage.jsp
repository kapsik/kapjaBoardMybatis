<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/homePage.css">
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript">
	//실시간 키입력
	/* function goIdSearch() {
		if(window.event.keyCode == 13)
			alert("엔터키를 눌렀군");
			document.getElementById("idCheck").click();
	} */
	
	function check_onclick(){
		
		var theForm = document.frm1;
	
		if(theForm.userId.value =="" || theForm.userPassword.value ==""){
			if(theForm.userId.value ==""){
				alert("아이디를 입력하시오");
				return theForm.userId.focus();
				
			}else if(theForm.userPassword.value==""){
				alert("비밀번호를 입력하시오");
				return theForm.userPassword.focus();
				
			}else if(theForm.userEmail.value==""){
				alert("아이디를 입력하시오");
				return theForm.userEmail.focus();
			}
		}else if(theForm.userId.value !="" && theForm.userPassword.value !=""){
			console.log("잘했어치타");
			theForm.submit();
		}
			
	}
</script>

<title>Insert title here</title>
</head>
<body>
	<div id="home_body">
		<h1>갑자의 홈풰이지</h1>
		<h2>회원가입</h2>
			<form action="memberJoin" name="frm1" method="post" autocomplete="off">
				<p>
					<label for="userId">아이디</label>
					<!--실시간 입력  -->
					<!-- <input type="text" id="userId" name="userId" placeholder="아이디 입력" 
					onkeyup="goIdSearch();"> -->
					
					<input type="text" id="userId" name="id" placeholder="아이디 입력" >
					<button type="button" id="idCheck" class="idCheck">중복확인</button>
				</p>
				<p class="resultId">
					<span class="msg">아이디를 확인해주십시오</span>
				</p>
				<p>
					<label for="userEmail">이메일</label>
					<input type="text" id="userEmail" name="email" placeholder="이메일 입력" >
					<button type="button" id="emailCheck" class="emailCheck">중복확인</button>
				</p>
				<p class="resultEmail">
					<span class="msg">이메일을 확인해주십시오</span>
				</p>
			
				
				<p>
					<label for="userPassword">비밀번호</label>
					<input type="password" id="userPassword" name="password" placeholder="비밀번호 입력">
				</p>
				<p class="resultPassword">
					<span class="msg">비밀번호를 확인해주십시오</span>
				</p>
				<p>
					<input type="button" id="join" disabled="disabled" value="가입신청" onclick="check_onclick()">
				<p>
					<a href="homePage">처음으로</a>
				</p>
			</form>
	</div>
	
<script type="text/javascript">
$(".idCheck").click(function(){
	
	 if($("#userId").val()==""){
		
		 $(".resultId .msg").text("사용 불가");
		 return  $("#userId").focus(); 
	 }
	 
	 var query = {userId : $("#userId").val()};
	 //alert(query);
	 
	 $.ajax({
	  url : "idCheck",
	  type : "post",
	  data : query,
	  success : function(data) {
	  	
	   if(data == 1) {
		   console.log("data = " + data);
	    $(".resultId .msg").text("사용 불가");
	    $(".resultId .msg").attr("style", "color:#f00"); 
	    
	    $("#join").attr("disabled", "disabled");
	   } else {
		   console.log("data = " + data);
	    $(".resultId .msg").text("사용 가능");
	    $(".resultId .msg").attr("style", "color:#00f");
	    
	    $("#join").removeAttr("disabled");
	   }
	  }
	 });  // ajax 끝
	});
	
	
$(".emailCheck").click(function(){
	
	//alert($("#userEmail").val());
	
	 if($("#userEmail").val()==""){
		
		 $(".resultEmail .msg").text("사용 불가");
		 return  $("#userEmail").focus(); 
	 }
	 
	 var query = {userEmail : $("#userEmail").val()};
	 //alert(query);
	 
	 $.ajax({
	  url : "emailCheck",
	  type : "post",
	  data : query,
	  success : function(data) {
	  	
	   if(data == 1) {
		   console.log("data = " + data);
	    $(".resultEmail .msg").text("사용 불가");
	    $(".resultEmail .msg").attr("style", "color:#f00"); 
	    
	    $("#join").attr("disabled", "disabled");
	   } else {
		   console.log("data = " + data);
	    $(".resultEmail .msg").text("사용 가능");
	    $(".resultEmail .msg").attr("style", "color:#00f");
	    
	    $("#join").removeAttr("disabled");
	   }
	  }
	 });  // ajax 끝
	});
	
	
	$("#userId").keyup(function(){
		$(this).val($(this).val().toUpperCase());
		 $(".result .msg").text("아이디를 확인해주십시오.");
		 $(".result .msg").attr("style", "color:#000");
		 
		 $("#join").attr("disabled", "disabled");
		 
		});
	
	$("#userEmail").keyup(function(){
		$(this).val($(this).val().toUpperCase());

		 $(".resultEmail .msg").text("이메일을 확인해주십시오.");
		 $(".resultEmail .msg").attr("style", "color:#000");
		 
		 $("#join").attr("disabled", "disabled");
		 
		});
	
	$("#userPassword").keyup(function(){
		$(this).val($(this).val().toUpperCase());
		if($(this).val().length > 20){
			$(".resultPassword .msg").text("너무 길어요");
		    $(".resultPassword .msg").attr("style", "color:#f00");
		    $("#join").attr("disabled", "disabled");
		    
		}else if($(this).val().length < 4){
			$(".resultPassword .msg").text("너무 짧아요");
			$(".resultPassword .msg").attr("style", "color:#f00");
			$("#join").attr("disabled", "disabled");
		}else {
			$(".resultPassword .msg").text("ok");
			$(".resultPassword .msg").attr("style", "color:#2EFE2E");
			$("#join").removeAttr("disabled");
			
		}
	});
</script>		
</body>
</html>