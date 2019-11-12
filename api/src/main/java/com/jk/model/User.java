package com.jk.model;


import java.io.Serializable;


public class User implements Serializable {


    private static final long serialVersionUID = 5009955893890081379L;
    private Integer userid;

    private Integer usid;

    private String loginnumber;

    private String username;

    private String password;

    private String birth;

    private String sex;

    private String headimg;

    private String roleid;

    private String roleName;

    private String roename;

    public Integer getUsid() {
        return usid;
    }

    public void setUsid(Integer usid) {
        this.usid = usid;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLoginnumber() {
        return loginnumber;
    }

    public void setLoginnumber(String loginnumber) {
        this.loginnumber = loginnumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoename() {
        return roename;
    }

    public void setRoename(String roename) {
        this.roename = roename;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", loginnumber='" + loginnumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birth=" + birth +
                ", sex='" + sex + '\'' +
                ", headimg='" + headimg + '\'' +
                ", roleid='" + roleid + '\'' +
                ", roleName='" + roleName + '\'' +
                ", roename='" + roename + '\'' +
                '}';
    }
}
