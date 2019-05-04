/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author asus
 */
public class Account {
    private String name;
    private String password;
    private String address;
    private String googleID;
    private String email;
    private int ID;
    private String telephone;

    public Account() {
    }

//    public Account(String googleID, String email, int ID) {
//        this.googleID = googleID;
//        this.email = email;
//        this.ID = ID;
//    }

//    public Account() {
//    }

//    public Account(String name, String password, String address, String googleID, String email, int ID) {
//        this.name = name;
//        this.password = password;
//        this.address = address;
//        this.googleID = googleID;
//        this.email = email;
//        this.ID = ID;
//    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGoogleID() {
        return googleID;
    }

    public void setGoogleID(String googleID) {
        this.googleID = googleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String toString() {
        return "AccountBuilder{" + "name=" + name + ", password=" + password + ", address=" + address + ", googleID=" + googleID + ", email=" + email + ", telephone=" + telephone + ", ID=" + ID + '}';
    }
    
    public static class AccountBuilder {
        private String name;
        private String password;
        private String address;
        private String googleID;
        private String email;
        private String telephone;
        private int ID;

        public AccountBuilder(String email) {
            this.email = email;

        }
        
        public AccountBuilder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }
        
        public AccountBuilder password(String password) {
            this.password = password;
            return this;
        }
        
        public AccountBuilder address(String address) {
            this.address = address;
            return this;
        }
        
        public AccountBuilder googleID(String googleID) {
            this.googleID = googleID;
            return this;
        }
        
        public AccountBuilder name(String name) {
            this.name = name;
            return this;
        }
        
        public AccountBuilder iD(int ID) {
            this.ID = ID;
            return this;
        }
        
        public Account build() {
            Account account = new Account();
            account.ID = this.ID;
            account.address = this.address;
            account.email = this.email;
            account.googleID = this.googleID;
            account.name = this.name;
            account.password = this.password;
            account.telephone = this.telephone;
            
            return account;
        }
    }
}
