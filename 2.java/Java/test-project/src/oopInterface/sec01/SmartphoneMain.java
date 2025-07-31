package oopInterface.sec01;

public class SmartphoneMain {
    public static void main(String[] ignoredArgs) {
        SamsungPhone sp = new SamsungPhone();
        sp.sendCall();

        ISmartPhone isp = new SamsungPhone();
        isp.sendCall();

        ISmartPhone iip = new IPhone();
        iip.sendCall();
    }
}
