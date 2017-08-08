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
 * @author Patrick
 */
public class UserInfo implements Serializable{
    
    private enum AccessType { 
        cliente("Cliente"), outros("Outros");
        private String type; 
        private AccessType(String type) { 
            this.type = type; 
        } 
        
        @Override 
        public String toString(){ 
            return type; 
        } 
    } 
    
    private AccessType accessType;
    private String name, address, lastName;
    private long cpf, cnpj, tel, id;
    private Date birthday;
    
    
    public UserInfo() {
    
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public Date getBirthday() {
        return birthday;
    }
    
    public void setAccessType(AccessType accessType) {
        this.accessType = accessType;
    }
    
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public long getCpf() {
        return cpf;
    }

    public long getCnpj() {
        return cnpj;
    }

    public long getTel() {
        return tel;
    }

    public String getAccessTypeString() {
        return accessType.toString();
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }
    
    @Override
    public String toString() {
        return "UserInfo{" + "accessType=" + accessType + ", name=" + name + ", address=" + address + ", lastName=" + lastName + ", cpf=" + cpf + ", cnpj=" + cnpj + ", tel=" + tel + ", id=" + id + ", birthday=" + birthday + '}';
    }
}