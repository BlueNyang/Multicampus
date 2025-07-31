package oopInterface.sec03;

public class SmartTelevision implements IRemoteControl, ISearchable {
    private int volume;

    @Override
    public void search(String url) {
        System.out.println("Searching for: " + url);
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on the Smart Television");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the Smart Television");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.min(Math.max(volume, IRemoteControl.MIN_VOLUME), IRemoteControl.MAX_VOLUME);
        System.out.println("Setting volume to: " + this.volume);
    }
}
