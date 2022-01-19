package com.sysu.swfbackend.controller;

import com.sysu.swfbackend.SecurityUtil;
import com.sysu.swfbackend.bean.ProcessDefinitionBean;
import com.sysu.swfbackend.dao.ProcessDefinitionDao;
import com.sysu.swfbackend.util.AjaxResponse;
import com.sysu.swfbackend.util.GlobalConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/processDefinition")
public class UserProcessDefinitionController {

    @Autowired
    SecurityUtil securityUtil;

    @Autowired
    ProcessDefinitionDao processDefinitionDao;

    @GetMapping("/getDefinitionByTenantID")
    public AjaxResponse getDefinitionByTenantID(@Param("TENANT_ID_") String TENANT_ID_) {
        try {

            List<HashMap<String, Object>> listMap = new ArrayList<HashMap<String, Object>>();

            List<ProcessDefinitionBean> list = processDefinitionDao.getProcessDefByTenantID(TENANT_ID_);
            System.out.println(list);
            for (ProcessDefinitionBean pd : list) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("DeploymentID", pd.getDEPLOYMENT_ID_());
                hashMap.put("Name", pd.getNAME_());
                hashMap.put("Key", pd.getKEY_());
                hashMap.put("Version", pd.getVERSION_());
                hashMap.put("Tenant", pd.getTENANT_ID_());
                listMap.add(hashMap);
            }

            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(), GlobalConfig.ResponseCode.SUCCESS.getDesc(), listMap);
        } catch (Exception e) {
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(), GlobalConfig.ResponseCode.ERROR.getDesc(), e.toString());
        }
    }
}
