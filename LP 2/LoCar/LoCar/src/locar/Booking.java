/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locar;

import java.util.Date;

/**
 *
 * @author Patrick
 */
public class Booking {
    private long id;
    private boolean approvedInicialPayment;
    private float remainingPayment;
    private Car car;
    private CreditCard creditCard;
    private Date dateb;
    private Date dateEnd;
    private String status;
    
    public Booking(long id, boolean approvedInicialPayment, float remainingPayment, Category category, Car car, CreditCard creditCard, Date dateb, Date dateEnd, String status) {
        this.id = id;
        this.approvedInicialPayment = approvedInicialPayment;
        this.remainingPayment = remainingPayment;
        this.car = car;
        this.creditCard = creditCard;
        this.dateb = dateb;
        this.dateEnd = dateEnd;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public boolean isApprovedInicialPayment() {
        return approvedInicialPayment;
    }

    public float getRemainingPayment() {
        return remainingPayment;
    }

    public Car getCar() {
        return car;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public Date getDateb() {
        return dateb;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setApprovedInicialPayment(boolean approvedInicialPayment) {
        this.approvedInicialPayment = approvedInicialPayment;
    }

    public void setRemainingPayment(float remainingPayment) {
        this.remainingPayment = remainingPayment;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void setDateb(Date dateb) {
        this.dateb = dateb;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}