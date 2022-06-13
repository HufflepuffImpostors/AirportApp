package cyran.filipowski.gui;

import cyran.filipowski.SerializationUtils;
import cyran.filipowski.objects.aircraft.IAircraft;
import cyran.filipowski.objects.airport.Airport;
import cyran.filipowski.objects.airport.Hangar;
import cyran.filipowski.objects.flightControl.Flight;
import cyran.filipowski.objects.flightControl.FlightControl;
import cyran.filipowski.people.crew.Crew;
import cyran.filipowski.people.crew.Position;
import cyran.filipowski.people.passenger.Passenger;
import cyran.filipowski.people.technicalSupport.TechnicalSupport;
import cyran.filipowski.people.ticketOffice.TicketSystem;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class GUI_Test {
    private JTextField CreateNewTicketPriceTextField;
    private JButton CreateNewTicketBtn;
    private JTextField CreateNewPassengerNameTextField;
    private JTextField CreateNewPassengerSurnameTextField;
    private JButton CreateNewPassengerBtn;
    private JComboBox<Passenger> TicketManagementPassengerComboBox;
    private JComboBox<Passenger> RebookTicketPassengerComboBox;
    private JComboBox<String> RebookTicketNewFlightIdComboBox;
    private JComboBox<String> RebookTicketOldFlightIdComboBox;
    private JRadioButton ReserveTicketRadioBtn;
    private JRadioButton CancelTicketRadioBtn;
    private JRadioButton BuyTicketRadioBtn;
    private JRadioButton CancelReservationRadioBtn;
    private JPanel MainFrame;
    private JComboBox<String> TicketManagementFlightIdComboBox;
    private JButton RebookTicketBtn;
    private JButton TicketManagementPerformBtn;

    DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");


    private JFormattedTextField departureDateFTF;
    private JFormattedTextField arrivalDateFTF;

    private JComboBox<String> aircraftCB;
    private JTextField flightIdTB;
    private JButton createFlightBT;
    private JRadioButton arrivalRB;
    private JButton setFlightPermissionBT;
    private JCheckBox suspenseAirportCB;
    private JLabel createFlightLabel;
    private JLabel departureDateLabel;
    private JLabel arrivalDateLabel;
    private JLabel aircraftLabel;
    private JLabel flightIdLabel;
    private JLabel permissionsLabel;
    private JLabel flightPermissionLabel;
    private JRadioButton departureRB;
    private JComboBox performFlightCB;
    private JButton performFlightBT;
    private JLabel performFlightLB;
    private JLabel performFlightBigLB;
    private JComboBox<String> pilotCB;
    private JLabel pilotLabel;
    private JComboBox<String> stewardessCB;
    private JLabel stewardessLabel;
    private JTextField departureDateTB;
    private JTextField arrivalDateTB;
    private JTextField flightPersmissionsCB;
    private JComboBox<String> CreateNewTicketFlightIdComboBox;
    private JRadioButton allowRB;
    private JRadioButton denyRB;
    private JButton SaveBtn;
    private JButton LoadBtn;
    private JTextField FilenameTextField;

    static TicketSystem ticketSystem = TicketSystem.getInstance();
    static FlightControl flightControl = FlightControl.getInstance();

    public GUI_Test() {
        /*
        initialization
         */
        ArrayList<Crew> crew = new ArrayList<>(Arrays.asList(
                new Crew("Jan","Kowalski", Position.PILOT),
                new Crew("Mikołaj","Stryczek", Position.PILOT),
                new Crew("Adam", "Nowak", Position.STEWARDESS),
                new Crew("Rafał", "Fatuła", Position.STEWARDESS))
                );
        TechnicalSupport technicalSupport = new TechnicalSupport();
        pilotCB.addItem(crew.get(0).getName() + " " + crew.get(0).getSurname());
        pilotCB.addItem(crew.get(1).getName() + " " + crew.get(1).getSurname());
        stewardessCB.addItem(crew.get(2).getName() + " " + crew.get(2).getSurname());
        stewardessCB.addItem(crew.get(3).getName() + " " + crew.get(3).getSurname());



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
        for(String t : IAircraft.planeTypes){
            aircraftCB.addItem(t);
        }
        for(String t : IAircraft.helicopterTypes){
            aircraftCB.addItem(t);
        }

        ArrayList<Passenger> passengers = new ArrayList<>(Arrays.asList(
           new Passenger("Patryk", "Cyran"),
           new Passenger("Jakub", "Filipowski"),
           new Passenger("Jakub", "Kościółek"),
           new Passenger("Konrad", "Kierepka")
        ));

        ticketSystem.addPassengers(passengers);

        CreateNewTicketBtn.addActionListener(e -> {
            String flightId;
            Double price;

            if (!CreateNewTicketPriceTextField.getText().isEmpty()) {
                flightId = CreateNewTicketFlightIdComboBox.getSelectedItem().toString();
                price = Double.valueOf(CreateNewTicketPriceTextField.getText().replaceAll(",", "."));

                ticketSystem.createNewTicket(flightId, price);

                refreshFlights();
            }
        });

        CreateNewPassengerBtn.addActionListener(e -> {
            String name;
            String surname;

            name = CreateNewPassengerNameTextField.getText();
            surname = CreateNewPassengerSurnameTextField.getText();

            Passenger newPassenger;

            if (!name.isEmpty() && !surname.isEmpty()) {
                newPassenger = ticketSystem.createNewPassenger(name, surname);

                refreshPassengers();
            }
        });


        RebookTicketBtn.addActionListener(e -> {
            if (!RebookTicketPassengerComboBox.getSelectedItem().toString().isEmpty() &&
                    !RebookTicketOldFlightIdComboBox.getSelectedItem().toString().isEmpty() &&
                    !RebookTicketNewFlightIdComboBox.getSelectedItem().toString().isEmpty()) {

                Passenger passenger = (Passenger) RebookTicketPassengerComboBox.getSelectedItem();
                //String[] passengerText = RebookTicketPassengerComboBox.getSelectedItem().toString().split(" ");
                String oldFlightText = RebookTicketOldFlightIdComboBox.getSelectedItem().toString();//.split(" ");
                String newFlightText = RebookTicketNewFlightIdComboBox.getSelectedItem().toString();//.split(" ");

                ticketSystem.changeTicketReservation(passenger, oldFlightText, newFlightText);
            }
        });
        TicketManagementPerformBtn.addActionListener(e -> {
            if (!TicketManagementPassengerComboBox.getSelectedItem().toString().isEmpty() &&
                    !TicketManagementFlightIdComboBox.getSelectedItem().toString().isEmpty()) {
                String flightId = TicketManagementFlightIdComboBox.getSelectedItem().toString();
                Passenger passenger;

                passenger = (Passenger) TicketManagementPassengerComboBox.getSelectedItem();

                if (ReserveTicketRadioBtn.isSelected()) {
                    ticketSystem.reserveTicket(passenger, flightId);
                    System.out.println("Ticket for flight " + flightId + " reserved by " + passenger);
                } else if (CancelReservationRadioBtn.isSelected()) {
                    ticketSystem.cancelTicketReservation(passenger, flightId);
                    System.out.println("Ticket reservation for flight " + flightId + " cancelled by " + passenger);
                } else if (BuyTicketRadioBtn.isSelected()) {
                    ticketSystem.buyTicket(passenger, flightId);
                    System.out.println("Ticket for flight " + flightId + " bought by " + passenger);
                } else if (CancelTicketRadioBtn.isSelected()) {
                    ticketSystem.cancelTicket(passenger, flightId);
                    System.out.println("Ticket for flight " + flightId + " returned by " + passenger);
                }
            }
        });
        createFlightBT.addActionListener( e ->{
            Flight newF = flightControl.createFlight(
                    LocalDate.parse(departureDateTB.getText()),
                    LocalDate.parse(arrivalDateTB.getText()),
                    airport.getAirstrip(0),
                    airport.getAirstrip(1),
                    airport.getHangar(0).getAircraft("airliner"),
                    new ArrayList<Passenger>(),
                    new ArrayList<Crew>(),
                    flightIdTB.getText()
                );
            if (newF != null){
                refreshFlights();
            }
        });
        setFlightPermissionBT.addActionListener(e->{
            String flightId = flightPersmissionsCB.getText();
            if(!flightId.isEmpty()){
                if(arrivalRB.isSelected()) flightControl.setArrivalAllowance(flightId, allowRB.isSelected());
                else if(departureRB.isSelected()) flightControl.setDepartureAllowance(flightId, allowRB.isSelected());
            }

        });
        performFlightBT.addActionListener(e->{
            String flightId = performFlightCB.getSelectedItem().toString();
            Flight selected = flightControl.getFlight(flightId);
            if(selected.getDeparture().permissionStatus() && selected.getArrival().permissionStatus()){
                technicalSupport.loadAircraft(flightId);
                technicalSupport.boardPassengers(flightId);
                System.out.println("Aircraft has been loaded and boarded!");
                System.out.println(selected.fly());
                technicalSupport.unboardPassengers(flightId);
                technicalSupport.unloadAircraft(flightId);
                System.out.println("Aircraft has been unloaded and unboarded!");
                System.out.println(flightControl.removeFlight(flightId));
                refreshFlights();
            }
            else System.out.println("The flight hasn't got permissions to perform!");
        });
        suspenseAirportCB.addActionListener(e->{
            createFlightBT.setEnabled(!suspenseAirportCB.isSelected());
            setFlightPermissionBT.setEnabled(!suspenseAirportCB.isSelected());
            performFlightBT.setEnabled(!suspenseAirportCB.isSelected());
            System.out.println("Suspension status set to " + suspenseAirportCB.isSelected());

        });
        SaveBtn.addActionListener(e -> {
            String filename = "save";

            if (!FilenameTextField.getText().isEmpty()) filename = FilenameTextField.getText();

            try {
                ArrayList<Object> objects = new ArrayList<>();
                objects.add(ticketSystem);
                objects.add(flightControl);
                SerializationUtils.serialize(objects, filename);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        LoadBtn.addActionListener(e -> {
            String filename = "save";

            if (!FilenameTextField.getText().isEmpty()) filename = FilenameTextField.getText();

            try {
                ArrayList<Object> objects = (ArrayList<Object>) SerializationUtils.deserialize(filename);
                ticketSystem = (TicketSystem) objects.get(0);
                flightControl = (FlightControl) objects.get(1);
                refreshPassengers();
                refreshFlights();
            } catch (IOException | ClassNotFoundException exception) {
                exception.printStackTrace();
            }
        });
        SaveBtn.addActionListener(e -> {
            String filename = "save";

            if (!FilenameTextField.getText().isEmpty()) filename = FilenameTextField.getText();

            try {
                ArrayList<Object> objects = new ArrayList<>();
                objects.add(ticketSystem);
                objects.add(flightControl);
                SerializationUtils.serialize(objects, filename);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        LoadBtn.addActionListener(e -> {
            String filename = "save";

            if (!FilenameTextField.getText().isEmpty()) filename = FilenameTextField.getText();

            try {
                ArrayList<Object> objects = (ArrayList<Object>) SerializationUtils.deserialize(filename);
                ticketSystem = (TicketSystem) objects.get(0);
                flightControl = (FlightControl) objects.get(1);
                refreshPassengers();
                refreshFlights();
            } catch (IOException | ClassNotFoundException exception) {
                exception.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        initFrame();
    }

    private static void initFrame() {
        GUI_Test gui_test = new GUI_Test();
        JFrame jFrame = new JFrame();
        jFrame.setContentPane(gui_test.MainFrame);
        jFrame.setSize(1080, 720);
        //jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        gui_test.BuyTicketRadioBtn.setSelected(true);

        initFlights(gui_test);
        initPassengers(gui_test);
    }

    private static void initFlights(GUI_Test gui_test) {
        ArrayList<String> flightIds = ticketSystem.getFlightIds();
        for (String f : flightIds) {
            System.out.println(f);
            gui_test.RebookTicketOldFlightIdComboBox.addItem(f);
            gui_test.RebookTicketNewFlightIdComboBox.addItem(f);
            gui_test.TicketManagementFlightIdComboBox.addItem(f);
            gui_test.CreateNewTicketFlightIdComboBox.addItem(f);
        }
    }

    private static void initPassengers(GUI_Test gui_test) {
        ArrayList<Passenger> passengers = ticketSystem.getPassengers();

        for (Passenger p : passengers) {
            gui_test.RebookTicketPassengerComboBox.addItem(p);
            gui_test.TicketManagementPassengerComboBox.addItem(p);
        }
    }

    private void refreshPassengers() {
        ArrayList<Passenger> passengers = ticketSystem.getPassengers();

        Passenger passenger1 = (Passenger) RebookTicketPassengerComboBox.getSelectedItem();
        Passenger passenger2 = (Passenger) RebookTicketPassengerComboBox.getSelectedItem();

        RebookTicketPassengerComboBox.removeAllItems();
        TicketManagementPassengerComboBox.removeAllItems();

        for (Passenger p : passengers) {
            RebookTicketPassengerComboBox.addItem(p);
            TicketManagementPassengerComboBox.addItem(p);
        }

        if (passenger1 != null) RebookTicketPassengerComboBox.setSelectedItem(passenger1);
        if (passenger1 != null) TicketManagementPassengerComboBox.setSelectedItem(passenger2);
    }

    private void refreshFlights() {

        ArrayList<String> flightIds = ticketSystem.getFlightIds();

        String flight1 = RebookTicketOldFlightIdComboBox.toString();
        String flight2 = RebookTicketNewFlightIdComboBox.toString();
        String flight3 = TicketManagementFlightIdComboBox.toString();
        String flight4 = CreateNewTicketFlightIdComboBox.toString();

        RebookTicketOldFlightIdComboBox.removeAllItems();
        RebookTicketNewFlightIdComboBox.removeAllItems();
        TicketManagementFlightIdComboBox.removeAllItems();
        CreateNewTicketFlightIdComboBox.removeAllItems();
        performFlightCB.removeAllItems();

        for (String f : flightIds) {
            RebookTicketOldFlightIdComboBox.addItem(f);
            RebookTicketNewFlightIdComboBox.addItem(f);
            TicketManagementFlightIdComboBox.addItem(f);
            CreateNewTicketFlightIdComboBox.addItem(f);
            performFlightCB.addItem(f);
        }

        if (!flight1.isEmpty()) RebookTicketOldFlightIdComboBox.setSelectedItem(flight1);
        if (!flight2.isEmpty()) RebookTicketNewFlightIdComboBox.setSelectedItem(flight2);
        if (!flight3.isEmpty()) TicketManagementFlightIdComboBox.setSelectedItem(flight3);
        if (!flight4.isEmpty()) CreateNewTicketFlightIdComboBox.setSelectedItem(flight4);
    }
}
