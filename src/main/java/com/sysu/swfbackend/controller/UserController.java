package com.sysu.swfbackend.controller;

import com.alibaba.fastjson.JSON;
import com.sysu.swfbackend.bean.QueryInfo;
import com.sysu.swfbackend.bean.User;
import com.sysu.swfbackend.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo) {
        // 获取最大页数及当前页号
        int numbers = userDao.getUsersCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

        List<User> users = userDao.getAllUsers("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers", numbers);
        res.put("data", users);
        String res_string = JSON.toJSONString(res);
        return res_string;
    }

//    @RequestMapping("/userState")
//    public String updateUserState(@RequestParam("id") Integer id, @RequestParam("state") Boolean state) {
//        int i = userDao.updateState(id, state);
//        String str = i > 0 ? "success":"error";
//        String res_str = JSON.toJSONString(str);
//        return res_str;
//    }

    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user) {
        user.setRoles("ROLE_ACTIVITI_USER,GROUP_activitiTeam");
        int i = userDao.addUser(user);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        int i = userDao.deleteUser(id);
        return i > 0 ? "success" : "error";
    }

    @RequestMapping("/getUpdateUser")
    public String getUpdateUser(int id) {
        User user = userDao.getUpdateUser(id);
        String s = JSON.toJSONString(user);
        return s;
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestBody User user) {
        int i = userDao.editUser(user);
        return i > 0 ? "success" : "error";
    }
}
