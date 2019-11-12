package com.jk.service;

import com.jk.model.MenuTree;
import com.jk.model.PowerModel;
import com.jk.model.RoeModel;
import com.jk.model.User;
import org.springframework.boot.web.servlet.server.Session;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    List<User> queryuser();

    List<MenuTree> getsync(HttpSession session);

    void addUser(User user);

    void delAll(Integer[] ids);

    List<RoeModel> queryRole();

    List<MenuTree> initPowerTree(Integer roleid);

    List<PowerModel> queryMenu(Integer powerid);

    void updatePowerById(MenuTree power);

    void saveRolePower(Integer roleid, String[] ids);

    void deletePowerById(Integer powerid);

    User queryUsername(String loginnumber);

    List<String> queryPowerByUserid(Integer userid);
}
