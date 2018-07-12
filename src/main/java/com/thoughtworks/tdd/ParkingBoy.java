package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList ;

    public ParkingBoy() {
        this.parkingLotList = new ArrayList<>();
    }

    public Receipt boyPark(Car car) {
        if(parkingLotList.size()==0){
            throw new RuntimeException();
        }
        Boolean isParkingSuccess = false;
        for (ParkingLot i : parkingLotList) {
            if (!i.isFull()) {
                isParkingSuccess = true;
                return i.park( car );
            }
        }
        if(!isParkingSuccess){
            throw new RuntimeException();
        }
        return  null;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotList.add( parkingLot );
    }

    public void boyUnPark(Receipt receipt) {
        Boolean isParkingSuccess = false;
        for (ParkingLot i : parkingLotList) {
            if (i.unPark( receipt )!=null) {
                isParkingSuccess = true;
                return;
            }
        }
        if(!isParkingSuccess){
            throw new RuntimeException(  );
        }
    }
}
