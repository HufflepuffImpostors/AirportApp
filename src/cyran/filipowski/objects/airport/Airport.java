package cyran.filipowski.objects.airport;

import java.util.ArrayList;
import java.util.Map;

public class Airport {
    ArrayList<String> terminals;
    ArrayList<String> airstrips;
    ArrayList<String> lounges;
    Map<String, Integer> carparks;
    ArrayList<Hangar> hangars;

    public Airport(ArrayList<String> terminals, ArrayList<String> airstrips, ArrayList<String> lounges, Map<String, Integer> carparks, ArrayList<Hangar> hangars) {
        this.terminals = terminals;
        this.airstrips = airstrips;
        this.lounges = lounges;
        this.carparks = carparks;
        this.hangars = hangars;
    }
}
