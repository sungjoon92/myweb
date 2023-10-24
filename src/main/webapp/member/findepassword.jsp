<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>
<!-- 본문 시작 -->

<!-- <form method="post" action="findcheck.jsp">
	<table class="table">
		<tr>
			<th>이름</th>
			<td><input type="text" name="mname" id="mname"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" name="email" id="email"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="메일보내기" class="btn btn-primary">
				<input type="reset" value="취소" class="btn btn-primary">
			</td>
		</tr>
	</table>
</form> -->


	<form name="idfindscreen" method = "POST" action="findIDcheck.jsp">
			<div class = "search-title">
				<h3>*아이디 찾기*</h3>
			</div>
		<section class = "form-search">
			<div class = "find-name">
				<label>이름</label>
				<input type="text" name="mname" id="mname" class = "mname" placeholder = "등록한 이름">
			</div>
			<div class = "find-email">
				<label>이메일</label>
				<input type="email" name="email" id="email" placeholder = "이메일입력">
			</div>
			<br>
		</section>
	<div class ="btnSearch">
		<input type="submit" name="enter" value="찾기"  onClick="id_search()">
		<input type="reset" name="cancle" value="뒤로" onClick="history.back()">
 	</div>
 </form>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>