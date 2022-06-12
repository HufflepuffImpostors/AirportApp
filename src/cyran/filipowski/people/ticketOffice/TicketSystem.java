package cyran.filipowski.people.ticketOffice;

import cyran.filipowski.objects.flightControl.Flight;
import cyran.filipowski.objects.flightControl.FlightControl;
import cyran.filipowski.people.passenger.Passenger;

import java.io.Serializable;
import java.util.*;

public class TicketSystem implements Serializable {

    private static TicketSystem instance;
    private FlightControl flightControl;
    //Maps stores amount of available and reserved tickets
    Map<String, Integer> availableTickets;
    Map<String, Integer> reservedTickets;
    //Map stores lists of passengers signed to every ticket
    Map<Ticket, ArrayList<Passenger>> passengersTickets;
    Map<Ticket, ArrayList<Passenger>> passengerReservedTickets;
    //List of all tickets
    ArrayList<Ticket> tickets;
    ArrayList<Passenger> passengers;


    /**
     * Singleton class
     */
    public TicketSystem() {
        availableTickets = new HashMap<>();
        reservedTickets = new HashMap<>();
        tickets = new ArrayList<>();
        passengersTickets = new HashMap<>();
        passengerReservedTickets = new HashMap<>();
        passengers = new ArrayList<>();
        flightControl = FlightControl.getInstance();
    }

    public static TicketSystem getInstance() {
        if (instance == null) {
            instance = new TicketSystem();
        }
        return instance;
    }


    public void createNewTicket(String flightId, Double price) {

        try {
            if (price <= 0) throw new IllegalArgumentException(price.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Ticket price is negative!");
            throw e;
        }

        ArrayList<Flight> flights = flightControl.getAllFlights();
        for (Flight f : flights) {
            if (f.getFlightId().equals(flightId)) {
                Ticket newTicket = new Ticket(flightId, price);
                tickets.add(newTicket);
                availableTickets.putIfAbsent(flightId, 100);
                reservedTickets.putIfAbsent(flightId, 0);
                System.out.println("New ticket added: " + newTicket);
                return;
            }
        }

        System.out.println("There is no flight with given id: " + flightId);
    }

    public Passenger createNewPassenger(String name, String surname) {
        Passenger newPassenger = new Passenger(name, surname);

        passengers.add(newPassenger);

        System.out.println("New passenger created: " + newPassenger.toString());

        return newPassenger;
    }

    public Passenger findPassenger(String name, String surname) {
        for (Passenger p : passengers) {
            if (p.getName().equals(name) && p.getSurname().equals(surname)) return p;
        }

        return null;
    }

    public boolean reserveTicket(Passenger passenger,String flightId) {

        try {
            if (!availableTickets.containsKey(flightId)) throw new FlightIdNotFoundException(flightId);
        } catch (FlightIdNotFoundException e) {
            System.out.println("There is no flight with such id");
            return false;
        }

        if (availableTickets.get(flightId) > 0) {

            availableTickets.replace(flightId, availableTickets.get(flightId) - 1);
            reservedTickets.putIfAbsent(flightId, 0);
            reservedTickets.replace(flightId, reservedTickets.get(flightId) + 1);


            Ticket ticket = getTicketByFlightId(flightId);
            passengerReservedTickets.putIfAbsent(ticket, new ArrayList<>());
            passengerReservedTickets.get(ticket).add(passenger);

            return true;
        }

        return false;
    }

    public boolean buyTicket(Passenger passenger, String flightId) {

        try {
            if (!availableTickets.containsKey(flightId)) throw new FlightIdNotFoundException(flightId);
        } catch (FlightIdNotFoundException e) {
            System.out.println("There is no flight with such id");
            return false;
        }

        if (availableTickets.get(flightId) > 0) {

            availableTickets.replace(flightId, availableTickets.get(flightId) - 1);
            availableTickets.putIfAbsent(flightId, 0);
            availableTickets.replace(flightId, reservedTickets.get(flightId) + 1);

            Ticket ticket = getTicketByFlightId(flightId);
            passengersTickets.putIfAbsent(ticket, new ArrayList<>());
            passengersTickets.get(ticket).add(passenger);

            return true;
        }

        return false;
    }

    public boolean cancelTicketReservation(Passenger passenger, String flightId) {

        try {
            if (!reservedTickets.containsKey(flightId)) throw new FlightIdNotFoundException(flightId);
        } catch (FlightIdNotFoundException e) {
            System.out.println("There is no flight with such id");
            return false;
        }

        Ticket ticket = getTicketByFlightId(flightId);
        if (!passengerReservedTickets.containsKey(ticket)) {
            return false;
        }

        passengerReservedTickets.get(ticket).remove(passenger);
        reservedTickets.replace(flightId, reservedTickets.get(flightId) - 1);
        availableTickets.replace(flightId, reservedTickets.get(flightId) + 1);

        return true;
    }

    public boolean cancelTicket(Passenger passenger, String flightId) {
        Ticket ticket = getTicketByFlightId(flightId);
        if (!passengersTickets.containsKey(ticket)) {
            return false;
        }

        passengersTickets.get(ticket).remove(passenger);
        availableTickets.replace(flightId, availableTickets.get(flightId) + 1);

        return true;
    }

    public boolean changeTicketReservation(Passenger passenger, String oldFlightId, String newFlightId) {

        return cancelTicket(passenger, oldFlightId) &&
        reserveTicket(passenger, newFlightId);
    }

    public Ticket getTicketByFlightId(String flightId) {
        for (Ticket t : tickets) {
            if (t.getFlightId().equals(flightId)) return t;
        }
        return null;
    }

    public ArrayList<Passenger> getFlightPassengers(String flightId) {

        ArrayList<Passenger> flightPassengers = new ArrayList<>();

        try {
            if (!availableTickets.containsKey(flightId)) throw new FlightIdNotFoundException(flightId);
        } catch (FlightIdNotFoundException e) {
            System.out.println("There is no flight with such id");
            return flightPassengers;
        }

        Ticket ticket = getTicketByFlightId(flightId);
        flightPassengers = passengersTickets.get(ticket);

        return flightPassengers;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public ArrayList<String> getFlights() {
        ArrayList<String> flights = new ArrayList<>();

        for (Ticket t : tickets) {
            flights.add(t.getFlightId());
        }

        return flights;
    }

    public ArrayList<String> getFlightIds() {
        ArrayList<String> flightIds = new ArrayList<>();

        for (Flight f : flightControl.getAllFlights()) {
            flightIds.add(f.getFlightId());
        }

        return flightIds;
    }

    public void addPassengers (ArrayList<Passenger> passengers) {
        this.passengers.addAll(passengers);
    }

    public void setPassengers (ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return "TicketSystem{" +
                "availableTickets=" + availableTickets +
                ", reservedTickets=" + reservedTickets +
                ", passengersTickets=" + passengersTickets +
                ", passengerReservedTickets=" + passengerReservedTickets +
                ", tickets=" + tickets +
                '}';
    }
}