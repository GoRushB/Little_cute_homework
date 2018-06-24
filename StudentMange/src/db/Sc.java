package db;


public class Sc {
	private int scid;
    private String sno;
    private String cno;
    private double grade;

    public int getScid() {
        return scid;
    }
    
    public void setScid(int scid) {
        this.scid = scid;
    }
    
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
