package com.mc.algorithm_quiz.greedy.classes;

public class Meeting {
    int idx;
    int start;
    int end;

    public Meeting(int idx, int start, int end) {
        this.idx = idx;
        this.start = start;
        this.end = end;
    }

    public int getIdx() {
        return idx;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "idx=" + idx +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
