<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="ssi.jsp"%>
<%@ include file="../header.jsp"%>
<!-- 본문 시작 template.jsp -->
<h3>*사진 올리기 결과*</h3>


<%
	try {
		//1) 첨부된 파일 저장하기
		String saveDirectory = application.getRealPath("/storage");
		//저장 가능한 최대 용량(10M)
		int maxPostSize = 1024 * 1024 * 10;
		//한글 인코딩
		String encoding = "UTF-8";
		MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding,
		new DefaultFileRenamePolicy());
	
		//2) 1)단계에서 저장한 파일의 파일명, 파일크기 가져오기
		String fileName = ""; //파일명
		long fileSize = 0; //파일크기
		File file = null; //실제 파일 크기
		String item = ""; //name="filename"
	
		Enumeration files = mr.getFileNames(); //mr에서 <input type=file>을 전부 수거하기
		while (files.hasMoreElements()) { //여러개의 파일을 첨부하는 경우에 한개씩 처리하기
			item = (String) files.nextElement(); //name="filename"
			fileName = mr.getFilesystemName(item); //mr객체에서 item이 가지고 있는 실제 파일명(sku.png)가져오기
			if (fileName != null) { //실제 파일명을 가져왔따면
		file = mr.getFile(item); //mr에서 실제 파일 가져오기
		if (file.exists()) { //파일이 존재한다면
			fileSize = file.length(); //파일크기 가져오기
		} //if ebd
			} //if end
		} //whilr end
	
		//사용자가 입력 요청한 정보를 가져오기
		String wname = mr.getParameter("wname").trim();
		String subject = mr.getParameter("subject").trim();
		String passwd = mr.getParameter("passwd").trim();
	
		//dto객체에 담기
		dto.setWname(wname);
		dto.setSubject(subject);
		dto.setPasswd(passwd);
		dto.setFilename(fileName);
		dto.setFilesize(fileSize);
	
		int cnt = dao.create(dto);
	
		if (cnt == 0) {
			out.println("<p>사진 올리기 실패했습니다!!</p>");
			out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
		} else {
			out.println("<script>");
			out.println("	alert('사진이 추가되었습니다~');");
			out.println("	location.href='pdsList.jsp';");//목록 페이지 이동
			out.println("</script>");
		} //if end
	
	} catch (Exception e) {
		out.print(e);
		out.print("<p>파일 업로드 실패!</p>");
		out.print("<a href='javascript:history.back();'>[다시시도]</a>");
	} //end
 %>

<!-- 본문 끝 -->

<%@ include file="../footer.jsp"%>
