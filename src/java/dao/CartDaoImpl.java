/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cart;
import model.Clothes;

/**
 *
 * @author asus
 */
public class CartDaoImpl implements CartDao{
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ConnectDB connectdb;
    
    public CartDaoImpl(){
        this.connectdb = new ConnectDB();
    }
    
    @Override
    public boolean insert() {
        String sql = "INSERT INTO  Cart () VALUES ()";
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Cart inserted!");
            return true;
        } catch (SQLException ex) {
            System.out.println("Loi insert cart");
        } finally {
            connectdb.closeConnect();
        }
        return false;
    }

    @Override
    public ArrayList<Cart> getCartDetails(int id) {
        ArrayList<Cart> list = new ArrayList();
        String sql = "SELECT * FROM Card_Product WHERE CartID = " + id;
        System.out.println(sql);
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setCartID(rs.getInt(1));
                cart.setProductId(rs.getInt(2));
                list.add(cart);
                System.out.println("Get Cart's Details successful!");
            }
        } catch (Exception e) {
            System.out.println("Get Cart Details Failed!");
        } finally{
            connectdb.closeConnect();
        }
        return list;
    }

    @Override
    public Cart update(Cart cart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Cart_Product WHERE Cart_ID = " + id;
        System.out.println(sql);
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Delete Cart success!");
        } catch (Exception e){
            System.out.println("Delete Cart is failed!");
        } finally {
            connectdb.closeConnect();
        }
    }

    @Override
    public void insertCartDetail(Cart cart) {
        String sql = "INSERT INTO Cart_Product (CartID, ProductID) VALUES (?, ?, ?)";
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.setInt(1, (int) cart.getCartID());
            stmt.setInt(2, cart.getProductId());
            stmt.executeUpdate();
            System.out.println("Cart's details inserted!");
        } catch (SQLException ex) {
            System.out.println("Loi insert cart details");
        } finally {
            connectdb.closeConnect();
        }
    }

    @Override
    public int getCartID() {
        String sqlGetCartID = "SELECT MAX(ID) FROM Cart";
        int cartID;
        try {
            rs = connectdb.getStatement().executeQuery(sqlGetCartID);
            while(rs.next()){
                cartID = rs.getInt("MAX(ID)");
                System.out.println("Get CartID successful!");
                return cartID;
            }
        } catch (SQLException ex) {
            System.out.println("Get CartID Faile!");
        } finally {
            connectdb.closeConnect();
        }
        return 0;
    }
    
}