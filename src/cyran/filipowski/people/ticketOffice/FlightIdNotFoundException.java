package cyran.filipowski.people.ticketOffice;

public class FlightIdNotFoundException extends Exception{

    public FlightIdNotFoundException(String id) {
        super(id);
    }

    public FlightIdNotFoundException(String id, Throwable cause) {
        super(id, cause);
    }
}