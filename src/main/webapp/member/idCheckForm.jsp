<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>idCheckForm</title>
</head>
<body>

	<div style="text-align: center">
		<h3>아이디 중복확인</h3>
		<form action="idCheckProc.jsp" onsubmit="return blankCheck()">
			아이디 : <input type="text" name="id" id="id" maxlength="10" autofocus="autofocus"> 
				  <input type="submit" value="중복확인">
		</form>	
	</div>
</body>

<script>
//////////id글자수 확인//////////
	function blankCheck() {
		let id=document.getElementById("id").value;
		id=id.trim();
		if(id.length<5){
			alert("아이디는 5~10글자 이내로 입력해 주세요");
			return false;
		}//if end
		return true;
	}//blankCheck() end
</script>

</html>