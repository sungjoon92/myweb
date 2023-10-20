package net.notice;

public class NoticeDTO {

	private int noticeno; 	// number not null -- 일련번호
	private String subject; // varchar2(255) not null -- 제목
	private String content; // varchar2(4000) not null -- 내용
	private String regdt; 	// date default sysdate -- 작성일
	private String passwd;
	private String wname;
	/**
	 * @return the noticeno
	 */
	public int getNoticeno() {
		return noticeno;
	}
	/**
	 * @param noticeno the noticeno to set
	 */
	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the regdt
	 */
	public String getRegdt() {
		return regdt;
	}
	/**
	 * @param regdt the regdt to set
	 */
	public void setRegdt(String regdt) {
		this.regdt = regdt;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/**
	 * @return the wname
	 */
	public String getWname() {
		return wname;
	}
	/**
	 * @param wname the wname to set
	 */
	public void setWname(String wname) {
		this.wname = wname;
	}
	@Override
	public String toString() {
		return "NoticeDTO [noticeno=" + noticeno + ", subject=" + subject + ", content=" + content + ", regdt=" + regdt
				+ ", passwd=" + passwd + ", wname=" + wname + "]";
	}
	
	
	
	
}// NoticeDTO class end
