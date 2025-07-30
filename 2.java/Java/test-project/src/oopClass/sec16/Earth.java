package oopClass.sec16;

public class Earth {
    final static double EARTH_RADIUS = 6.371e6; // in meters
    final static double EARTH_SURFACE_AREA; // in square meters

    static {
        EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
    }

    public static void main(String[] ignoredArgs) {
        System.out.println("Earth radius: " + Earth.EARTH_RADIUS);
        System.out.println("Earth surface area: " + Earth.EARTH_SURFACE_AREA);
    }
}
