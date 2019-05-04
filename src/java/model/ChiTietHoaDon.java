/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Linh
 */
public class ChiTietHoaDon {
    private long cartID;
    private int clothesID;
    private int quantity;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(long cartID, int clothesID, int quantity) {
        this.cartID = cartID;
        this.clothesID = clothesID;
        this.quantity = quantity;
    }

    public long getCartID() {
        return cartID;
    }

    public void setCartID(long cartID) {
        this.cartID = cartID;
    }

    public int getClothesID() {
        return clothesID;
    }

    public void setClothesID(int clothesID) {
        this.clothesID = clothesID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
