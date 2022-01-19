package com.sysu.swfbackend.dao;

import com.sysu.swfbackend.bean.ProcessDefinitionBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProcessDefinitionDao {
    /**
     * 根据租户获取对应的流程定义
     * @param TENANT_ID_
     * @return
     */
    public List<ProcessDefinitionBean> getProcessDefByTenantID(@Param("TENANT_ID_") String TENANT_ID_);

    /**
     * 获取所有流程定义
     * @return
     */
    public List<ProcessDefinitionBean> getAllTenantProcessDef();
}
