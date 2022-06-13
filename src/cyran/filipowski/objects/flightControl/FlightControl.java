package cyran.filipowski.objects.flightControl;

import cyran.filipowski.objects.aircraft.Aircraft;
import cyran.filipowski.objects.events.Arrival;
import cyran.filipowski.objects.events.Departure;
import cyran.filipowski.people.crew.Crew;
import cyran.filipowski.people.passenger.Passenger;
import cyran.filipowski.people.ticketOffice.TicketSystem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class FlightControl implements Serializable {
    ArrayList<Flight> flights;
    boolean suspensionStatus;
    private static FlightControl instance;

    /**
     * Singleton class
     */

    private FlightControl() {
        flights = new ArrayList<>();
        suspensionStatus = false;
    }

    public static FlightControl getInstance() {
        if (instance == null) {
            instance = new FlightControl();
        }
        return instance;
    }

    public String setDepartureAllowance(String flightId,boolean decision){
        for(Flight f : flights){
            if(f.getFlightId().equals(flightId)){
                f.getDeparture().askForPermission(decision);
                return "Flight control changed the departure";
            }
        }
        return "No such flight!";
    };
    public String setArrivalAllowance(String flightId, boolean decision){
        for(Flight f : flights){
            if(f.getFlightId().equals(flightId)){
                f.getArrival().askForPermission(decision);
                return "Flight control changed the arrival";
            }
        }
        return "No such flight!";
    }
    public Flight getFlight(String flightId){
        for(Flight f: flights){
            if(f.getFlightId().equals(flightId)) return f;
        }
        return null;
    }

    public ArrayList<Flight> getAllFlights() {
        return flights;
    }

    public void setAllFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }

    public Flight createFlight(LocalDate departureDate, LocalDate arrivalDate, String depAirstrip, String arrAirstrip,
                               Aircraft aircraft, ArrayList<Passenger> passengers, ArrayList<Crew> crew, String flightId){
        try{
            if(arrivalDate.isBefore(departureDate)) throw new IllegalArgumentException("The dates are wrong!");
            if(getFlight(flightId)!=null) throw new IllegalArgumentException("There is a flight with that id!");
            Departure dep = new Departure(departureDate, 0, depAirstrip);
            Arrival arr = new Arrival(arrivalDate,0,arrAirstrip);
            Flight newFlight = new Flight(dep, arr,passengers,crew,aircraft,flightId);
            flights.add(newFlight);
            return newFlight;
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public String removeFlight(String flightId){
        for(Flight f: flights){
            if(f.getFlightId().equals(flightId)) {
                flights.remove(f);
                return "Flight has been removed!";
            }
        }
        return "No flight has been removed!";
    }
}
