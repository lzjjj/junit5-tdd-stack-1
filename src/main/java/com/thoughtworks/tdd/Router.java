package com.thoughtworks.tdd;

public class Router {
    private HandleCommandController handleCommandController;
    private String currentPage;
    private ParkingView parkingView;

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public Router(HandleCommandController handleCommandController, ParkingView parkingView) {
        this.handleCommandController = handleCommandController;
        this.parkingView = parkingView;
    }

    public void selectPage(String id,String currentPage) {
        switch (currentPage) {
            case "main":
                parkingView.send( handleCommandController.startMsg() );
                break;
            case "park":
                parkingView.send( handleCommandController.buildParkingMsg( id ) );
                break;
            case "unPark":
                parkingView.send( handleCommandController.buildUnParkingMsg( id ) );
                break;
            case "inValid":
                parkingView.send( handleCommandController.inValidMsg() );
                parkingView.send( handleCommandController.startMsg() );
                break;
        }
    }

    public void handleCommand(String commandStr) {
        switch (commandStr) {
            case "1":
                currentPage = "park";
                parkingView.send( handleCommandController.buildBeforeParkingMsg() );

                break;
            case "2":
                currentPage = "unPark";
                parkingView.send( handleCommandController.buildBeforeUnParkingMsg() );

                break;
            default:
                currentPage = "inValid";
                this.selectPage( commandStr,currentPage );
                break;
        }

    }
}
