package com.thoughtworks.tdd;

public class Main {
    public static void main(String[] args) throws Exception {
        ParkingLot parkingLot1 = new ParkingLot( "sdfs",1 );
        ParkingLot parkingLot2 = new ParkingLot( "dsdg",1 );
        ParkingBoy parkingBoy = new ParkingBoy();
        parkingBoy.addParkingLot( parkingLot1 );
        parkingBoy.addParkingLot( parkingLot2 );
        Response response = new Response();
        ParkingServiceController parkingServiceController = new ParkingServiceController( parkingBoy, response );
        ParkingManageController parkingManageController = new ParkingManageController( parkingBoy, response );
        MianController mianController = new MianController( response );
        Router router = new Router( parkingServiceController,parkingManageController );
        String currentPage = "main";
        while(true){
            ScannerStr scannerStr1 = new ScannerStr();
            router.processRequest(scannerStr1.getStr());
        }
//        mianController.showStartMsg();
//        String inputStr = new ScannerStr().getStr();
//        if (inputStr.equals( "1" )) {
//            parkingServiceController.startMsg();
//            while (true) {
//                ScannerStr scannerStr1 = new ScannerStr();
//                currentPage = router.selectServicePage( scannerStr1.getStr(), currentPage );
//            }
//        } else if (inputStr.equals( "2" )) {
//            parkingManageController.buildStartMsg();
//            while (true) {
//                ScannerStr scannerStr1 = new ScannerStr();
//
//                currentPage = router.selectManagePage( scannerStr1.getStr(), currentPage );
//            }
//        } else {
//            mianController.showInvalidMsg();
//        }
    }
}
