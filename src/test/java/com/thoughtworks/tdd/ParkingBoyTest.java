package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
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
    public void should_park_order_given_parking_firt_lot() {
        ParkingLot parkingLotFirst = new ParkingLot(1);
        ParkingLot parkingLotSecond = new ParkingLot(1);
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLotFirst);
        Receipt receipt = parkingBoy.boyPark(car);
        assertThat(car, is(parkingLotFirst.unPark( receipt )));
        assertThat(car, not(parkingLotSecond.unPark( receipt )));
    }
    @Test
    public void should_get_car_success_when_call_boyUnPark_given_rightReceipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        Car car = new Car();
        Receipt receipt = parkingBoy.boyPark(car);
        assertThat(parkingBoy.boyUnPark(receipt), is(car));

    }
    @Test
    public void should_get_car_unSuccess_when_call_boyUnPark_given_wrongReceipt() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot( parkingLot );
        Receipt receipt = new Receipt();
        try{
            parkingBoy.boyUnPark(receipt);
            fail("should unPark successfully");
        }catch (RuntimeException exception){
        }
    }

}
