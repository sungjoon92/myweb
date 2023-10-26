package net.pds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import net.notice.NoticeDTO;
import net.pds.PdsDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class PdsDAO {

	private DBOpen dbopen = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private StringBuilder sql = null;

	public PdsDAO() {
		dbopen = new DBOpen();
	}// end	

	public ArrayList<PdsDTO> list() {
		ArrayList<PdsDTO> list = null;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT pdsno, wname, subject, readcnt, filename, regdate ");
			sql.append("   FROM tb_pds ");
			sql.append("  ORDER BY regdate desc");

			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<PdsDTO>();
				do {
					PdsDTO dto = new PdsDTO(); // 한줄담기
					dto.setPdsno(rs.getInt("pdsno"));
					dto.setWname(rs.getString("wname"));
					dto.setSubject(rs.getString("subject"));
					dto.setReadcnt(rs.getInt("readcnt"));
					dto.setFilename(rs.getString("filename"));
					dto.setRegdate(rs.getString("regdate"));

					list.add(dto); // list에 모으기

				} while (rs.next());
			} // if end

		} catch (Exception e) {
			System.out.println("포토 갤러리 목록실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // end

		return list;

	}// list() end

	
	
	
	
	//행 추가
		public int create(PdsDTO dto) {
		        int cnt=0;
		        try {
		            con=dbopen.getConnection();//DB연결
		            
		            sql=new StringBuilder();
		            sql.append(" INSERT INTO tb_pds(pdsno, wname, subject, passwd, filename, filesize, regdate) ");
		            sql.append(" VALUES (noticeno_seq.nextval, ?, ?, ?, ?, ? , sysdate) ");
		            
		            pstmt=con.prepareStatement(sql.toString());
		            pstmt.setString(1, dto.getWname());
		            pstmt.setString(2, dto.getSubject());
		            pstmt.setString(3, dto.getPasswd());
		            pstmt.setString(4, dto.getFilename());
		            pstmt.setLong  (5, dto.getFilesize());
		            
		            cnt=pstmt.executeUpdate();
		            
		        }catch (Exception e) {
		            System.out.println("포토갤러리 추가실패:"+e);
		        }finally {
		            DBClose.close(con, pstmt);
		        }//end
		        return cnt;
		    }//create() end

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}// PdsDAO class end
