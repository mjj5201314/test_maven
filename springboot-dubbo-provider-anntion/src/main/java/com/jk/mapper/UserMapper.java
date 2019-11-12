package com.jk.mapper;

import com.jk.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from t_user")
    List<User> queryuser();

    void addUser(User user);

    void delAll(@Param("ids") Integer[] ids);

    User queryuserByid(Integer userId);

    void updateuser(User user);

    void addUSers(List<User> list);
}
