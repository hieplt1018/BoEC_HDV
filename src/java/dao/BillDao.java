/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Bill;

/**
 *
 * @author asus
 */
public interface BillDao {
    public boolean insertBill(Bill bill);
    public Bill getBill(int id);
    public ArrayList<Bill> getAllBill();
}
