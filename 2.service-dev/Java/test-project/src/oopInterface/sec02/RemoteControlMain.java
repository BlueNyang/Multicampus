package oopInterface.sec02;

public class RemoteControlMain {
    public static void main(String[] ignoredArgs) {
        IRemoteControl rc;

        rc = new Television();
        rc.turnOn();
        rc.turnOff();
        rc.setVolume(5);
        rc.setMute(true);
        rc.setMute(false);

        System.out.println("---------------------");

        rc = new Audio();
        rc.turnOn();
        rc.turnOff();
        rc.setVolume(50);
        rc.setMute(true);
        rc.setMute(false);

        IRemoteControl.changeBattery(); // calling static method from the interface
    }
}
