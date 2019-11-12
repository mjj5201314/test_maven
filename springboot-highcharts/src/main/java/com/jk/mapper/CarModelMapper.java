package com.jk.mapper;

import java.util.List;
import java.util.Map;

public interface CarModelMapper {

    List<Map<String, Object>> queryCar();


    List<Map<String, Object>> queryCarAll();
}
