package lps.pojo;

import java.io.Serializable;

public class Answers implements Serializable {
	/** * �ɼ���� */
	private int aid;
	/** * �û���� */
	private int uid;
	/** * �û���������ѡ�� */
	private int ans;
	/** * ��Ŀ��� */
	private int qid;
	/** * ����ʱ�� */
	private String adate;
	/** * �÷� */
	private double grade;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getAns() {
		return ans;
	}

	public void setAns(int ans) {
		this.ans = ans;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
}