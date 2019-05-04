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
public class Clothes implements Comparable<Clothes>{
    private String name, size, company, country, image;
    private double price;
    private int categoryId;
    private int clothId;
    private int quantity;
    private String categoryName;

    public Clothes(){
        
    }

    public int getClothId() {
        return clothId;
    }

    public void setClothId(int clothId) {
        this.clothId = clothId;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public int compareTo(Clothes t) {
        return this.clothId - t.clothId;
    }


    
    
    public static class ClothesBuilder {

        private String name, size, company, country, image;
        private double price;
        private int categoryId;
        private int clothId;
        private int quantity;
        
        public ClothesBuilder() {
        }

        public ClothesBuilder size(String size) {
            this.size = size;
            return this;
        }
        
        public ClothesBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }
        
        public ClothesBuilder image(String image) {
            this.image = image;
            return this;
        }

        public ClothesBuilder company(String company) {
            this.company = company;
            return this;
        }

        public ClothesBuilder country(String country) {
            this.country = country;
            return this;
        }

        public ClothesBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ClothesBuilder price(double price) {
            this.price = price;
            return this;
        }

        public ClothesBuilder clothId(int clothId) {
            this.clothId = clothId;
            return this;
        }
        
        public ClothesBuilder categoryId(int categoryId) {
            this.categoryId = categoryId;
            return this;
        }
        
        public Clothes build() {
            Clothes clothes = new Clothes();
            clothes.price = this.price;
            clothes.company = this.company;
            clothes.size = this.size;
            clothes.country = this.country;
            clothes.name = this.name;
            clothes.image = this.image;
            clothes.clothId = this.clothId;
            clothes.categoryId = this.categoryId;
            clothes.quantity = this.quantity;
            
            return clothes;
        }
    }
}
