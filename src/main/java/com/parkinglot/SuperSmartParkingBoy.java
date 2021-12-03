package com.parkinglot;

import java.util.List;

public class SuperSmartParkingBoy extends SmartParkingBoy {

    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot availableParkingLot = parkingLotList.get(0);
        for (int i = 1; i < parkingLotList.size(); i++) {
            if (availableParkingLot.getAvailableRate() < parkingLotList.get(i).getAvailableRate()) {
                availableParkingLot = parkingLotList.get(i);
            }
        }
        return availableParkingLot.park(car);
    }
}
