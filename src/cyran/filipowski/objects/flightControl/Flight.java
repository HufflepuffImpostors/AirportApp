package cyran.filipowski.objects.flightControl;

import cyran.filipowski.objects.aircraft.Aircraft;
import cyran.filipowski.objects.events.Arrival;
import cyran.filipowski.objects.events.Departure;
import cyran.filipowski.people.crew.Crew;
import cyran.filipowski.people.passenger.Passenger;
import cyran.filipowski.people.technicalSupport.TechnicalSupport;

import java.io.Serializable;
import java.util.ArrayList;

public class Flight implements Serializable {
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
        this.passengers = passengers;
        this.crew = crew;
        this.aircraft = aircraft;
        this.flightId = flightId;
    }
    public String fly(){
        if(departure.permissionStatus() && arrival.permissionStatus()){
            aircraft.fly(50);
            aircraft.fuelUp(50);
            return "The flight has been successful!";
        }
        return "The flight misses some permission!";
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
