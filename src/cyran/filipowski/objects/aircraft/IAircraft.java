package cyran.filipowski.objects.aircraft;

import cyran.filipowski.people.passenger.Passenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public interface IAircraft {
    ArrayList<String> planeTypes = new ArrayList<String>(Arrays.asList("airliner","transporter", "military","boeing","concorde", "airbus", "cesna"));

    String fuelUp(int amount);
    String fly(int length);
    String load(ArrayList<String> luggage);
    ArrayList<String> unload();
    String board(ArrayList<Passenger> passengers);
}
