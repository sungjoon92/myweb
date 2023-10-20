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
	int bbsno=Integer.parseInt(request.getParameter("bbsno"));
	String wname	= request.getParameter("wname").trim();
	String subject	= request.getParameter("subject").trim();
	String content	= request.getParameter("content").trim();
	String passwd	= request.getParameter("passwd").trim();
	String ip		= request.getRemoteAddr();// 요청 pc의 IP

	//dto객체에 담기
	dto.setBbsno(bbsno);
	dto.setWname(wname);
	dto.setSubject(subject);
	dto.setContent(content);
	dto.setPasswd(passwd);
	dto.setIp(ip);

	int cnt = dao.updateproc(dto);
	
	if(cnt==0){
		out.println("<p>비밀번호가 일치하지 않습니다!!</p>");
		out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	}else{
		out.println("<script>");
		out.println("	alert('게시글이 수정되었습니다~');");
		out.println("	location.href='bbsList.jsp;col=" + col + "&word=" + word + "';");//목록 페이지 이동
		out.println("</script>");
	}//if end
%>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>
    
    
    
    
    
    