package com.example.project2.Service;

import com.example.project2.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {


    ArrayList<Product> products = new ArrayList<>();
    public ArrayList<Product> getProduct() {
        return products;
    }

    public Boolean addProduct(Product product) {
        return products.add(product);

    }

    public ArrayList<Product> delProduct(Integer index) {
        products.remove(index);
        return products;
    }

    public ArrayList<Product>updProduct(ArrayList<String> productsNames, Integer index) {
        productsNames.set(index , "");
        return products;

    }

    public Product getProductsId(String productId) {
        for (Product product:products) {
            if (product.getId().equals(productId)){
                return product;
            }

        }
        return null ;
    }



}
