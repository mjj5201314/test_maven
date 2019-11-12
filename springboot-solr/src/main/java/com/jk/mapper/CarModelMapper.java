package com.jk.mapper;

import com.jk.model.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CarModelMapper {

    void addCar(Car car);

    void delAll(@Param("id") Integer[] id);

    void queryById(Integer carid);
}
