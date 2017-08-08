/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locar;

import java.util.ArrayList;

/**
 *
 * @author Patrick
 */
public class Category {
    private float price;
    private long id;
    private final float inicialPrice = price/2;
    private String name;
    private String details;
    private ArrayList<Car> carros;

    public Category(float price, long id, String name, String details, ArrayList<Car> carros) {
        this.price = price;
        this.id = id;
        this.name = name;
        this.details = details;
        this.carros = carros;
    }

    public float getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public float getInicialPrice() {
        return inicialPrice;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetails(String details) {
        this.details = details;
    }  
}