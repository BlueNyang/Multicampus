package oopInterface.sec03;

public interface IRemoteControl {
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;

    void turnOn();

    void turnOff();

    void setVolume(int volume);

    default void setMute(boolean mute) {
        if (mute) {
            System.out.println("Mute is ON");
        } else {
            System.out.println("Mute is OFF");
        }
    }

    static void showRemote() {
        System.out.println("static 메소드가 인터페이스에서 구현");
    }

    static void changeBattery() {
        System.out.println("배터리를 교체합니다.");
    }
}

