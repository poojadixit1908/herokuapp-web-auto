package com.herokuapp.test;

public class CarFactory {

    public static Car createCar(String carBrand) {

        Car car = null;
        switch (carBrand) {
            case "toyota":
              car = new ToyotaCar();
              break;
            case "holden":
                car = new HoldenCar();
        }
        return car;
    }

}
