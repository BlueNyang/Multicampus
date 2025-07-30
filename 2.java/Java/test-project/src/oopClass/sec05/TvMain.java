package oopClass.sec05;

public class TvMain {
    public static void main(String[] ignoredArgs) {
        Tv[] tvArr = new Tv[3];

        for (int i = 0; i < tvArr.length; i++) {
            tvArr[i] = new Tv();
            tvArr[i].color = "Black";
            tvArr[i].power = false;
            tvArr[i].channel = 10 + i;
        }

        for (Tv tv : tvArr) {
            System.out.println("TV Color: " + tv.color);
            System.out.println("TV Power: " + (tv.power ? "On" : "Off"));
            System.out.println("TV Channel: " + tv.channel);
            System.out.println();
        }
    }
}
