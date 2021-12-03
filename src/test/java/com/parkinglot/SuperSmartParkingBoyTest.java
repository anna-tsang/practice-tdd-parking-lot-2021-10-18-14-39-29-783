package com.parkinglot;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuperSmartParkingBoyTest {
    private final String UNRECOGNISED_PARKING_TICKET = "Unrecognised parking ticket.";
    private final String NO_AVAILABLE_POSITION = "No available position.";

    @Test
    void should_return_ticket_when_park_car_given_parking_lot_and_car() {
        //given
        ParkingLot parkingLotA = new ParkingLot(2);
        ParkingLot parkingLotB = new ParkingLot(2);
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLotA,parkingLotB);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLotList);
        //when
        Ticket ticket = superSmartParkingBoy.park(new Car());

        //then
        assertEquals(1, parkingLotA.getAvailablePosition());
        assertEquals(2, parkingLotB.getAvailablePosition());
    }

    //case2
    @Test
    void should_return_second_parking_lot_when_park_car_given_second_parking_lot_has_larger_empty_position_rate() {
        //given
        ParkingLot parkingLotA = new ParkingLot(5);
        ParkingLot parkingLotB = new ParkingLot(10);
        SuperSmartParkingBoy parkingBoy = new SuperSmartParkingBoy(Arrays.asList(parkingLotA, parkingLotB));
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertTrue(parkingLotB.ticketCarMap.containsValue(car));
        assertFalse(parkingLotA.ticketCarMap.containsValue(car));
    }
}
