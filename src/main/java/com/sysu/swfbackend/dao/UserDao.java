package com.sysu.swfbackend.dao;

import com.sysu.swfbackend.bean.UserInfoBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public List<UserInfoBean> getAllUsers(@Param("username") String username, @Param("pageStart") int pageStart, @Param("pageSize") int pageSize);
    public int getUsersCounts(@Param("username") String username);
    public int addUser(UserInfoBean userInfoBean);
    public int deleteUser(int id);
    public UserInfoBean getUserByID(int id);
    public int editUser(UserInfoBean userInfoBean);
}
