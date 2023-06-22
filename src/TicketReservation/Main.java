package TicketReservation;

public class Main {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Customer2(ticket);
        new Customer1(ticket);

    }
}
