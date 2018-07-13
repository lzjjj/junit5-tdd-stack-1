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
        for (ParkingLot i : parkingLotList) {
            if (!i.isFull()) {
                return null;
            }
        }
        throw new RuntimeException();
    }

    public void addParkingLot(ParkingLot parkingLot) {
        parkingLotList.add( parkingLot );
    }

    public Car boyUnPark(Receipt receipt) {
        Car car = null;
        for (ParkingLot i : parkingLotList) {
            car =i.unPark( receipt );
            if (car!=null) {
                return car;
            }
        }
        throw new RuntimeException(  );
    }
}
