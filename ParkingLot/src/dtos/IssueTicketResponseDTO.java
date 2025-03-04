package Client.dtos;


import Client.enums.ResponseStatus;


public class IssueTicketResponseDTO {
    private String  ticketNumber;
    private ResponseStatus responseStatus;
    private String failureMessage;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }
    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
    public String getFailureMessage() {
        return failureMessage;
    }
    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
    public String getTicketNumber() {
        return ticketNumber;
    }
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    
}
