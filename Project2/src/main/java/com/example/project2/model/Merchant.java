package com.example.project2.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Merchant {

    @NotEmpty(message = " id is required")
    @Size(min = 3 , max = 3)
    private String id ;
    @NotEmpty(message = " name is required")
    @Size(min = 3 , max = 3)
    private String name;
}
