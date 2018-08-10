package lps.logic;

import java.io.Serializable;

/**
 * �������ڴ�Ž���ɼ����������
 */
public class ChengJi implements Serializable, Comparable<ChengJi> {
	private int cjid; // �ɼ����
	private int uid; // �û����
	private String uname; // �û���
	private double grade; // �û��ĳɼ�

	public ChengJi() {
	}

	public ChengJi(int uid, String uname, double grade) {
		this.cjid = 0;
		this.uid = uid;
		this.uname = uname;
		this.grade = grade;
	}

	public int getCjid() {
		return cjid;
	}

	public void setCjid(int cjid) {
		this.cjid = cjid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public int compareTo(ChengJi o) {
		if (this.grade < o.getGrade())
			return -1;
		else if (this.grade > o.getGrade())
			return 1;
		else
			return 0;
	}
}