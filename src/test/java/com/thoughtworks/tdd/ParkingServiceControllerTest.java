package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ParkingServiceControllerTest {
    ParkingLot parkingLot1 = new ParkingLot(  1);
    ParkingLot parkingLot2 = new ParkingLot(  1);


    @Test
    public void should_return_parking_car_when_input_given_is_car_number() {

        //given
        String scannerStr = "1";
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        Response response = mock( Response.class );
        //when
        ParkingServiceController entrance = new ParkingServiceController(parkingBoy,response);
        when( parkingBoy.boyPark(any())).thenReturn( new Receipt( "40b83c35-5465-47b4-8854-aaf3517b6f95" ) );
        entrance.buildParkingMsg(scannerStr);
        verify(response).send("停车成功，您的小票是：\n40b83c35-5465-47b4-8854-aaf3517b6f95") ;
        //then
    }
    @Test
    public void should_return_car_when_unPark_car_input_given_is_receipt() {

        //given
        String receiptId = "40b83c35-5465-47b4-8854-aaf3517b6f95";
        ParkingBoy parkingBoy = mock(ParkingBoy.class);
        Response response = mock( Response.class );
        Receipt receipt = new Receipt( receiptId );
        //when
        ParkingServiceController entrance = new ParkingServiceController(parkingBoy,response);
        when( parkingBoy.boyUnPark(receipt)).thenReturn(new Car( "2" ));
        entrance.buildUnParkingMsg(receiptId);
        verify( response).send( "非法小票，无法取出车，请查证后再输" ) ;
        //then

    }

}
