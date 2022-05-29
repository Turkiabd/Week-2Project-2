package com.example.project2.Service;

import com.example.project2.model.Category;
import com.example.project2.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryService {
    ArrayList<Category> categories = new ArrayList<>();
    public ArrayList<Category> getCategory() {
        return categories;
    }

    public Boolean addCategory(Category category) {
        return categories.add(category);

    }

    public ArrayList<Category> delCategory(Integer index) {
        categories.remove(index);
        return categories;
    }

    public ArrayList<Category> updCategory (ArrayList<String> categoryNames, Integer index) {
        categoryNames.set(index , "");
        return categories;

    }
}
