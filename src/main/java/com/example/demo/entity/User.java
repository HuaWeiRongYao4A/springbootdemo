package com.example.demo.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/20.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 2462454450058615403L;

    private int id;
    private String username;
    private String password;

    public User() {}

    public User(int id) {
        this.id = id;
    }

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
