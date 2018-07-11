package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private int size;
    private HashMap<Receipt,Car> parkingLotMap;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ParkingLot(int size) {
        this.size = size;
        parkingLotMap = new HashMap <>();
    }
    public Boolean isFull(){
        if(getSize()==parkingLotMap.size()){
            return true;
        }
        return false;
    }
    public Receipt park(Car car) {
        if(this.isFull()) {
            throw new RuntimeException();
        }
        Receipt receipt = new Receipt();
        parkingLotMap.put(receipt,car);
        return receipt;
    }

    public Car unPark(Receipt receipt) {
        if (!parkingLotMap.containsKey( receipt )){
            return null;
        }
        return parkingLotMap.remove(receipt);
    }
}
