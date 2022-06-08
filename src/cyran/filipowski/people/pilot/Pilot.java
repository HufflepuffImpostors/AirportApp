package cyran.filipowski.people.pilot;

import cyran.filipowski.people.Person;

import java.time.LocalDateTime;

public class Pilot extends Person {
    Integer lengthOfShift;

    public Pilot(String name, String surname, Integer lengthOfShift) {
        super(name, surname);
        this.lengthOfShift = lengthOfShift;
    }

    public Integer getLengthOfShift() {
        return lengthOfShift;
    }

    public void setLengthOfShift(Integer lengthOfShift) {
        this.lengthOfShift = lengthOfShift;
    }

    public void startPlane() {
        LocalDateTime takeOffTime = LocalDateTime.now();
    }

    public void landPlane() {
        LocalDateTime landingTime = LocalDateTime.now();
    }

    public String announceInfo(String info) {
        return "Dear passengers, " + info + ". Thanks for your attention.";
    }
}
