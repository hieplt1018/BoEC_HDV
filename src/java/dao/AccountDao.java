/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Account;

/**
 *
 * @author asus
 */
public interface AccountDao {
    public boolean checkEmail(String email);
    public boolean register(Account account);
    public Account login(String email, String password);
    public void registerGoogle(String gooleID, String email);
    public Account loginGoogle(String email);
}
