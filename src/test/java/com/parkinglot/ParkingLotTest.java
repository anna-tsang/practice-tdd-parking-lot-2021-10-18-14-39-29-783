package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_park_car_given_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        Ticket ticket = parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_nothing_when_park_car_given_full_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();
        //when
        Ticket ticket = parkingLot.park(car);
        //then
        assertNull(ticket);
    }

    @Test
    void should_return_parked_car_when_fetch_car_given_parking_lot_and_parked_ticket_and_parked_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);

        //when
        Car result = parkingLot.fetch(ticket);

        //then
        assertEquals(car,result);
    }

    @Test
    void should_return_correct_parked_car_when_fetch_car_given_parking_lot_and_2_parked_ticket_and_2_parked_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car carA = new Car();
        Ticket ticketA = parkingLot.park(carA);
        Car carB = new Car();
        Ticket ticketB = parkingLot.park(carB);
        //when
        Car resultOfCarA = parkingLot.fetch(ticketA);
        Car resultOfCarB = parkingLot.fetch(ticketB);

        //then
        assertEquals(carA,resultOfCarA);
        assertEquals(carB,resultOfCarB);
    }

    @Test
    void should_return_null_when_fetch_car_given_parking_lot_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car carA = new Car();
        Ticket ticketA = parkingLot.park(carA);
        Ticket wrongTicket = new Ticket();

        //when
        Car fetchCar = parkingLot.fetch(wrongTicket);

        //then
        assertNull(fetchCar);
    }
}
