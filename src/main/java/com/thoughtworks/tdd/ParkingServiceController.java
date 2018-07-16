package com.thoughtworks.tdd;

public class ParkingServiceController {

    private Response response;
    private ParkingBoy parkingBoy;

    public ParkingServiceController(ParkingBoy parkingBoy, Response response) {
        this.parkingBoy = parkingBoy;
        this.response = response;
    }
    public String mainMsg(String commandStr){
        if(commandStr.equals( "1" )){
            this.buildBeforeParkingMsg();
            return "park";
        } else if (commandStr.equals( "2" )){
            this.buildBeforeUnParkingMsg();
            return "unPark";
        } else {
            this.buildInValidMsg(  );
            this.startMsg();
            return "main";
        }
    }
    public void startMsg() {
        response.send("1. 停车\n" +
                "2. 取车 \n" +
                "请输入您要进行的操作：") ;

    }
    public void inValidMsg( ) {
        response.send("非法指令，请查证后再输");
    }


    public void buildInValidMsg() {
        response.send("非法指令，请查证后再输");
    }

    public void buildBeforeParkingMsg() {
        response.send("请输入车牌号:");

    }
    public boolean goToTotalMain() {
        return false;
    }
    public String buildParkingMsg(String Id) {
        try {
            Receipt receipt = parkingBoy.boyPark( generateCar( Id ) );
            response.send("停车成功，您的小票是：\n" +
                    receipt.getReceiptId()) ;
        } catch (RuntimeException e) {
            response.send("车已停满，请晚点再来");
        }
        this.startMsg();
        return "main";
    }

    public void buildBeforeUnParkingMsg() {
        response.send("请输入小票编号：");
    }

    public String buildUnParkingMsg(String id) {
        try {
            Car car = parkingBoy.boyUnPark( generateReceipt( id ) );
            response.send("车已取出，您的车牌号是: " + car.getCarId());
        } catch (RuntimeException e) {
            response.send("非法小票，无法取出车，请查证后再输");
        }
        this.startMsg();
        return "main";
    }

    public Car generateCar(String id) {
        return new Car( id );
    }

    public Receipt generateReceipt(String receiptId) {

        return new Receipt( receiptId ) ;
    }

}
