package com.sysu.swfbackend.dao;

import com.sysu.swfbackend.pojo.UserInfoBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserInfoBeanMapper {
    @Select("SELECT * FROM user WHERE username = #{username};")
    UserInfoBean selectByUsername(@Param("username") String username);
}
