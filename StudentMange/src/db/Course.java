package db;


public class Course {
    private String cno;
    private String cname;
    private double cprior;

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getCprior() {
        return cprior;
    }

    public void setCprior(double cprior) {
        this.cprior = cprior;
    }
}