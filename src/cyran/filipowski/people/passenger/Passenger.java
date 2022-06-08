package cyran.filipowski.people.passenger;

import cyran.filipowski.people.Person;
import cyran.filipowski.people.ticketOffice.Ticket;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Passenger extends Person {
    //ArrayList<String> passengerFlights;
    Set<String> passengerFlights;

    public Passenger(String name, String surname) {
        super(name, surname);
        passengerFlights = new HashSet<>();
    }

    public Passenger(String name, String surname, Set<String> passengerTickets) {
        super(name, surname);
        this.passengerFlights = passengerTickets;
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

    public void reserveTicket(String flightId) {

    }

    public void changeReservation(String prevFlightId, String newFlightId) {
        if (passengerFlights.contains(newFlightId)) {
            passengerFlights.remove(prevFlightId);
            passengerFlights.add(newFlightId);
        }
    }

    public void refundTicket(String flightId) {

    }

    public void orderFood() {

    }

    public void leaveLuggage(){}

    public void getLuggage(){}
}
