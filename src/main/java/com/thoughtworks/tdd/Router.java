package com.thoughtworks.tdd;

public class Router {
    private ParkingServiceController parkingServiceController;
    private ParkingManageController parkingManageController;
    private String currentPage;

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public Router(ParkingServiceController parkingServiceController,ParkingManageController parkingManageController) {
        this.parkingServiceController = parkingServiceController;
        this.parkingManageController = parkingManageController;
    }

    public String selectServicePage(String id, String currentPage) {
        switch (currentPage) {
            case "main":
                this.currentPage =  parkingServiceController.mainMsg(id);
                break;
            case "park":
                this.currentPage = parkingServiceController.buildParkingMsg( id );
                break;
            case "unPark":
                this.currentPage = parkingServiceController.buildUnParkingMsg( id );
                break;
            case "totalMain" :
                break;
        }
        return this.currentPage;
    }

    public String selectManagePage(String id, String currentPage) {
        switch (currentPage) {
            case "main":
                this.currentPage = parkingManageController.mainMsg(id);
                break;
            case "parkInfo":
                this.currentPage =  parkingManageController.buildLotsInfo( );
                break;
            case "addParkingLot":
                this.currentPage = parkingManageController.addParkingLot(id );
                break;
            case "deleteParkingLot":
                this.currentPage = parkingManageController.deleteParkingLot( id );
                break;
        }
        return this.currentPage;
    }



}
