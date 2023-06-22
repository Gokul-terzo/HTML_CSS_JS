package TicketReservation;

public class Customer1 extends Thread{
    Ticket ticket;
    public Customer1(Ticket ticket){
        this.ticket=ticket;
        Thread t1=new Thread(this,"TicketReservation.Customer1");
        t1.start();
    }

    public void run(){
        if(ticket.getTicket()) {
            System.out.println("Got by me (Customer 1)");
        }
        else{
            System.out.println("Customer 1:Couldn't acquire as it was acquired by someone else");
        }
    }
}
