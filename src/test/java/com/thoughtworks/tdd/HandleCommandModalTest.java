package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HandleCommandModalTest {

    @Test
    public void should_return_parking_car_when_input_given_is_2() {

        //given
        ScannerStr scannerStr = mock(ScannerStr.class);
        //when
        when( scannerStr.getStr() ).thenReturn( "2" );
        HandleCommandController entrance = new HandleCommandController(scannerStr.getStr());
        //then
        assertThat(entrance.buildFirstReturn(), is("取车"));

    }
    @Test
    public void should_return_parking_car_when_input_given_is_car_number() {

        //given
        ScannerStr scannerStr = mock(ScannerStr.class);
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        ParkingLot parkingLot1 = new ParkingLot(  1);
        ParkingLot parkingLot2 = new ParkingLot(  1);
        parkingBoy.addParkingLot( parkingLot1 );
        parkingBoy.addParkingLot( parkingLot2 );
        //when
        when( scannerStr.getStr() ).thenReturn( "2" );
        HandleCommandController entrance = new HandleCommandController(scannerStr.getStr());
        Car car = new Car(Integer.parseInt( scannerStr.getStr() ));
        when( parkingBoy.boyPark(car)).thenReturn( new Receipt( "40b83c35-5465-47b4-8854-aaf3517b6f95" ) );

        //then
        assertThat(entrance.buildParkingMsg(parkingBoy,car), is("停车成功，您的小票是：\n" +
                "40b83c35-5465-47b4-8854-aaf3517b6f95"));

    }

}
