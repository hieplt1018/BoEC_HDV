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
import java.sql.Timestamp;
import java.util.ArrayList;
import model.Bill;

/**
 *
 * @author asus
 */
public class BillDaoImpl implements BillDao{
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ConnectDB connectdb;
    
    public BillDaoImpl(){
        this.connectdb = new ConnectDB();
    }

    @Override
    public boolean insertBill(Bill bill) {
        String sql = "INSERT INTO Bill (CartID, AccountID, Total, Payment, DateBill, Address_Shipping) VALUES(?,?,?,?,?)"; 
        try {
            long cartID = bill.getCartId();
            String cartIDstr = Long.toString(cartID);
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.setString(1, cartIDstr);
            stmt.setInt(2, bill.getAccountId());
            stmt.setFloat(3, bill.getTotal());
            stmt.setString(4, bill.getPayment());
            stmt.setTimestamp(5, bill.getDateBill());
            stmt.setString(6, bill.getAddress_shipping());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Loi insert account");
        } finally {
            connectdb.closeConnect();
        }
        return false;
    }

    @Override
    public Bill getBill(int id) {
        String sql = "SELECT * FROM Bill WHERE ID = " + id;
        System.out.println(sql);
        Bill bill = null;
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String cartId = rs.getString("CartID");
                int accountId = rs.getInt("AccountID");
                float total = rs.getFloat("Total");
                String payment = rs.getString("Payment");
                Timestamp DateBill = rs.getTimestamp("DateBill");
                String Address_Shipping = rs.getString("Address_Shipping");
                long cartIDLong = Long.parseLong(cartId);
                bill = new Bill(accountId, cartIDLong, total, payment, DateBill, Address_Shipping);
            }
        } catch (Exception e) {
            System.out.println("Please check getAllBill index.jsp in BillDAOImpl");
        }
        finally{
            connectdb.closeConnect();
        }
        return bill;
    }

    @Override
    public ArrayList<Bill> getAllBill() {
        ArrayList<Bill> list = new ArrayList();
        String sql = "SELECT * FROM Bill";
        System.out.println(sql);
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                Bill bill = new Bill();
                long cartIDLong = Long.parseLong(rs.getString(2));
                bill.setId(rs.getInt(1));
                bill.setCartId(cartIDLong);
                bill.setAccountId(rs.getInt(3));
                bill.setTotal(rs.getFloat(4));
                bill.setPayment(rs.getString(5));
                bill.setDateBill(rs.getTimestamp(6));
                bill.setAddress_shipping(rs.getString(7));
                list.add(bill);
            }
        } catch (Exception e) {
            System.out.println("Please check getAllBill index.jsp in BillDAOImpl");
        } finally{
            connectdb.closeConnect();
        }
        return list;
    }
    
    
}
