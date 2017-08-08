/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.LoCar.dao;

import java.util.List;

/**
 *
 * @author windows
 */
public interface GenericDAO<E> {
    public boolean insert(E e); //C - CREATE
    
    public List<E> findAll(); //R - READ
    
    public E findById(long id);
    
    public E findByEmail(String email);
    
    public boolean modify(E e); //U - UPDATE
    
    public boolean remove(E e); //D - DELETE
}
