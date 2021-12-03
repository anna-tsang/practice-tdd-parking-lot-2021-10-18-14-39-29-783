package com.parkinglot;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmartParkingBoyTest {
    private final String UNRECOGNISED_PARKING_TICKET = "Unrecognised parking ticket.";
    private final String NO_AVAILABLE_POSITION = "No available position.";

    //case1
    @Test
    void should_return_first_parking_lot_when_park_car_given_same_number_of_empty_position() {
        //given
        ParkingLot parkingLotA = new ParkingLot(2);
        ParkingLot parkingLotB = new ParkingLot(2);
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLotA,parkingLotB);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotList);
        //when
        Ticket ticket = smartParkingBoy.park(new Car());

        //then
        assertEquals(1, parkingLotA.getAvailablePosition());
        assertEquals(2, parkingLotB.getAvailablePosition());
    }

    //case2
    @Test
    void should_return_second_parking_lot_when_park_car_given_second_parking_lot_has_more_empty_position() {
        //given
        ParkingLot parkingLotA = new ParkingLot(5);
        ParkingLot parkingLotB = new ParkingLot(10);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(Arrays.asList(parkingLotA, parkingLotB));
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.park(car);

        //then
        assertTrue(parkingLotB.ticketCarMap.containsValue(car));
        assertFalse(parkingLotA.ticketCarMap.containsValue(car));
    }
}
