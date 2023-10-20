package net.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.notice.NoticeDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class NoticeDAO {

	private DBOpen dbopen = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private StringBuilder sql = null;

	public NoticeDAO() {
		dbopen = new DBOpen();
	}// end
	
	
	
	//행 추가
	public int create(NoticeDTO dto) {
	        int cnt=0;
	        try {
	            con=dbopen.getConnection();//DB연결
	            
	            sql=new StringBuilder();
	            sql.append(" INSERT INTO tb_notice(noticeno, wname, subject, content, passwd) ");
	            sql.append(" VALUES (noticeno_seq.nextval, ?, ?, ?, ?) ");
	            
	            pstmt=con.prepareStatement(sql.toString());
	            pstmt.setString(1, dto.getWname());
	            pstmt.setString(2, dto.getSubject());
	            pstmt.setString(3, dto.getContent());
	            pstmt.setString(4, dto.getPasswd());
	            
	            cnt=pstmt.executeUpdate();
	            
	        }catch (Exception e) {
	            System.out.println("추가실패:"+e);
	        }finally {
	            DBClose.close(con, pstmt);
	        }//end
	        return cnt;
	    }//create() end
	    
//	날짜데이터 
//(SELECT NVL(MAX(bbsno), 0)+1 FROM tb_notice)) 
	
	
	 public ArrayList<NoticeDTO> list(){
	        ArrayList<NoticeDTO> list = null;
	        try {
	           con = dbopen.getConnection();
	           
	           sql = new StringBuilder();
	           sql.append(" SELECT subject, wname, content, regdt, passwd ");
	           sql.append(" FROM tb_notice ");
	           sql.append(" ORDER BY noticeno desc");
	           
	           pstmt=con.prepareStatement(sql.toString());
	           rs=pstmt.executeQuery();
	           if(rs.next()) {
	               list = new ArrayList<NoticeDTO>();
	               do {
	            	   NoticeDTO dto = new NoticeDTO(); //한줄담기
	                   dto.setSubject(rs.getString("subject"));
	                   dto.setWname(rs.getString("wname"));
	                   dto.setContent(rs.getString("content"));
	                   dto.setPasswd(rs.getString("passwd"));
	                   dto.setRegdt(rs.getString("regdt"));
	                  
	                   list.add(dto); //list에 모으기
	                   
	               }while(rs.next());
	           }//if end
	           
	        }catch (Exception e) {
	            System.out.println("전체목록실패:"+e);
	        }finally {
	            DBClose.close(con, pstmt, rs);
	        }//end
	        
	        return list;
	        
	    }//list() end
	
	
}
