package oopClass.sec17;

public class Car {
    private int speed;
    private boolean stop;

    public void setSpeed(int speed) {
        this.speed = Math.max(speed, 0);
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        if (stop) this.speed = 0;
    }

    public static void main(String[] ignoredArgs) {
        Car myCar = new Car();

        myCar.setSpeed(-50);
        System.out.printf("Speed: %d km/h%n", myCar.getSpeed());

        myCar.setSpeed(60);
        System.out.printf("Speed: %d km/h%n", myCar.getSpeed());

        myCar.setStop(true);
        System.out.printf("Is the car stopped? %b%n", myCar.isStop());
        System.out.printf("Speed after stopping: %d km/h%n", myCar.getSpeed());
    }
}
