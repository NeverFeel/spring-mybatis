package com.ilidan.domain;

import java.io.Serializable;

/**
 * @author ilidan_Y
 * @Package com.ilidan.domain
 * @Description:
 * @date 2018/6/26
 * @Modified by:
 */
public class User implements Serializable {

    private static final long serialVersionUID = -2269170667856676769L;

    private Long id;

    private String username;

    private String password;

    private Double money;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
