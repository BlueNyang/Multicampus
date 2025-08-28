package com.mc.algorithm_quiz.greedy;

import com.mc.algorithm_quiz.greedy.classes.Meeting;
import com.mc.algorithm_quiz.util.SortUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        Meeting[] meetings = {
                new Meeting(1, 1, 10),
                new Meeting(2, 5, 6),
                new Meeting(3, 13, 15),
                new Meeting(4, 14, 17),
                new Meeting(5, 8, 14),
                new Meeting(6, 3, 12)
        };

        SortUtil.measure("q2", () -> {
            Meeting[] result = q2_greedy2(meetings);
            System.out.println(Arrays.toString(result));
        });
    }

    private static Meeting[] q2_greedy2(Meeting[] meetings) {
        List<Meeting> list = Arrays.asList(meetings);

        list.sort(Comparator.comparing(Meeting::getEnd));

        Stack<Meeting> stack = new Stack<>();

        for (Meeting meeting : list) {
            if (stack.isEmpty()) {
                stack.push(meeting);
            } else {
                Meeting top = stack.peek();
                if (top.getEnd() <= meeting.getStart()) {
                    stack.push(meeting);
                }
            }
        }

        Meeting[] result = new Meeting[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}

