package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_car_given_standard_parking_boy_manage_one_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        //when
        Ticket ticket = parkingBoy.park(new Car());

        //then
        assertNotNull(ticket);
    }
    //case 2
    @Test
    void should_return_first_parking_lot_when_park_car_given_2_parking_lot_with_available_position() {
        //given
        ParkingLot parkingLotA = new ParkingLot();
        ParkingLot parkingLotB = new ParkingLot();
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLotA,parkingLotB);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        //when
        Ticket ticket = parkingBoy.park(new Car());

        //then
        assertEquals(9, parkingLotA.getAvailablePosition());
        assertEquals(10, parkingLotB.getAvailablePosition());
    }

    //case 3
    @Test
    void should_return_second_parking_lot_when_park_car_given_first_parking_lot_full_second_with_available_position() {
        //given
        ParkingLot parkingLotA = new ParkingLot();
        ParkingLot parkingLotB = new ParkingLot();
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLotA,parkingLotB);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        //when
        Ticket ticket = parkingBoy.park(new Car());
        //then
        assertEquals(0, parkingLotA.getAvailablePosition());
        assertEquals(9, parkingLotB.getAvailablePosition());
    }
}
