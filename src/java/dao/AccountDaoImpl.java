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
import model.Account;

/**
 *
 * @author asus
 */
public class AccountDaoImpl implements AccountDao{
    private final Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ConnectDB connectdb;

    public AccountDaoImpl() {
        this.connectdb = new ConnectDB();
    }
    
    @Override
    public boolean checkEmail(String email) {
        String sql = "SELECT * FROM Account WHERE email='" + email + "'";
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                connectdb.closeConnect();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Check email bi loi.");
        } finally{
//            connectdb.closeConnect();
        }
        return false;
    }

    @Override
    public boolean register(Account account) {
        String sql = "INSERT INTO Account (Email, Password, Name, Address, Telephone) "
                + " VALUES(?,?,?,?,?)";
        System.out.println(account.toString());
       
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.setString(1, account.getEmail());
            stmt.setString(2, account.getPassword());
            stmt.setString(3, account.getName());
            stmt.setString(4, account.getAddress());
            stmt.setString(5, account.getTelephone());
            stmt.executeUpdate();
            System.out.println("Register successful!");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally{
//            connectdb.closeConnect();
        }
        return false;
    }

    @Override
    public Account login(String email, String password) {
        String sql = "select * from Account where email='" + email 
                + "' and password='" + password + "'";
        System.out.println(sql);
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                Account account = new Account.AccountBuilder(email)
                        .password(password).name(name).address(address).iD(id).build();
                System.out.println("Login successful!");
                return account;
            } else {
                System.out.println("Sai username hoac password");
            }
        } catch (SQLException ex) {
            System.out.println("Catch Login function");
        } finally{
//            connectdb.closeConnect();
        }
        return null;
    }

    @Override
    public void registerGoogle(String googleID, String email) {
        String sql = "INSERT INTO Account (Email, GoogleID)  VALUES(?,?)";
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, googleID);
            stmt.executeUpdate();
            System.out.println("Register by Google successful!");
        } catch (SQLException ex) {
            System.out.println("Register by Google failed!");
        } finally{
//            connectdb.closeConnect();
        }
    }

    @Override
    public Account loginGoogle(String email) {
        String sql = "SELECT * FROM Account WHERE Email = '" + email + "'";
        System.out.println(sql);
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                String googleID = rs.getString("GoogleID");
                int id = rs.getInt("ID");
                Account account = new Account.AccountBuilder(email)
                        .googleID(googleID).iD(id).build();
                System.out.println("Get Account successful!");
                return account;
            }
        } catch (Exception e) {
            System.out.println("loginGoogle() failed!");
        }
        finally{
//            connectdb.closeConnect();
        }
        return null;
    }
    
    public static void main(String[] args) {
        AccountDaoImpl dao = new AccountDaoImpl();
//        dao.loginGoogle("hieplt1018@gmail.com ");
        Account account = new Account.AccountBuilder("123@gmail").password("abc")
                .name("Hồng Duyên").address("Vaine, Germany").telephone("123213").build();
        dao.register(account);
//        System.out.println(dao.login("duyta@gmail.com", "123123").getName());
//        System.out.println(dao.loginGoogle("skydevil1202@gmail.com"));
    }

}
