package com.jk.mapper;

import com.jk.model.MenuTree;
import com.jk.model.PowerModel;
import com.jk.model.RoeModel;
import com.jk.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<User> queryuser();



    List<MenuTree> queryTree(@Param("pid") Integer pid,@Param("userid") Integer userid);

   

    void delAll(@Param("ids") Integer[] ids);

    @Select(" select * from t_role")
    List<RoeModel> queryRole();

    List<MenuTree> queryPowerTreeByRoleid(Integer roleid);

    List<MenuTree> queryTreeByPid(@Param("pid") int pid);


    List<PowerModel> queryMenu(@Param("powerid") Integer powerid);

    void updatePowerById(MenuTree power);

    void deleteByRoleid(Integer roleid);

    void addRolePower(@Param("roleid") Integer roleid,@Param("ids") String[] ids);

    void deletePowerById(Integer powerid);



    void deleteUserRole(Integer userid);

    void addUserRole(@Param("arrId") String[] arrId, @Param("userid") Integer userid);

    void addUser(User user);


    User queryUsername(@Param("loginnumber") String loginnumber);

    List<String> queryPowerByUserid(Integer userid);
}
