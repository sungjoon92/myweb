<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp"%>
<%@ include file="../header.jsp" %>
    
<!-- 본문 시작 template.jsp -->
<h3>* 게시판 수정 *</h3>
<p>
   <a href="bbsForm.jsp">[글쓰기]</a>
   &nbsp;&nbsp;
   <a href="bbsList.jsp">[글목록]</a>
</p>
<%
	//사용자가 입력 요청한 정보를 가져오기
	
	
	String id	= request.getParameter("id").trim();
	String passwd	= request.getParameter("passwd").trim();
	String mname	= request.getParameter("mname").trim();
	String tel	= request.getParameter("tel").trim();
	String zipcode	= request.getParameter("zipcode").trim();
	String address1	= request.getParameter("address1").trim();
	String address2	= request.getParameter("address2").trim();
	String email	= request.getParameter("email").trim();
	String job	= request.getParameter("job").trim();

	//dto객체에 담기
	dto.setId(id);
	dto.setPasswd(passwd);
	dto.setMname(mname);
	dto.setTel(tel);
	dto.setZipcode(zipcode);
	dto.setAddress1(address1);
	dto.setAddress2(address2);
	dto.setEmail(email);
	dto.setJob(job);
	

	int cnt = dao.updateproc(dto);
	
	if(cnt==0){
		out.println("<p>회원정보 수정 실패!!</p>");
		out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	}else{
		out.println("<script>");
		out.println("	alert('게시글이 수정되었습니다~');");
		out.println("	location.href='loginForm.jsp'");//목록 페이지 이동
		out.println("</script>");
	}//if end
%>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>
    
    
    
    
    
    