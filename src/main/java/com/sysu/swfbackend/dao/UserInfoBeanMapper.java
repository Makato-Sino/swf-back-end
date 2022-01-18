package com.sysu.swfbackend.dao;

import com.sysu.swfbackend.bean.UserInfoBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component
public interface UserInfoBeanMapper {
    /**
     * 根据用户名获取用户实体
     * @param username
     * @return
     */
    @Select("SELECT * FROM user WHERE username = #{username};")
    UserInfoBean selectByUsername(@Param("username") String username);

    /**
     * 获取用户列表
     * @return
     */
    @Select("SELECT * FROM user")
    List<HashMap<String, Object>> selectUser();
}
