/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;

/**
 *
 * @author asus
 */
public class Cart {
    private int productId;

    private HashMap<Long, Clothes> list;
    private HashMap<Long, Integer> quantity;
    private long cartID;
    
    
    public Cart() {
        list = new HashMap<>();
        quantity = new HashMap<>();
    }
    
    public Cart(HashMap<Long, Clothes> list, HashMap<Long, Integer> quantity) {
        this.list = list;
        this.quantity = quantity;
    }
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public HashMap<Long, Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(HashMap<Long, Integer> quantity) {
        this.quantity = quantity;
    }
    
    
    public HashMap<Long, Clothes> getList() {
        return list;
    }

    public void setList(HashMap<Long, Clothes> list) {
        this.list = list;
    }

    public long getCartID() {
        return cartID;
    }

    public void setCartID(long cartID) {
        this.cartID = cartID;
    }
      
    public void insertToCart(Long key, Clothes clothes) {
        boolean bln = list.containsKey(key);
        if (bln) {
            int quantity_old = quantity.get(key);
            quantity.remove(key);
            quantity.put(key, quantity_old + 1);
            list.put(key, clothes);
        }
        else {
            int quantity_old = 0;
            clothes.setQuantity(quantity_old + 1);
            quantity.put(key, quantity_old + 1);
            list.put(key, clothes);
        }
    }
    
    public void subToCart(Long key, Clothes clothes) {
        boolean bln = list.containsKey(key);
        if (bln) {
            int quantity_old = clothes.getQuantity();
            clothes.setQuantity(quantity_old - 1);
            if ((quantity_old - 1)  <= 0) {
                list.remove(key);
            } else {
                list.remove(key);
                list.put(key, clothes);
            }
        }
    }
    
    public void removeToCart(Long key) {
        boolean bln = list.containsKey(key);
        if (bln) {
            list.remove(key);
        }
    }
}
