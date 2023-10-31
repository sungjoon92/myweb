<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="auth.jsp" %>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
    
<!-- 본문 시작 memberWithdrawproc.jsp-->
<h3>* 글삭제 *</h3>
<%
	String passwd= request.getParameter("passwd");  

	dto.setId(s_id);
	dto.setPasswd(passwd);
	
	int cnt = dao.delete(dto);
	session.removeAttribute("s_id");
	
	if(cnt==0){
        out.println("<p>비밀번호가 일치하지 않습니다</p>");
        out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	}else{
		
        out.println("<script>");
        out.println("    alert('게시글이 삭제되었습니다');");
        out.println("    location.href='bbsList.jsp';");//목록페이지 이동
        out.println("</script>");
	}//if end
%>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>
    