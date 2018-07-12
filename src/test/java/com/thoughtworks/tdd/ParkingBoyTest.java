package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ParkingBoyTest {

    @Test
    public void should_park_successfully_when_call_boyPark_given_parkingBoy() {
        ParkingLot parkingLot = mock(ParkingLot.class);
        when(parkingLot.isFull()).thenReturn(false);
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        Car car = new Car();
        try{
            parkingBoy.boyPark(car);
            verify( parkingLot ).park(car);
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
        ParkingLot parkingLot = mock(ParkingLot.class);
        when(parkingLot.isFull()).thenReturn(true);
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot);
        try{
            parkingBoy.boyPark(new Car());
            fail("should park successfully");
        }catch (RuntimeException exception){

        }
    }
    @Test
    public void should_park_order_given_parking_firt_lot() {
        Car car = new Car();
        ParkingLot parkingLot1 = mock(ParkingLot.class);
        ParkingLot parkingLot2 = mock(ParkingLot.class);

        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot(parkingLot1);
        parkingBoy.addParkingLot(parkingLot2);
        Receipt receipt = parkingBoy.boyPark(car);
        when(parkingLot1.unPark(receipt)).thenReturn(car);
        when(parkingLot2.unPark(receipt)).thenReturn(null);
        assertThat(car, is(parkingLot1.unPark( receipt )));
        assertThat(car, not(parkingLot2.unPark( receipt )));
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
