package lps.pojo;

import java.io.Serializable;

public class Users implements Serializable {
	/**
	 * �û����
	 */
	private int uid;
	/**
	 * �û�����
	 */
	private String uname;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
}