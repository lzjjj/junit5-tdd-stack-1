package com.thoughtworks.tdd;

public class Car {
    private int carId;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Car(int carId) {

        this.carId = carId;
    }

    public Car() {

    }

}
