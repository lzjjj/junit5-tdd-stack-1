package com.thoughtworks.tdd;

public class Car {
    private String carId;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Car(String carId) {

        this.carId = carId;
    }

    public Car() {

    }

}
