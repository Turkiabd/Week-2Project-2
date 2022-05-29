package com.example.project2.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor @Data
public class Comment {
    @NotEmpty(message = "id is required")
    @Size(min = 3, max = 3)
    private String id;
    @NotEmpty(message = "user id is required")
    @Size(min = 5, max = 5)
    private String userId;
    @NotEmpty(message = "message should be provided")
    @Size(min = 6, max = 6)
    private String message;
    @NotNull(message = "rate is required")
    @Length(min = 1, max = 5)
    private Integer rate;

}
