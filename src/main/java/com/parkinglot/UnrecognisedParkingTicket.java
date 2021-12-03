package com.parkinglot;

public class UnrecognisedParkingTicket extends RuntimeException{
    public UnrecognisedParkingTicket(String message){
        super(message);
    }
}
