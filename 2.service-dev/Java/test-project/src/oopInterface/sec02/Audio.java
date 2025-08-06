package oopInterface.sec02;

public class Audio implements IRemoteControl {
    private int volume;
    private boolean mute;

    @Override
    public void turnOn() {
        System.out.println("Audio is turned ON");
    }

    @Override
    public void turnOff() {
        System.out.println("Audio is turned OFF");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.min(Math.max(volume, IRemoteControl.MIN_VOLUME), IRemoteControl.MAX_VOLUME);
        System.out.println("Audio volume set to: " + this.volume);
    }
}
