package cyran.filipowski.people.passenger;

import cyran.filipowski.people.Person;
import cyran.filipowski.people.ticketOffice.Ticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Passenger extends Person implements Serializable {
    Set<String> passengerFlights;

    String luggage;

    public Passenger(String name, String surname) {
        super(name, surname);
        passengerFlights = new HashSet<>();
        luggage = name + "'s luggage";
    }

    public Passenger(String name, String surname, Set<String> passengerTickets) {
        super(name, surname);
        this.passengerFlights = passengerTickets;
        luggage = name + "'s luggage";
    }

    public Set<String> getPassengerFlights() {
        return passengerFlights;
    }

    public void setPassengerFlights(Set<String> passengerFlights) {
        this.passengerFlights = passengerFlights;
    }

    public void buyTicket(String flightId) {
        passengerFlights.add(flightId);
    }

    public void changeReservation(String prevFlightId, String newFlightId) {
        if (passengerFlights.contains(newFlightId)) {
            passengerFlights.remove(prevFlightId);
            passengerFlights.add(newFlightId);
        }
    }

    public String getLuggage(){
        return luggage;
    }

    @Override
    public String toString() {
        return  getName() + " " +
                getSurname();
    }
}
