package net.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.RecipientStringTerm;

import net.bbs.BbsDTO;
import net.notice.NoticeDTO;
import net.utility.DBClose;
import net.utility.DBOpen;
import net.utility.MyAuthenticator;
import oracle.net.aso.i;

public class MemberDAO { // Data Access Object
							// 데이터베이스 비지니스 로직 구현

	private DBOpen dbopen = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private StringBuilder sql = null;

	public MemberDAO() {
		dbopen = new DBOpen();
	}// end

	//////////////// 로그인 프로세스/////////////////////
	public String loginProc(MemberDTO dto) {
		String mlevel = null;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT mlevel ");
			sql.append(" FROM member ");
			sql.append(" WHERE id=? AND passwd=? ");
			sql.append(" AND mlevel in ('A1', 'B1', 'C1', 'D1') ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				mlevel = rs.getString("mlevel");
			} // if end

		} catch (Exception e) {
			System.out.println("로그인실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // end
		return mlevel;
	}// loginProc() end

///////////////////아이디 중복확인///////////////////////
	public int duplecateID(String id) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT COUNT(id) as cnt");
			sql.append(" FROM member ");
			sql.append(" WHERE id=?");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			} // if end

		} catch (Exception e) {
			System.out.println("로그인실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // end
		return cnt;
	}// duplecateId() end

	

	
//////////////////////////////////////////////////////////////////
	
	
	public int duplecateEmail(String email) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT COUNT(email) as cnt");
			sql.append(" FROM member ");
			sql.append(" WHERE eamil=?");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			} // if end

		} catch (Exception e) {
			System.out.println("로그인실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // end
		return cnt;
	}// duplecateId() end
  
//////////////////////////////////////////////////////////////////
	
	public int create(MemberDTO dto) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" INSERT INTO member(id, passwd, mname, tel, email, zipcode, address1, address2, job, mlevel, mdate) ");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 'D1', sysdate) ");

			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPasswd());
			pstmt.setString(3, dto.getMname());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getEmail());
			pstmt.setString(6, dto.getZipcode());
			pstmt.setString(7, dto.getAddress1());
			pstmt.setString(8, dto.getAddress2());
			pstmt.setString(9, dto.getJob());

			cnt = pstmt.executeUpdate();

			if (rs.next()) {
				cnt = rs.getInt("cnt");
			} // if end

		} catch (Exception e) {
			System.out.println("회원 가입 실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // end
		return cnt;
	}// duplecateId() end

	/*
	 * public String idcheck(MemberDTO dto) { String id=null; try {
	 * con=dbopen.getConnection();
	 * 
	 * sql=new StringBuilder(); sql.append(" SELECT id ");
	 * sql.append("   FROM member "); sql.append("  WHERE mname=? and email=? ");
	 * 
	 * pstmt=con.prepareStatement(sql.toString());
	 * 
	 * pstmt.setString(1, dto.getMname()); pstmt.setString(2, dto.getEmail());
	 * 
	 * 
	 * rs= pstmt.executeQuery(); if(rs.next()) { id=rs.getString("id"); }//if end
	 * 
	 * }catch (Exception e) { System.out.println("로그인실패:" + e); }finally {
	 * DBClose.close(con, pstmt, rs); }//end return id; }//loginProc() end
	 */

	
////////////////////////////////////////////////////////////////////	
	
	
	public boolean findID(MemberDTO dto) {
		boolean flag = false;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT id ");
			sql.append("   FROM member ");
			sql.append("  WHERE mname=? AND email=? ");

			pstmt = con.prepareStatement(sql.toString());

			pstmt.setString(1, dto.getMname());
			pstmt.setString(2, dto.getEmail());

			rs = pstmt.executeQuery();
			// 1) 아이디 가져오기
			if (rs.next()) {
				String id = rs.getString("id");

				// 2) 임시 비밀번호
				// -> 대문자, 소문자, 숫자를 이용해서 랜덤하게 10글자를 만들기
				String[] ch = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
						"R", "S", "T", "Y", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
						"p", "q", "r", "s", "t", "y", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

				// ch배열에서 랜덤하게 10글자 뽑아서가져오기
				StringBuilder imsiPW = new StringBuilder();// 임시 비밀번호
				for (int i = 0; i < 10; i++) {
					int num = (int) (Math.random() * ch.length);
					imsiPW.append(ch[num]);
				} // for end

				
				// 임시 비밀번호로 테이블 수정하기

				sql = new StringBuilder();
				sql.append(" UPDATE member ");
				sql.append(" SET passwd=? ");
				sql.append(" WHERE mname=? and email=? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, imsiPW.toString());
				pstmt.setString(2, dto.getMname());
				pstmt.setString(3, dto.getEmail());
				
				int cnt=pstmt.executeUpdate();
				if(cnt==1) {//임시 비밀번호로 테이블 수정 되었다면
					//아이디(id)와 임시비밀번호(imsiPW)를 웹 메일 전송하기
					
					//메일내용
					String content="임시 비밀번호로 로그인 한 후 회원정보 수정에서 비밀번호를 변경하시기 바랍니다";
					content += "<hr>";
					content += "<table border='1'>";
					content += "<tr>";
					content += 		"<th>아이디</th>";
					content += 		"<td>" + id + "</td>";
					content += "<tr>";
					content += 		"<th>임시비밀번호</th>";
					content += 		"<td>" + imsiPW.toString() + "</td>";
					content += "</tr>";
					content += "</table>";
				
					//2) 메일서버(SMTP/POP3) 지정하기
					String mailServer = "mw-002.cafe24.com"; //cafe24 메일서버
				    Properties props = new Properties();
				    props.put("mail.smtp.host", mailServer);
				    props.put("mail.smtp.auth", true);
				
				    //3) 메일서버에서 인증받은 계정+비번
				    Authenticator myAuth = new MyAuthenticator(); //다형성      
				    
				    //4) 2)와 3)이 유효한지 검증
				    Session sess = Session.getInstance(props, myAuth);
				    
				    //받는 사람 이메일 주소 
				    InternetAddress[] address = { new InternetAddress(dto.getEmail()) }; //한 명에게 메일 보낼때
				   
				    //메일 관련 정보 작성
				    Message msg = new MimeMessage(sess); 
				    //받는 사람
				    msg.setRecipients(Message.RecipientType.TO, address);
				    
				    //참조   Message.RecipientType.CC      
				    //숨은참조 Message.RecipientType.BCC
				    
				    //보내는 사람
				    msg.setFrom(new InternetAddress("wsjwindy0714@daum.net"));
				    
				    //메일 제목
				    msg.setSubject("myweb 아이디/비번입니다");
				    
				    //메일 내용
				    msg.setContent(content,"text/html; charset=UTF-8"); //content를 "" 형식 안에 맞춰서 보여줘

				    //메일 보낸날짜
				    msg.setSentDate(new Date());
				    
				    //메일 전송
				    Transport.send(msg);
				    	
				    flag = true;
				    
				}//if end
				
			} // if end

		} catch (Exception e) {
			System.out.println("아이디/비번찾기 실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // end
		return flag;
	}//// findId() end

	/*
	 * 비밀번호 랜덤 생성 String pswd = "";
	 * 
	 * // 아스키문자 65번(A) 부터 26 자 중에 택일, (대문자) for( int i = 0;i<4;i++) { pswd = pswd +
	 * Character.toString((char) ((Math.random() * 26) + 65)); }
	 * 
	 * // 아스키문자 97번(a) 부터 26 자 중에 택일, (소문자) for( int i = 0;i<4;i++) { pswd = pswd +
	 * Character.toString((char) ((Math.random() * 26) + 97)); }
	 * 
	 * // 아스키문자 48번(1) 부터 10 자 중에 택일, (숫자) for( int i = 0;i<2;i++) { pswd = pswd +
	 * Character.toString((char) ((Math.random() * 10) + 48)); }
	 * 
	 * out.println("passwd = "+pswd);
	 */

	
	
	
	
	 public int updateproc(MemberDTO dto) { //반환할 값이 없으면 int 대신 void
	        int cnt = 0 ;
	        try {
	           con = dbopen.getConnection();
	           
	           sql = new StringBuilder();
	           sql.append(" UPDATE member ");
	           sql.append(" SET ");
	           sql.append("  passwd=? ");
	           sql.append(" , mname=? ");
	           sql.append(" , tel=? ");
	           sql.append(" , email=? ");
	           sql.append(" , zipcode=? ");
	           sql.append(" , address1=? ");
	           sql.append(" , address2=? ");
	           sql.append(" , job=? ");
	           sql.append(" WHERE id=?");

	           pstmt = con.prepareStatement(sql.toString());
	           pstmt.setString(1, dto.getPasswd());   
	           pstmt.setString(2, dto.getMname());    
	           pstmt.setString(3, dto.getTel());      
	           pstmt.setString(4, dto.getEmail());    
	           pstmt.setString(5, dto.getZipcode());  
	           pstmt.setString(6, dto.getAddress1()); 
	           pstmt.setString(7, dto.getAddress2()); 
	           pstmt.setString(8, dto.getJob());      
	           pstmt.setString(9, dto.getId());       
	           
	           cnt = pstmt.executeUpdate();

	        } catch (Exception e) {
	           System.out.println("수정실패:" + e);
	        } finally {
	           DBClose.close(con, pstmt);
	        }//end
	        return cnt;
	     }//updateproc() end
	 
	 
	 
	 public MemberDTO read(String id) {
		 	MemberDTO dto = null;
	        try {
	            con = dbopen.getConnection();
	            
	            sql=new StringBuilder();
	            sql.append(" SELECT id, passwd, mname, tel, email, zipcode, address1, address2, job, mlevel, mdate");
	            sql.append("   FROM member ");
	            sql.append("  WHERE id = ? ");
	         
	            pstmt=con.prepareStatement(sql.toString());
	            pstmt.setString(1, id);
	            
	            rs=pstmt.executeQuery();
	            if(rs.next()) {
	                dto=new MemberDTO();
	                dto.setId(rs.getString("id"));
	                dto.setPasswd(rs.getString("passwd"));
	                dto.setMname(rs.getString("mname"));
	                dto.setTel(rs.getString("tel"));
	                dto.setEmail(rs.getString("email"));
	                dto.setZipcode(rs.getString("zipcode"));
	                dto.setAddress1(rs.getString("address1"));
	                dto.setAddress2(rs.getString("address2"));
	                dto.setJob(rs.getString("job"));
	                dto.setMlevel(rs.getString("mlevel"));
	                dto.setMdate(rs.getString("mdate"));
	                
	            }//if end
	            
	        }catch (Exception e) {
	            System.out.println("상세보기실패:"+e);
	        }finally {
	            DBClose.close(con, pstmt, rs);
	        }//end
	        
	        return dto;
	        
	    }//read() end
	 
	 
	 
	 
	 
	 
	 public int delete(MemberDTO dto) {
	        int cnt=0;
	        try {
	            
	            con=dbopen.getConnection();
	            sql=new StringBuilder();
	            sql.append(" DELETE FROM member ");
	            sql.append(" WHERE id=? AND passwd=? ");
	            
	            pstmt=con.prepareStatement(sql.toString());
	            pstmt.setString(1, dto.getId());
	            pstmt.setString(2, dto.getPasswd());
	            cnt=pstmt.executeUpdate();
	            
	        }catch (Exception e) {
	            System.out.println("삭제 실패:"+e);
	        }finally {
	            DBClose.close(con, pstmt);
	        }//end
	        return cnt;
	    }//delete() end
	 
	 
	
	    
}// class end
