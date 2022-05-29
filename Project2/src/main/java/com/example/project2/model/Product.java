package com.example.project2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@AllArgsConstructor @Data
public class Product {
    @NotEmpty(message = " id is required")
    @Size(min = 3)
    private String id;
    @NotEmpty(message = " name is required")
    @Size(min = 3)
    private String name;
    @NotEmpty(message = "price is required")
    @Positive(message = "cannot enter negative values")
    private Integer price ;
    @NotEmpty(message = " categoryID is required")
    @Size(min = 3)
    private String categoryID;
    private ArrayList<Comment> commentsList;
}
