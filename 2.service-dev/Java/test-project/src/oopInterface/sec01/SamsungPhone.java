package oopInterface.sec01;

public class SamsungPhone implements ISmartPhone {
    String name;

    public SamsungPhone() {
        this.name = "Samsung Phone";
    }

    @Override
    public void sendCall() {
        System.out.println(name + " is making a call.");
    }

    @Override
    public void receiveCall() {
        System.out.println(name + " is receiving a call.");
    }

    @Override
    public void sendSMS() {
        System.out.println(name + " is sending an SMS.");
    }

    @Override
    public void receiveSMS() {
        System.out.println(name + " is receiving an SMS.");
    }
}
