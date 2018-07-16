package com.thoughtworks.tdd;

import java.util.List;

public class HandleCommandController {


    private ParkingBoy parkingBoy;

    public HandleCommandController(ParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public String startMsg() {
        return "1. 停车\n" +
                "2. 取车 \n" +
                "请输入您要进行的操作：";
    }
    public String inValidMsg( ) {
            return "非法指令，请查证后再输";
    }


    public String buildInValidMsg() {
        return "非法指令，请查证后再输";
    }

    public String buildBeforeParkingMsg() {
        return "请输入车牌号:";
    }

    public String buildParkingMsg(String Id) {
        try {
            Receipt receipt = parkingBoy.boyPark( generateCar( Id ) );
            return "停车成功，您的小票是：\n" +
                    receipt.getReceiptId();
        } catch (RuntimeException e) {
            return "车已停满，请晚点再来";
        }

    }

    public String buildBeforeUnParkingMsg() {
        return "请输入小票编号：";
    }

    public String buildUnParkingMsg(String id) {
        try {
            Car car = parkingBoy.boyUnPark( generateReceipt( id ) );
            return "车已取出，您的车牌号是: " + car.getCarId() + "";
        } catch (RuntimeException e) {
            return "非法小票，无法取出车，请查证后再输";
        }

    }

    public Car generateCar(String id) {
        return new Car( id );
    }

    public Receipt generateReceipt(String receiptId) {

        return new Receipt( receiptId ) ;
    }

}
