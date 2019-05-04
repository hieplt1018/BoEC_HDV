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
import model.Category;

/**
 *
 * @author asus
 */
public class CategoryDaoImpl implements CategoryDao{
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private ConnectDB connectdb;
    
    public CategoryDaoImpl(){
        this.connectdb = new ConnectDB();
    }
    @Override
    public boolean insert(Category category) {
        String sql = "INSERT INTO Category (Name) VALUES(?)"; 
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.setString(1, category.getName());
            stmt.executeUpdate();
            System.out.println("Category inserted!");
            return true;
        } catch (SQLException ex) {
            System.out.println("Loi insert account");
        }
        finally {
            connectdb.closeConnect();
        }
        return false;
    }

    @Override
    public Category getCategory(int id) {
        String sql = "SELECT * FROM Category WHERE ID = " + id;
        System.out.println(sql);
        Category category = null;
        try {
            rs = connectdb.getStatement().executeQuery(sql);
            while (rs.next()) {
                String name = rs.getString("Name");
                category = new Category(id, name);
                System.out.println("Get Category successful!");
            }
        } catch (Exception e) {
            System.out.println("get Category failed!");
        }
        finally{
            connectdb.closeConnect();
        }
        return category;
    }

    @Override
    public ArrayList<Category> getAllCategory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Category update(Category clothes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Category WHERE ID = " + id;
        System.out.println(sql);
        try {
            stmt = connectdb.openConnect().prepareStatement(sql);
            stmt.executeUpdate();
            System.out.println("Delete Category success!");
        } catch (Exception e){
            System.out.println("Delete Category is failed!");
        } finally {
            connectdb.closeConnect();
        }
    }
    
}
