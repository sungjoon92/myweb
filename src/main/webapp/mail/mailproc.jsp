<%@page import="net.utility.MyAuthenticator"%>
<%@page import="javax.mail.Transport"%>
<%@page import="java.util.Date"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.activation.MimeType"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="net.utility.Utility"%>
<%@page import="javax.mail.Session"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%> 

<!-- 본문 시작 template.jsp -->
<h3>*메일 보내기 결과*</h3>

<%
try{
    
    //1) 사용하고자 하는 메일서버에서 인증받은 계정과 비번 등록하기
    //-> MyAuthenticator 클래스 생성
    
    //2) 메일서버(SMTP/POP3) 지정하기
    String mailServer = "mw-002.cafe24.com"; //cafe24 메일서버
    Properties props = new Properties();
    props.put("mail.smtp.host", mailServer);
    props.put("mail.smtp.auth", true);
    
    //3) 메일서버에서 인증받은 계정+비번
    Authenticator myAuth = new MyAuthenticator(); //다형성      
    
    //4) 2)와 3)이 유효한지 검증
    Session sess = Session.getInstance(props, myAuth);
    out.print("메일 서버 인증 성공!!");

    //5) 메일 보내기
    request.setCharacterEncoding("UTF-8");
    String to       = request.getParameter("to").trim();
    String from    = request.getParameter("from").trim();
    String subject = request.getParameter("subject").trim();
    String content = request.getParameter("content").trim();

    //엔터 및 특수문자 변경
    content = Utility.convertChar(content);
    
    //표작성
    content += "<hr>";
    content += "<table border='1'>";
    content += "<tr>";
    content += 	"<th>상품명</th>";
    content += 	"<th>상품가격</th>";
    content += "</tr>";
    content += "<tr>";
    content += "<td>운동화</td>";
    content += "<td><span style='color:red; font-weight:bold;'>15,000원</span></td>";
    content += "</tr>";
    content += "</table>";
    
    //이미지 출력하기
    content += "<hr>";
    content += "<img src='http://localhost:9090/myweb/images/devil.png'>";
    
    
    //받는 사람 이메일 주소 
    InternetAddress[] address = { new InternetAddress(to) }; //한 명한테 메일 보낼때
    /*
       cf. 수신인이 여러 명인 경우
       InternetAddress[] address = { new InternetAddress(to1),
                                 InternetAddress(to2),
                                 InternetAddress(to3)};
    */
    
    //메일 관련 정보 작성
    Message msg = new MimeMessage(sess); 
    
    //받는 사람
    msg.setRecipients(Message.RecipientType.TO, address);
    
    //참조   Message.RecipientType.CC      
    //숨은참조 Message.RecipientType.BCC
    
    //보내는 사람
    msg.setFrom(new InternetAddress(from));
    
    //메일 제목
    msg.setSubject(subject);
    
    //메일 내용
    msg.setContent(content,"text/html; charset=UTF-8"); //content를 "" 형식 안에 맞춰서 보여줘

    //메일 보낸날짜
    msg.setSentDate(new Date());
    
    //메일 전송
    Transport.send(msg);
    
    out.print(to+"님에게 메일이 발송되었습니다");
    
    
 }catch(Exception e){
    out.println("<p>메일 전송 실패!!" + e + "</p>");
    out.println("<p><a href='javascript:history.back();'>[다시시도]</a></p>");
 }//end
%>



<!-- ● [아이디/비번찾기] - findID.jsp

1) 이름과 이메일을 입력받아서 일치가 되면 id를 가져오고
2) 임시 비밀번호를 발급 해서
3) 아이디와 임시 비밀번호를 이메일로 전송하기
4) 임시비밀번호로 로그인 한후,
   본인이 회원 정보 수정에서 비밀번호를 수정한다
● [임시 비밀번호 발급]
1) 대문자, 소문자, 숫자를 이용해서 랜덤하게 10글자를 만들기
2) 1)에서 생성된 임시 비밀번호를 테이블에서 수정하기
 -->

<!-- 본문 끝 -->

<%@ include file="../footer.jsp"%>
