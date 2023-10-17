<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
    
<!-- 본문 시작 template.jsp -->
<form name="bbsfrm" id="bbsfrm" method="post" action="bbsreplyproc.jsp" onsubmit="return bbsCheck()">
	<!-- 부모글 번호 -->
	<input type="hidden" name="bbsno" value="<%=request.getParameter("bbsno")%>">
	<table class="table">
		<tr>
		   <th class="success">작성자</th>
		   <td><input type="text" name="wname" id="wname" class="form-control" maxlength="20" ></td>
		</tr>
		<tr>
		   <th class="success">제목</th>
		   <td><input type="text" name="subject" id="subject" class="form-control" maxlength="100" ></td>
		</tr>
		<tr>
		   <th class="success">내용</th>
		   <td><textarea rows="5"  class="form-control" name="content" id="content"></textarea></td>
		</tr>
		<tr>
		   <th class="success">비밀번호</th>
		   <td><input type="password" name="passwd" id="passwd" class="form-control" maxlength="10" oninput="key(this)" ></td>
		</tr>
		<tr>
		    <td colspan="2" align="center">
		       <input type="submit" value="새글쓰기" class="btn btn-success">
		       <input type="reset"  value="취소" class="btn btn-danger">
		    </td>
		</tr>
	</table>
</form>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>