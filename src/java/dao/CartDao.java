/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Cart;
import model.Clothes;

/**
 *
 * @author asus
 */
public interface CartDao {
    public boolean insert();
    
    public void insertCartDetail(Cart cart);

    public ArrayList<Cart> getCartDetails(int id);

    public Cart update(Cart cart);

    public void delete(int id);
    
    public int getCartID();
}
