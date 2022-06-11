package cyran.filipowski.objects.aircraft;

public class Helicopter extends Aircraft{
    String type;

    public Helicopter(double maxSpeed, int passengerCapacity, int luggageCapacity, String type) {
        super(maxSpeed, passengerCapacity, luggageCapacity);
        this.type = type;
    }
    public String getType(){
        return type;
    }
}
