package com.mc.musiccoordinator.presentation;

import com.mc.musiccoordinator.domain.Music;
import com.mc.musiccoordinator.domain.MusicCoordinator;

import java.util.Optional;
import java.util.Scanner;

public class Menu {

    private MusicCoordinator coordinator = new MusicCoordinator();

    public void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=========================");
            System.out.println("오늘 기분을 말해줘! 어울리는 노래를 추천해줄게! (종료: exit)");
            System.out.print("입력 : ");
            String inp = sc.nextLine();

            if (inp.equals("exit")) break;

            Optional<Music> optional = coordinator.recommend(inp);

            if (optional.isEmpty()) {
                System.out.println("오늘은 추천할 노래가 없어요.");
                continue;
            }

            System.out.println("======================================");
            Music Music = optional.get();
            System.out.println("노래 제목 : " + Music.artist() + "-" + Music.name());
            System.out.println("추천 이유 : " + Music.reason());
            System.out.println("======================================");
        }


    }

}
