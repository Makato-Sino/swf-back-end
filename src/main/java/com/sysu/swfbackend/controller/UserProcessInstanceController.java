package com.sysu.swfbackend.controller;

import com.sysu.swfbackend.bean.ProcessInstanceBean;
import com.sysu.swfbackend.dao.ProcessInstanceDao;
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
@RequestMapping("/processInstance")
public class UserProcessInstanceController {

    @Autowired
    ProcessInstanceDao processInstanceDao;

    /**
     * 根据租户ID获取流程实例列表
     * @param USER_ID_
     * @return
     */
    @GetMapping("/getUserInstancesByUserID")
    public AjaxResponse getUserInstancesByUserID(@Param("USER_ID_") String USER_ID_) {
        try {
            List<HashMap<String, Object>> hashMapList = new ArrayList<HashMap<String, Object>>();
            List<ProcessInstanceBean> list = processInstanceDao.getUserInstancesByUserID(USER_ID_);
            for (ProcessInstanceBean pi : list) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("Id", pi.getID_());
                hashMap.put("userID", pi.getUSER_ID_());
                hashMap.put("processInstanceID", pi.getPROC_INST_ID_());
                hashMapList.add(hashMap);
            }
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.SUCCESS.getCode(), GlobalConfig.ResponseCode.SUCCESS.getDesc(), hashMapList);
        } catch (Exception e) {
            return AjaxResponse.AjaxData(GlobalConfig.ResponseCode.ERROR.getCode(), GlobalConfig.ResponseCode.ERROR.getDesc(), e.toString());
        }
    }
}
