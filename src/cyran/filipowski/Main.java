package cyran.filipowski;

import cyran.filipowski.people.ticketOffice.TicketSystem;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        String filename = "dane.data";

        TicketSystem ticketSystem = new TicketSystem();

        ticketSystem.createNewTicket("A", 10D);
        ticketSystem.createNewTicket("B", 20D);
        ticketSystem.createNewTicket("C", 30D);
        ticketSystem.createNewTicket("D", 40D);

        try {
            SerializationUtils.serialize(ticketSystem, filename);
            TicketSystem ticketSystem1 = (TicketSystem) SerializationUtils.deserialize(filename);
            System.out.println(ticketSystem1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }





    }
}
