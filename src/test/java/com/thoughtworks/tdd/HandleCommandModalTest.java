package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HandleCommandModalTest {
    ParkingLot parkingLot1 = new ParkingLot(  1);
    ParkingLot parkingLot2 = new ParkingLot(  1);

    @Test
    public void should_return_parking_car_when_input_given_is_2() {

        //given
        ScannerStr scannerStr = mock(ScannerStr.class);
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        //when
        when( scannerStr.getStr() ).thenReturn( "2" );
        HandleCommandController entrance = new HandleCommandController(scannerStr.getStr(),parkingBoy);
        //then
        assertThat(entrance.buildFirstReturn(), is("取车"));

    }
    @Test
    public void should_return_parking_car_when_input_given_is_car_number() {

        //given
        ScannerStr scannerStr = mock(ScannerStr.class);
        ParkingBoy parkingBoy = mock(ParkingBoy.class);

        parkingBoy.addParkingLot( parkingLot1 );
        parkingBoy.addParkingLot( parkingLot2 );
        //when
        when( scannerStr.getStr() ).thenReturn( "1" );
        HandleCommandController entrance = new HandleCommandController(scannerStr.getStr(),parkingBoy);
        when( parkingBoy.boyPark(any())).thenReturn( new Receipt( "40b83c35-5465-47b4-8854-aaf3517b6f95" ) );
        //then
        assertThat(entrance.buildParkingMsg("1"), is("停车成功，您的小票是：\n" +
                "40b83c35-5465-47b4-8854-aaf3517b6f95"));

    }
    @Test
    public void should_return_car_when_unPark_car_input_given_is_receipt() {

        //given
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        Car car = new Car( 2 );
        Receipt receipt = new Receipt( "40b83c35-5465-47b4-8854-aaf3517b6f95" );
        parkingLot1.getParkingLotMap().put(receipt,car);
        List<ParkingLot> parkingLotList = new ArrayList();
        parkingLotList.add( parkingLot1 );
        when( parkingBoy.getParkingLotList() ).thenReturn( parkingLotList);
        //when
        HandleCommandController entrance = new HandleCommandController("2",parkingBoy);
        when( parkingBoy.boyUnPark(entrance.generateReceipt( "40b83c35-5465-47b4-8854-aaf3517b6f95" )) ).thenReturn(car);

        //then
        assertThat(entrance.buildUnParkingMsg("40b83c35-5465-47b4-8854-aaf3517b6f95"), is("车已取出，您的车牌号是: 2"));

    }

}
