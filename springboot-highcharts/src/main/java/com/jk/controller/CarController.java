package com.jk.controller;

import com.jk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping("toQueryCar")
    public String toQueryCar(HttpServletRequest request){
        return "show";
    }


    @RequestMapping("tolist")
    public String list(HttpServletRequest request){
        return "list";
    }

    @RequestMapping("queryCar")
    @ResponseBody
    public List<Map<String,Object>> queryCarList(){
        //查询数据库数据
        List<Map<String,Object>> map1 =carService.queryCar();
        //前台展示的返回的数据
        List<Map<String,Object>> map2 =new ArrayList<Map<String,Object>>();

        for (Map<String,Object> map:map1) {
            Map<String,Object> map3=new HashMap<>();
            map3.put("y",map.get("count"));
            map3.put("name",map.get("time"));
            map2.add(map3);
        }



        return map2;
    }



    @RequestMapping("queryCarAll")
    @ResponseBody
    public List<Map<String,Object>> queryCarAll(){

        /**
         * 1.使用饼状图展示2019年每一个月的销量
         * 2.使用折线图展示每一周的销量
         * 3.使用面积图展示每个品牌的销量
         * 4.使用柱状图展示一个月内每一天的销量
         */
        List<Map<String,Object>> map =carService.queryCarAll();

        List<Map<String,Object>> map2 =new ArrayList<Map<String,Object>>();

        for (Map<String,Object> map1:map) {
            Map<String,Object> map3=new HashMap<>();
            map3.put("name",map1.get("time"));
            map3.put("data",map1.get("count"));
            map2.add(map3);

        }




        return map;
    }




}
