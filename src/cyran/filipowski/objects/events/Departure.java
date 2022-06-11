package cyran.filipowski.objects.events;

import java.time.LocalDate;

public class Departure {
    LocalDate time;
    int delay; // in minutes
    int gate;
    int airstripId;
    boolean permission;

    public Departure(LocalDate time, int delay, int gate, int airstripId) {
        this.time = time;
        this.delay = delay;
        this.gate = gate;
        this.airstripId = airstripId;
    }
    public boolean askForPermission(boolean decision) {
        permission = decision;
        return permission;
    }
}
