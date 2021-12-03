package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {
    private final int DEFAULT_CAPACITY = 10;
    private final int capacity;
    HashMap<Ticket,Car> ticketCarMap = new HashMap<>();
    private final String UNRECOGNISED_PARKING_TICKET = "Unrecognised parking ticket.";
    private final String NO_AVAILABLE_POSITION = "No available position.";

    public ParkingLot(){
        capacity = DEFAULT_CAPACITY;
    }
    public ParkingLot(int capacity){
        this.capacity = capacity;
    }

    public Ticket park(Car car) {
        if(!isParkingLotFull()){
            Ticket ticket = new Ticket();
            ticketCarMap.put(ticket,car);
            return ticket;
        }
        throw new NoAvailablePositionException(NO_AVAILABLE_POSITION);
    }

    public boolean isParkingLotFull(){
        return ticketCarMap.size() >= capacity;
    }

    public Car fetch(Ticket ticket) {
        if(ticketCarMap.containsKey(ticket)){
            Car car = ticketCarMap.get(ticket);
            ticketCarMap.remove(ticket);
            return car;
        }
        throw new UnrecognisedParkingTicket(UNRECOGNISED_PARKING_TICKET);
    }

    public int getAvailablePosition() {
        return capacity - ticketCarMap.size();
    }
    public double getAvailableRate() {
        return (double) getAvailablePosition() / capacity;
    }
}
