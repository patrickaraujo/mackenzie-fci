/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2;

import java.util.Date;

/**
 *
 * @author 41318862
 */
public class UserInfo {
    long id_userinfo;
    String fullname;
    String email;
    Date birthday;
    long cpf;
    String address;
    
    public UserInfo(long id_userinfo, String fullname, String email, Date birthday, long cpf, String address){
        this.id_userinfo = id_userinfo;
        this.fullname = fullname;
        this.email = email;
        this.birthday = birthday;
        this.cpf = cpf;
        this.address = address;
    }
    
    public UserInfo(){
        this.id_userinfo = 0;
        this.fullname = "";
        this.email = "";
        this.birthday = null;
        this.cpf = 0;
        this.address = "";
    }
    
    public long getId_userinfo(){
        return this.id_userinfo;
    }
    
    public void setId_userinfo(long id_userinfo){
        this.id_userinfo = id_userinfo;
    }
    
    public String getFullname(){
        return this.fullname;
    }
    
    public void setFullname(String fullname){
        this.fullname = fullname;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public Date getBirthday(){
        return this.birthday;
    }
    
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    
    public long getCpf(){
        return this.cpf;
    }
    
    public void setCpf(long cpf){
        this.cpf = cpf;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
}
