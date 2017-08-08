/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.LoCar.javabeans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author windows
 */
public class User implements Serializable{
    
    private String password, email;
    private UserInfo userInfo;
    private long id;

    public User() {
    
    }
    
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    
    public String getEmail() {
        return email;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    @Override
    public String toString() {
        return "User{" + "password=" + password + ", email=" + email + ", userInfo=" + userInfo + ", id=" + id + '}';
    }
    
}