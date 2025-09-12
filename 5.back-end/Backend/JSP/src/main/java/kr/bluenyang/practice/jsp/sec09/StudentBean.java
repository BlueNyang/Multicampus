package kr.bluenyang.practice.jsp.sec09;

public class StudentBean {
    private String stdNo;
    private String stdName;
    private String stdPhone;
    private String stdAddr;
    private int stdYear;
    private String[] stdInterests;

    public String getStdNo() {
        return stdNo;
    }

    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getStdPhone() {
        return stdPhone;
    }

    public void setStdPhone(String stdPhone) {
        this.stdPhone = stdPhone;
    }

    public String getStdAddr() {
        return stdAddr;
    }

    public void setStdAddr(String stdAddr) {
        this.stdAddr = stdAddr;
    }

    public int getStdYear() {
        return stdYear;
    }

    public void setStdYear(int stdYear) {
        this.stdYear = stdYear;
    }

    public String[] getStdInterests() {
        return stdInterests;
    }

    public void setStdInterests(String[] stdInterests) {
        this.stdInterests = stdInterests;
    }
}
