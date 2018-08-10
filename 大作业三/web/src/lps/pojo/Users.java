package lps.pojo;

import java.io.Serializable;

public class Users implements Serializable {
	/**
	 * 用户编号
	 */
	private int uid;
	/**
	 * 用户名称
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