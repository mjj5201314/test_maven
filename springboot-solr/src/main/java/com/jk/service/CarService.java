package com.jk.service;

import com.jk.model.Car;

public interface CarService {
    void addCar(Car car);

    void delAll(Integer[] id);

    void queryById(Integer carid);
}
