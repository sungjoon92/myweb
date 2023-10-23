<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>emailCheckProc</title>
</head>
<body>

	<div style="text-align: center">
		<h3>이메일 중복확인</h3>
		<form action="emailCheckProc.jsp" onsubmit="return blankCheck()">
			이메일 : <input type="text" name="email" id="email" maxlength="25" autofocus="autofocus"> 
				  <input type="submit" value="중복확인">
		</form>	
	</div>
</body>

<script>
//////////id글자수 확인//////////
	function blankCheck() {
		let email=document.getElementById("email").value;
		email=email.trim();
		if(email.length<5){
			alert("이메일은 5~25글자 이내로 입력해 주세요");
			return false;
		}//if end
		return true;
	}//blankCheck() end
</script>

</html>