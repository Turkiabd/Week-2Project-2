package com.example.project2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor  @Data
public class MerchantStock {
    @NotEmpty(message = " id is required")
    @Size(min = 3 , max = 3)
    private String id;
    @NotEmpty(message = " product id is required")
    @Size(min = 3 , max = 3)
    private String prductId;
    @NotEmpty(message = " merchant id is required")
    @Size(min = 3 , max = 3)
    private String merchantId;
    @NotNull(message = "stock is required" )
    @Length(min = 10)
    private Integer stock ;

}
