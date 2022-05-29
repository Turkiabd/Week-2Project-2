package com.example.project2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

 @Data
public class Cart {
    @NotEmpty(message = "id is required")
    @Size(min = 3 , max = 3)
    private String id;
    @NotEmpty(message = "userid is required")
    @Size(min = 3 , max = 3)
    private String userId;

    private ArrayList<Product> products;

    public Cart(String id, String userId ,  ArrayList<Product> products) {
        this.id = id;
        this.userId = userId;
        this.products = new ArrayList<>();
    }
}
