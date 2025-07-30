package oopClass.sec03;

class Tv {
    String color;
    boolean power;
    int channel;

    void power() {
        power = !power;
    }

    void channelUp() {
        if (power) {
            channel++;
        }
    }

    void channelDown() {
        if (power) {
            channel--;
        }
    }
}

public class TvMain {
    public static void main(String[] args) {
        Tv t;
        t = new Tv();

        t.color = "black";
        System.out.println("TV Color: " + t.color);

        System.out.println("TV Power: " + t.power);
        t.power();
        System.out.println("TV Power after toggle: " + t.power);

        t.channel = 7;
        System.out.println("Current Channel: " + t.channel);

        t.channelDown();
        System.out.println("Channel after channelDown: " + t.channel);


    }
}
