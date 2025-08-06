package oopInterface.sec02;

public interface IRemoteControl {
    int MAX_VOLUME = 10; // constant variable, implicitly public, static and final
    // it is not necessary to use "public static final" keywords, they are added by the compiler
    int MIN_VOLUME = 0;

    // declaration abstract methods: automatically added public and abstract by the compiler
    void turnOn();

    void turnOff();

    void setVolume(int volume);

    // declaration default method with implementation
    // it needs "default" keyword - this is not an access modifier
    default void setMute(boolean mute) {
        if (mute) {
            System.out.println("Mute is ON");
        } else {
            System.out.println("Mute is OFF");
        }
    }

    // declaration static method with implementation: method which can be called without and instance of the interface
    // use "static" keyword, and it has its own body
    // this is public by default
    static void showRemote() {
        System.out.println("Static method implemented in the interface");
    }

    static void changeBattery() {
        System.out.println("Changing battery");
    }
}
