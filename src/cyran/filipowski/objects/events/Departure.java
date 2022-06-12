package cyran.filipowski.objects.events;

import java.time.LocalDate;

public class Departure {
    LocalDate time;
    int delay; // in minutes
    String airstrip;
    boolean permission;

    public Departure(LocalDate time, int delay, String airstrip) {
        this.time = time;
        this.delay = delay;
        this.airstrip = airstrip;
    }
    public boolean askForPermission(boolean decision) {
        permission = decision;
        return permission;
    }
    public boolean permissionStatus(){
        return permission;
    }
}
