package com.thoughtworks.tdd;

public class Main {
    public static void main(String[] args) throws Exception {
        ParkingLot parkingLot1 = new ParkingLot( 0 );
        ParkingLot parkingLot2 = new ParkingLot( 1 );
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot( parkingLot1 );
        parkingBoy.addParkingLot( parkingLot2 );
        ParkingView parkingView = new ParkingView( parkingBoy );
        parkingView.parkingStart();
        parkingView.outputResult();
    }
}
