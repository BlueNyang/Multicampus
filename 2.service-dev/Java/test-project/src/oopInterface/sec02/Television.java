package oopInterface.sec02;

public class Television implements IRemoteControl {
    private int volume;
    private boolean mute;

    @Override
    public void turnOn() {
        System.out.println("Television is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Television is turned OFF");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.min(Math.max(volume, IRemoteControl.MIN_VOLUME), IRemoteControl.MAX_VOLUME);
        System.out.println("Television volume set to: " + this.volume);
    }
}
