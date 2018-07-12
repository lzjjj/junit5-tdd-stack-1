package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class ParkingBoyTest {

    @Test
    public void should_park_successfully_when_call_boyPark_given_parkingBoy() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        try{
            parkingBoy.boyPark(new Car());
        }catch (RuntimeException exception){
            fail("should park successfully");
        }
    }

    @Test
    public void should_park_unsuccessfully_when_call_boyPark_given_parkingBoy_without_parkingLot() {
        ParkingBoy parkingBoy = new ParkingBoy();

        try{
            parkingBoy.boyPark(new Car());
            fail("should park successfully");
        }catch (RuntimeException exception){

        }
    }
    @Test
    public void should_park_unsuccessfully_when_call_boyPark_given_parkingLot_isFull() {
        ParkingLot parkingLot = new ParkingLot(1);

        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        parkingBoy.boyPark(new Car());
        try{
            parkingBoy.boyPark(new Car());
            fail("should park successfully");
        }catch (RuntimeException exception){

        }
    }
    @Test
    public void should_get_car_success_when_call_boyUnPark_given_rightReceipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        Receipt receipt = parkingBoy.boyPark(new Car());
        try{
            parkingBoy.boyUnPark(receipt);

        }catch (RuntimeException exception){
            fail("should unPark successfully");
        }
    }
    @Test
    public void should_get_car_unSuccess_when_call_boyUnPark_given_wrongReceipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy();
        Receipt receipt = new Receipt();
        try{
            parkingBoy.boyUnPark(receipt);
            fail("should unPark successfully");
        }catch (RuntimeException exception){
        }
    }
}
