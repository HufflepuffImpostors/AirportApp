package cyran.filipowski.people.technicalSupport;

import cyran.filipowski.objects.flightControl.Flight;
import cyran.filipowski.objects.flightControl.FlightControl;
import cyran.filipowski.people.passenger.Passenger;
import cyran.filipowski.people.ticketOffice.Ticket;
import cyran.filipowski.people.ticketOffice.TicketSystem;

import java.util.ArrayList;

public class TechnicalSupport {

    TicketSystem ticketSystem;
    FlightControl flightControl;

    public TechnicalSupport() {
        ticketSystem = TicketSystem.getInstance();
        flightControl = FlightControl.getInstance();
    }

    public void repairAircraft() {}

    public void loadAircraft(String flightId) {
        ArrayList<String> luggage = new ArrayList<>();
        ArrayList<Passenger> passengers = ticketSystem.getFlightPassengers(flightId);

        for (Passenger p : passengers) {
            luggage.add(p.getLuggage());
        }

        flightControl.getFlight(flightId).setLuggage(luggage);
    }

    public void unloadAircraft(String flightId) {
        Ticket ticket = ticketSystem.getTicketByFlightId(flightId);

        if (ticket != null) {
            flightControl.getFlight(flightId).setLuggage(new ArrayList<>());
        } else {
            System.out.println("There is no flight with such id");
        }
    }

    public void positionAircraft() {}

    public void boardPassengers(String flightId) {
        ArrayList<Passenger> passengers = ticketSystem.getFlightPassengers(flightId);

        flightControl.getFlight(flightId).setPassengers(passengers);
    }

    public void unboardPassengers(String flightId) {
        Ticket ticket = ticketSystem.getTicketByFlightId(flightId);

        if (ticket != null) {
            flightControl.getFlight(flightId).setPassengers(new ArrayList<>());
        } else {
            System.out.println("There is no flight with such id");
        }

    }
}
