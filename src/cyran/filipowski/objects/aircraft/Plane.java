package cyran.filipowski.objects.aircraft;

public class Plane extends Aircraft{
    String type;

    public Plane(double maxSpeed, int passengerCapacity, int luggageCapacity, String type) {
        super(maxSpeed, passengerCapacity, luggageCapacity);
        this.type = type;
    }
    public String getType(){
        return type;
    }
}
