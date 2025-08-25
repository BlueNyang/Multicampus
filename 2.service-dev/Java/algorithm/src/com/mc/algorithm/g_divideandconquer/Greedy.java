package com.mc.algorithm.g_divideandconquer;

import com.mc.algorithm.util.SortUtil;

import java.util.*;

public class Greedy {
    public static void main(String[] args) {
        int n = 3465;
        int[] coins = {50, 10, 100, 1, 500};

        Meeting[] meetings = {
                new Meeting(1, 1, 10),
                new Meeting(2, 5, 6),
                new Meeting(3, 13, 15),
                new Meeting(4, 14, 17),
                new Meeting(5, 8, 14),
                new Meeting(6, 3, 12)
        };

        SortUtil.measure("q1", () -> {
//            q2_greedy(n, coins);
            Meeting[] result = q2_greedy2(meetings);
            System.out.println(Arrays.toString(result));
        });
    }

    private static void q2_greedy(int n, int[] coins) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        List<Integer> list = new ArrayList<>();

        for (int coin : coins) {
            list.add(coin);
        }

        list.sort(Collections.reverseOrder());

        for (int coin : list) {
            map.put(coin, 0);
            while (n >= coin) {
                n -= coin;
                map.put(coin, map.get(coin) + 1);
            }
        }

        System.out.print("count: ");
        for (int coin : list) {
            System.out.print(coin + " : " + map.get(coin) + ", ");
        }
        System.out.println();
    }

    private static Meeting[] q2_greedy2(Meeting[] meetings) {
        List<Meeting> list = Arrays.asList(meetings);

        list.sort(Comparator.comparing(m -> m.end));

        Stack<Meeting> stack = new Stack<>();

        for (Meeting meeting : list) {
            if (stack.isEmpty()) {
                stack.push(meeting);
            } else {
                Meeting top = stack.peek();
                if (top.end <= meeting.start) {
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

class Meeting {
    int idx;
    int start;
    int end;

    public Meeting(int idx, int start, int end) {
        this.idx = idx;
        this.start = start;
        this.end = end;
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
