package Client.controllers;

import Client.enums.ResponseStatus;
import Client.models.Ticket;
import Client.Exception.GateNotFoundException;
import Client.Serivce.TicketService;
import Client.dtos.IssueTicketRequestDTO;
import Client.dtos.IssueTicketResponseDTO;

public class TicketController {

    private TicketService ticketService;  // tight coupling it will not effect as there  will never be any other service provider so it will not effect it.

     public TicketController(TicketService ticketService){
        this.ticketService=ticketService;   //Dependency Injection
     }
    
    public IssueTicketResponseDTO issueTicket (IssueTicketRequestDTO ticketRequestDTO)
    {
        IssueTicketResponseDTO issueTicketResponseDTO=new IssueTicketResponseDTO();
        Ticket ticket;
        try {
           ticket =ticketService.IssueTicket(ticketRequestDTO.getGateId(),ticketRequestDTO.getVehicleType(),ticketRequestDTO.getVehicleNumber(),ticketRequestDTO.getOwnerName());
        } catch (GateNotFoundException e) {
            
            issueTicketResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            issueTicketResponseDTO.setFailureMessage("Gate Id is INvalid.");
            return issueTicketResponseDTO;
        }
        catch (Exception e) {
            
            issueTicketResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
            issueTicketResponseDTO.setFailureMessage(e.getMessage());
            return issueTicketResponseDTO;
        }
        
        issueTicketResponseDTO.setTicketNumber(ticket.getTicketNumber());
        issueTicketResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        return issueTicketResponseDTO;
    } 
}
