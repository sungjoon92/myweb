package net.notice;

public class NoticeDTO {

	private int noticeno; 	// number not null -- 일련번호
	private String wname;
	private String subject; // varchar2(255) not null -- 제목
	private String content; // varchar2(4000) not null -- 내용
	private String regdt; 	// date default sysdate -- 작성일
	private String passwd;
	private int readcnt;
	
	
	
	public int getNoticeno() {
		return noticeno;
	}



	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
	}



	public String getWname() {
		return wname;
	}



	public void setWname(String wname) {
		this.wname = wname;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getRegdt() {
		return regdt;
	}



	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}



	public String getPasswd() {
		return passwd;
	}



	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}



	public int getReadcnt() {
		return readcnt;
	}



	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}



	@Override
	public String toString() {
		return "NoticeDTO [noticeno=" + noticeno + ", wname=" + wname + ", subject=" + subject + ", content=" + content
				+ ", regdt=" + regdt + ", passwd=" + passwd + ", readcnt=" + readcnt + "]";
	}



	
	
	
	
	
}// NoticeDTO class end
