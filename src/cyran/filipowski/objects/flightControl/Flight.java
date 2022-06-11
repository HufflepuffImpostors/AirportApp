package cyran.filipowski.objects.flightControl;

import cyran.filipowski.objects.aircraft.Aircraft;
import cyran.filipowski.objects.events.Arrival;
import cyran.filipowski.objects.events.Departure;
import cyran.filipowski.people.Person;
import cyran.filipowski.people.passenger.Passenger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Flight {
    Departure departure;
    Arrival arrival;
    ArrayList<Passenger> passengers;
    ArrayList<Person> crew;
    Aircraft aircraft;
    ArrayList<String> luggage;
    String flightId;

    public Flight(Departure departure, Arrival arrival, ArrayList<Passenger> passengers, ArrayList<Person> crew, Aircraft aircraft, String flightId) {
        this.departure = departure;
        this.arrival = arrival;
        this.passengers = new ArrayList<Passenger>();
        this.crew = new ArrayList<Person>();
        this.aircraft = aircraft;
        this.flightId = flightId;
    }
    public String fly(){
        return "The flight has started!";
    }

    public String getFlightId() {        return flightId;
    }
}
