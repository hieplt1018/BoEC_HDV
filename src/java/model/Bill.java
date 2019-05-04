/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author asus
 */
public class Bill {
    private int id, accountId;
    private long cartId;
    private float total;
    private String payment;
    private Timestamp dateBill;
    private String address_shipping;


    public Bill(long cartId, int accountId, float total) {
        this.cartId = cartId;
        this.accountId = accountId;
        this.total = total;
    }
    
    public Bill() {
    }

    public Bill(int accountId, long cartId, float total, String payment, Timestamp dateBill, String address_shipping) {
        this.accountId = accountId;
        this.cartId = cartId;
        this.total = total;
        this.payment = payment;
        this.dateBill = dateBill;
        this.address_shipping = address_shipping;
    }
    
    

    public String getAddress_shipping() {
        return address_shipping;
    }

    public void setAddress_shipping(String address_shipping) {
        this.address_shipping = address_shipping;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Timestamp getDateBill() {
        return dateBill;
    }

    public void setDateBill(Timestamp dateBill) {
        this.dateBill = dateBill;
    }
    
    
}
