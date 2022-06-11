package cyran.filipowski.people.technicalSupport;

import cyran.filipowski.objects.flightControl.Flight;
import cyran.filipowski.objects.flightControl.FlightControl;
import cyran.filipowski.people.passenger.Passenger;
import cyran.filipowski.people.ticketOffice.Ticket;
import cyran.filipowski.people.ticketOffice.TicketSystem;

import java.util.ArrayList;

public class TechnicalSupport {

    TicketSystem ticketSystem;

    public TechnicalSupport() {
        ticketSystem = TicketSystem.getInstance();
    }

    public void repairAircraft() {}

    public void loadAircraft(String flightId) {
        ArrayList<String> luggage = new ArrayList<>();
        ArrayList<Passenger> passengers = ticketSystem.getFlightPassengers(flightId);

        for (Passenger p : passengers) {
            luggage.add(p.getLuggage());
        }

        //Flight flight = FlightControl.getFlightById();
        //flight.loadLuggage(luggage);
    }

    public void unloadAircraft(String flightId) {
        Ticket ticket = ticketSystem.getTicketByFlightId(flightId);

        if (ticket != null) {
            //Flight flight = FlightControl.getFlightById();
            //flight.loadLuggage(new ArrayList<>());
        } else {
            System.out.println("There is no flight with such id");
        }
    }

    public void positionAircraft() {}

    public void boardPassengers(String flightId) {
        ArrayList<Passenger> passengers = ticketSystem.getFlightPassengers(flightId);
        //Flight flight = FlightControl.getFlightById();
        //flight.boardPassengers(passengers);
    }

    public void unboardPassengers(String flightId) {
        Ticket ticket = ticketSystem.getTicketByFlightId(flightId);

        if (ticket != null) {
            //Flight flight = FlightControl.getFlightById();
            //flight.boardPassengers(new ArrayList<>());
        } else {
            System.out.println("There is no flight with such id");
        }

    }
}
