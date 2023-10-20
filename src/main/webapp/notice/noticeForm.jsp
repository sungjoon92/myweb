<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
<!-- 본문 시작 -->
<h3> 글 쓰기</h3>
<p><a href="noticeList.jsp">[글목록]</a></p>
																	<!-- myscript.js에 함수 작성 -->
<form name="Noticefrm" id="Noticefrm" method="post" action="noticeIns.jsp" onsubmit="return bbsCheck()">
	<table class="table">
		<tr>
		   <th class="success">공지사항</th>
		   <td><input type="text" name="subject" id="subject" class="form-control" maxlength="20" ></td>
		</tr>
		<tr>
		   <th class="success">내용</th>
		   <td><textarea rows="5" name="content" id="content" class="form-control" ></textarea></td>
		</tr>
		<tr>
		   <th class="success">작성자</th>
		   <td><input type="text" name=wname id="wname" class="form-control" maxlength="100" ></td>
		</tr>
		<tr>
		   <th class="success">비밀번호</th>
		   <td><input type="password" name="passwd" id="passwd" class="form-control" maxlength="10" oninput="key(this)" ></td>
		</tr>
		<tr>
		    <td colspan="2" align="center">
		       <input type="submit" value="완료" class="btn btn-success">
		       <input type="reset"  value="취소" class="btn btn-danger">
		    </td>
		</tr>
		
	</table>
</form>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>
      