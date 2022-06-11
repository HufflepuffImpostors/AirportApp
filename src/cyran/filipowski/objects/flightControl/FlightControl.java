package cyran.filipowski.objects.flightControl;

import java.util.ArrayList;

public class FlightControl {
    ArrayList<Flight> flights;
    boolean suspensionStatus;

    public FlightControl() {
        flights = new ArrayList<Flight>();
        suspensionStatus = false;
    }
    public String allowDeparture(String flightId){
        for(Flight f : flights){
            if(f.getFlightId().equals(flightId)){
                System.out.println("allow departure"); // TO-DO
                return "Flight controlled approved the departure";
            }
        }
        return "No such flight!";
    };
    public String allowArrival(String flightId){
        for(Flight f : flights){
            if(f.getFlightId().equals(flightId)){
                System.out.println("allow departure"); // TO-DO
                return "Flight controlled approved the arrival";
            }
        }
        return "No such flight!";
    };
    public String setSuspensionStatus(boolean status){
        suspensionStatus = status;
        return "The suspension status has been set to " + (status?"open":"closed");
    };
    public String checkWeather(){
        return "The weather is good, go on!"; //TO-DO
    };
}
