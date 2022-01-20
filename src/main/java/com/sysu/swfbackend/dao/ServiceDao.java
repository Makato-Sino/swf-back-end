package com.sysu.swfbackend.dao;

import com.sysu.swfbackend.bean.Service;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceDao {
    public List<Service> getServices();
}
