package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {
    private final int DEFAULT_CAPACITY = 10;
    private final int capacity;
    HashMap<Ticket,Car> ticketCarMap = new HashMap<>();

    public ParkingLot(){
        capacity = DEFAULT_CAPACITY;
    }
    public ParkingLot(int capacity){
        this.capacity = capacity;
    }

    public Ticket parkCar(Car car) {
        if(!isParkingLotFull()){
            Ticket ticket = new Ticket();
            ticketCarMap.put(ticket,car);
            return ticket;
        }
        return null;
    }

    private boolean isParkingLotFull(){
        return ticketCarMap.size() >= capacity;
    }
}
