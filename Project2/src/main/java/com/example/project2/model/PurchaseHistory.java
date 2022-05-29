package com.example.project2.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class PurchaseHistory {

    @NotEmpty(message= "id is required")
    @Size(min =3 , max = 3)
    private String id;
    @NotEmpty(message= "user id is required")
    @Size(min =3 , max = 3)
    private String userId;
    @NotEmpty(message= "product id is required")
    @Size(min =3 , max = 3)
    private String productId;
    @NotEmpty(message= "price should provided")
    @Positive(message = "price should be +ve number!")
    private Integer price;




}
