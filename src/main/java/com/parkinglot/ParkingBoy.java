package com.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;
    private final String UNRECOGNISED_PARKING_TICKET = "Unrecognised parking ticket.";
    private final String NO_AVAILABLE_POSITION = "No available position.";

    public ParkingBoy(List<ParkingLot> parkingLotList){
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) {
        return parkingLotList.stream().filter(parkingLot -> parkingLot.getAvailablePosition() > 0)
                .findFirst()
                .get()
                .park(car);
    }

    public Car fetch(Ticket ticket) {
        for(ParkingLot parkingLot: parkingLotList){
            try {
                return parkingLot.fetch(ticket);
            } catch (RuntimeException ignored) {}
        }
        throw new UnrecognisedParkingTicket(UNRECOGNISED_PARKING_TICKET);
    }
}
