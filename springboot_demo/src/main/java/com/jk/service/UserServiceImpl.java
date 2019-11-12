package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.MenuTree;
import com.jk.model.PowerModel;
import com.jk.model.RoeModel;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserMapper usermapper;


    @Override
    public List<User> queryuser() {

        return usermapper.queryuser();
    }

    @Override
    public List<MenuTree> getsync(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer userid = user.getUserid();
        Integer pid=0;
        List<MenuTree> list=nodes(pid,userid);
        return list;
    }

    private List<MenuTree> nodes(Integer pid,Integer userid) {
        List<MenuTree> list = usermapper.queryTree(pid,userid);
        for (MenuTree MenuTree : list) {
            Integer id = MenuTree.getId();
            List<MenuTree> node = nodes(id,userid);
            MenuTree.setChildren(node);
        }
        return list;
    }

    @Override
    public void addUser(User user) {
        Integer userid = user.getUserid();
        if(userid!=null){

            usermapper.deleteUserRole(userid);
        }else{

            usermapper.addUser(user);
        }



        String roleids = user.getRoleid();
        String[] arrId = roleids.split(",");
        usermapper.addUserRole(arrId,user.getUserid());
    }

    @Override
    public void delAll(Integer[] ids) {
        usermapper.delAll(ids);
    }

    @Override
    public List<RoeModel> queryRole() {

        return usermapper.queryRole();
    }

    @Override
    public List<MenuTree> initPowerTree(Integer roleid) {
        List<MenuTree> rolePower = usermapper.queryPowerTreeByRoleid(roleid);

        int pid = 0;

        List<MenuTree> list = queryPowerNodes(pid, rolePower);

        MenuTree tree = new MenuTree();
        tree.setId(0);
        tree.setpId(-1);
        tree.setText("根节点");
        tree.setChildren(list);

        ArrayList<MenuTree> list2 = new ArrayList<MenuTree>();
        list2.add(tree);
        return list2;
    }

    @Override
    public List<PowerModel> queryMenu(Integer powerid) {

        return usermapper.queryMenu(powerid);
    }

    @Override
    public void updatePowerById(MenuTree power) {
        usermapper.updatePowerById(power);
    }

    @Override
    public void saveRolePower(Integer roleid, String[] ids) {
        usermapper.deleteByRoleid(roleid);

        if(ids.length>0){
            usermapper.addRolePower(roleid,ids);
        }

    }

    @Override
    public void deletePowerById(Integer powerid) {
        usermapper.deletePowerById(powerid);
    }

    @Override
    public User queryUsername(String loginnumber) {
        return usermapper.queryUsername(loginnumber);
    }


    private List<MenuTree> queryPowerNodes(int pid, List<MenuTree> rolePower) {

        List<MenuTree> list = usermapper.queryTreeByPid(pid);

        for (MenuTree treeBean : list) {
            Integer id = treeBean.getId();
            //查询对应的子节点
            List<MenuTree> nodes = queryPowerNodes(id, rolePower);//递归：自己调自己
            treeBean.setChildren(nodes);

            //把所有的权限，跟当前角色拥有的权限比较：checked属性：true
            for (MenuTree treeBean2 : rolePower) {
                Integer id2 = treeBean.getId();
                Integer id3 = treeBean2.getId();
                if (nodes.size() <= 0 && id2 == id3) {//是子节点 并且 有权限
                    treeBean.setChecked(true);
                }
            }
        }
        return list;
    }


    @Override
    public List<String> queryPowerByUserid(Integer userid) {
        // TODO Auto-generated method stub
        return usermapper.queryPowerByUserid(userid);
    }


}
