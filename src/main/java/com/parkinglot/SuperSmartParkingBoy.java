package com.parkinglot;

import java.util.List;

public class SuperSmartParkingBoy extends SmartParkingBoy {
    private final String UNRECOGNISED_PARKING_TICKET = "Unrecognised parking ticket.";
    private final String NO_AVAILABLE_POSITION = "No available position.";

    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }
}
