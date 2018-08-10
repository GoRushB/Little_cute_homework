package lps.pojo;

import java.io.Serializable;

public class Questions implements Serializable {
	/** * 问题编号 */
	private int qid;
	/** * 问题描述 */
	private String qdesp;
	/** * 备选项1 */
	private String qans1;
	/** * 备选项2 */
	private String qans2;
	/** * 备选项3 */
	private String qans3;
	/** * 备选项4 */
	private String qans4;
	/** * 分值 */
	private int points;
	/** * 正确选项编号 */
	private int right_ans;

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQdesp() {
		return qdesp;
	}

	public void setQdesp(String qdesp) {
		this.qdesp = qdesp;
	}

	public String getQans1() {
		return qans1;
	}

	public void setQans1(String qans1) {
		this.qans1 = qans1;
	}

	public String getQans2() {
		return qans2;
	}

	public void setQans2(String qans2) {
		this.qans2 = qans2;
	}

	public String getQans3() {
		return qans3;
	}

	public void setQans3(String qans3) {
		this.qans3 = qans3;
	}

	public String getQans4() {
		return qans4;
	}

	public void setQans4(String qans4) {
		this.qans4 = qans4;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getRight_ans() {
		return right_ans;
	}

	public void setRight_ans(int right_ans) {
		this.right_ans = right_ans;
	}
}