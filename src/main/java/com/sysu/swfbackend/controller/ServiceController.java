package com.sysu.swfbackend.controller;

import com.alibaba.fastjson.JSON;
import com.sysu.swfbackend.bean.Service;
import com.sysu.swfbackend.dao.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class ServiceController {

    @Autowired
    ServiceDao serviceDao;

    @RequestMapping("/services")
    public String getAllMenus() {
        HashMap<String, Object> data = new HashMap<>();
        List<Service> services = serviceDao.getServices();
        if (services != null) {
            data.put("services", services);
            data.put("flag", 200);
        } else {
            data.put("flag", 404);
        }
        String s = JSON.toJSONString(data);
        return s;
    }
}

