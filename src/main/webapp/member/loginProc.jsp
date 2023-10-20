<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>
    
<!-- 본문시작 loginProc.jsp -->
<h3>* 로 그 인 결과 *</h3>
<%

	String id    =request.getParameter("id").trim();
	String passwd=request.getParameter("passwd").trim();

	/* out.print(id);
	out.print(passwd); */
	
	dto.setId(id);
	dto.setPasswd(passwd);
	
	String mlevel = dao.loginProc(dto);
	//out.print(mlevel);
	if(mlevel==null){
		out.println("<p>아이디/비밀번호 다시 한번 확인해주세요!!</p>");
		out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	}else{
		//out.println("로그인 성공~~");
		//out.println("회원등급:"+ mlevel);
		
		//다른 페이지에서도 로그인 상태 정보를 공유할 수 있도록
		//나의 세션 케비냇생성
		session.setAttribute("s_id", id);
		session.setAttribute("s_passwd", passwd);
		session.setAttribute("s_mlevel", mlevel);
		
		//쿠키 시작--------------------------------
		//-> 웹서버가 사용자 pc에 저장하는 텍스트 파일로 된 정보
		//-> 각 브라우저의 쿠키삭제의 영향을 받는다
		//-> 보안에 취약하다
		//-> 아이디 저장, 오늘창그만보기, 클릭한 상품목록
		//-> 오늘창그만보기는 자바스크립트 쿠키. 참조 https://www.w3schools.com/js/js_cookies.asp
		//<input type="checkbox" name="c_id" value="SAVE">ID저장
		String c_id = Utility.checkNull(request.getParameter("c_id"));
		Cookie cookie = null;
		if(c_id.equals("SAVE")){
			//쿠키변수 선언 new Cookie("변수명", 값)
			cookie = new Cookie("c_id", id);
			//쿠키의 생존기간 1개월
			cookie.setMaxAge(60*60*24*30); //각 브라우저의 쿠키삭제의 영향을 받는다
		}else{
			cookie = new Cookie("c_id", "");
			cookie.setMaxAge(0);
		}//if end
		
		//요청한 사용자 pc에 쿠키값을 저장
		response.addCookie(cookie);
		//쿠키 끝--------------------------------
		
		
		//첫 페이지 이동
		//http://localhost:9090/myweb/index.jsp
		String root = Utility.getRoot(); // /myweb반환
		/* 1. sendRedirect : 짐 (데이터) 없이 단순 이동일 때 주로 사용 */
		response.sendRedirect(root + "/index.jsp");
		
		
	}//if end
	
	
%>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>
    