<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="auth.jsp" %>
<%@ include file="../header.jsp" %>
    
<!-- 본문 시작 pdsDel.jsp-->
<!-- 글번호(pdsno)와 비밀번호(passwd)가 일치하면 삭제 -->
<h3>* 회원탈퇴 *</h3>
<p><a href="loginForm.jsp">로그인화면으로</a></p>

                                                <!-- myscript.js -->
	<form method="post" action="memberWithdrawproc.jsp" onsubmit="return pwCheck()">
		<input type="hidden" name="s_id" value="<%=s_id%>">
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
    