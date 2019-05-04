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
import model.ChiTietHoaDon;

/**
 *
 * @author Linh
 */
public class ChiTietHoaDonDaoImpl implements ChiTietHoaDonDao{
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ConnectDB connectdb;
    
    public ChiTietHoaDonDaoImpl() {
         this.connectdb = new ConnectDB();
    }
    
    @Override
    public void themChiTietHD(ChiTietHoaDon cthd) {
       String sql = "INSERT INTO cart_product VALUES(?,?,?)"; 
        System.out.println(cthd.getCartID());
        System.out.println(cthd.getQuantity());
        System.out.println(cthd.getClothesID());
        long cartID = cthd.getCartID();
        String cartIDstring = Long.toString(cartID);
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.setString(1, cartIDstring);
            stmt.setInt(2, cthd.getClothesID());
            stmt.setInt(3, cthd.getQuantity());
            stmt.executeUpdate();
            System.out.println("Cart_product inserted!");
//            return true;
        } catch (SQLException ex) {
            System.out.println("Loi insert cart_product");
        }
        finally {
//            connectdb.closeConnect();
        }
//        return false;
    }
    
    public static void main(String[] args) {
        
    }
}
