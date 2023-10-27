package net.pds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.text.Utilities;

import net.notice.NoticeDTO;
import net.pds.PdsDTO;
import net.utility.DBClose;
import net.utility.DBOpen;
import net.utility.Utility;

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

	// 행 추가
	public int create(PdsDTO dto) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();// DB연결

			sql = new StringBuilder();
			sql.append(" INSERT INTO tb_pds(pdsno, wname, subject, passwd, filename, filesize, regdate) ");
			sql.append(" VALUES (noticeno_seq.nextval, ?, ?, ?, ?, ? , sysdate) ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getWname());
			pstmt.setString(2, dto.getSubject());
			pstmt.setString(3, dto.getPasswd());
			pstmt.setString(4, dto.getFilename());
			pstmt.setLong(5, dto.getFilesize());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("포토갤러리 추가실패:" + e);
		} finally {
			DBClose.close(con, pstmt);
		} // end
		return cnt;
	}// create() end

	public PdsDTO read(int pdsno) {
		PdsDTO dto = null;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT pdsno, wname, subject, regdate, passwd, readcnt, filename, filesize ");
			sql.append("  FROM tb_pds ");
			sql.append("  WHERE pdsno = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, pdsno);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new PdsDTO();
				dto.setPdsno(rs.getInt("pdsno"));
				dto.setWname(rs.getString("wname"));
				dto.setSubject(rs.getString("subject"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setFilename(rs.getString("filename"));
				dto.setFilesize(rs.getLong("filesize"));
			} // if end

		} catch (Exception e) {
			System.out.println("상세보기실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // end

		return dto;

	}// read() end

	// 조회수 증가

	public void incrementCnt(int pdsno) {
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" UPDATE tb_pds ");
			sql.append(" SET readcnt = readcnt+1 ");
			sql.append(" WHERE pdsno = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, pdsno);
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("조회수 증가 실패:" + e);
		} finally {
			DBClose.close(con, pstmt);
		} // end
	}// incrementCnt() end

	public int delete(PdsDTO dto) {
		int cnt = 0;
		try {

			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" DELETE FROM tb_pds ");
			sql.append(" WHERE pdsno=? AND passwd=?");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getPdsno());
			pstmt.setString(2, dto.getPasswd());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("삭제 실패:" + e);
		} finally {
			DBClose.close(con, pstmt);
		} // end
		return cnt;
	}// delete() end

	
	
	public int delete(int pdsno, String passwd, String saveDir) {
		int cnt = 0;
		
		try {
			//테이블의 행 삭제하기 전에, 삭제하고자 하는 파일명 을 변수에 저장
			String filename = "";
			PdsDTO oldDTO = read(pdsno);
			if(oldDTO != null) {
				filename = oldDTO.getFilename();
			}//if end
		
			con=dbopen.getConnection();
			sql=new StringBuilder();
			sql.append(" DELETE FROM tb_pds ");		
			sql.append(" WHERE pdsno = ? AND passwd = ?");		
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, pdsno);
			pstmt.setString(2, passwd);
			cnt = pstmt.executeUpdate();
			if(cnt==1) {
				Utility.deleteFile(saveDir,filename);
			}//if end
			
			
			

		} catch (Exception e) {
			System.out.println("삭제 실패:" + e);
		} finally {
			DBClose.close(con, pstmt);
		} // end
		return cnt;
	}//delete() end

}// PdsDAO class end
