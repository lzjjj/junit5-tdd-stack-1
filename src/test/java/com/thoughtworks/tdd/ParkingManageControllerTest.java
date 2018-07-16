package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ParkingManageControllerTest {
    ParkingLot parkingLot1 = new ParkingLot(  1);
    ParkingLot parkingLot2 = new ParkingLot(  1);
    ParkingBoy parkingBoy = new ParkingBoy();


    @Test
    public void should_return_parking_info_when_input_is_1() {

        //given
        String handleComand = "1";
        Response response = mock( Response.class );
        parkingBoy.addParkingLot( parkingLot1 );
        parkingBoy.addParkingLot( parkingLot2 );
        ParkingManageController parkingManageController = new ParkingManageController(parkingBoy,response);
        //when

        //then
        parkingManageController.buildStartMsg();
       verify( response ).send( any() );
    }


}
