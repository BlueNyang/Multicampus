package kr.bluenyang.practice.aop.sec02;

public class Evaluation {
    private int korean;
    private int english;
    private int math;

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void showScores() {
        System.out.println("Korean: " + korean);
        System.out.println("English: " + english);
        System.out.println("Math: " + math);
        System.out.println("Total: " + (korean + english + math));
    }
}

