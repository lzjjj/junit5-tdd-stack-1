package com.thoughtworks.tdd;

public class HandleCommandController {
    private  String commandStr;

    public HandleCommandController(String commandStr) {
        this.commandStr = commandStr;
    }



    public  String buildFirstReturn() {
        if (commandStr.equals( "1" )){

            return "停车";
        }
        if (commandStr.equals("2")){
            return "取车";
        }
        return "非法指令，请查证后再输";
    }
    public  String buildParkingMsg(ParkingBoy parkingBoy,Car car) {
        Receipt receipt =  parkingBoy.boyPark( car );
        return "停车成功，您的小票是：\n" +
                receipt.getReceiptId();
    }
}
