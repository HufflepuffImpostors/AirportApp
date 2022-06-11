package cyran.filipowski.objects.flightControl;

import cyran.filipowski.objects.aircraft.Aircraft;
import cyran.filipowski.objects.events.Arrival;
import cyran.filipowski.objects.events.Departure;
import cyran.filipowski.people.crew.Crew;
import cyran.filipowski.people.passenger.Passenger;

import java.util.ArrayList;

public class Flight {
    Departure departure;
    Arrival arrival;
    ArrayList<Passenger> passengers;
    ArrayList<Crew> crew;
    Aircraft aircraft;
    ArrayList<String> luggage;
    String flightId;

    public Flight(Departure departure, Arrival arrival, ArrayList<Passenger> passengers, ArrayList<Crew> crew, Aircraft aircraft, String flightId) {
        this.departure = departure;
        this.arrival = arrival;
        this.passengers = new ArrayList<Passenger>();
        this.crew = new ArrayList<Crew>();
        this.aircraft = aircraft;
        this.flightId = flightId;
    }
    public String fly(){
        return "The flight has started!";
    }

    public String getFlightId() {
        return flightId;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setLuggage(ArrayList<String> luggage) {
        this.luggage = luggage;
    }

    public Departure getDeparture() {
        return departure;
    }

    public Arrival getArrival() {
        return arrival;
    }
}
