package com.mc.studyhelper.presentation;

import com.mc.studyhelper.domain.StudyHelper;
import com.mc.studyhelper.domain.StudyPlan;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public void menu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("공부하고 싶은 프로그래밍언어를 입력하세요 : ");
        String inp = sc.nextLine();

        // 난이도, 소요시간, 선행 프로그래밍언어, 프로젝트
        StudyHelper helper = new StudyHelper();
        List<StudyPlan> plans = helper.execute(inp);

        plans.forEach(plan -> {
            System.out.println("=====추천 학습 플랜=====");
            System.out.println("난이도 : " + plan.difficulty());
            System.out.println("소요시간 : " + plan.period());
            System.out.println("선행 프로그래밍언어 : " + plan.firststepLanguage());
            System.out.println("추천 프로젝트 : " + plan.recommandedProject());
            System.out.println("=====================");
        });
        sc.close();
    }
}
