package cyran.filipowski.objects.aircraft;

public class NotEnoughFuelException extends RuntimeException{
    public NotEnoughFuelException(String message) {
        super(message);
    }
}
