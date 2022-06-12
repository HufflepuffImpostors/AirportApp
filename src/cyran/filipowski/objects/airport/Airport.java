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
    public Hangar getHangar(int number){
        try{
            if(number >= hangars.size() || number < 0) throw new IllegalArgumentException("There isn't a hangar with this number!");
            return hangars.get(number);
        }
        catch(IllegalArgumentException e){
            return null;
        }
    }
    public String getAirstrip(int number){
        try{
            if(number >= airstrips.size() || number < 0) throw new IllegalArgumentException("There isn't an airstrip with this number!");
            return airstrips.get(number);
        }
        catch(IllegalArgumentException e){
            return null;
        }
    }
}
