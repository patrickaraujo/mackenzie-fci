/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locar;

/**
 *
 * @author Patrick
 */
public class Car {
    private int year;
    private long id;
    private String color;
    private Category category;
    private String linPlate;
    private String model;
    private String details;
    private boolean isAvailable;
    private String chassi;

    public Car(int year, long id, String color, Category category, String linPlate, String model, String details, boolean isAvailable, String chassi) {
        this.year = year;
        this.id = id;
        this.color = color;
        this.category = category;
        this.linPlate = linPlate;
        this.model = model;
        this.details = details;
        this.isAvailable = isAvailable;
        this.chassi = chassi;
    }

    public int getYear() {
        return year;
    }

    public long getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public Category getCategory() {
        return category;
    }

    public String getLinPlate() {
        return linPlate;
    }

    public String getModel() {
        return model;
    }

    public String getDetails() {
        return details;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public String getChassi() {
        return chassi;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setLinPlate(String linPlate) {
        this.linPlate = linPlate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }
    
    
    
}
