package cyran.filipowski;

import cyran.filipowski.objects.airport.Airport;
import cyran.filipowski.objects.airport.Hangar;
import cyran.filipowski.objects.flightControl.FlightControl;
import cyran.filipowski.people.crew.Crew;
import cyran.filipowski.people.crew.Position;
import cyran.filipowski.people.passenger.Passenger;
import cyran.filipowski.people.ticketOffice.TicketSystem;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

//        String filename = "dane.data";
//
//        TicketSystem ticketSystem = new TicketSystem();
//
//        ticketSystem.createNewTicket("A", 10D);
//        ticketSystem.createNewTicket("B", 20D);
//        ticketSystem.createNewTicket("C", 30D);
//        ticketSystem.createNewTicket("D", 40D);
//
//        try {
//            SerializationUtils.serialize(ticketSystem, filename);
//            TicketSystem ticketSystem1 = (TicketSystem) SerializationUtils.deserialize(filename);
//            System.out.println(ticketSystem1);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        /*
        FlightControl flightControl = FlightControl.getInstance();
        Airport airport = new Airport(
                new ArrayList<>(Arrays.asList(
                        "1",
                        "2",
                        "3"
                )),
                new ArrayList<>(Arrays.asList(
                        "long",
                        "short",
                        "military"
                )),
                new ArrayList<>(Arrays.asList(
                        "main",
                        "vip"
                )),
                new HashMap<>(){{
                    put("private",100);
                    put("public",20);
                }},
                new ArrayList<>(Arrays.asList(
                        new Hangar(),
                        new Hangar()
                ))
        );
        Hangar firstHangar = airport.getHangar(0);
        ArrayList<Passenger> currentPassengers = new ArrayList<>(Arrays.asList(
                new Passenger("Patryk", "Cyran"),
                new Passenger("Jakub", "Filipowski")
        ));
        ArrayList<Crew> currentCrew = new ArrayList<Crew>(Arrays.asList(
                new Crew("Jakub", "Kościółek", Position.PILOT)
        ));
        flightControl.createFlight(
                LocalDate.now().minusDays(2),
                LocalDate.now(),
                airport.getAirstrip(0),
                airport.getAirstrip(1),
                firstHangar.getAircraft("airliner"),
                currentPassengers,
                currentCrew,
                "0x5"
        );
        flightControl.getFlight("0x5").setLuggage(new ArrayList<>(Arrays.asList("walizka","walizka")));
        String result = flightControl.getFlight("0x5").fly();
        System.out.println(result);
        flightControl.getFlight("0x5").getDeparture().askForPermission(true);
        flightControl.getFlight("0x5").getArrival().askForPermission(true);
        result = flightControl.getFlight("0x5").fly();
        System.out.println(result);
        */

    }
}
