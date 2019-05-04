/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;

import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author admin
 */
public class ConnectDB {

    private java.sql.Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;
    
    protected void hasDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println("Invalid Driver!! Please check this driver...");
        }

    }
    public java.sql.Connection openConnect() {
        try {
            if (conn == null) {
                hasDriver();
                String url = "jdbc:mysql://localhost:3306/BoEC"  + "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
                conn = DriverManager.getConnection(url, "root", "123123");
                System.out.println("Connected successful1");
            }
        } catch (Exception e) {
            System.out.println("Error Connecton! Please check url or username and password of mysql!");
        }
        return conn;
    }

    public Statement getStatement() {
        try {
            if (stmt == null) {
                stmt = openConnect().createStatement();
            }
        } catch (Exception e) {
            System.out.println("Please check statement");
        }
        return stmt;
    }

    public void closeConnect() {
        if (rs != null) {
            try {
                rs.close();
                System.out.println("Closed successful!");
            } catch (SQLException e) {
                /* ignored */
            }
        }
        if (ps != null) {
            try {
                ps.close();
                System.out.println("Closed successful!");
            } catch (SQLException e) {
                /* ignored */
            }
        }
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Closed successful!");
            } catch (SQLException e) {
                /* ignored */
            }
        }

    }
    
    public static void main(String[] args) {
        ConnectDB cn = new ConnectDB();
        cn.openConnect();
    }

}

