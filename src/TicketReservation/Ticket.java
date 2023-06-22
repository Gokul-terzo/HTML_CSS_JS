package TicketReservation;

public class Ticket extends Thread{
    private boolean notBooked=true;
    public synchronized boolean getTicket(){
        if(notBooked){
            System.out.println("TicketReservation.Ticket acquired");
            notBooked=false;
            return !notBooked;
        }
        return notBooked;
    }
}
