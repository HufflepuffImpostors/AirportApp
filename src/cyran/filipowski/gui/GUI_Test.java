package cyran.filipowski.gui;

import cyran.filipowski.objects.flightControl.Flight;
import cyran.filipowski.people.passenger.Passenger;
import cyran.filipowski.people.ticketOffice.TicketSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI_Test {
    private JTextArea textArea1;
    private JTextField CreateNewTicketFlightIdTextField;
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

    static TicketSystem ticketSystem = TicketSystem.getInstance();

    public GUI_Test() {
        CreateNewTicketBtn.addActionListener(e -> {
            String flightId;
            Double price;

            if (!CreateNewTicketFlightIdTextField.getText().isEmpty() && !CreateNewTicketPriceTextField.getText().isEmpty()) {
                flightId = CreateNewTicketFlightIdTextField.getText();
                price = Double.valueOf(CreateNewTicketPriceTextField.getText().replaceAll(",", "."));

                ticketSystem.createNewTicket(flightId, price);

                RebookTicketOldFlightIdComboBox.addItem(flightId);
                RebookTicketNewFlightIdComboBox.addItem(flightId);
                TicketManagementFlightIdComboBox.addItem(flightId);
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
                RebookTicketPassengerComboBox.addItem(newPassenger);
                TicketManagementPassengerComboBox.addItem(newPassenger);
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
                } else if (CancelReservationRadioBtn.isSelected()) {
                    ticketSystem.cancelTicketReservation(passenger, flightId);
                } else if (BuyTicketRadioBtn.isSelected()) {
                    ticketSystem.buyTicket(passenger, flightId);
                } else if (CancelTicketRadioBtn.isSelected()) {
                    ticketSystem.cancelTicket(passenger, flightId);
                }
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

        refreshPassengers();
    }

    private static void refreshPassengers() {
        GUI_Test gui_test = new GUI_Test();

        ArrayList<Passenger> passengers = ticketSystem.getPassengers();

        for (Passenger p : passengers) {
            gui_test.RebookTicketPassengerComboBox.addItem(p);
            gui_test.TicketManagementPassengerComboBox.addItem(p);
        }
    }

    private static void refreshFlights() {
        GUI_Test gui_test = new GUI_Test();

        ArrayList<String> flights = ticketSystem.getFlights();

        for (String f : flights) {
            gui_test.RebookTicketOldFlightIdComboBox.addItem(f);
            gui_test.RebookTicketNewFlightIdComboBox.addItem(f);
            gui_test.TicketManagementFlightIdComboBox.addItem(f);
        }
    }
}
