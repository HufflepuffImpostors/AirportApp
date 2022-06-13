package cyran.filipowski.objects.aircraft;

import cyran.filipowski.people.passenger.Passenger;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Aircraft implements IAircraft, Serializable {
    int fuel = 200;
    double maxSpeed;
    int passengerCapacity, luggageCapacity;
    ArrayList<String> onboardLuggage;
    ArrayList<Passenger> onboardPassengers;

    public Aircraft(double maxSpeed, int passengerCapacity, int luggageCapacity) {
        this.maxSpeed = maxSpeed;
        this.passengerCapacity = passengerCapacity;
        this.luggageCapacity = luggageCapacity;
        this.onboardLuggage = new ArrayList<String>();
        this.onboardPassengers = new ArrayList<Passenger>();
    }

    public String fuelUp(int amount){
        fuel += amount;
        return "The aircraft has been fueled up!";
    }
    public String fly(int length){
        try{
            if(length <= 0) throw new IllegalArgumentException();
            else if((length/100) * fuelEfficiency > fuel) throw new NotEnoughFuelException("0x01");
            else fuel -= (length/100) * fuelEfficiency;
            return "The aircraft flew the distance!";
        }
        catch(NotEnoughFuelException e){
            return "There isn't enough fuel in the tank!";
        }
        catch (IllegalArgumentException e){
            return "Length of flight must be greater than 0!";
        }
    }
    public String load(ArrayList<String> luggage){
        try{
            if(luggage.size()+onboardLuggage.size() > luggageCapacity) throw new IllegalArgumentException("The luggage is too big for this aircraft!");
            onboardLuggage.addAll(luggage);
            return "The luggage has been loaded successfully";
        }
        catch(IllegalArgumentException e){
            return e.getMessage();
        }
    }
    public ArrayList<String> unload(){
        try{
            if(onboardLuggage.isEmpty()) throw new IllegalStateException("There isn't any luggage!");
            else{
                ArrayList<String> luggageToReturn = onboardLuggage;
                onboardLuggage.clear();
                return luggageToReturn;
            }
        }
        catch(IllegalStateException e){
            return new ArrayList<String>();
        }
    }
    public String board(ArrayList<Passenger> passengers){
        try{
            if(passengers.size()+onboardPassengers.size() > passengerCapacity ) throw new IllegalArgumentException("There isn't enough space for that amount of passengers!");
            onboardPassengers.addAll(passengers);
            return "The passengers have successfully boarded!";
        }
        catch(IllegalArgumentException e){
            return e.getMessage();
        }
    }
}
