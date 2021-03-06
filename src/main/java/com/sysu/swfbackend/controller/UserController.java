package com.sysu.swfbackend.controller;

import com.sysu.swfbackend.bean.QueryInfo;
import com.sysu.swfbackend.bean.UserInfoBean;
import com.sysu.swfbackend.dao.UserDao;
import com.sysu.swfbackend.dao.UserInfoBeanMapper;
import com.sysu.swfbackend.security.MyUserDetailsService;
import com.sysu.swfbackend.util.AjaxResponse;
import com.sysu.swfbackend.util.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    UserInfoBeanMapper userInfoBeanMapper;

    @Autowired
    private UserDao userDao;

    /**
     * 获取全部租户列表
     * @return
     */
    @GetMapping("/getUsers")
    public AjaxResponse getUsers() {
        try {
            List<HashMap<String, Object>> userList = userInfoBeanMapper.selectUser();
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(), GlobalConfig.ResponseCode.SUCCESS.getDesc(), userList);
        } catch (Exception e) {
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(), GlobalConfig.ResponseCode.ERROR.getDesc(), e.toString());
        }
    }

    /**
     * 获取分页用户信息
     * @param queryInfo
     * @return
     */
    @RequestMapping("/getUserList")
    public AjaxResponse getUserList(QueryInfo queryInfo) {
        try {
            // 获取最大页数及当前页号
            int numbers = userDao.getUsersCounts("%" + queryInfo.getQuery() + "%");
            int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();

            List<UserInfoBean> users = userDao.getAllUsers("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());
            HashMap<String, Object> res = new HashMap<>();
            res.put("numbers", numbers);
            res.put("data", users);
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(), GlobalConfig.ResponseCode.SUCCESS.getDesc(), res);
        } catch (Exception e) {
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(), GlobalConfig.ResponseCode.ERROR.getDesc(), e.toString());
        }

    }

    /**
     * 添加用户
     * @param userInfoBean
     * @return
     */
    @PostMapping("/addUser")
    public AjaxResponse addUser(@RequestBody UserInfoBean userInfoBean) {
        try {
            userInfoBean.setRoles("ROLE_ACTIVITI_USER");
            String password = myUserDetailsService.passwordEncoder().encode(userInfoBean.getPassword());
            userInfoBean.setPassword(password);
            userDao.addUser(userInfoBean);
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(), GlobalConfig.ResponseCode.SUCCESS.getDesc(), userInfoBean.getName());
        } catch (Exception e) {
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(), GlobalConfig.ResponseCode.ERROR.getDesc(), e.toString());
        }
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/deleteUser")
    public AjaxResponse deleteUser(@RequestParam("id") int id) {
        try {
            userDao.deleteUser(id);
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(), GlobalConfig.ResponseCode.SUCCESS.getDesc(), null);
        } catch (Exception e) {
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(), GlobalConfig.ResponseCode.ERROR.getDesc(), e.toString());
        }
    }

    /**
     * 根据id获取用户的信息
     * @param id
     * @return
     */
    @RequestMapping("/getUserByID")
    public AjaxResponse getUserByID(int id) {
        try {
            UserInfoBean userInfoBean = userDao.getUserByID(id);
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(), GlobalConfig.ResponseCode.SUCCESS.getDesc(), userInfoBean);
        }catch (Exception e) {
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(), GlobalConfig.ResponseCode.ERROR.getDesc(), e.toString());
        }
    }

    /**
     * 修改用户信息
     * @param userInfoBean
     * @return
     */
    @RequestMapping("/editUser")
    public AjaxResponse editUser(@RequestBody UserInfoBean userInfoBean) {
        try {
            userInfoBean.setRoles("ROLE_ACTIVITI_USER");
            String password = myUserDetailsService.passwordEncoder().encode(userInfoBean.getPassword());
            userInfoBean.setPassword(password);
            userDao.editUser(userInfoBean);
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(), GlobalConfig.ResponseCode.SUCCESS.getDesc(), userInfoBean);
        } catch (Exception e) {
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(), GlobalConfig.ResponseCode.ERROR.getDesc(), e.toString());
        }
    }
}
