<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
<!-- 본문 시작 -->
<%
	//사용자가 입력 요청한 정보를 가져오기
	String wname	= request.getParameter("wname").trim();//작성자
	String subject	= request.getParameter("subject").trim();//제목
	String content	= request.getParameter("content").trim();//내용
	String passwd	= request.getParameter("passwd").trim();//비번
	
	//dto객체에 담기
	dto.setWname(wname);
	dto.setSubject(subject);
	dto.setContent(content);
	dto.setPasswd(passwd);
	
	int cnt = dao.create(dto);
	
	if(cnt==0){
		out.println("<p>글추가 실패 했습니다!!</p>");
		out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	}else{
		out.println("<script>");
		out.println("	alert('게시글이 추가되었습니다~');");
		out.println("	location.href='noticeList.jsp';");//목록 페이지 이동
		out.println("</script>");
	}//if end
%>
      
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>
      