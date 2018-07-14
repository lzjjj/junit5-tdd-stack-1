package com.thoughtworks.tdd;

import java.util.List;

public class HandleCommandController {


    private  String commandStr;
    private ParkingBoy parkingBoy;

    public HandleCommandController(String commandStr, ParkingBoy parkingBoy) {
        this.commandStr = commandStr;
        this.parkingBoy = parkingBoy;
    }
    public boolean isValiate(){
        if(commandStr.equals( "1" ) || commandStr.equals("2")){
            return true;
        }
        return false;
    }
    public boolean isPark(){
        if(commandStr.equals( "1" )){
            return true;
        }
        return false;
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
    public String  selectParkOrUnPark (String id){

        if(commandStr.equals( "1" )){
           return buildParkingMsg(id);
        } else {
           return buildUnParkingMsg(id);
        }
    }
    public  String buildParkingMsg(String Id) {
        try{
            System.out.print( "请输入车牌号:" );
            Receipt receipt =  parkingBoy.boyPark( generateCar(Id) );
            return "停车成功，您的小票是：\n" +
                    receipt.getReceiptId();
        }catch(RuntimeException e){
            return "车已停满，请晚点再来";
        }

    }
    public  String buildUnParkingMsg(String id) {
        try{
            Car car = parkingBoy.boyUnPark( generateReceipt(id) );
            return "车已取出，您的车牌号是: "+car.getCarId()+"";
        }catch(RuntimeException e){
            return "非法小票，无法取出车，请查证后再输";
        }

    }
    public Car generateCar(String id){
        return new Car( Integer.parseInt( id ) );
    }
    public Receipt generateReceipt(String receiptId){

        List<ParkingLot> ParkingLotList =  parkingBoy.getParkingLotList();
        for(ParkingLot parkingLot: ParkingLotList){
            for(Receipt key:parkingLot.getParkingLotMap().keySet()){
                if(key.getReceiptId().equals( receiptId ));
                return key;
            }
        };
        throw new RuntimeException(  );
    }

}
