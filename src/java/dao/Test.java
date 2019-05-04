/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Timestamp;
import model.Account;
import model.Bill;
import model.Cart;
import model.Category;
import model.Clothes;

/**
 *
 * @author asus
 */
public class Test {
    
    public static void main(String[] args) {
        AccountDaoImpl ac = new AccountDaoImpl();
        System.out.println(ac.checkEmail("tatailinh0608@gmail.com"));
//        System.out.println(ac.loginGoogle("tatailinh0608@gmail.com").getEmail());
        
//        Account account = new Account("lamthon97@gmail.com", "123456", "Lam Thon", "Ha Nam");
//        ac.register(account);
//        System.out.println(ac.login("duyta@gmail.com", "123123").getName());
        
//        CategoryDaoImpl cate = new CategoryDaoImpl();
//        Category category = new Category("Leather jacket");
//        cate.insert(category);
//        cate.delete(3);
//        System.out.println(cate.getCategory(1).getName());

//        ClothesDaoImpl cl = new ClothesDaoImpl();
//        Clothes cloths = new Clothes("MICHYEORA RIBBON POINT CHECKED DRESS", "S", "MICHYEORA", "KOREAN", 25.2, 4);
//        cl.insert(cloths);
        
//        CartDaoImpl cartdao = new CartDaoImpl();
//        cartdao.insert();
//        ClothesDaoImpl clothdao = new ClothesDaoImpl();
//        Clothes cloth = clothdao.getClothes(1);
//        Cart cart3 = new Cart(1, 2, 2);
//        cartdao.insertCartDetail(cart3);
//        Cart cart2 = new Cart(3, 2, 4);
//        cartdao.insertCartDetail(cart2);
        CategoryDaoImpl cdi = new CategoryDaoImpl();
        ClothesDaoImpl cldi = new ClothesDaoImpl();
        System.out.println(cldi.getClothesDetails(10).getName());
    }
}
