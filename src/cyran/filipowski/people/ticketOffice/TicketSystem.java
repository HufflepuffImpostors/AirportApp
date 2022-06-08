package cyran.filipowski.people.ticketOffice;

import cyran.filipowski.people.passenger.Passenger;

import java.util.*;

public class TicketSystem {

    private static TicketSystem instance;
    //Maps stores amount of available and reserved tickets
    Map<String, Integer> availableTickets;
    Map<String, Integer> reservedTickets;
    //Map stores lists of passengers signed to every ticket
    Map<Ticket, ArrayList<Passenger>> passengersTickets;
    Map<Ticket, ArrayList<Passenger>> passengerReservedTickets;
    //List of all tickets
    ArrayList<Ticket> tickets;


    /**
     * Singleton class
     */
    private TicketSystem() {
        availableTickets = new HashMap<>();
        reservedTickets = new HashMap<>();
        tickets = new ArrayList<>();
        passengersTickets = new HashMap<>();
        passengerReservedTickets = new HashMap<>();
    }

    public TicketSystem getInstance() {
        if (instance == null) {
            instance = new TicketSystem();
        }
        return instance;
    }


    public boolean createNewTicket(String flightId, Double price) {
        if (price > 0) {
            Ticket newTicket = new Ticket(flightId, price);
            tickets.add(newTicket);

            return true;
        }

        return false;
    }

    public boolean reserveTicket(Passenger passenger,String flightId) {
        if (availableTickets.containsKey(flightId) && availableTickets.get(flightId) > 0) {

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
        if (availableTickets.containsKey(flightId) && availableTickets.get(flightId) > 0) {

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
        if (!reservedTickets.containsKey(flightId)) {
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
}