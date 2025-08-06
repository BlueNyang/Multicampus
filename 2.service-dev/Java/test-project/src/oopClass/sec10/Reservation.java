package oopClass.sec10;

import java.text.NumberFormat;

public class Reservation {
    private String flight;
    private String reserveName;
    private String departure;
    private String destination;
    private int price;
    private String seatNumber;

    public Reservation() {
        this("Unknown Flight", "Unknown Name", "Unknown Departure", "Unknown Destination", 0, "Unknown Seat");
    }

    public Reservation(String flight, String reserveName, String departure, String destination, int price, String seatNumber) {
        this.flight = flight;
        this.reserveName = reserveName;
        this.departure = departure;
        this.destination = destination;
        this.price = price;
        this.seatNumber = seatNumber;
    }

    public void showReservation() {
        NumberFormat nf = NumberFormat.getInstance();
        String formattedPrice = nf.format(price);
        System.out.println("**** Reservation Information ****");
        System.out.println("Flight: " + flight);
        System.out.println("Reserved by: " + reserveName);
        System.out.println("Departure: " + departure);
        System.out.println("Destination: " + destination);
        System.out.println("Price: " + formattedPrice);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println();
    }
}
