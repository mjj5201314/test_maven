package com.jk.service;


import com.jk.mapper.CarModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements  CarService {

    @Autowired
    private CarModelMapper carModelMapperl;

    @Override
    public List<Map<String, Object>> queryCar() {
        return carModelMapperl.queryCar();
    }

    @Override
    public List<Map<String, Object>> queryCarAll() {
        return carModelMapperl.queryCarAll();
    }


}
