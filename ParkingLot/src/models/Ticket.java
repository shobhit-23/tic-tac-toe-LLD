package Client.models;

import java.util.Date;

public class Ticket extends BaseModel{
    private String ticketNumber;
    private Date entryTime;
    private Vehicle vehicle;
    private ParkingSlots parkingSlots;
    private Gate gateGeneratedAt;
    private Operator generatedBy;
    
    public String getTicketNumber() {
        return ticketNumber;
    }
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    public Date getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public ParkingSlots getParkingSlots() {
        return parkingSlots;
    }
    public void setParkingSlots(ParkingSlots parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
    public Gate getGateGeneratedAt() {
        return gateGeneratedAt;
    }
    public void setGateGeneratedAt(Gate gateGeneratedAt) {
        this.gateGeneratedAt = gateGeneratedAt;
    }
    public Operator getGeneratedBy() {
        return generatedBy;
    }
    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    
}
