package cyran.filipowski.objects.events;

import java.io.Serializable;
import java.time.LocalDate;

public class Arrival implements IEvent, Serializable {
    LocalDate time;
    int delay; // in minutes
    String airstrip;
    boolean permission;

    public Arrival(LocalDate time, int delay, String airstrip) {
        this.time = time;
        this.delay = delay;
        this.airstrip = airstrip;
    }

    @Override
    public boolean askForPermission(boolean decision) {
        permission = decision;
        return permission;
    }
    public boolean permissionStatus(){
        return permission;
    }
}
