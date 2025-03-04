package Client.Repository;

import java.util.Map;
import java.util.TreeMap;

import Client.models.Ticket;

public class TicketRepository {

    private Map<Integer ,Ticket> ticketshm=new TreeMap<>();

    private int previousId=0;

    public Ticket saveTicket(Ticket ticket){
        previousId+=1;
        ticket.setId(previousId);
        ticketshm.put(previousId,ticket);
        return ticket;
    }
}
