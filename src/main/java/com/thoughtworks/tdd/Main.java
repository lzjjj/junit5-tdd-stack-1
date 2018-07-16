package com.thoughtworks.tdd;

public class Main {
    public static void main(String[] args) throws Exception {
        ParkingLot parkingLot1 = new ParkingLot( 1 );
        ParkingLot parkingLot2 = new ParkingLot( 1 );
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot( parkingLot1 );
        parkingBoy.addParkingLot( parkingLot2 );
        ParkingView parkingView = new ParkingView();
        HandleCommandController handleCommandController = new HandleCommandController( parkingBoy );
        Router router = new Router( handleCommandController ,parkingView);

        while(true){
            router.selectPage( "","main" );
            ScannerStr scannerStr = new ScannerStr();
            router.handleCommand(scannerStr.getStr());
            ScannerStr scannerStr1 = new ScannerStr();
            router.selectPage( scannerStr1.getStr(),router.getCurrentPage() );
        }

    }
}
