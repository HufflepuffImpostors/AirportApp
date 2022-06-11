package cyran.filipowski.people.crew;

import cyran.filipowski.people.Person;

public class Crew extends Person {

    Position position;

    public Crew(String name, String surname, Position position) {
        super(name, surname);
        this.position = position;
    }
}
