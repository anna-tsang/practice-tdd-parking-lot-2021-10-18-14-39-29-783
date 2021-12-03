package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingBoyTest {
    private final String UNRECOGNISED_PARKING_TICKET = "Unrecognised parking ticket.";
    private final String NO_AVAILABLE_POSITION = "No available position.";

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
        ParkingLot parkingLotA = new ParkingLot(0);
        ParkingLot parkingLotB = new ParkingLot(10);
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLotA,parkingLotB);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);
        //when
        Ticket ticket = parkingBoy.park(new Car());
        //then
        assertEquals(0, parkingLotA.getAvailablePosition());
        assertEquals(9, parkingLotB.getAvailablePosition());
    }

    //case 4
    @Test
    void should_return_right_car_with_each_ticket_when_fetch_car_twice_given_both_with_parked_car_and_2_parking_ticket() {
        //given
        ParkingLot parkingLotA = new ParkingLot();
        ParkingLot parkingLotB = new ParkingLot();
        Car carA = new Car();
        Car carB = new Car();
        Ticket ticketA = parkingLotA.park(carA);
        Ticket ticketB = parkingLotB.park(carB);
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLotA,parkingLotB);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);

        //when
        Car resultOfCarA = parkingBoy.fetch(ticketA);
        Car resultOfCarB = parkingBoy.fetch(ticketB);

        //then
        assertEquals(carA, resultOfCarA);
        assertEquals(carB, resultOfCarB);
    }

    //case 5
    @Test
    void should_return_error_message_when_fetch_car_given_unrecognised_ticket() {
        //given
        ParkingLot parkingLotA = new ParkingLot();
        ParkingLot parkingLotB = new ParkingLot();
        Car carA = new Car();
        Car carB = new Car();
        Ticket ticketA = parkingLotA.park(carA);
        Ticket ticketB = parkingLotB.park(carB);
        Ticket wrongTicket = new Ticket();
        List<ParkingLot> parkingLotList = Arrays.asList(parkingLotA,parkingLotB);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLotList);

        //when
        UnrecognisedParkingTicket unrecognisedParkingTicket = assertThrows(UnrecognisedParkingTicket.class, () -> {
            Car fetchCar = parkingBoy.fetch(wrongTicket);
        });

        //then
        assertEquals(UNRECOGNISED_PARKING_TICKET, unrecognisedParkingTicket.getMessage());

    }
}
