package com.thoughtworks.tdd;

public class ParkingView {
    private ParkingBoy parkingBoy;
    private String sc;
    public ParkingView(ParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public void parkingStart (){
        System.out.print( "1. 停车\n" +
                "2. 取车 \n" +
                "请输入您要进行的操作：" );
         sc = getScannerStr();
    }
    public void  outputResult(){
        HandleCommandController handleCommandModal = new HandleCommandController( sc,parkingBoy );
        System.out.println( handleCommandModal.buildFirstReturn() );
        if(handleCommandModal.isValiate()){
            if(handleCommandModal.isPark()){
                System.out.print( "请输入车牌号:" );
            } else {
                System.out.print( "请输入小票编号：" );
            }
            ScannerStr sc2 = new ScannerStr();
            System.out.println( handleCommandModal.selectParkOrUnPark(sc2.getStr()) );
            parkingStart();
            outputResult();
        } else {
            parkingStart();
            outputResult();
        }

    }

    private String getScannerStr() {
        return new ScannerStr().getStr();
    }
}
