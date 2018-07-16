package com.thoughtworks.tdd;

public class ParkingManageController {

    private Response response;
    private ParkingBoy parkingBoy;

    public ParkingManageController(ParkingBoy parkingBoy, Response response) {
        this.response = response;
        this.parkingBoy = parkingBoy;
    }

    public String mainMsg(String commandStr) {
        if (commandStr.equals( "1" )) {
            this.buildLotsInfo();
            return "parkInfo";
        } else if (commandStr.equals( "2" )) {
            this.beforeAddParkingLot();
            return "addParkingLot";
        } else if (commandStr.equals( "3" )) {
            this.beforeDeleteParkingLot();
            return "deleteParkingLot";
        } else {
            this.showInvalidMsg();
            this.buildStartMsg();
            return "main";
        }
    }

    public void buildStartMsg() {
        response.send( "1.查看停车场详情\n" +
                "2.添加停车场\n" +
                "3.删除停车场" );
    }

    public String buildLotsInfo() {
        String parkingLotStr = "";
        int totalLots = 0;
        int totalCars = 0;
        for (ParkingLot parkingLot : parkingBoy.getParkingLotList()) {
            parkingLotStr += "|" + parkingBoy.getParkingLotList().indexOf( parkingLot ) + "|" + parkingLot.getName() + "|" + parkingLot.getSize() + "(个)|" + parkingLot.getParkingLotMap().size() + "(辆)|" + (parkingLot.getSize() - parkingLot.getParkingLotMap().size()) + "(个)|\n";
            totalLots += parkingLot.getSize();
            totalCars += parkingLot.getParkingLotMap().size();
        }

        response.send( "|停车场ID|名称|车位|已停车辆|剩余车位|\n" +
                "======================================\n" +
                parkingLotStr +
                "\n" +
                "总车位：" + totalLots + "(个)\n" +
                "停车总量："+totalCars+"（辆）\n" +
                "总剩余车位："+(totalLots-totalCars)+"（个）" );
        this.buildStartMsg();
        return "main";
    }


    public void beforeDeleteParkingLot() {
        response.send( "请输入需要删除的被管理停车场ID:" );
    }

    public String deleteParkingLot(String id) {
        parkingBoy.deleteParkingLot( Integer.parseInt( id ) );
        response.send( "停车场删除成功" );
        this.buildStartMsg();
        return "main";

    }

    public void beforeAddParkingLot() {
        response.send( "请输入你套添加的停车场信息（格式为：名称，车位）：" );
    }

    public String addParkingLot(String commandStr) {
        ParkingLot parkingLot = new ParkingLot(commandStr.split( "，" )[0],Integer.parseInt( commandStr.split( "，" )[1] ));
        parkingBoy.addParkingLot( parkingLot );
        response.send( "停车场添加成功！" );
        this.buildStartMsg();
        return "main";
    }

    public void showInvalidMsg() {
        response.send( "非法指令，请查证后再输" );
    }
}
