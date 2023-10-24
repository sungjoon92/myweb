
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
	
	dto.setMname(mname);
	dto.setEmail(email);
	
	String id = dao.idcheck(dto);
	
	if(id==null){
	    out.println("해당 글 없음!!");
	}else{ 
%>
		<table class="table">
		<tr>
			<th class="success">아이디</th>
			<td><%=id%></td>
		</tr>
		<tr>
			<a href="findepassword.jsp">비밀번호 찾기</a>
		</tr>
		</table>
		
		
<%
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
