package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {

    public Ticket parkCar(Car car) {
        HashMap<Ticket,Car> ticketCarMap = new HashMap<>();
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket,car);

        return ticket;
    }
}
