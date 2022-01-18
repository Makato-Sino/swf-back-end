package com.sysu.swfbackend.bean;

/**
 * 用户实体
 */
public class User {

    private Integer id;
    private String name;     // 姓名
    private String address;    // 联系地址
    private String username; // 账号
    private String password; // 密码
    private String roles;     // 角色

    public User() {
    }

    public User(String name, String address, String username, String password, String roles) {
        this.name = name;
        this.address = address;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getRoles() {
        return roles;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setName(String name) {this.name = name; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
