package cyran.filipowski.people.ticketOffice;

import cyran.filipowski.people.passenger.Passenger;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Ticket implements Serializable {
    String flightId;
    Double price;
    LocalDateTime takeOffTime;
    LocalDateTime landingTime;


    public Ticket(String flightId, Double price) {
        this.flightId = flightId;
        this.price = price;

        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now().plusDays(7);
        takeOffTime = RandomDateGenerator.generateRandomDate(start, end);

        start = takeOffTime;
        end = takeOffTime.plusHours((long) (price%10));
        landingTime = RandomDateGenerator.generateRandomDate(start, end);
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getTakeOffTime() {
        return takeOffTime;
    }

    public void setTakeOffTime(LocalDateTime takeOffTime) {
        this.takeOffTime = takeOffTime;
    }

    public LocalDateTime getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(LocalDateTime landingTime) {
        this.landingTime = landingTime;
    }

    @Override
    public String toString() {
        return
                "\nflightId='" + flightId + '\'' +
                "\n price=" + price +
                "\n takeOffTime=" + takeOffTime +
                "\n landingTime=" + landingTime;
    }
}