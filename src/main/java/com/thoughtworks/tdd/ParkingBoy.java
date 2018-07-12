package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList ;

    public ParkingBoy() {
        this.parkingLotList = new ArrayList<>();
    }

    public void boyPark(Car car) {
        if(parkingLotList.size()==0){
            throw new RuntimeException();
        }
        Boolean isParkingSuccess = false;
        for (ParkingLot i : parkingLotList) {
            if (!i.isFull()) {
                i.park( car );
                isParkingSuccess = true;
                return ;
            }
        }
        if(!isParkingSuccess){
            throw new RuntimeException();
        }

    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotList.add( parkingLot );
    }
}
