<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 -->



<!-- 본문 시작 bbsRead.jsp -->
<h3>* 공지사항 상세보기 *</h3>
<p>
   <a href="noticeForm.jsp">[글쓰기]</a>
   &nbsp;&nbsp;
   <a href="noticeList.jsp">[글목록]</a>
</p>
<%
	int noticeno=Integer.parseInt(request.getParameter("noticeno"));
	dto = dao.read(noticeno);
	if(dto==null){
	    out.println("해당 글 없음!!");
	}else{ 
	    
	    dao.incrementCnt(noticeno); //조회수 증가
%>
		<table class="table">
		<tr>
			<th class="success">제목</th>
			<td><%=dto.getSubject()%></td>
		</tr>
		<tr>
			<th class="success">내용</th>
			<td>
<%
				//특수문자 및 엔터를 <br>태그로 치환하기
				String content = dto.getContent();
				content = Utility.convertChar(content);
				out.print(content);
%>				
			</td>
		</tr>
		<tr>
			<th class="success">조회수</th>
			<td><%=dto.getReadcnt()%></td>
		</tr>
		<tr>
			<th class="success">작성자</th>
			<td><%=dto.getWname()%></td>
		</tr>
		<tr>
			<th class="success">작성일</th>
			<td><%=dto.getRegdt()%></td>
		</tr>		
		</table>
		
		<br>
		<input type="button" value="수정"    class="btn btn-warning" onclick="location.href='noticeUpdate.jsp?noticeno=<%=noticeno%>&col=<%=col%>&word=<%=word%>'">
<%	
		/* if(s_mlevel.equals("A1")){ */
%>
		<input type="button" value="삭제"    class="btn btn-danger"  onclick="location.href='noticeDel.jsp?noticeno=<%=noticeno%>'">
<%	
		/* }//(등급에 따른 삭제버튼 보이기) if end */
	}//if end
%>
<!-- 본문 끝 -->
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>
      