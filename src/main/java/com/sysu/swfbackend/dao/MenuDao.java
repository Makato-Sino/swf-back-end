package com.sysu.swfbackend.dao;

import com.sysu.swfbackend.bean.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<Menu> getMenus();
    public List<Menu> getTenantMenus();
}
