package com.sysu.swfbackend.dao;

import com.sysu.swfbackend.bean.ProcessInstanceBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessInstanceDao {

    /**
     * 根据用户ID获取流程实例列表
     * @param USER_ID_
     * @return
     */
    public List<ProcessInstanceBean> getUserInstancesByUserID(@Param("USER_ID_") String USER_ID_);
}
