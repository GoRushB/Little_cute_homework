package lps.pojo;

import java.io.Serializable;

public class Answers implements Serializable {
	/** * 成绩编号 */
	private int aid;
	/** * 用户编号 */
	private int uid;
	/** * 用户作答该题的选项 */
	private int ans;
	/** * 题目编号 */
	private int qid;
	/** * 答题时间 */
	private String adate;
	/** * 得分 */
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