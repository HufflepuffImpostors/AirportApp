package cyran.filipowski.objects.events;

import java.time.LocalDate;

public class Arrival implements IEvent{
    LocalDate time;
    int delay; // in minutes
    int gate;
    int airstripId;
    boolean permission;

    public Arrival(LocalDate time, int delay, int gate, int airstripId) {
        this.time = time;
        this.delay = delay;
        this.gate = gate;
        this.airstripId = airstripId;
    }

    @Override
    public boolean askForPermission(boolean decision) {
        permission = decision;
        return permission;
    }
}
