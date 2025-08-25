package com.mc.a_encapsulation.method;

public class Player {
    private String instrument;

    public Player(String instrument) {
        super();
        this.instrument = instrument;
    }

    public void play() {
        prepare();
        System.out.println(instrument + " 연주");
        stop();
        leave();
    }

    private void prepare() {
        System.out.println(instrument + " 준비");
    }

    private void stop() {
        System.out.println(instrument + " 연주 종료");
    }

    private void leave() {
        System.out.println(instrument + " 퇴장");
    }
}
