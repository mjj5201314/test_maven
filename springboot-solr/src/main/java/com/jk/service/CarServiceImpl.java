package com.jk.service;

import com.jk.mapper.CarModelMapper;
import com.jk.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements  CarService{

    @Autowired
    private  CarModelMapper carModelMapper;

    @Override
    public void addCar(Car car) {

        carModelMapper.addCar(car);
    }

    @Override
    public void delAll(Integer[] id) {
        carModelMapper.delAll(id);
    }

    @Override
    public void queryById(Integer carid) {
        carModelMapper.queryById(carid);
    }


}
