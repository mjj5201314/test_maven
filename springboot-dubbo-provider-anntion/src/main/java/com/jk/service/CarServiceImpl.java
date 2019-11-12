package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.CarModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CarServiceImpl implements  CarService {

    @Autowired
    private CarModelMapper carModelMapperl;
}
