package com.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

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
            return parkingLot.fetch(ticket);
        }
        return null;
    }
}
