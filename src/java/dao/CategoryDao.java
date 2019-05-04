/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Category;

/**
 *
 * @author asus
 */
public interface CategoryDao {
    public boolean insert(Category category);
    public Category getCategory(int id);
    public ArrayList<Category> getAllCategory();
    public Category update(Category clothes);
    public void delete(int id);
}
