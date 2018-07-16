package com.thoughtworks.tdd;

import java.util.HashMap;

public class ParkingLot {
    private int size;
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private HashMap <Receipt, Car> parkingLotMap;

    public HashMap <Receipt, Car> getParkingLotMap() {
        return parkingLotMap;
    }

    public void setParkingLotMap(HashMap <Receipt, Car> parkingLotMap) {
        this.parkingLotMap = parkingLotMap;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ParkingLot(String name,int size) {
        this.size = size;
        this.name = name;
        parkingLotMap = new HashMap <>();
    }

    public Boolean isFull() {
        if (getSize() == parkingLotMap.size()) {
            return true;
        }
        return false;
    }

    public Receipt park(Car car) {
        if (this.isFull()) {
            throw new RuntimeException();
        }
        Receipt receipt = new Receipt();
        parkingLotMap.put( receipt, car );
        return receipt;
    }

    public Car unPark(Receipt receipt) {
        for (Receipt key : parkingLotMap.keySet()) {
            if (key.getReceiptId().equals( receipt.getReceiptId() ))
                return parkingLotMap.remove( key );
        }
        return null;
    }

}
