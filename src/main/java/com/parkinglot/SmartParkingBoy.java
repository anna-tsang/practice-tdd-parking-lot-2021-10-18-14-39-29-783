package com.parkinglot;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy{
    private final String UNRECOGNISED_PARKING_TICKET = "Unrecognised parking ticket.";
    private final String NO_AVAILABLE_POSITION = "No available position.";

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot availableParkingLot = parkingLotList.get(0);
        for(int i = 0 ; i < parkingLotList.size(); i++){
            if (availableParkingLot.getAvailablePosition() < parkingLotList.get(i).getAvailablePosition()) {
                availableParkingLot = parkingLotList.get(i);
            }
        }
        return availableParkingLot.park(car);
    }

}
