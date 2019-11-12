package com.jk.model;

import java.io.Serializable;

public class Car implements Serializable {

    private  Integer  carid;

    private  String   carName;

    private   String   cartime;

    private   String   carprice;

    private   String  typeid;

    private   String deptName;

    private   String  countCar;

    public String getCountCar() {
        return countCar;
    }

    public void setCountCar(String countCar) {
        this.countCar = countCar;
    }

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCartime() {
        return cartime;
    }

    public void setCartime(String cartime) {
        this.cartime = cartime;
    }

    public String getCarprice() {
        return carprice;
    }

    public void setCarprice(String carprice) {
        this.carprice = carprice;
    }

    public String getTypeid() {
        return typeid;
    }

    public void setTypeid(String typeid) {
        this.typeid = typeid;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
