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
        for(ParkingLot parkingLot: parkingLotList){
            if (!parkingLot.isParkingLotFull()){
                parkingLot.park(car);
            }
        }
        throw new NoAvailablePositionException(NO_AVAILABLE_POSITION);
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
