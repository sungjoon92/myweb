<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
<!-- 본문 시작 bbsDel.jsp-->
<!-- 글번호(bbsno)와 비밀번호(passwd)가 일치하면 삭제 -->
<h3>* 글삭제 *</h3>
<p><a href="noticeList.jsp">[글목록]</a></p>
<%
    int noticeno=Integer.parseInt(request.getParameter("noticeno"));
%>
                                                <!-- myscript.js -->
	<form method="post" action="noticeDelProc.jsp" onsubmit="return pwCheck()">
		<input type="hidden" name="noticeno" value="<%=noticeno%>">
		<table class="table">
		<tr>
			<th class="success">비밀번호</th>
			<td><input type="password" name="passwd" id="passwd" required></td>
		</tr>
		<tr>
			<td colspan="2">
			    <input type="submit" value="삭제" class="btn btn-danger">
			</td>
		</tr>
		</table>
	</form>

<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>
    