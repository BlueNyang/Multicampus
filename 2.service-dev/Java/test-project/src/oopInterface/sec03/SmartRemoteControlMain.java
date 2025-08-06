package oopInterface.sec03;

public class SmartRemoteControlMain {
    public static void main(String[] ignoredArgs) {
        SmartTelevision stv = new SmartTelevision();

        stv.turnOn();
        stv.setVolume(4);
        stv.search("www.naver.com");

        IRemoteControl rc = new SmartTelevision();
        rc.turnOn();
        ISearchable se = new SmartTelevision();
        se.search("www.naver.com");
    }
}
