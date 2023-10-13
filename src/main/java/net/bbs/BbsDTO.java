package net.bbs;

public class BbsDTO {
	  private int bbsno;    
	  private String wname;  
	  private String subject; 
	  private String content;
	  private String passwd;
	  private int readcnt; 
	  private String regdt; 
	  private int intgrpno;   
	  private int indent;  
	  private int ansnum; 
	  private String ip; 
	  
	  
	  //생성자 함수 constructor
	  public BbsDTO() {}
	  

	/**
	 * @return the bbsno
	 */
	public int getBbsno() {
		return bbsno;
	}


	/**
	 * @param bbsno the bbsno to set
	 */
	public void setBbsno(int bbsno) {
		this.bbsno = bbsno;
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
	 * @return the readcnt
	 */
	public int getReadcnt() {
		return readcnt;
	}


	/**
	 * @param readcnt the readcnt to set
	 */
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
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
	 * @return the intgrpno
	 */
	public int getIntgrpno() {
		return intgrpno;
	}


	/**
	 * @param intgrpno the intgrpno to set
	 */
	public void setIntgrpno(int intgrpno) {
		this.intgrpno = intgrpno;
	}


	/**
	 * @return the indent
	 */
	public int getIndent() {
		return indent;
	}


	/**
	 * @param indent the indent to set
	 */
	public void setIndent(int indent) {
		this.indent = indent;
	}


	/**
	 * @return the ansnum
	 */
	public int getAnsnum() {
		return ansnum;
	}


	/**
	 * @param ansnum the ansnum to set
	 */
	public void setAnsnum(int ansnum) {
		this.ansnum = ansnum;
	}


	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}


	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}


	@Override
	public String toString() {
		return "BbsDTO [bbsno=" + bbsno + ", wname=" + wname + ", subject=" + subject + ", content=" + content
				+ ", passwd=" + passwd + ", readcnt=" + readcnt + ", regdt=" + regdt + ", intgrpno=" + intgrpno
				+ ", indent=" + indent + ", ansnum=" + ansnum + ", ip=" + ip + "]";
	}
	  
	
	  
	
}// class end