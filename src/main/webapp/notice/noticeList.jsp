<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 -->
<style>
.success th {
	text-align: center;
}
</style>

<!-- 본문 시작 bbsList.jsp -->
<h3>* 공지사항 *</h3>
<p>
	<a href="noticeForm.jsp">[글쓰기]</a>
</p>

<table class="table table-hover">
	<thead>
		<tr class="success">
			<th>공지사항</th>
			<th>작성자</th>	
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
<%
	ArrayList<NoticeDTO> list = dao.list();
	if(list==null){
	    out.println("<tr>");
	    out.println("  <td colspan='4'>");
	    out.println("    <strong>관련자료 없음!!</strong>");
	    out.println("  </td>");
	    out.println("</tr>");
	}else{
	
	    
	    for(int i=0; i<list.size(); i++){
	        dto = list.get(i);
%>
			<tr>
				<td style="">
					<a href="noticeRead.jsp?noticeno=<%=dto.getNoticeno()%>"><%=dto.getSubject()%></a>
				</td>
				
				<td><%=dto.getWname()%></td>
				<td><%=dto.getRegdt().substring(0, 10)%></td>
			</tr>
<%	        
	    }//for end
	    
	
	}//if end
%>

		<tr>
			<td colspan="4" style="text-align: center; height: 50px;">
				<form action="NoticeList.jsp" onsubmit="return searchCheck()">
					<select name="col">
						<option value="subject_content">제목+내용
						
						<option value="subject">제목
					
						<option value="content">내용
					
						<option value="wname">작성자
				
					</select>
				<input type="text" name="word" id="word">
				<input type="submit" value="검색" class="btn btn-primary">
			</form>
		</td>
	</tr>
<!-- 검색 끝 -->




</tbody>
</table>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>