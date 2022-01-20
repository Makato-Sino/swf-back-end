package com.sysu.swfbackend.bean;

// 服务实体
public class Service {

    private int id;
    private String name;
    private int level;
    private int limit;

    public Service() {
    }

    public Service(String name, int level, int limit) {
        this.name = name;
        this.level = level;
        this.limit = limit;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getLimit() {
      return limit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLimit(int limit) {
      this.limit = limit;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", limit='" + limit + '\'' +
                '}';
    }
}
