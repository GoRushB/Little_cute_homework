package lps.logic;

import java.io.Serializable;

/**
 * 该类用于存放结果成绩表里的数据
 */
public class ChengJi implements Serializable, Comparable<ChengJi> {
	private int cjid; // 成绩编号
	private int uid; // 用户编号
	private String uname; // 用户名
	private double grade; // 用户的成绩

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