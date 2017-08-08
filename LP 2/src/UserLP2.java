/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp2;

/**
 *
 * @author 41318862
 */
public class UserLP2 {
    long id_user;
    String username;
    String password;
    
    public UserLP2(long id_user, String username, String password){
        this.id_user = id_user;
        this.username =  username;
        this.password = password;
    }
    
    public UserLP2(){
        this.id_user = 0;
        this.username =  "";
        this.password = "";
    }
    
    public long getId_user(){
        return this.id_user;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setId_user(long id_user){
        this.id_user = id_user;
    }
    
    public void setId_Username(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}
