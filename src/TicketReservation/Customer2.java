package TicketReservation;

public class Customer2 extends Thread{
    Ticket ticket;
    public Customer2(Ticket ticket){
        this.ticket=ticket;
        Thread t2=new Thread(this,"Customer 2");
        t2.start();
    }

    public void run(){
        if(ticket.getTicket()) {
            System.out.println("Got by me (Customer 2)");
        }
        else{
            System.out.println("Customer 2:Couldn't acquire as it was acquired by someone else");
        }
    }
}
