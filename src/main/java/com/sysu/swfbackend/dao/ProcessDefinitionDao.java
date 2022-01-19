package com.sysu.swfbackend.dao;

import com.sysu.swfbackend.bean.ProcessDefinitionBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessDefinitionDao {
    public List<ProcessDefinitionBean> getProcessDefByTenantID(@Param("TENANT_ID_") String TENANT_ID_);
}
