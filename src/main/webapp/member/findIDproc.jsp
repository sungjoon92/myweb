
<%@page import="oracle.security.o5logon.d"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp"%> 

<!-- 본문 시작 template.jsp -->
<h3>*아이디 찾기 결과*</h3>

<%	
	request.setCharacterEncoding("utf-8");

	String mname = request.getParameter("mname");
	String email = request.getParameter("email");
	
	//out.print(mname);
	//out.print(email);
	
	dto.setMname(mname);
	dto.setEmail(email);
	
	
	boolean flag = dao.findID(dto);
	if(flag == false){
		out.println("<p>이름/이메일을 다시 한번 확인해주세요!!</p>");
		out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	}else{
		String message="";
		message +="아이디/임시 비밀번호가 이메일로 전송되었습니다\\n";
		message +="임시 비밀번호는 로그인후 회정정보수정에서 수정하시기 바랍니다";
		out.println("<script>");
		out.println("	alert('" + message + "');");
		out.println("	location.href='loginForm.jsp';");
		out.println("</script>");
		
	}//if end

%>


<!-- ● [아이디/비번찾기] - findID.jsp

1) 이름과 이메일을 입력받아서 일치가 되면 id를 가져오고
2) 임시 비밀번호를 발급 해서
3) 아이디와 임시 비밀번호를 이메일로 전송하기
4) 임시비밀번호로 로그인 한후,
   본인이 회원 정보 수정에서 비밀번호를 수정한다
● [임시 비밀번호 발급]
1) 대문자, 소문자, 숫자를 이용해서 랜덤하게 10글자를 만들기
2) 1)에서 생성된 임시 비밀번호를 테이블에서 수정하기
 -->

<!-- 본문 끝 -->

<%@ include file="../footer.jsp"%>
