
package com.thoughtworks.tdd;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.concurrent.TimeoutException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class ParkingLotTest{

    @Test
    public void should_park_successfully_given_parking_lot_is_not_full() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        try {
            parkingLot.park(new Car());
        } catch (RuntimeException exception) {
            fail("should park successfully");
        }
    }
    @Test
    public void should_park_unsuccessfully_given_parking_lot_is_full() {
        //given
        ParkingLot parkingLot = new ParkingLot(0);

        try {
            parkingLot.park(new Car());
            fail("should park successfully");

        } catch (RuntimeException exception) {
        }
    }

    @Test
    public void should_get_specific_car_when_call_unPark_given_receipt_is_right() {
        Car theCar = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        Receipt receipt = parkingLot.park(theCar);
        assertThat(parkingLot.unPark(receipt), is(theCar));
    }
    @Test
    public void should_not_get_specific_car_when_call_unPark_given_receipt_is_wrong() {
        Car theCar = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        Receipt anotherReceipt = new Receipt();
        parkingLot.park(theCar);
        assertThat(parkingLot.unPark(anotherReceipt), not(theCar));
    }
    @Test
    public void should_be_true_when_call_isFull_given_parking_lot_is_full(){
        ParkingLot parkingLot = new ParkingLot(0);

        assertThat(parkingLot.isFull(), is(true));
    }
    @Test
    public void should_be_false_when_call_isFull_given_parking_lot_is_not_full(){
        ParkingLot parkingLot = new ParkingLot(1);

        assertThat(parkingLot.isFull(), is(false));
    }
    @Test
    public void should_be_false_when_call_isFull_given_a_full_parking_lot_take_out_a_car(){
        ParkingLot parkingLot = new ParkingLot(1);

        Car theCar = new Car();
        Receipt receipt = parkingLot.park(theCar);
        parkingLot.unPark(receipt);

        assertThat(parkingLot.isFull(), is(false));
    }
    @Test
    public void should_park_successfullly_when_call_park_again_given_a_full_parking_lot_take_out_a_car(){
        ParkingLot parkingLot = new ParkingLot(1);

        Car theCar = new Car();
        Receipt receipt = parkingLot.park(theCar);
        parkingLot.unPark(receipt);

        try {
            parkingLot.park(new Car());
        } catch (RuntimeException exception) {
            fail("should park successfully");
        }
    }


}
