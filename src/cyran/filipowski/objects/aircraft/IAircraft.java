package cyran.filipowski.objects.aircraft;

import cyran.filipowski.people.passenger.Passenger;

import java.util.ArrayList;
import java.util.Arrays;

public interface IAircraft {
    ArrayList<String> planeTypes = new ArrayList<String>(Arrays.asList("airliner","transporter", "military","boeing","concorde", "airbus", "cesna"));
    ArrayList<String> helicopterTypes = new ArrayList<String>(Arrays.asList("civilian, military"));
    double fuelEfficiency = 40; // per 100km

    String fuelUp(int amount);
    String fly(int length);
    String load(ArrayList<String> luggage);
    ArrayList<String> unload();
    String board(ArrayList<Passenger> passengers);
}
