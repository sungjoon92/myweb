<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
    
<!-- 본문 시작 bbsUpdate.jsp-->
<!-- 글번호가 일치하는 행을 가져와서, 수정폼에 출력하기 -->
<h3>* 게시판 수정 *</h3>
<p>
   <a href="noticeForm.jsp">[글쓰기]</a>
   &nbsp;&nbsp;
   <a href="noticeList.jsp">[글목록]</a>
</p>
<%
    int noticeno=Integer.parseInt(request.getParameter("noticeno"));
	dto=dao.read(noticeno); //글번호가 일치하는 행을 가져오기
	if(dto==null){
	    out.println("해당 글 없음!!");
	}else{
%>
	<form name="noticefrm" id="noticefrm" method="post" action="noticeUpdateProc.jsp" onsubmit="return noticeCheck()">
		<input type="hidden" name="noticeno" value="<%=noticeno%>"><!-- 글번호 -->
		<!-- 현재 페이지의 상태를 유지하기 위한 값 -->
		<input type="hidden" name="col" value="<%=col%>">
		<input type="hidden" name="word" value="<%=word%>">
		<table class="table">
			<tr>
			   <th class="success">작성자</th>
			   <td><input type="text" name="wname" id="wname" value="<%=dto.getWname()%>" class="form-control" maxlength="20" ></td>
			</tr>
			<tr>
			   <th class="success">제목</th>
			   <td><input type="text" name="subject" id="subject" value="<%=dto.getSubject()%>" class="form-control" maxlength="100" ></td>
			</tr>
			<tr>
			   <th class="success">내용</th>
			   <td><textarea rows="5"  class="form-control" name="content" id="content"><%=dto.getContent()%></textarea></td>
			</tr>
			<tr>
			   <th class="success">비밀번호</th>
			   <td><input type="password" name="passwd" id="passwd" value="" class="form-control" maxlength="10" oninput="key(this)" ></td>
			</tr>
			<tr>
			    <td colspan="2" align="center">
			       <input type="submit" value="수정" class="btn btn-success">
			       <input type="reset"  value="취소" class="btn btn-danger">
			    </td>
			</tr>
		</table>
	</form>   
<%
	}//if end
%>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>
    