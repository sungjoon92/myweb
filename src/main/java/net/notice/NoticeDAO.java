package net.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.bbs.BbsDTO;
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
	
	
////////////////////////////////////////////////////////////////////	
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

////////////////////////////////////////////////////////////////////
	
//	날짜데이터 
//(SELECT NVL(MAX(bbsno), 0)+1 FROM tb_notice)) 
	
	
	 public ArrayList<NoticeDTO> list(){
	        ArrayList<NoticeDTO> list = null;
	        try {
	           con = dbopen.getConnection();
	           
	           sql = new StringBuilder();
	           sql.append(" SELECT subject, wname, content, regdt, passwd, readcnt, noticeno ");
	           sql.append("   FROM tb_notice ");
	           sql.append("  ORDER BY noticeno desc");
	           
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
	                   dto.setReadcnt(rs.getInt("readcnt"));
	                   dto.setNoticeno(rs.getInt("noticeno"));
	                  
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
	
////////////////////////////////////////////////////////////////////
	
	   public NoticeDTO read(int noticeno) {
		   NoticeDTO dto = null;
	        try {
	            con = dbopen.getConnection();
	            
	            sql=new StringBuilder();
	            sql.append(" SELECT noticeno, wname, subject, content, regdt, readcnt");
	            sql.append("   FROM tb_notice ");
	            sql.append("  WHERE noticeno = ? ");
	            
	            pstmt=con.prepareStatement(sql.toString());
	            pstmt.setInt(1, noticeno);
	            
	            rs=pstmt.executeQuery();
	            if(rs.next()) {
	                dto=new NoticeDTO();
	                dto.setNoticeno(rs.getInt("noticeno"));
	                dto.setWname(rs.getString("wname"));
	                dto.setSubject(rs.getString("subject"));
	                dto.setContent (rs.getString("content"));
	                dto.setRegdt(rs.getString("regdt"));
	                dto.setReadcnt(rs.getInt("readcnt"));
	            }//if end
	            
	        }catch (Exception e) {
	            System.out.println("상세보기실패:"+e);
	        }finally {
	            DBClose.close(con, pstmt, rs);
	        }//end
	        
	        return dto;
	        
	    }//read() end
	 
	 
////////////////////////////////////////////////////////////////////
	   
	   public void incrementCnt(int noticeno) {
	        try {
	            con=dbopen.getConnection();
	            
	            sql=new StringBuilder();
	            sql.append(" UPDATE tb_notice ");
	            sql.append(" SET readcnt = readcnt+1 ");
	            sql.append(" WHERE noticeno = ? ");
	            
	            pstmt=con.prepareStatement(sql.toString());
	            pstmt.setInt(1, noticeno);
	            pstmt.executeUpdate();
	            
	        }catch (Exception e) {
	            System.out.println("조회수 증가 실패:"+e);
	        }finally {
	            DBClose.close(con, pstmt);
	        }//end
	    }//incrementCnt() end    
	 
	   public int delete(NoticeDTO dto) {
	        int cnt=0;
	        try {
	            
	            con=dbopen.getConnection();
	            sql=new StringBuilder();
	            sql.append(" DELETE FROM tb_notice ");
	            sql.append(" WHERE noticeno=? AND passwd=? ");
	            
	            pstmt=con.prepareStatement(sql.toString());
	            pstmt.setInt(1, dto.getNoticeno());
	            pstmt.setString(2, dto.getPasswd());
	            cnt=pstmt.executeUpdate();
	            
	        }catch (Exception e) {
	            System.out.println("삭제 실패:"+e);
	        }finally {
	            DBClose.close(con, pstmt);
	        }//end
	        return cnt;
	    }//delete() end
	 
	 
	   public int updateproc(NoticeDTO dto) { //반환할 값이 없으면 int 대신 void
	        int cnt = 0 ;
	        try {
	           con = dbopen.getConnection();
	           
	           sql = new StringBuilder();
	           sql.append(" UPDATE tb_notice ");
	           sql.append(" SET wname=? ");
	           sql.append(" , subject=? ");
	           sql.append(" , content=? ");
	           sql.append(" WHERE noticeno=? AND passwd=? ");

	           pstmt = con.prepareStatement(sql.toString());
	           pstmt.setString(1, dto.getWname());
	           pstmt.setString(2, dto.getSubject());
	           pstmt.setString(3, dto.getContent());
	           pstmt.setInt(4, dto.getNoticeno());
	           pstmt.setString(5, dto.getPasswd());
	           
	           cnt = pstmt.executeUpdate();

	        } catch (Exception e) {
	           System.out.println("수정실패:" + e);
	        } finally {
	           DBClose.close(con, pstmt);
	        }//end
	        return cnt;
	     }//updateproc() end
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}//NoticeDAO class end
