package cyran.filipowski.objects.airport;

import cyran.filipowski.objects.aircraft.Aircraft;
import cyran.filipowski.objects.aircraft.Helicopter;
import cyran.filipowski.objects.aircraft.IAircraft;
import cyran.filipowski.objects.aircraft.Plane;

import java.util.ArrayList;
import java.util.Arrays;

public class Hangar {
    ArrayList<Aircraft> availableAircraft;
    int capacity = 10;

    public Hangar() {
        this.availableAircraft = new ArrayList<Aircraft>(Arrays.asList(
            new Plane(400,200,400, IAircraft.planeTypes.get(0)),
            new Plane(450,20,600, IAircraft.planeTypes.get(1)),
            new Plane(600,30,30,IAircraft.planeTypes.get(2)),
            new Helicopter(300,20, 20, IAircraft.helicopterTypes.get(0))
        ));
    }
    public String parkAircraft(Aircraft newAircraft){
        try{
            if(availableAircraft.size() == capacity) throw new IllegalStateException("There is no space in the hangar!");
            availableAircraft.add(newAircraft);
            return "The aircraft has been parked!";
        }
        catch(IllegalStateException e){
            return e.getMessage();
        }
    }
    public Aircraft getAircraft(String type){
        for(Aircraft a: availableAircraft){
            if(a instanceof Plane && (((Plane) a).getType()) == type){
                return a;
            }
            else if(a instanceof Helicopter && ((Helicopter) a).getType() == type) {
                return a;
            }
        }
        return null;
    }
    public String toString(){
        String wy = "";
        for (Aircraft a:availableAircraft){
            wy += a.toString();
        }
        return wy;
    }
}
