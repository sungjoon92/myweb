<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!-- 본문시작 loginForm.jsp -->

<%
	//세션변수 제거 -> null값
	session.removeAttribute("s_id");
	session.removeAttribute("s_pwsswd");
	session.removeAttribute("s_mlevel");

	//페이지 이동
	response.sendRedirect("loginForm.jsp");
%>
<!-- 본문 끝 -->

    