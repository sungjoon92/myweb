<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 -->

<form name="idfindscreen" method="POST" action="findIDproc.jsp"
	onsubmit="return findIDCheck()">
	<div class="search-title">
		<h3>*아이디 찾기*</h3>
	</div>
	<section class="form-search">
		<div class="find-name">
			<label>이름</label>
			 <input type="text" name="mname" id="mname"
				class="mname" placeholder="등록한 이름">
		</div>
		<div class="find-email">
			<label>이메일</label>
			<input type="email" name="email" id="email"
				placeholder="이메일입력">
		</div>
		<br>
	</section>
	<div class="btnSearch">
		<input type="submit" name="enter" value="찾기" onClick="id_search()">
		<input type="reset" name="cancle" value="뒤로" onClick="history.back()">
	</div>
	
	
</form>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp"%>