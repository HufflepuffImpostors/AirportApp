package cyran.filipowski.people.crew;

import cyran.filipowski.people.Person;

import java.io.Serializable;

public class Crew extends Person implements Serializable {

    Position position;

    public Crew(String name, String surname, Position position) {
        super(name, surname);
        this.position = position;
    }
}
