package oopClass.sec05;

public class Tv {
    String color;
    boolean power;
    int channel;

    public void power() {
        power = !power;
    }

    public void channelUp() {
        if (power) {
            channel++;
        }
    }

    public void channelDown() {
        if (power) {
            channel--;
        }
    }
}
